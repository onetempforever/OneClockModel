package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.RegisterView;

/**
 * Created by DELL on 2018/4/27.
 */

public interface GetRegisterPresenter {

    void getRegisterPresenterData(String mobile, String password, RegisterView registerView);
}
