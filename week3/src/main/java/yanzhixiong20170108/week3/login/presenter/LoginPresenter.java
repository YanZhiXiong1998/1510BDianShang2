package yanzhixiong20170108.week3.login.presenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import yanzhixiong20170108.week3.login.model.LoginModel;
import yanzhixiong20170108.week3.login.model.bean.Login_Bean;
import yanzhixiong20170108.week3.login.view.LoginView;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class LoginPresenter extends IPresenter<LoginView>{

    private LoginModel loginModel;

    public LoginPresenter(LoginView view) {
        super(view);
    }

    @Override
    protected void inti() {
        loginModel=new LoginModel();
    }
    //登录
    public void login( ){
        Map<String,String> map=new HashMap<>();
        String name = view.getname();
        String getpwd = view.getpwd();
        map.put("mobile",name);
        map.put("password",getpwd);
        Observable<Login_Bean> login = loginModel.login(map);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login_Bean>() {
                               @Override
                               public void accept(Login_Bean login_bean) throws Exception {
                                   view.LoginSuccess(login_bean);
                               }
                           }
                        , new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                view.LoginFaild(throwable);
                            }
                        }
                );
    }
}
