package git.example.dell.clockmodel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.bean.GetJokeBean;
import git.example.dell.clockmodel.bean.PostJokesBean;
import git.example.dell.clockmodel.duanzi.model.MyAdapter;
import git.example.dell.clockmodel.duanzi.mvp.IJokes;
import git.example.dell.clockmodel.duanzi.presenter.GetJokesPresenter;
import git.example.dell.clockmodel.duanzi.mvp.FaBuActivity;

/**
 * Created by DELL on 2018/4/24.
 */

public class CrosstalkFragment extends Fragment implements IJokes.IGetJokesView {

    private GetJokesPresenter getJokesPresenter;
    private View view;
    private ImageView fabu;
    private RecyclerView recyclerView;

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
        fabu = view.findViewById(R.id.fabu);
        fabu.setOnClickListener(new View.OnClickListener() {
            //点击事件
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FaBuActivity.class));
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getJokesPresenter = new GetJokesPresenter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //发布段子
//        getJokesPresenter.postJokes("dd","dd","dd");
        //获取段子
        getJokesPresenter.getJokes("1");
    }

    @Override
    public void postJokesSuccess(PostJokesBean postJokesBean) {
//        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getJokesSuccess(GetJokeBean getJokeBean) {

        List<GetJokeBean.DataBean> data = getJokeBean.getData();
        Log.d("TestFragment", "getJokesSuccess: "+getJokeBean.toString());
        MyAdapter adapter =new MyAdapter(getJokeBean.getData(),getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String err) {
        if(getContext()!=null)
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
    }
}
