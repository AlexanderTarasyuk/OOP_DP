package controller;

import model.AbstractUser;
import model.User;

/**
 * Created by t420 on 26.04.2018.
 */
public interface IController {

    public void addUser(User user);

    void deleteUser(String login);

    void showAllUsers();

    void clearDB();
}
