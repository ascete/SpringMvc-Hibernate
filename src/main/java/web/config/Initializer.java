//package web.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//import web.dao.RoleDao;
//import web.dao.UserDao;
//import web.dao.UserDaoImpl;
//import web.models.Role;
//import web.models.User;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//@Scope("prototype")
//public class Initializer {
//
//    private UserDao userDao;
//    private RoleDao roleDao;
//
//    @Autowired
//    @PostConstruct
//    private void postConstruct() {
//        Role role1 = new Role(0L,"ROLE_ADMIN");
//        Role role2 = new Role(1L,"ROLE_USER");
//       roleDao.addRole(role1);
//       roleDao.addRole(role2);
//
//        Set<Role> roles_admin = new HashSet<>();
//        roles_admin.add(role1);
//        User admin = new User(0L,"admin", "Admin", "1333",
//                "admin@yan.ru", "1",  roles_admin);
//        userDao.addUser(admin);
//
//        Set<Role> roles_user = new HashSet<>();
//        roles_user.add(role2);
//        User user = new User(1L,"user", "user", "1444",
//                "user@yan.ru", "1",  roles_user);
//        userDao.addUser(admin);
//
//        userDao.addUser(user);
//
//    }
//}