package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;

/**
 * Created by DELL on 2018/4/27.
 */

public interface IntUserInfoModel {

    void LoadeModelUserInfoSuccess(UserInfoBean userInfoBean);
    void LoadeModelUserInfoError(Throwable t);
}
