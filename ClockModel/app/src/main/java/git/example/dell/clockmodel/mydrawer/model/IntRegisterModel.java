package git.example.dell.clockmodel.mydrawer.model;

import git.example.dell.clockmodel.mydrawer.bean.Register;

/**
 * Created by DELL on 2018/4/27.
 */

public interface IntRegisterModel {

    void LoadeModelRegisterSuccess(Register register);
    void LoadeModelRegisterError(Throwable t);
}
