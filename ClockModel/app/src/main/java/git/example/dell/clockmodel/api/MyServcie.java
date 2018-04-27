package git.example.dell.clockmodel.api;

import java.util.Map;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.bean.Register;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.myvideo.model.VideoBean;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by dell on 2018/4/26.
 */

public interface MyServcie {

    @GET("quarter/getHotVideos")
    Observable<VideoBean> getVideodata(@QueryMap Map<String,String> map);
    @GET("quarter/getVideoDetail")
    Observable<VideoDetailBean> getVideoDateil(@QueryMap Map<String,String> map);
    //登录login?mobile=15566667777&password=123456
    @GET("login")
    Flowable<LoginBean> getClockLogin(@Query("mobile")String mobile,@Query("password")String password);
    //注册register?mobile=15566667777&password=123456
    @GET("register")
    Flowable<Register> getClockRegiest(@Query("mobile")String mobile, @Query("password")String password);

  /*  //上传头像
    @GET("upload")
    Flowable<>*/
    //用户信息
    @GET("getUserInfo")
    Flowable<UserInfoBean> getUserInfo(@Query("uid")String uid,@Query("token")String token);


}
