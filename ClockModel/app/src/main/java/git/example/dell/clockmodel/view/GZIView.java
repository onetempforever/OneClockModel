package git.example.dell.clockmodel.view;



import java.util.List;

import git.example.dell.clockmodel.model.RMSPBean;

/**
 * Created by LI on 2018/4/18.
 */

public interface GZIView {
    void setBannderData(List<String> bannder_url);
    void setSPData(List<RMSPBean.DataBean> data);

}
