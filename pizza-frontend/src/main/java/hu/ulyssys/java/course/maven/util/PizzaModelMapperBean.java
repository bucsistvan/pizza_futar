package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.rest.model.PizzaModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PizzaModelMapperBean extends CoreModelMapperBean<PizzaModel, Pizza>{
    @Override
    public PizzaModel initNewModel() {
        return new PizzaModel();
    }
    @Override
    public PizzaModel createModelFromEntity(Pizza entity) {
        PizzaModel pizzaModel = super.createModelFromEntity(entity);
        pizzaModel.setName(entity.getName());
        pizzaModel.setDescription(entity.getDescription());
        pizzaModel.setPrice(entity.getPrice());
        return pizzaModel;
    }

    @Override
    public void populateEntityFromModel(Pizza entity, PizzaModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
    }
}
