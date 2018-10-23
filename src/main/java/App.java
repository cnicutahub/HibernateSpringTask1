import model.User;
import service.UserService;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = new User("username1","fname","lname","wasd");

        userService.persist(user1);

        userService.findAll().forEach(System.out::println);
    }
}
