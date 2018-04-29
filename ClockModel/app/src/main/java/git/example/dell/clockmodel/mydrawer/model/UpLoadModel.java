package git.example.dell.clockmodel.mydrawer.model;

import java.io.File;

import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.RegBean;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by DELL on 2018/4/26.
 */

public class UpLoadModel implements GetUpLoadModel{

    @Override
    public void getUpLoadModelData(String uid, File file, final IntUpLoadModel intUpLoadModel) {

        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file",file.getName(), RequestBody.create(
                MediaType.parse("application/octet-stream"),file));
        MyServcie retrofit = RetrofitUtils.getInData().getRetrofit(API.UPLOADINGHEAD_URL, MyServcie.class);

        Flowable<RegBean> flowable = retrofit.getClockUpLoad(uid, filePart);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RegBean>() {
                    @Override
                    public void onNext(RegBean regBean) {
                        intUpLoadModel.LoadeModelUpLoadSuccess(regBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        intUpLoadModel.LoadeModelUpLoadError(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
