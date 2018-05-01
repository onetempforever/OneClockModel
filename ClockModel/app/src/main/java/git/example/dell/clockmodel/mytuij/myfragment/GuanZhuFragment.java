package git.example.dell.clockmodel.mytuij.myfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.List;


import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.mytuij.model.RMSPBean;
import git.example.dell.clockmodel.mytuij.presenter.IPresenterImpl;
import git.example.dell.clockmodel.mytuij.view.GZIView;

/**
 * Created by LI on 2018/4/9.
 */

public class GuanZhuFragment extends Fragment implements GZIView {


    private IPresenterImpl iPresenter;
    private Banner gzBannder;
    private MyListView gzlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guanzu_layout, container, false);
        gzBannder = view.findViewById(R.id.gz_bannder);
        gzlv = view.findViewById(R.id.gzlv);
       /* iPresenter = new IPresenter();
        iPresenter.getGZBannderData(this,new IModel(iPresenter));
        Map<String,String> map = new HashMap<>();
        map.put("type","1");
        map.put("page","1");
        iPresenter.getGZListData(this,new IModelImpl(iPresenter),map);*/


        return view;
    }




    @Override
    public void setBannderData(List<String> bannder_url) {
        Log.d("aaa", "-----main展示-----");
        gzBannder.setBannerAnimation(Transformer.CubeOut);
        gzBannder.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        });
        gzBannder.setDelayTime(2000);
        gzBannder.setImages(bannder_url);
        gzBannder.start();

    }

    @Override
    public void setSPData(List<RMSPBean.DataBean> data) {
        
    }


}
