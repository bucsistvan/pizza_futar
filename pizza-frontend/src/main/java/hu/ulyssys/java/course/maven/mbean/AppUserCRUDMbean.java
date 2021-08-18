package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class AppUserCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable {
    @Inject
    public AppUserCRUDMbean(AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(appUserService);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
    }

    @Override
    protected String dialogName() {
        return "userDialog";
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    public void registration(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/pizza.xhtml");
            save();
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt regisztráció közben", ""));
            e.printStackTrace();
        }
    }

    private String hashPassword(String rawPassword) {
        return DigestUtils.sha512Hex(rawPassword);
    }
}
