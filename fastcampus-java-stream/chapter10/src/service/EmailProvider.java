package service;

import model.User;

public interface EmailProvider {
    String getEmail(User user);
}
