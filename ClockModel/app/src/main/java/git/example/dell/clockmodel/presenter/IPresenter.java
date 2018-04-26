package git.example.dell.clockmodel.presenter;

import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.model.IModel.HotModel;
import git.example.dell.clockmodel.model.VideoBean;
import git.example.dell.clockmodel.view.HotView;

/**
 * Created by dell on 2018/4/26.
 */

public interface IPresenter {
  void showVideoToView(HotModel hotModel, HotView hotView);
  void getVideoData(List<VideoBean.DataBean> data);
  void getError(String error);
}
