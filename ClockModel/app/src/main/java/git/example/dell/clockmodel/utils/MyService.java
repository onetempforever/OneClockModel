package git.example.dell.clockmodel.utils;

import java.util.Map;

import git.example.dell.clockmodel.model.RMSPBean;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public interface MyService {
    @GET("quarter/getAd")
    Observable<RMSPBean> getRMSPData(@QueryMap Map<String,String> map);
}
