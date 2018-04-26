package git.example.dell.clockmodel.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import git.example.dell.clockmodel.R;

/**
 * Created by dell on 2018/4/25.
 */

public class NearBarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.nearbarfragment_layout, null);
        return view;
    }
}
