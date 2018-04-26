package git.example.dell.clockmodel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.model.VideoBean;
import git.example.dell.clockmodel.presenter.PresenterImpl;
import git.example.dell.clockmodel.view.HotView;
import git.example.dell.clockmodel.view.adapter.MyAdapter;

/**
 * Created by dell on 2018/4/25.
 */

public class HotFragment extends Fragment implements HotView{
    private static final String TAG = "HotFragment";
    private View view;
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.hotfragment_layout, null);
        initView();
        PresenterImpl presenter=new PresenterImpl();
        presenter.showVideoToView(new HotModellmpl(presenter),this);
        return view;
    }

    private void initView() {
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }


    @Override
    public void showVideoSuccess(List<VideoBean.DataBean> data) {
        MyAdapter myAdapter=new MyAdapter(getActivity(),data);
        recycler.setAdapter(myAdapter);
    }

    @Override
    public void showVideoError(String error) {
        Log.d(TAG, "showVideoError: aaa"+error);
    }
}
