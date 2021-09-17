package web.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component

public class Initializer {

    private final UserService userService;
    private final RoleService roleService;

    public Initializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        Role role1 = new Role(0L,"ROLE_ADMIN");
        Role role2 = new Role(1L,"ROLE_USER");
        roleService.addRole(role1);
        roleService.addRole(role2);

        Set<Role> roles_admin = new HashSet<>();
        roles_admin.add(role1);
        User admin = new User(0L, "admin", "Admin", "1333",
                "admin@yan.ru", "1", roles_admin);
        admin.setRoles(roles_admin);
        userService.addUser(admin);

        Set<Role> roles_user = new HashSet<>();
        roles_user.add(role2);
        User user = new User( 1L,"user", "user", "1444",
                "user@yan.ru", "1", roles_user);
        //user.setRoles(roles_user);
        userService.addUser(user);

    }
}