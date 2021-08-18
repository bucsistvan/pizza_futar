package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractCompany;
import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class CompanyCRUDMbean<T extends AbstractCompany> extends CoreCRUDMbean<T>{
    private List<AppUser> userList;

    protected LoggedInUserBean loggedInUserBean;

    public CompanyCRUDMbean(CoreService<T> service, AppUserService appUserService, LoggedInUserBean loggedInUserBean){
        super(service);
        userList = appUserService.getAll();
        this.loggedInUserBean =loggedInUserBean;
    }

    @Override
    public void save() {
        try {
            selectedEntity.setModifiedDate(getCurrentDate());
            selectedEntity.setModifiedBy(userList.stream().filter(u -> u.getUserName().equals(loggedInUserBean.getModel().getUsername())).findFirst().get());
            super.save();
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt mentés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected void saveNewEntity(){
        selectedEntity.setCreatedBy(userList.stream().filter(u -> u.getUserName().equals(loggedInUserBean.getModel().getUsername())).findFirst().get());
        super.saveNewEntity();
    }

    public List<AppUser> getUserList() {
        return userList;
    }

    public void setUserList(List<AppUser> userList) {
        this.userList = userList;
    }
}
