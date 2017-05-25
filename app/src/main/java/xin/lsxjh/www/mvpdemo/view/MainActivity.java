package xin.lsxjh.www.mvpdemo.view;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import xin.lsxjh.www.mvpdemo.R;
import xin.lsxjh.www.mvpdemo.bean.User;
import xin.lsxjh.www.mvpdemo.databinding.ActivityMainBinding;
import xin.lsxjh.www.mvpdemo.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText etUserName;
    EditText etPwd;
    Button btnLogin;
    private LoginPresenter presenter;

    protected ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       // initView();


        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User();
        user.setName("我是绑定的数据");
        binding.setUser(user);

        btnLogin = binding.btnLogin;
        presenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.etUserName.getText().toString().trim();
                String pwd = binding.etPwd.getText().toString().trim();
                presenter.login(userName,pwd);
            }
        });
    }





    @Override
    public void showProgressDialog(String msg) {
        if (pd != null && pd.isShowing()) {
            pd.setMessage(msg);
        } else {
            pd = new ProgressDialog(this);
            pd.setCanceledOnTouchOutside(false);
            pd.setMessage(msg);
            pd.show();
        }
    }

    @Override
    public void closeProgressDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        pd = null;
    }

    @Override
    public void loginSuccess(User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("欢迎您："+user.getName())
                .setPositiveButton("确定",null)
                .create().show();
    }

    @Override
    public void loginFaild(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("登录失败："+msg)
                .setPositiveButton("确定",null)
                .create().show();
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
