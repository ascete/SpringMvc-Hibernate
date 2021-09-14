package web.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.models.User;

import javax.annotation.PostConstruct;

public class Initializer {
    @Autowired
    private UserDaoImpl userDao;

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", "admin password");
        User normalUser = new User("user", "user password");
        userDao.addUser(admin);
    }
}