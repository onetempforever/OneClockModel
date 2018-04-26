package git.example.dell.clockmodel.myvideo.viewInter;

import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;

/**
 * Created by dell on 2018/4/26.
 */

public interface VideoDetailView {
    void showVideoDetail(VideoDetailBean.DataBean data);
    void showSuccess(String json);
    void showError(String json);
}
