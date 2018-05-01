package git.example.dell.clockmodel.mydrawer.presenter;

import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.api.MyServcie;
import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.Register;
import git.example.dell.clockmodel.mydrawer.model.IntLoginModel;
import git.example.dell.clockmodel.mydrawer.model.IntRegisterModel;
import git.example.dell.clockmodel.mydrawer.model.LoginModel;
import git.example.dell.clockmodel.mydrawer.model.RegisterModel;
import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.mydrawer.view.RegisterView;
import git.example.dell.clockmodel.utils.RetrofitUtils;
import io.reactivex.Flowable;

/**
 * Created by DELL on 2018/4/26.
 */

public class RegisterPresenter implements GetRegisterPresenter{

    @Override
    public void getRegisterPresenterData(String mobile, String password, final RegisterView registerView) {

        RegisterModel registerModel = new RegisterModel();
        registerModel.getRegisterModelData(mobile, password, new IntRegisterModel() {
            @Override
            public void LoadeModelRegisterSuccess(Register register) {
                registerView.LoadeViewRegisterSuccess(register);
            }

            @Override
            public void LoadeModelRegisterError(Throwable t) {
                registerView.LoadeViewRegisterError(t);
            }
        });
    }
}
