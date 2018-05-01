package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.mydrawer.view.LoginView;

/**
 * Created by DELL on 2018/4/27.
 */

public interface GetLoginPresenter {

    void getLoginPresenterData(String mobile,String password,LoginView view);
}
