package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.AppUserDAO;
import hu.ulyssys.java.course.maven.entity.AppUser;
import hu.ulyssys.java.course.maven.service.AppUserService;

import javax.ejb.Stateless;

@Stateless
public class AppUserServiceImpl extends AbstractServiceImpl<AppUser> implements AppUserService {
    @Override
    public AppUser findByUserName(String username) {
        return ((AppUserDAO) dao).findByUserName(username);
    }
}
