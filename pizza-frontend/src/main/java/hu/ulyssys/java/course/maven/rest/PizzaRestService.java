package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.rest.model.PizzaModel;
import hu.ulyssys.java.course.maven.util.PizzaModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/pizza")
public class PizzaRestService extends CoreRestService<Pizza, PizzaModel> {

    @Inject
    private PizzaModelMapperBean pizzaModelMapperBean;

    @Override
    protected void populateEntityFromModel(Pizza entity, PizzaModel model) {
        pizzaModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected PizzaModel createModelFromEntity(Pizza entity) {
        return pizzaModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }

}
