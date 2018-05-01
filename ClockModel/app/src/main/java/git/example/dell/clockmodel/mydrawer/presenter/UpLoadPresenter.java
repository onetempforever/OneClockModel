package git.example.dell.clockmodel.mydrawer.presenter;

import java.io.File;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.RegBean;
import git.example.dell.clockmodel.mydrawer.model.IntLoginModel;
import git.example.dell.clockmodel.mydrawer.model.IntUpLoadModel;
import git.example.dell.clockmodel.mydrawer.model.LoginModel;
import git.example.dell.clockmodel.mydrawer.model.UpLoadModel;
import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.UpLoadView;

/**
 * Created by DELL on 2018/4/26.
 */

public class UpLoadPresenter implements GetUpLoadPresenter{


    @Override
    public void getUpLoadPresenterData(String uid, File file, final UpLoadView upLoadView) {

        UpLoadModel upLoadModel = new UpLoadModel();
        upLoadModel.getUpLoadModelData(uid, file, new IntUpLoadModel() {
            @Override
            public void LoadeModelUpLoadSuccess(RegBean regBean) {
                upLoadView.LoadeViewUpLoadSuccess(regBean);
            }

            @Override
            public void LoadeModelUpLoadError(Throwable t) {

                upLoadView.LoadeViewUpLoadError(t);

            }
        });
    }
}
