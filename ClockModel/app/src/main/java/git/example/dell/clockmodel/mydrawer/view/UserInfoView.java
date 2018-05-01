package git.example.dell.clockmodel.mydrawer.view;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;

/**
 * Created by DELL on 2018/4/26.
 */

public interface UserInfoView {
    void LoadeViewUserInfoSuccess(UserInfoBean userInfoBean);
    void LoadeViewUserInfoError(Throwable t);


}
