package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Pizza;

public interface PizzaDAO extends CoreDAO<Pizza>{
    Pizza findByUserName(String username);
}
