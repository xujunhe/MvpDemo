package xin.lsxjh.www.mvpdemo.module;

import xin.lsxjh.www.mvpdemo.bean.User;

/**
 * Created by olyls on 2017/5/25.
 */

public interface ILoginModule {

    User login(String userName, String pwd);
}
