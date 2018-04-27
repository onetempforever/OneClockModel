package git.example.dell.clockmodel.duanzi.model;

import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import git.example.dell.clockmodel.bean.GetJokeBean;
import git.example.dell.clockmodel.bean.PostJokesBean;
import git.example.dell.clockmodel.duanzi.mvp.IJokes;
import git.example.dell.clockmodel.duanzi.mvp.NetWorkCallBack;

/**
 * Created by ASUS on 2018/4/25.
 */

public class JokesModel implements IJokes.IGetJokesModel {
    @Override
    public void postJokes(String uid, final String content, String token, final NetWorkCallBack<PostJokesBean> netWorkCallBack) {
//        ViseHttp.BASE(new PostRequest("quarter/publishJoke").addParam())
        ViseHttp.POST("quarter/publishJoke")
                .addParam("source","android")
                .addParam("appVersion","101")
                .addParam("uid", "111")//添加请求参数
                .addParam("content", "111")//添加请求参数
                .addParam("token", "111")//添加请求参数
                .request(new ACallback<PostJokesBean>() {
                    @Override
                    public void onSuccess(PostJokesBean data) {

                        netWorkCallBack.Success(data);
//                        MyAdapter myAdapter=new MyAdapter()
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        netWorkCallBack.Error(errMsg);
                    }
                });
    }

    @Override
    public void getJokes(String page, final NetWorkCallBack<GetJokeBean> netWorkCallBack) {
        ViseHttp.GET("quarter/getJokes")
                .addParam("source","android")
                .addParam("appVersion","101")
                .addParam("page","1")
                .request(new ACallback<GetJokeBean>() {
                    @Override
                    public void onSuccess(GetJokeBean data) {
                        netWorkCallBack.Success(data);
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {
                        netWorkCallBack.Error(errMsg);
                    }
                });
    }
}
