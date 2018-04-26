package git.example.dell.clockmodel.model;


import android.util.Log;

import java.util.Map;

import git.example.dell.clockmodel.presenter.IPresenter;
import git.example.dell.clockmodel.utils.MyService;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by LI on 2018/4/9.
 */

public class IModelImpl implements IModel{
    private IPresenter iPresenter;
    private static final String TAG = "IModelImpl";

    public IModelImpl(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }



    @Override
    public void getBannderBean(Map<String, String> map) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        MyService retrofit = retrofitUtils.getRetrofit("https://www.zhaoapi.cn/", MyService.class);
        Subscription subscribe = retrofit.getRMSPData(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RMSPBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RMSPBean rmspBean) {
                        Log.d(TAG, "onNext:==========="+rmspBean.getMsg());
                    }
                });
    }
}
