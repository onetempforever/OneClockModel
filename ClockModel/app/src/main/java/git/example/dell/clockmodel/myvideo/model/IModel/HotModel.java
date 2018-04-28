package git.example.dell.clockmodel.myvideo.model.IModel;

import java.util.Map;

/**
 * Created by dell on 2018/4/26.
 */

public interface HotModel {
    void getHotData( Map<String,String> map);
    void getVideoDetail(Map<String,String> map);
    //获取附近视频
    void getNearbar(Map<String,String> map);
}
