package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractEntity;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order> {

    @Inject
    private CourierService courierService;

    @Inject
    private PizzaService pizzaService;

    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }
    @Override
    public OrderModel createModelFromEntity(Order entity) {
        OrderModel pizzaModel = super.createModelFromEntity(entity);
        pizzaModel.setDeliveredDate(entity.getDeliveredDate());
        if (entity.getCourier() != null) {
            pizzaModel.setCourier(entity.getCourier().getId());
        }else {
            pizzaModel.setCourier(null);
        }
        pizzaModel.setPizzas(entity.getPizzas().stream().map(AbstractEntity::getId).collect(Collectors.toList()));
        pizzaModel.setSettlement(entity.getSettlement());
        pizzaModel.setPublicSpace(entity.getPublicSpace());
        pizzaModel.setNatureOfPublicSpace(entity.getNatureOfPublicSpace());
        pizzaModel.setHouseNumber(entity.getHouseNumber());
        return pizzaModel;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setDeliveredDate(model.getDeliveredDate());
        if (model.getCourier() != null) {
            entity.setCourier(courierService.findById(model.getCourier()));
        }
        if (model.getPizzas() != null) {
            entity.setPizzas(model.getPizzas().stream().map(pizza -> pizzaService.findById(pizza)).collect(Collectors.toList()));
        }
        entity.setSettlement(model.getSettlement());
        entity.setPublicSpace(model.getPublicSpace());
        entity.setNatureOfPublicSpace(model.getNatureOfPublicSpace());
        entity.setHouseNumber(model.getHouseNumber());
    }
}
