import model.Order;
import model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8Section2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0);
//        System.out.println(allPositive);

        boolean anyPositive = numbers.stream()
                .anyMatch(number -> number > 0);
//        System.out.println(anyPositive);

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("david@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        boolean areAllUserVerified = users.stream()
                .allMatch(User::isVerified);

        System.out.println(areAllUserVerified);

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean isAnyOrderError = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println(isAnyOrderError);
    }
}
