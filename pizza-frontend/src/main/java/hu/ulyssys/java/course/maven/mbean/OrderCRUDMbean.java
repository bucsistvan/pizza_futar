package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.OrderService;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class OrderCRUDMbean extends CompanyCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    private List<Pizza> pizzaList;

    private OrderService orderService;

    @Inject
    public OrderCRUDMbean(OrderService orderService, AppUserService appUserService, LoggedInUserBean loggedInUserBean, CourierService courierService, PizzaService pizzaService) {
        super(orderService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Kérünk jelentkezzen be az oldal használatához!");
        }
        this.courierList = courierService.getAll();
        this.pizzaList = pizzaService.getAll();
        this.orderService = orderService;
        refreshData();
    }
    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    @Override
    protected void refreshData() {
        if (!loggedInUserBean.isAdmin()) {
            setList(orderService.getAll().stream().filter(order -> order.getCreatedBy().getUserName().equals(loggedInUserBean.getModel().getUsername())).collect(Collectors.toList()));
        }else {
            setList(orderService.getAll());
        }
    }
/*
    public void writeOutEntity(){
        System.out.println(selectedEntity.getId());
        System.out.println(selectedEntity.getCreatedDate());
        System.out.println(selectedEntity.getModifiedDate());
        System.out.println(selectedEntity.getHouseNumber());
        System.out.println(selectedEntity.getNatureOfPublicSpace());
        System.out.println(selectedEntity.getPublicSpace());
        System.out.println(selectedEntity.getSettlement());
        System.out.println(selectedEntity.getCreatedBy().getId());
        System.out.println(selectedEntity.getModifiedBy().getId());
        System.out.println(selectedEntity.getDeliveredDate());
        System.out.println(selectedEntity.getCourier().getId());
        selectedEntity.getPizzas().forEach(pizza -> System.out.println("Pizza: "+pizza.getName()));
    }*/


    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
