package git.example.dell.clockmodel.myvideo.viewInter;

import java.util.List;

import git.example.dell.clockmodel.myvideo.model.VideoBean;

/**
 * Created by dell on 2018/4/26.
 */

public interface HotView {
    //展示数据
    void showVideoSuccess(List<VideoBean.DataBean> data);
    void showVideoError(String error);
}
