package git.example.dell.clockmodel.utils;

import java.util.Map;

import git.example.dell.clockmodel.model.VideoBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by dell on 2018/4/26.
 */

public interface MyServcie {
    @GET("quarter/getHotVideos")
    Observable<VideoBean> getVideodata(@QueryMap Map<String,String> map);
}
