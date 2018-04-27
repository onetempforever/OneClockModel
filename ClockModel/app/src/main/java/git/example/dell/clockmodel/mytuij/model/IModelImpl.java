package git.example.dell.clockmodel.mytuij.model;


import android.util.Log;

import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.mytuij.presenter.IPresenter;
import git.example.dell.clockmodel.mytuij.utils.Myse;
import git.example.dell.clockmodel.mytuij.utils.RetrofitUtils;
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
        Myse retrofit = retrofitUtils.getRetrofit("https://www.zhaoapi.cn/", Myse.class);
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
                        List<RMSPBean.DataBean> data = rmspBean.getData();
                        iPresenter.setRMSPData(data);
                    }
                });
    }

    @Override
    public void getBannder1Bann() {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        Myse retrofit = retrofitUtils.getRetrofit("https://www.zhaoapi.cn/", Myse.class);
        Subscription subscribe = retrofit.getBannder()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannderBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted:----------成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onCompleted:----------失败"+e.getMessage());
                    }

                    @Override
                    public void onNext(BannderBean bannderBean) {
                      iPresenter.setBannder(bannderBean);
                    }
                });
    }
}
