package git.example.dell.clockmodel.myvideo.viewInter;

import java.util.List;

import git.example.dell.clockmodel.bean.NearBarBean;

/**
 * Created by dell on 2018/4/27.
 */

public interface NearDetailView {
    //附近视频详情
    void showNearDetail(List<NearBarBean.DataBean> data);
    void showSuccess(String json);
    void showError(String error);
}
