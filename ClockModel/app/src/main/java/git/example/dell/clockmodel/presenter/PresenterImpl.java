package git.example.dell.clockmodel.presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.model.IModel.HotModel;
import git.example.dell.clockmodel.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.model.VideoBean;
import git.example.dell.clockmodel.view.HotView;

/**
 * Created by dell on 2018/4/26.
 */

public class PresenterImpl implements IPresenter{
    private HotView hotView;
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
}
