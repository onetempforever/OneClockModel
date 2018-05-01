package git.example.dell.clockmodel.mydrawer.view;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.Register;

/**
 * Created by DELL on 2018/4/26.
 */

public interface RegisterView {
    void LoadeViewRegisterSuccess(Register register);
    void LoadeViewRegisterError(Throwable t);


}
