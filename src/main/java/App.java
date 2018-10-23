import model.Role;
import model.User;
import model.UserRole;
import service.RoleService;
import service.UserRoleService;
import service.UserService;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        UserRoleService userRoleService = new UserRoleService();

        User user = userService.findById(1);
        Role role = roleService.findById(1);

        UserRole userRole = new UserRole(user,role);

        userRoleService.persist(userRole);

        userRoleService.findAll().forEach(System.out::println);

    }
}
