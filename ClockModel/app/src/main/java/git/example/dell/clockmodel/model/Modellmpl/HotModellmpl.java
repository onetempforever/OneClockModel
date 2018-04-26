package git.example.dell.clockmodel.model.Modellmpl;

import java.util.HashMap;
import java.util.Map;

import git.example.dell.clockmodel.model.IModel.HotModel;
import git.example.dell.clockmodel.model.VideoBean;
import git.example.dell.clockmodel.presenter.IPresenter;
import git.example.dell.clockmodel.utils.HttpConfig;
import git.example.dell.clockmodel.utils.MyServcie;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
    public void getHotData(Map<String, String> map) {
        RetrofitUtils inData = RetrofitUtils.getInData();
        MyServcie myServcie = inData.getRetrofit(HttpConfig.base_url, MyServcie.class);
        myServcie.getVideodata(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

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
}
