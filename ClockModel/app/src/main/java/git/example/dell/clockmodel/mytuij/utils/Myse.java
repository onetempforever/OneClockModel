package git.example.dell.clockmodel.mytuij.utils;

import java.util.Map;

import git.example.dell.clockmodel.mytuij.model.BannderBean;
import git.example.dell.clockmodel.mytuij.model.RMSPBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public interface Myse {
    @GET("quarter/getVideos")
    Flowable<RMSPBean> getRMSPData(@QueryMap Map<String,String> map);
    @GET("quarter/getAd")
    Flowable<BannderBean> getBannder();
}
