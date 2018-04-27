package git.example.dell.clockmodel.api;

import java.util.Map;

import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by dell on 2018/4/26.
 */

public interface MyServcie {
    @GET("quarter/getHotVideos")
    Observable<VideoBean> getVideodata(@QueryMap Map<String,String> map);
    @GET("quarter/getVideoDetail")
    Observable<VideoDetailBean> getVideoDateil(@QueryMap Map<String,String> map);
}
