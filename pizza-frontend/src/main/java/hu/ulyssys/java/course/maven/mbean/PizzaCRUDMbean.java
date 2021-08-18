package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PizzaCRUDMbean extends CompanyCRUDMbean<Pizza> implements Serializable {
    @Inject
    public PizzaCRUDMbean(PizzaService pizzaService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(pizzaService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Kérünk jelentkezzen be az oldal használatához!");
        }
    }

    @Override
    protected String dialogName() {
        return "pizzaDialog";
    }

    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }

}
