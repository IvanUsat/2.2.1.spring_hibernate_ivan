package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("bmw", 5)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("lada", 1)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("nissan", 2)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("audi", 3)));

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);


     

      Car car = new Car("bmw", 5);
      List<User> user = userService.getUserOnCar(car.getModel(), car.getSeries());
      user.forEach(System.out::println);



      context.close();
   }
}
