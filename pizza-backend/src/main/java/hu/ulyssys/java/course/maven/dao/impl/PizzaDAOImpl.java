package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.PizzaDAO;
import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Pizza;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PizzaDAOImpl extends CoreDAOImpl<Pizza> implements PizzaDAO {
    @Override
    protected Class<Pizza> getManagedClass() {
        return Pizza.class;
    }

    @Override
    public Pizza findByUserName(String username) {
        TypedQuery<Pizza> query = entityManager.createNamedQuery(Pizza.FIND_BY_USERNAME, Pizza.class);
        query.setParameter("name", username);
        List<Pizza> pizzaList = query.getResultList();
        if(pizzaList.isEmpty()){
            return null;
        }
        System.out.println("findByUserName: "+pizzaList.get(0).getName());
        return pizzaList.get(0);
    }
}
