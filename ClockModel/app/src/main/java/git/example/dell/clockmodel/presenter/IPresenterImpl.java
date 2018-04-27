package git.example.dell.clockmodel.presenter;


import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.model.BannderBean;
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

    @Override
    public void getBannder1Data(RMIView view, IModel model) {
        this.view = view;
       model.getBannder1Bann();

    }

    //--------------------------
    @Override
    public void setRMSPData(List<RMSPBean.DataBean> data) {
       view.setSPData(data);
    }

    @Override
    public void setBannder(BannderBean bannderBean) {
        List<BannderBean.DataBean> data = bannderBean.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0;i<data.size();i++){
            String icon = data.get(i).getIcon();
            list.add(icon);
            Log.d(TAG, "setBannderData: -----------"+icon);
        }

        view.setBannderData(list);

    }


}
