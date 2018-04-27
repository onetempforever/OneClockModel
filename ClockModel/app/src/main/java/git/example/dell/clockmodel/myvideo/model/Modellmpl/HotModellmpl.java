package git.example.dell.clockmodel.myvideo.model.Modellmpl;

import java.util.HashMap;
import java.util.Map;

import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.presenter.IPresenter;
import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/4/26.
 */

public class HotModellmpl implements HotModel {
    private IPresenter iPresenter;

    public HotModellmpl(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }


    @Override
    public void getHotData() {
        Map<String,String> map = new HashMap<>();
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie retrofit = inData.getRetrofit(API.base_url, MyServcie.class);
        map.put("page","1");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("token","4B5D657C7D23644A5BE9454ED8DC1C7E");
        retrofit.getVideodata(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<VideoBean>() {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        iPresenter.getVideoData(videoBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

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
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<VideoDetailBean>() {
                    @Override
                    public void onNext(VideoDetailBean videoDetailBean) {
                        iPresenter.getVideoDatail(videoDetailBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
