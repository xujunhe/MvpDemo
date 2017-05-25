package xin.lsxjh.www.mvpdemo.module;

import java.util.ArrayList;
import java.util.List;
import xin.lsxjh.www.mvpdemo.bean.User;

/**
 * Created by olyls on 2017/5/25.
 */

public class LoginModule implements ILoginModule{

    List<User> userTables = new ArrayList<>();
    {
        User user = new User();
        user.setPwd("123");
        user.setName("xxx");
        userTables.add(user);
    }

    @Override
    public User login(String name,String pwd)
    {
        for (User user:
             userTables) {
            if (name.equals(user.getName())&&pwd.equals(user.getPwd()))

                return user;
        }
        return null;
    }










}
