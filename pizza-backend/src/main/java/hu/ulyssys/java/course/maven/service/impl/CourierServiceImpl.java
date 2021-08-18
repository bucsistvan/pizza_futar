package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.AppUserDAO;
import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractServiceImpl<Courier> implements CourierService {
    @Override
    public Courier findByUserName(String firstName, String lastName) {
        return ((CourierDAO) dao).findByUserName(firstName, lastName);
    }
}
