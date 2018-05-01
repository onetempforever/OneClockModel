package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.model.IntLoginModel;
import git.example.dell.clockmodel.mydrawer.model.LoginModel;
import git.example.dell.clockmodel.mydrawer.view.LoginView;

/**
 * Created by DELL on 2018/4/26.
 */

public class LoginPresenter implements GetLoginPresenter{
    @Override
    public void getLoginPresenterData(String mobile, String password, final LoginView view) {
        LoginModel loginModel = new LoginModel();
        loginModel.getLodinModelData(mobile, password, new IntLoginModel() {
            @Override
            public void LoadeModelLoginSuccess(LoginBean loginBean) {
                view.LoadeViewLoginSuccess(loginBean);
            }

            @Override
            public void LoadeModelLoginError(Throwable t) {
                view.LoadeViewLoginError(t);
            }
        });
    }
}
