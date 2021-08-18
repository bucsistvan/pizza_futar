package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.entity.Courier;

public interface CourierService extends CoreService<Courier> {
    Courier findByUserName(String firstName, String lastName);
}
