package yanzhixiong20170108.week3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import yanzhixiong20170108.week3.login.model.bean.Login_Bean;
import yanzhixiong20170108.week3.login.presenter.LoginPresenter;
import yanzhixiong20170108.week3.login.view.LoginView;
import yanzhixiong20170108.week3.shop.ShopActivity;

public class MainActivity extends AppCompatActivity implements LoginView {

    @InjectView(R.id.login_name)
    EditText loginName;
    @InjectView(R.id.login_user)
    EditText loginUser;
    @InjectView(R.id.login_login)
    Button loginLogin;
    @InjectView(R.id.login_zhuce)
    TextView loginZhuce;
    private LoginPresenter loginPresenter;
    private CheckBox rem_pw;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        sp = this.getSharedPreferences("userInfo", MODE_PRIVATE);
        loginPresenter = new LoginPresenter(this);
        rem_pw = (CheckBox) findViewById(R.id.cb_mima);

        //判断记住密码多选框的状态
        if (sp.getBoolean("ISCHECK",false)){
            //设置默认是记录密码状态
            rem_pw.setChecked(true);
            loginName.setText(sp.getString("USER_NAME", ""));
            loginUser.setText(sp.getString("PASSWORD", ""));

        }


        //监听记住密码多选框按钮事件
        rem_pw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rem_pw.isChecked()) {

                    System.out.println("记住密码已选中");
                    sp.edit().putBoolean("ISCHECK", true).commit();

                }else {

                    System.out.println("记住密码没有选中");
                    sp.edit().putBoolean("ISCHECK", false).commit();

                }

            }
        });
    }

    @Override
    public void LoginSuccess(Login_Bean login_bean) {
        editor.putInt("uid",login_bean.getData().getUid());
        editor.commit();
        Toast.makeText(this, login_bean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFaild(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getname() {
        return loginName.getText().toString().trim();
    }

    @Override
    public String getpwd() {
        return loginUser.getText().toString().trim();
    }

    @OnClick({R.id.login_login, R.id.login_zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_login:
                String name = loginName.getText().toString().trim();
                String pwd = loginUser.getText().toString().trim();
                //记住用户名、密码、
                editor = sp.edit();
                editor.putString("USER_NAME", name);
                editor.putString("PASSWORD",pwd);
                editor.commit();
                loginPresenter.login();
                Intent intent=new Intent(MainActivity.this,ShopActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login_zhuce:
                break;
        }
    }
}
