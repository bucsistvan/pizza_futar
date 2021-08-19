package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends AbstractCompany {

    @Future
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "delivered_date", nullable = false)
    private Date deliveredDate;

    @JoinColumn(name = "courier_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Courier courier;

    @NotEmpty
    @JoinColumn(name = "order_id")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Pizza> pizzas = new ArrayList<>();

    @Column(name = "settlement", length = 200)
    private String settlement;

    @Column(name = "public_space", length = 200)
    private String publicSpace;

    @Column(name = "nature_of_public_space", length = 200)
    private String natureOfPublicSpace;

    @Column(name = "house_number", length = 200)
    private String houseNumber;

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

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
