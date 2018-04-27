package git.example.dell.clockmodel.mytuij.view;



import java.util.List;

import git.example.dell.clockmodel.mytuij.model.RMSPBean;

/**
 * Created by LI on 2018/4/10.
 */

public interface RMIView  {
    void setBannderData(List<String> bannder_url);
    void setSPData(List<RMSPBean.DataBean> data);
}
