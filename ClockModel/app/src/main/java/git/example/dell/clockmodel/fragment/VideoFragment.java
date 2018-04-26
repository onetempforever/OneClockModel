package git.example.dell.clockmodel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.fragment.videofragment.HotFragment;
import git.example.dell.clockmodel.fragment.videofragment.NearBarFragment;


/**
 * Created by DELL on 2018/4/24.
 */

public class VideoFragment extends Fragment {

    private TabLayout table;
    private ViewPager viewpager;
    private List<String> menu;
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.videofragment_layout, null);
        table = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);


        return view;
    }

}
