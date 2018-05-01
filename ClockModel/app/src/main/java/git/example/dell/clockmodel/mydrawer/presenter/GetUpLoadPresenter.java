package git.example.dell.clockmodel.mydrawer.presenter;

import java.io.File;

import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.UpLoadView;

/**
 * Created by DELL on 2018/4/27.
 */

public interface GetUpLoadPresenter {

    void getUpLoadPresenterData(String uid, File file, UpLoadView upLoadView);
}
