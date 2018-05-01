package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.mydrawer.model.IntLoginModel;
import git.example.dell.clockmodel.mydrawer.model.IntUserInfoModel;
import git.example.dell.clockmodel.mydrawer.model.LoginModel;
import git.example.dell.clockmodel.mydrawer.model.UserInfoModel;
import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.UserInfoView;

/**
 * Created by DELL on 2018/4/26.
 */

public class UserInfoPresenter implements GetUserInfoPresenter{

    @Override
    public void getUserInfoPresenterData(String uid,String token, final UserInfoView userInfoView) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.getUserInfoModelData(uid,token, new IntUserInfoModel() {
            @Override
            public void LoadeModelUserInfoSuccess(UserInfoBean userInfoBean) {
                userInfoView.LoadeViewUserInfoSuccess(userInfoBean);
            }

            @Override
            public void LoadeModelUserInfoError(Throwable t) {
                userInfoView.LoadeViewUserInfoError(t);

            }
        });
    }
}
