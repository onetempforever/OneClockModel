package git.example.dell.clockmodel.mytuij.presenter;


import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.mytuij.model.BannderBean;
import git.example.dell.clockmodel.mytuij.model.IModel;
import git.example.dell.clockmodel.mytuij.model.RMSPBean;
import git.example.dell.clockmodel.mytuij.view.RMIView;

/**
 * Created by LI on 2018/4/9.
 */

public interface IPresenter {
    //-----------获取数据
    void getBannderData(RMIView view, IModel model,Map<String,String> map);
    void getBannder1Data(RMIView view, IModel model);
    //-------------------------楚河汉界-----------------------------

//----------------返回数据

    void setRMSPData(List<RMSPBean.DataBean> data);
    void setBannder(BannderBean bannderBean);
    ;


}
