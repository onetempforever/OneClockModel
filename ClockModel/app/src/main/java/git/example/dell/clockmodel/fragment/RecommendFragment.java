package git.example.dell.clockmodel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import git.example.dell.clockmodel.R;

/**
 * Created by DELL on 2018/4/24.
 */

public class RecommendFragment extends Fragment {

  
   
    
    private GuanZhuFragment guanZhuFragment;
    private ReMenFragment reMenFragment;
    private List<Fragment> list;
    private List<String> tab = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian, container, false);
        TabLayout tablayout = view.findViewById(R.id.tablayout);
        ViewPager tabpager = view.findViewById(R.id.tabpager);
        list = new ArrayList<>();
        guanZhuFragment = new GuanZhuFragment();
        reMenFragment = new ReMenFragment();
        list.add(reMenFragment);
        list.add(guanZhuFragment);
        tab.add("热门");
        tab.add("关注");

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


        tablayout.setupWithViewPager(tabpager);

        return view;
    }


    
}
