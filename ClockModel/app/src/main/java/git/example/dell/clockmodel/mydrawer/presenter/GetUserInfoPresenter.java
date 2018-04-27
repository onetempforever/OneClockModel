package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.UserInfoView;

/**
 * Created by DELL on 2018/4/27.
 */

public interface GetUserInfoPresenter {

    void getUserInfoPresenterData(String uid,String token, UserInfoView userInfoView);
}
