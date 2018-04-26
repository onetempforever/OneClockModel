package git.example.dell.clockmodel.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import git.example.dell.clockmodel.R;

/**
 * Created by dell on 2018/4/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        getData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void getData();
}
