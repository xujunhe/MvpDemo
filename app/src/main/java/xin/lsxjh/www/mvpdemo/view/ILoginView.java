package xin.lsxjh.www.mvpdemo.view;

import xin.lsxjh.www.mvpdemo.bean.User;

/**
 * Created by olyls on 2017/5/25.
 */

public interface ILoginView {

        void showProgressDialog(String msg);
        void closeProgressDialog();

        void loginSuccess(User user);

        void loginFaild(String msg);
}
