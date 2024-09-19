import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Chapter5Section2 {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        System.out.println(strLength.apply("hello world!"));

        BiPredicate<String, String> strEquals = String::equals;
        System.out.println(strEquals.test("hello", "world"));
        System.out.println(strEquals.test("hello", "hello"));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));

        printUserField(users, User::getId);
        printUserField(users, User::getName);
    }

    public static void printUserField(List<User> users, Function<User, Object> getter){
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}
