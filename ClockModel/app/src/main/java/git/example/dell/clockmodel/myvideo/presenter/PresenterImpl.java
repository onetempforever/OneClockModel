package git.example.dell.clockmodel.myvideo.presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.viewInter.HotView;
import git.example.dell.clockmodel.myvideo.viewInter.VideoDetailView;

/**
 * Created by dell on 2018/4/26.
 */

public class PresenterImpl implements IPresenter{
    private HotView hotView;
    private VideoDetailView videoDetailView;
    @Override
    public void showVideoToView(HotModel hotModel, HotView hotView) {
        this.hotView=hotView;
        Map<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("token","4B5D657C7D23644A5BE9454ED8DC1C7E");
        hotModel.getHotData(map);
    }

    @Override
    public void getVideoData(List<VideoBean.DataBean> data) {
        hotView.showVideoSuccess(data);
    }

    @Override
    public void getError(String error) {
            hotView.showVideoError(error);
    }

    @Override
    public void showDetailToView(HotModel hotModel, VideoDetailView videoDetailView) {
        this.videoDetailView=videoDetailView;
        Map<String,String> map=new HashMap<>();
        hotModel.getVideoDetail(map);
    }

    @Override
    public void getVideoDatail(VideoDetailBean.DataBean data) {
       videoDetailView.showVideoDetail(data);

    }

    @Override
    public void geVideotError(String error) {
        videoDetailView.showError(error);
    }
}
