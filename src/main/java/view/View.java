package view;

import controller.DBController;
import controller.IController;
import exception.SuchLoginExist;
import lombok.Data;
import model.User;

/**
 * Created by t420 on 26.04.2018.
 */
@Data
public class View {

    private static IController controller;

    public View(IController controller) {
        this.controller = controller;
    }
    public IController getController(){
        return controller;
    }

    public static void main(String[] args) {
        View view = new View(new DBController());


        try {
            controller.addUser(new User("11", "22", "444"));
            controller.addUser(new User("11112", "222", "4443"));
            controller.addUser(new User("1154", "22", "444"));
            controller.deleteUser("111");
            controller.showAllUsers();
            controller.clearDB();


        } catch (SuchLoginExist suchLoginExist) {
            suchLoginExist.printStackTrace();
        }
    }
}
