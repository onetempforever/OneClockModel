package git.example.dell.clockmodel.myvideo.model.Modellmpl;

import android.util.Log;

import java.util.Map;

import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.presenter.IPresenter;
import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by dell on 2018/4/26.
 */

public class HotModellmpl implements HotModel {
    private IPresenter iPresenter;

    public HotModellmpl(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void getHotData(Map<String, String> map) {
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie myServcie = inData.getRetrofit(API.base_url, MyServcie.class);
        myServcie.getVideodata(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<VideoBean>() {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        iPresenter.getVideoData(videoBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("videoError",t.toString());
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
    public void getNearbar(Map<String, String> map) {
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie myServcie = inData.getRetrofit(API.base_url, MyServcie.class);
        myServcie.getNearbar(map)
                .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
                .subscribeWith(new DefaultSubscriber<NearBarBean>() {
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
}
