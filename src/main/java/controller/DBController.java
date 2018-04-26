package controller;

import lombok.Data;
import model.AbstractUser;
import model.User;
import view.View;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by t420 on 26.04.2018.
 */
@Data
public class DBController implements IController {

    //DB
    private static List<User> users = User.userList;
    //view
    private static View main;

    //just lock
    Lock lock = new ReentrantLock(true);


    @Override
    public void addUser(User user) {
        lock.lock();
        users.add(user);
        lock.unlock();

        System.out.println("Added" + user.toString());

    }

    @Override
    public void deleteUser(String login) {
        AbstractUser user = null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)) {
                user = users.get(i);
                break;
            }

        }
        if (user != null) {
            System.out.println("Deleted" + user.toString());
            users.remove(user);

        }

    }

    @Override
    public void showAllUsers() {
        System.out.println("DB consists of:  ");
        users.stream().forEach(p -> System.out.println(p.toString()));

    }

    @Override
    public void clearDB() {
        if (users != null)
            users.clear();
        System.out.println("DB cleared");

    }
}
