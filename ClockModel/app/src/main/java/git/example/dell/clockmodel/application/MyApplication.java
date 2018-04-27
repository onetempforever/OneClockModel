package git.example.dell.clockmodel.application;

import android.app.Application;

import com.vise.xsnow.http.ViseHttp;

/**
 * Created by ASUS on 2018/4/25.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ViseHttp.init(this);
        ViseHttp.CONFIG()
                //配置请求主机地址
                .baseUrl("https://www.zhaoapi.cn/");
    }
}
