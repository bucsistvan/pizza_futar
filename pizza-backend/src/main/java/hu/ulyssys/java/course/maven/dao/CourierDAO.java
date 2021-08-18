package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Courier;

public interface CourierDAO extends CoreDAO<Courier>{
    Courier findByUserName(String firstName, String lastName);
}
