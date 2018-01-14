package yanzhixiong20170108.week3.login.view;


import yanzhixiong20170108.week3.login.model.bean.Login_Bean;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public interface LoginView extends IView{
    void LoginSuccess(Login_Bean login_bean);
    void LoginFaild(Throwable throwable);

    String getname();
    String getpwd();
}
