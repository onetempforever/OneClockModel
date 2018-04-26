package git.example.dell.clockmodel.presenter;


import android.support.v4.app.FragmentActivity;

import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.model.IModel;
import git.example.dell.clockmodel.model.IModelImpl;
import git.example.dell.clockmodel.model.RMSPBean;
import git.example.dell.clockmodel.view.RMIView;

/**
 * Created by LI on 2018/4/9.
 */

public class IPresenterImpl implements IPresenter {
    private static final String TAG = "IPresenterImpl";
    private RMIView view;


    @Override
    public void getBannderData(RMIView view, IModel model, Map<String, String> map) {
        this.view = view;
        model.getBannderBean(map);

    }
//--------------------------
    @Override
    public void setRMSPData(List<RMSPBean.DataBean> data) {

    }


}
