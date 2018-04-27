package git.example.dell.clockmodel.duanzi.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import git.example.dell.clockmodel.R;

public class FaBuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_bu);

        initViews();
    }

    private void initViews() {
        Button bt_dz=findViewById(R.id.bt_dz);

        bt_dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(FaBuActivity.this,TwoFBActivity.class));
            }
        });
    }

    private void initDatas() {

    }
}
