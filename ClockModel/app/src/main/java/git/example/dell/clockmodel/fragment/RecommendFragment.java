package git.example.dell.clockmodel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.mytuij.myfragment.GuanZhuFragment;
import git.example.dell.clockmodel.mytuij.myfragment.ReMenFragment;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

/**
 * Created by DELL on 2018/4/24.
 */

public class RecommendFragment extends Fragment implements View.OnClickListener{

  
   
    
    private GuanZhuFragment guanZhuFragment;
    private ReMenFragment reMenFragment;
    private List<Fragment> list;
    private List<String> tab = new ArrayList<>();
    private ImageView fabu;
    private ImageView open_dr;
    private DrawerLayout drlayout;
    private RelativeLayout rel;
    private TextView biaoti_name;
    private TabLayout tablayout;
    private ViewPager tabpager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian, container, false);

        initview(view);
        setData();
        viewpager(tabpager);

        return view;
    }

    //获取控件
    private void initview(View view) {
        tablayout = view.findViewById(R.id.tablayout);
        tabpager = view.findViewById(R.id.tabpager);

        open_dr = view.findViewById(R.id.Open_Dr);
        fabu = view.findViewById(R.id.fabu);
        biaoti_name = view.findViewById(R.id.biaoti_name);
        biaoti_name.setText("推荐");
        open_dr.setOnClickListener(this);
        fabu.setOnClickListener(this);
        //获取MainActivity中的控件
        drlayout = getActivity().findViewById(R.id.drlayout);
        rel = getActivity().findViewById(R.id.rel);
    }
    //准备数据
    private void setData() {
        list = new ArrayList<>();
        guanZhuFragment = new GuanZhuFragment();
        reMenFragment = new ReMenFragment();
        list.add(reMenFragment);
        list.add(guanZhuFragment);
        tab.add("热门");
        tab.add("关注");
        tablayout.setupWithViewPager(tabpager);
    }
    //ViewPage适配器
    private void viewpager(ViewPager tabpager) {
        tabpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {

                return tab.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = list.get(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return tab.size();
            }

        });
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

        String icon = (String) SharedPreferencesUtils.getParam(getContext(), "icon", "");
        Glide.with(getActivity()).load(icon).into(open_dr);
    }
}
