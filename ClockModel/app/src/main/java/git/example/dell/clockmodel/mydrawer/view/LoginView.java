package git.example.dell.clockmodel.mydrawer.view;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;

/**
 * Created by DELL on 2018/4/26.
 */

public interface LoginView {
    void LoadeViewLoginSuccess(LoginBean loginBean);
    void LoadeViewLoginError(Throwable t);


}
