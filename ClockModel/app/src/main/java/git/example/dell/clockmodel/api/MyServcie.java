package git.example.dell.clockmodel.api;

import java.util.Map;

import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by dell on 2018/4/26.
 */

public interface MyServcie {
    @GET("quarter/getHotVideos")
    Flowable<VideoBean> getVideodata(@QueryMap Map<String,String> map);
    @GET("quarter/getVideoDetail")
    Flowable<VideoDetailBean> getVideoDateil(@QueryMap Map<String,String> map);
    //获取附近视频
    @GET("quarter/getNearVideos")
    Flowable<NearBarBean> getNearbar(@QueryMap Map<String,String> map);
    //附近视频详情

}
