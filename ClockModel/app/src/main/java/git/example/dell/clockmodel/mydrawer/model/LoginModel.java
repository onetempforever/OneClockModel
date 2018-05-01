package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by DELL on 2018/4/26.
 */

public class LoginModel implements GetLoginModel{
    @Override
    public void getLodinModelData(String mobile, String password, final IntLoginModel intLoginModel) {

        MyServcie retrofit = RetrofitUtils.getInData().getRetrofit(API.LOGIN_URL, MyServcie.class);

        Flowable<LoginBean> flowable = retrofit.getClockLogin(mobile, password);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {

                        intLoginModel.LoadeModelLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        intLoginModel.LoadeModelLoginError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
