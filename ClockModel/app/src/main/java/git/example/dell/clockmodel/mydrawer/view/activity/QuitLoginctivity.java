package git.example.dell.clockmodel.mydrawer.view.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

public class QuitLoginctivity extends AppCompatActivity implements View.OnClickListener{

    private Button quit_login;
    private LinearLayout back_triples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quit_loginctivity);

       /* Window window = getWindow();
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/
        quit_login = findViewById(R.id.Quit_Login);
        back_triples = findViewById(R.id.Back_Triples);
        quit_login.setOnClickListener(this);
        back_triples.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Quit_Login:

                SharedPreferencesUtils.clearAll(QuitLoginctivity.this);
                Intent intent = new Intent(this, Triple_LoginActivity.class);
                startActivity(intent);

                SharedPreferencesUtils.setParam(QuitLoginctivity.this,"isChecked",false);

                break;
            case R.id.Back_Triples:

                finish();

                break;
            default:

                break;
        }
    }
}
