package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@NamedQuery(name = Pizza.FIND_BY_USERNAME, query = "select u from Pizza u where u.name=:name ")
@Entity
@Table
public class Pizza extends AbstractCompany {

    public static  final String FIND_BY_USERNAME = "Pizza.findByUsername";

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;
        Pizza pizza = (Pizza) o;
        return price == pizza.price && Objects.equals(name, pizza.name) && Objects.equals(description, pizza.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
