package git.example.dell.clockmodel.myvideo.videofragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.myvideo.activity.VideoDetailActivity;
import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.adapter.MyNearBarAdapter;
import git.example.dell.clockmodel.myvideo.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.myvideo.presenter.PresenterImpl;
import git.example.dell.clockmodel.myvideo.viewInter.NearBarView;

/**
 * Created by dell on 2018/4/25.
 */

public class NearBarFragment extends Fragment implements NearBarView{
    private static final String TAG = "NearBarFragment";
    private View view;
    private RecyclerView nearbar;
    private MyNearBarAdapter myNearBarAdapter;
    //   private MyNearBarAdapter myNearBarAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.nearbarfragment_layout, null);

        PresenterImpl presenter = new PresenterImpl();
        presenter.showNearbarToView(new HotModellmpl(presenter),this);
        initView();
        return view;
    }

    private void initView() {
        nearbar = view.findViewById(R.id.nearbar_recycler);
        nearbar.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void showNearbar(List<NearBarBean.DataBean> data) {
        Log.d(TAG, "showNearbar: NearBarFragment"+data.toString());
        if (data != null){
            Log.e("AA","不是用的");
            Toast.makeText(getContext(),data.size() + "===",Toast.LENGTH_LONG).show();
            myNearBarAdapter = new MyNearBarAdapter(getContext(), data);
            nearbar.setAdapter(myNearBarAdapter);
        }
        myNearBarAdapter.setHotItemClickListener(new MyNearBarAdapter.NearItemClickListener() {
            @Override
            public void onClick(int wid) {
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                intent.putExtra("wid", wid);
                startActivity(intent);
            }
        });
    }
}
