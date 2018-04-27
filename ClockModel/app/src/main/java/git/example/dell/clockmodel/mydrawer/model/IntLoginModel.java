package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;

/**
 * Created by DELL on 2018/4/27.
 */

public interface IntLoginModel {

    void LoadeModelLoginSuccess(LoginBean loginBean);
    void LoadeModelLoginError(Throwable t);
}
