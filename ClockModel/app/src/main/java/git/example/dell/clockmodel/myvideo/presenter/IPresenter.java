package git.example.dell.clockmodel.myvideo.presenter;

import java.util.List;

import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.viewInter.HotView;
import git.example.dell.clockmodel.myvideo.viewInter.VideoDetailView;

/**
 * Created by dell on 2018/4/26.
 */

public interface IPresenter {
  void showVideoToView(HotModel hotModel, HotView hotView);
  void getVideoData(List<VideoBean.DataBean> data);
  void getError(String error);
  void showDetailToView(HotModel hotModel, VideoDetailView videoDetailView);
  void getVideoDatail(VideoDetailBean.DataBean data);
  void geVideotError(String error);
}
