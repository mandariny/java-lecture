import model.User;
import service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chapter8Section9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
//        numbers.stream()
//                .forEach(number -> System.out.println("The number is " + number));

//        numbers.forEach(System.out::println);
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 207, 218));
        List<User> users = Arrays.asList(user1, user2, user3);

        EmailService emailService = new EmailService();

        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);

        IntStream.range(0, users.size())
                .forEach(i -> {
                    User user = users.get(i);
                    System.out.println(user.getName() + " at index " + i);
                });

    }
}
