package yanzhixiong20170108.week3.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:Created by YanZhiXiong on 2018/1/13.
 */

public class ImageloderUtils extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
