package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Pizza;

public interface PizzaService extends CoreService<Pizza> {
    Pizza findByUserName(String username);
}
