package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.AppUserDAO;
import hu.ulyssys.java.course.maven.dao.PizzaDAO;
import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Pizza;
import hu.ulyssys.java.course.maven.service.PizzaService;

import javax.ejb.Stateless;

@Stateless
public class PizzaServiceImpl extends AbstractServiceImpl<Pizza> implements PizzaService {
    @Override
    public Pizza findByUserName(String username) {
        return ((PizzaDAO) dao).findByUserName(username);
    }
}
