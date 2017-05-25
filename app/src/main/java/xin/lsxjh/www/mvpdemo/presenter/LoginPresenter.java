package xin.lsxjh.www.mvpdemo.presenter;

import android.os.Handler;
import android.support.annotation.Nullable;
import xin.lsxjh.www.mvpdemo.bean.User;
import xin.lsxjh.www.mvpdemo.module.LoginModule;
import xin.lsxjh.www.mvpdemo.view.ILoginView;

/**
 * Created by olyls on 2017/5/25.
 */

public class LoginPresenter {

    private LoginModule module;
    private ILoginView  view;


    public LoginPresenter(ILoginView view) {
        this.view = view;
        module = new LoginModule();
    }

    public void login(final String name, final String pwd)
    {

        if (isEmpty(name))
        {
            view.loginFaild("用户名不能为空");
            return;
        }
        if (isEmpty(pwd))
        {
            view.loginFaild("密码不能为空");
            return;
        }

        view.showProgressDialog("正在登录...");
        //模拟网路延时
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = module.login(name, pwd);
                if (null!=user)
                {
                    view.loginSuccess(user);
                }else
                {
                    view.loginFaild("用户名或密码错误！");
                }

                view.closeProgressDialog();
            }
        },2000);

    }

    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
