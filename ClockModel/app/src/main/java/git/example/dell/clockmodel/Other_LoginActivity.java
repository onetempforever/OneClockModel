package git.example.dell.clockmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import git.example.dell.clockmodel.mydrawer.bean.LoginBean;
import git.example.dell.clockmodel.mydrawer.presenter.LoginPresenter;
import git.example.dell.clockmodel.mydrawer.view.LoginView;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

public class Other_LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_triple;
    private TextView regiest;
    private EditText login_zh;
    private EditText login_mima;
    private TextView yk_login;
    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__login);

        //获取控件
        initview();
    }

    private void initview() {
        back_triple = findViewById(R.id.Back_Triple);
        regiest = findViewById(R.id.Regiest);
        login_zh = findViewById(R.id.Login_zh);
        login_mima = findViewById(R.id.Login_mima);
        login = findViewById(R.id.Login);
        yk_login = findViewById(R.id.YK_Login);

        back_triple.setOnClickListener(this);
        regiest.setOnClickListener(this);
        login.setOnClickListener(this);
        yk_login.setOnClickListener(this);
    }

    //点击进行选择
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Back_Triple:

                Intent intent = new Intent(this, Triple_LoginActivity.class);
                startActivity(intent);

                break;
            case R.id.Regiest:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);

                break;
            case R.id.Login:
                //点击登录跳转到推荐
                LoginPresenter loginPresenter = new LoginPresenter();
                loginPresenter.getLoginPresenterData(login_zh.getText().toString(), login_mima.getText().toString(), new LoginView() {
                    @Override
                    public void LoadeViewLoginSuccess(LoginBean loginBean) {

                        if ("0".equals(loginBean.getCode())){

                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"mobile",loginBean.getData().getMobile()+"");
                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"uid",loginBean.getData().getUid()+"");
                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"username",loginBean.getData().getUsername());
                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"icon",loginBean.getData().getIcon());
                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"token",loginBean.getData().getToken());
                            SharedPreferencesUtils.setParam(Other_LoginActivity.this,"isChecked", true);
                            Intent intent2 = new Intent(Other_LoginActivity.this, MainActivity.class);
                            startActivity(intent2);


                            Toast.makeText(Other_LoginActivity.this, ""+loginBean.getMsg(), Toast.LENGTH_SHORT).show();

                        }else {


                            Toast.makeText(Other_LoginActivity.this, ""+loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void LoadeViewLoginError(Throwable t) {

                    }
                });


                break;
            case R.id.YK_Login:
                //点击跳转到推荐
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);

                break;



        }
    }
}
