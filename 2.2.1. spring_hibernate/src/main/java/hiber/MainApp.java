package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Zaur", "Tregulov", "tregulov@mail.ru");
      Car car1 = new Car("Lada Granta", 2);
      user1.setMyCar(car1);
      userService.add(user1);
      userService.listUsers();

      User user2 = new User("Oleg", "Vlasov", "vlas@gmail.com");
      Car car2 = new Car("Nisan Tilda", 4);
      user2.setMyCar(car2);
      userService.add(user2);

      User user3 = new User("Irina", "Sidorova", "sidr@gmail.com");
      Car car3 = new Car("Nissan Almera", 3);
      user3.setMyCar(car3);
      userService.add(user3);

      User user = userService.getUser(car3);
      System.out.println(user);



















//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();

   }
}
