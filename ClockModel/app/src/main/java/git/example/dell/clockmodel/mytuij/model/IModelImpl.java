package git.example.dell.clockmodel.mytuij.model;


import android.util.Log;

import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.mytuij.presenter.IPresenter;
import git.example.dell.clockmodel.mytuij.utils.Myse;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

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
        Flowable<RMSPBean> flowable = retrofit.getRMSPData(map);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RMSPBean>() {
                    @Override
                    public void onNext(RMSPBean rmspBean) {
                         Log.d(TAG, "onNext:==========="+rmspBean.getMsg());
                        List<RMSPBean.DataBean> data = rmspBean.getData();
                        iPresenter.setRMSPData(data);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void getBannder1Bann() {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        Myse retrofit = retrofitUtils.getRetrofit("https://www.zhaoapi.cn/", Myse.class);
        Flowable<BannderBean> flowable = retrofit.getBannder();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())


                .subscribeWith(new DisposableSubscriber<BannderBean>() {

                    @Override
                    public void onNext(BannderBean bannderBean) {
                        iPresenter.setBannder(bannderBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }


                });
    }

    @Override
    public void getGuanZhu(Map<String, String> map) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getInData();
        Myse retrofit = retrofitUtils.getRetrofit("https://www.zhaoapi.cn/", Myse.class);
        Flowable<RMSPBean> flowable = retrofit.getRMSPData(map);
        flowable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RMSPBean>() {
                    @Override
                    public void onNext(RMSPBean rmspBean) {
                        Log.d(TAG, "onNext:===========关注+111111111"+rmspBean.getMsg()+rmspBean.getData().size());
                        List<RMSPBean.DataBean> data = rmspBean.getData();
                        iPresenter.setGuanZhuData(data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, "onError: ---------关注失败");

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onCompleted: --------关注成功");

                    }
                });
    }
}
