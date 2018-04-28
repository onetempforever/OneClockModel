package git.example.dell.clockmodel.myvideo.presenter;

import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.viewInter.HotView;
import git.example.dell.clockmodel.myvideo.viewInter.NearBarView;
import git.example.dell.clockmodel.myvideo.viewInter.NearDetailView;
import git.example.dell.clockmodel.myvideo.viewInter.VideoDetailView;

/**
 * Created by dell on 2018/4/26.
 */

public interface IPresenter {
  void showVideoToView(HotModel hotModel, HotView hotView);
  void getVideoData(List<VideoBean.DataBean> data);
  void getError(String error);
  void showDetailToView(HotModel hotModel, VideoDetailView videoDetailView, Map<String, String> map);
  void getVideoDatail(VideoDetailBean.DataBean data);
  void geVideotError(String error);
  //展示附近视频图片
  void showNearbarToView(HotModel hotModel, NearBarView nearBarView);
  void getNearbarData(List<NearBarBean.DataBean> data);
  void getNearbarError(String error);
  //展示附近视频图片详情
  void showNearToView(HotModel hotModel, NearDetailView nearDetailView, Map<String, String> map);
  void getNearDatail(List<NearBarBean.DataBean> data);
  void getNearError(String error);
}
