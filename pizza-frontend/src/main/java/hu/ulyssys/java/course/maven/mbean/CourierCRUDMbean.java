package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CourierCRUDMbean extends CompanyCRUDMbean<Courier> implements Serializable {
    @Inject
    public CourierCRUDMbean(CourierService courierService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(courierService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
    }

    @Override
    public void save() {
        if (!selectedEntity.getLastName().equals(selectedEntity.getFirstName())){
            super.save();
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A keresztnév és a vezetéknév különböző kell legyen!", ""));
        }
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
