package service;

import model.User;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserSerivceInFunctionalWay {
    private final Predicate<User> validateUser;
    private final Consumer<User> writeToDB;
    public UserSerivceInFunctionalWay(Predicate<User> validateUser, Consumer<User> writeToDB){
        this.validateUser = validateUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(User user) {
        if (validateUser.test(user)) {
            writeToDB.accept(user);
        } else {
            System.out.println("Cannot create user");
        }
    }
}
