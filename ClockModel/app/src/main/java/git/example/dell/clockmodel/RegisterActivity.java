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

import git.example.dell.clockmodel.mydrawer.bean.Register;
import git.example.dell.clockmodel.mydrawer.presenter.RegisterPresenter;
import git.example.dell.clockmodel.mydrawer.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_login;
    private TextView already;
    private Button register;
    private EditText phone;
    private EditText mima;
    private TextView yk_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back_login = findViewById(R.id.Back_Login);
        already = findViewById(R.id.Already);
        phone = findViewById(R.id.phone);
        mima = findViewById(R.id.mima);
        register = findViewById(R.id.Register);
        yk_login = findViewById(R.id.YK_Login);

        back_login.setOnClickListener(this);
        already.setOnClickListener(this);
        register.setOnClickListener(this);
        yk_login.setOnClickListener(this);

        String mobile = phone.getText().toString();
        String password = mima.getText().toString();


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Back_Login:
                //点击跳转到登录
                Intent intent = new Intent(this, Other_LoginActivity.class);

                startActivity(intent);

                break;
            case R.id.Already:
                //点击跳转到登录
                Intent intent1 = new Intent(this, Other_LoginActivity.class);

                startActivity(intent1);

                break;
            case R.id.Register:
                //点击跳转到推荐

                RegisterPresenter registerPresenter = new RegisterPresenter();
                registerPresenter.getRegisterPresenterData(phone.getText().toString(), mima.getText().toString(), new RegisterView() {
                    @Override
                    public void LoadeViewRegisterSuccess(Register register) {

                        if ("0".equals(register.getCode())){
                            Intent intent2 = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent2);
                            Toast.makeText(RegisterActivity.this, ""+register.getMsg(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, ""+register.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void LoadeViewRegisterError(Throwable t) {

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
