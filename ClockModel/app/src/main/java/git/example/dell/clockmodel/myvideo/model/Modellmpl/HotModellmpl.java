package git.example.dell.clockmodel.myvideo.model.Modellmpl;

import java.util.Map;

import git.example.dell.clockmodel.application.MyApplication;
import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.presenter.IPresenter;
import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.shangchuanduanzi.CrossTalkBean;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import retrofit2.http.HEAD;

/**
 * Created by dell on 2018/4/26.
 */

public class HotModellmpl implements HotModel {
    private IPresenter iPresenter;
    private static final String TAG = "HotModellmpl";
    public HotModellmpl(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }


    @Override
    public void getHotData(Map<String, String> map) {
        Log.e("============","==============");
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie retrofit = inData.getRetrofit(API.base_url, MyServcie.class);
        map.put("page", "1");
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("token", "4B5D657C7D23644A5BE9454ED8DC1C7E");
        retrofit.getVideodata(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<VideoBean>() {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        iPresenter.getVideoData(videoBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                       Log.e("======",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getVideoDetail(Map<String, String> map) {
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie myServcie = inData.getRetrofit(API.base_url, MyServcie.class);
        myServcie.getVideoDateil(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DefaultSubscriber<VideoDetailBean>() {
                    @Override
                    public void onNext(VideoDetailBean videoDetailBean) {
                        iPresenter.getVideoDatail(videoDetailBean.getData());
                        Log.d(TAG, "onNext: hot"+videoDetailBean.getMsg()+"123123");
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("onError",t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getNearbar(Map<String, String> map){
            RetrofitUtils inData = RetrofitUtils.getInData();
            MyServcie myServcie = inData.getRetrofit(API.base_url, MyServcie.class);
            myServcie.getNearbar(map)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableSubscriber<NearBarBean>() {
                        @Override
                        public void onNext(NearBarBean nearBarBean) {
                            iPresenter.getNearbarData(nearBarBean.getData());
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

            }
   //上传段子啊

    @Override
    public void getduanzai(Map<String, String> map) {
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie retrofit = inData.getRetrofit(API.publishJoke, MyServcie.class);
        Log.e("tag",API.base_url+"");
        map.put("appVersion", "101");
        String token = (String) SharedPreferencesUtils.getParam(MyApplication.getContext(),"token", "");
        map.put("token",token );
        map.put("source", "android");
        retrofit.publishJoke(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<CrossTalkBean>() {
                    @Override
                    public void onNext(CrossTalkBean crossTalkBean) {
                         Log.e("tag",crossTalkBean.getMsg()+"上传");

                        iPresenter.getshangchuanlist(crossTalkBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("tag",t.toString()+"上传");
                        iPresenter.getshangchuanErroe(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

