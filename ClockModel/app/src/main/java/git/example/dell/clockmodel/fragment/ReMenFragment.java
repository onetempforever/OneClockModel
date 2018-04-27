package git.example.dell.clockmodel.fragment;


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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.adapter.MyListViewAdapter;
import git.example.dell.clockmodel.model.IModelImpl;
import git.example.dell.clockmodel.model.RMSPBean;
import git.example.dell.clockmodel.presenter.IPresenterImpl;
import git.example.dell.clockmodel.view.RMIView;

/**
 * Created by LI on 2018/4/9.
 */

public class ReMenFragment extends Fragment implements RMIView {


    private IPresenterImpl iPresenter;
    private static final String TAG = "ReMenFragment";
    private Banner bannder;
    private MyListView rmlv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remen_layout, container, false);

        bannder = view.findViewById(R.id.bannder);
        rmlv = view.findViewById(R.id.rmlv);

        iPresenter = new IPresenterImpl();
        //iPresenter.getBannderData(this, new IModelImpl(iPresenter));
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("source","android");
        map.put("appVersion","101");
        IModelImpl iModel = new IModelImpl(iPresenter);
        iPresenter.getBannderData(this,new IModelImpl(iPresenter),map);
        iPresenter.getBannder1Data(this,new IModelImpl(iPresenter));
        return view;
    }


    @Override
    public void setBannderData(List<String> bannder_url) {
        Log.d("aaa", "-----main展示-----");
        bannder.setBannerAnimation(Transformer.CubeOut);
        bannder.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        });
        bannder.setDelayTime(2000);
        bannder.setImages(bannder_url);
        bannder.start();

    }

    @Override
    public void setSPData(List<RMSPBean.DataBean> data) {
        Log.d(TAG, "setSPData: "+data.size());
        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(data,getActivity());
        rmlv.setAdapter(myListViewAdapter);
    }






}
