package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.Role;
import web.models.User;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

//    @Component
//    public class DbInit {
//
//        @Autowired
//        private UserDao userRepository;
//        Set<Role> rol = (Set<Role>) new Role(1L, "ROLE_ADMIN");
//        @PostConstruct
//        private void postConstruct() {
//            User admin = new User(1L, "admin", "borov",
//                    "13", "email", "1", rol);
//            //User user = new User("user", "user");
//            userRepository.addUser(admin);
//           // userRepository.addUser((user));
//        }
//    }

    @Transactional
    @Override
    public Role getRoleByName(String name) {
        return userDao.getRoleByName(name);
    }

    @Override
    public Set<Role> getRolesFromText(String text) {
        return userDao.getRolesFromText(text);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(long id, String log, String pas, String rol, String fn, String sn, String c) {
        userDao.updateUser(id, log, pas, rol, fn, sn, c);
    }

    @Override
    public User getUserByName(String s) {
        return null;
    }
}
