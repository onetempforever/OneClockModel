package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.RegBean;

/**
 * Created by DELL on 2018/4/27.
 */

public interface IntUpLoadModel {

    void LoadeModelUpLoadSuccess(RegBean regBean);
    void LoadeModelUpLoadError(Throwable t);
}
