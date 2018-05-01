package git.example.dell.clockmodel.api;

import java.util.Map;

import git.example.dell.clockmodel.shangchuanduanzi.CrossTalkBean;
import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.Register;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/4/26.
 */

public interface MyServcie {

    @GET("quarter/getHotVideos")
    Flowable<VideoBean> getVideodata(@QueryMap Map<String, String> map);

    @GET("quarter/getVideoDetail")
    Flowable<VideoDetailBean> getVideoDateil(@QueryMap Map<String, String> map);

    //获取附近视频
    @GET("quarter/getNearVideos")
    Flowable<NearBarBean> getNearbar(@QueryMap Map<String, String> map);

    //附近视频详情
    Observable<NearBarBean> getNearDateil(@QueryMap Map<String, String> map);

    @GET("login")
    Flowable<LoginBean> getClockLogin(@Query("mobile") String mobile, @Query("password") String password);

    //注册register?mobile=15566667777&password=123456
    @GET("register")
    Flowable<Register> getClockRegiest(@Query("mobile") String mobile, @Query("password") String password);

    /*  //上传头像
      @GET("upload")
      Flowable<>*/
    //用户信息
    @GET("getUserInfo")
    Flowable<UserInfoBean> getUserInfo(@Query("uid") String uid, @Query("token") String token);

    //上传段子
    @GET("publishJoke")
    Flowable<CrossTalkBean> publishJoke(@QueryMap Map<String, String> ma);


}
