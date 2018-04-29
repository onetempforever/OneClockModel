package git.example.dell.clockmodel.mydrawer.view;

import git.example.dell.clockmodel.mydrawer.bean.RegBean;

/**
 * Created by DELL on 2018/4/28.
 */

public interface UpLoadView {

    void LoadeViewUpLoadSuccess(RegBean regBean);
    void LoadeViewUpLoadError(Throwable t);
}
