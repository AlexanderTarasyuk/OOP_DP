package model;

import lombok.Data;
import lombok.ToString;

/**
 * Created by t420 on 26.04.2018.
 */

@Data
@ToString
public abstract class AbstractUser {

    protected int id;
    protected String login;
    protected String password;
    protected String FIO;


}
