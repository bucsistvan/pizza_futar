package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;
import hu.ulyssys.java.course.maven.rest.model.PizzaModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier> {
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        CourierModel pizzaModel = super.createModelFromEntity(entity);
        pizzaModel.setFirstName(entity.getFirstName());
        pizzaModel.setLastName(entity.getLastName());
        pizzaModel.setPhoneNumber(entity.getPhoneNumber());
        return pizzaModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
}
