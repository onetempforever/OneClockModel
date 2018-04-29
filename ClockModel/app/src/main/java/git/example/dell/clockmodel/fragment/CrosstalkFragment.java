package git.example.dell.clockmodel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.bean.GetJokeBean;
import git.example.dell.clockmodel.bean.PostJokesBean;
import git.example.dell.clockmodel.duanzi.model.HLSAdapter;
import git.example.dell.clockmodel.duanzi.mvp.IJokes;
import git.example.dell.clockmodel.duanzi.presenter.GetJokesPresenter;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

/**
 * Created by DELL on 2018/4/24.
 */

public class CrosstalkFragment extends Fragment implements IJokes.IGetJokesView,View.OnClickListener {

    private GetJokesPresenter getJokesPresenter;
    private View view;
    private RecyclerView recyclerView;
    private ImageView fabu;
    private ImageView open_dr;
    private DrawerLayout drlayout;
    private RelativeLayout rel;
    private TextView biaoti_name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.duanzi_fragment, null);
        initViews();
        return view;

    }
    //初始化视图
    private void initViews() {
        recyclerView = view.findViewById(R.id.joke_recycler);
        open_dr = view.findViewById(R.id.Open_Dr);
        fabu = view.findViewById(R.id.fabu);
        biaoti_name = view.findViewById(R.id.biaoti_name);
        biaoti_name.setText("段子");
        open_dr.setOnClickListener(this);
        fabu.setOnClickListener(this);
        //获取MainActivity中的控件
        drlayout = getActivity().findViewById(R.id.drlayout);
        rel = getActivity().findViewById(R.id.rel);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getJokesPresenter = new GetJokesPresenter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getJokesPresenter.getJokes("1");
    }

    @Override
    public void postJokesSuccess(PostJokesBean postJokesBean) {
    }
    @Override
    public void getJokesSuccess(GetJokeBean getJokeBean) {

        List<GetJokeBean.DataBean> data = getJokeBean.getData();
        Log.d("TestFragment", "getJokesSuccess: "+getJokeBean.toString());
        HLSAdapter adapter =new HLSAdapter(getJokeBean.getData(),getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String err) {
        if(getContext()!=null)
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Open_Dr:

                drlayout.openDrawer(rel);
                Toast.makeText(getActivity(), "触发了点击事件", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fabu:

                break;

        }

    }

    @Override
    public void onResume() {
        super.onResume();

        String icon = (String) SharedPreferencesUtils.getParam(getActivity(), "icon", "");

        Glide.with(getActivity()).load(icon).into(open_dr);
    }
}
