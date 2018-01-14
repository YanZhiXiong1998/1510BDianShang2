package yanzhixiong20170108.week3.login.model;

import java.util.Map;

import io.reactivex.Observable;
import yanzhixiong20170108.week3.login.canstant.LoginApi;
import yanzhixiong20170108.week3.login.model.bean.Login_Bean;
import yanzhixiong20170108.week3.utils.RetrofitManager;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class LoginModel implements IModel{

    public Observable<Login_Bean> login(Map<String,String> map){
        LoginApi loginApi = RetrofitManager.getinstance().create(LoginApi.class);
        return loginApi.login(map);
    }
}
