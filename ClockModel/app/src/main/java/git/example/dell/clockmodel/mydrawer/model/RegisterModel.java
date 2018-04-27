package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.Register;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by DELL on 2018/4/26.
 */

public class RegisterModel implements GetRegisterModel{

    @Override
    public void getRegisterModelData(String mobile, String password, final IntRegisterModel intRegisterModel) {
        MyServcie retrofit = RetrofitUtils.getInData().getRetrofit(API.Regiest_URL, MyServcie.class);

        Flowable<Register> flowable = retrofit.getClockRegiest(mobile, password);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Register>() {
                    @Override
                    public void onNext(Register register) {

                        intRegisterModel.LoadeModelRegisterSuccess(register);
                    }

                    @Override
                    public void onError(Throwable t) {
                        intRegisterModel.LoadeModelRegisterError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
