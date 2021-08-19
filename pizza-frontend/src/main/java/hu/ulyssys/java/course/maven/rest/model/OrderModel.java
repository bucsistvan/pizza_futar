package hu.ulyssys.java.course.maven.rest.model;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Pizza;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel extends CoreRestModel{
    @Future
    private Date deliveredDate;
    private Long courier;
    @NotEmpty
    private List<Long> pizzas = new ArrayList<>();
    @Size(max = 200)
    private String settlement;
    @Size(max = 200)
    private String publicSpace;
    @Size(max = 200)
    private String natureOfPublicSpace;
    @Size(max = 200)
    private String houseNumber;

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Long getCourier() {
        return courier;
    }

    public void setCourier(Long courier) {
        this.courier = courier;
    }

    public List<Long> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Long> pizzas) {
        this.pizzas = pizzas;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPublicSpace() {
        return publicSpace;
    }

    public void setPublicSpace(String publicSpace) {
        this.publicSpace = publicSpace;
    }

    public String getNatureOfPublicSpace() {
        return natureOfPublicSpace;
    }

    public void setNatureOfPublicSpace(String natureOfPublicSpace) {
        this.natureOfPublicSpace = natureOfPublicSpace;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
