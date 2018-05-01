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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import git.example.dell.clockmodel.R;

import git.example.dell.clockmodel.myvideo.fragment.HotFragment;
import git.example.dell.clockmodel.myvideo.fragment.NearBarFragment;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;


/**
 * Created by DELL on 2018/4/24.
 */

public class VideoFragment extends Fragment implements View.OnClickListener{

    private TabLayout table;
    private ViewPager viewpager;
    private List<String> menu;
    private List<Fragment> list;
    private ImageView fabu;
    private ImageView open_dr;
    private DrawerLayout drlayout;
    private RelativeLayout rel;
    private TextView biaoti_name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.videofragment_layout, null);



        initview(view);

        setData();
        ViewAdapter();
        return view;
    }
    //设置控件
    private void initview(View view) {
        table = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        open_dr = view.findViewById(R.id.Open_Dr);
        fabu = view.findViewById(R.id.fabu);
        biaoti_name = view.findViewById(R.id.biaoti_name);
        biaoti_name.setText("视频");
        open_dr.setOnClickListener(this);
        fabu.setOnClickListener(this);
        //获取MainActivity中的控件
        drlayout = getActivity().findViewById(R.id.drlayout);
        rel = getActivity().findViewById(R.id.rel);
    }

    //准备数据
    private void setData() {
        menu = new ArrayList<>();
        menu.add("热门");
        menu.add("附近");
        list = new ArrayList<>();
        list.add(new HotFragment());
        list.add(new NearBarFragment());
        table.setupWithViewPager(viewpager);
    }
    //viewpager适配器
    private void ViewAdapter() {
        viewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list != null ? list.size() :0;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return menu.get(position);
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

        String icon = (String) SharedPreferencesUtils.getParam(getActivity(), "icon", "");

        Glide.with(getActivity()).load(icon).into(open_dr);
    }
}
