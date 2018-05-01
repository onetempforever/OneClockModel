package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by DELL on 2018/4/27.
 */

public class UserInfoModel implements GetUserInfoModel {

    String token="D3F891BF085AFE7177AB8509AA587B54";
    @Override
    public void getUserInfoModelData(String uid,String token, final IntUserInfoModel intUserInfoModel) {

        MyServcie retrofit = RetrofitUtils.getInData().getRetrofit(API.USERINFO_URL, MyServcie.class);

        Flowable<UserInfoBean> flowable = retrofit.getUserInfo(uid,token);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<UserInfoBean>() {
                    @Override
                    public void onNext(UserInfoBean userInfoBean) {
                        intUserInfoModel.LoadeModelUserInfoSuccess(userInfoBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        intUserInfoModel.LoadeModelUserInfoError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
