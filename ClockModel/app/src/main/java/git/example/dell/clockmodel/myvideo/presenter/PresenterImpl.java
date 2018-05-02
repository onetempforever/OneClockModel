package git.example.dell.clockmodel.myvideo.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.application.MyApplication;
import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.IModel.HotModel;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.viewInter.HotView;
import git.example.dell.clockmodel.myvideo.viewInter.NearBarView;
import git.example.dell.clockmodel.myvideo.viewInter.NearDetailView;
import git.example.dell.clockmodel.myvideo.viewInter.ShangChuanView;
import git.example.dell.clockmodel.myvideo.viewInter.VideoDetailView;
import git.example.dell.clockmodel.shangchuanduanzi.CrossTalkBean;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;
import retrofit2.http.HEAD;

/**
 * Created by dell on 2018/4/26.
 */

public class PresenterImpl implements IPresenter {
    private HotView hotView;
    private VideoDetailView videoDetailView;
    private NearBarView nearBarView;
    private static final String TAG = "PresenterImpl";
    private NearDetailView nearDetailView;
    private ShangChuanView ShangChuanView;

    @Override
    public void showVideoToView(HotModel hotModel, HotView hotView) {
        Log.e("==============","showVideoToView");
        this.hotView = hotView;
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("token", "4B5D657C7D23644A5BE9454ED8DC1C7E");
        hotModel.getHotData(map);

    }
    @Override
    public void getVideoData(List<VideoBean.DataBean> data) {
        Log.e("------",""+data.size());
        hotView.showVideoSuccess(data);
    }
    @Override
    public void getError(String error) {
        hotView.showVideoError(error);
    }

    @Override
    public void showDetailToView(HotModel hotModel, VideoDetailView videoDetailView, Map<String, String> map) {
        this.videoDetailView = videoDetailView;
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

    @Override
    public void showNearbarToView(HotModel hotModel, NearBarView nearBarView) {
        this.nearBarView = nearBarView;
        Map<String, String> map = new HashMap<>();
         map.put("latitude","39.95");
         map.put("longitude","116.30");
         map.put("token","4B5D657C7D23644A5BE9454ED8DC1C7E");
         map.put("source","android");
         map.put("appVersion","101");
         hotModel.getNearbar(map);
    }

    @Override
    public void getNearbarData(List<NearBarBean.DataBean> data) {
        Log.e("回调了","嗯嗯");
        nearBarView.showNearbar(data);
    }

    @Override
    public void getNearbarError(String error) {
        Log.e(TAG, "getNearbarError: 错误"+error );
    }

    @Override
    public void showNearToView(HotModel hotModel, NearDetailView nearDetailView, Map<String, String> map) {
        this.nearDetailView=nearDetailView;
        hotModel.getNearbar(map);
    }

    @Override
    public void getNearDatail(List<NearBarBean.DataBean> data) {
        nearDetailView.showNearDetail(data);
    }

    @Override
    public void getNearError(String error) {

    }
    //上传段子
    @Override
    public void getshangchuan(HotModel hotModel, ShangChuanView shangChuanView,String contex) {
        this.ShangChuanView=shangChuanView;
        Map<String,String> map=new HashMap<>();
        String uid = (String) SharedPreferencesUtils.getParam(MyApplication.getContext(), "uid","");
        map.put("uid", uid);
        map.put("content",contex);
        hotModel.getduanzai(map);
    }

    @Override
    public void getshangchuanlist(Object o) {
        CrossTalkBean v= (CrossTalkBean) o;
        Log.e("tag",v.getMsg());
        ShangChuanView.ShangChuanView(o);

    }

    @Override
    public void getshangchuanErroe(String error) {
        Log.e("tag",error);
        ShangChuanView.ShangChuanViewError(error);
    }
}
