package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class PizzaConverter implements Converter {
    @Inject
    private PizzaService pizzaService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return pizzaService.findByUserName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Pizza) {
            return ((Pizza) o).getName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
