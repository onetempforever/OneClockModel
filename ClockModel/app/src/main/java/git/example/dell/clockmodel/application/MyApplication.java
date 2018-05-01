package git.example.dell.clockmodel.application;

import android.app.Application;
import android.content.Context;

import com.vise.xsnow.http.ViseHttp;

/**
 * Created by ASUS on 2018/4/25.
 */

public class MyApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ViseHttp.init(this);
        context = this;
        ViseHttp.CONFIG()
                //配置请求主机地址
                .baseUrl("https://www.zhaoapi.cn/");
    }

    public static Context getContext(){
        return context;
    }
}
