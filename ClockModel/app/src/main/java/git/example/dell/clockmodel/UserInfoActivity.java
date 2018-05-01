package git.example.dell.clockmodel;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.mydrawer.presenter.UserInfoPresenter;
import git.example.dell.clockmodel.mydrawer.view.UserInfoView;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;

public class UserInfoActivity extends AppCompatActivity {

    private Boolean isChecked;
    private String uid;
    private TextView username;
    private TextView userInfo_nickname;
    private String nickname;
    private ImageView fresco;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        username = findViewById(R.id.userInfo_username);
        userInfo_nickname = findViewById(R.id.userInfo_nickname);
        fresco = findViewById(R.id.userInfo_fresco);

        initData();
    }

    private void initData() {
        isChecked = (Boolean) SharedPreferencesUtils.getParam(this, "isChecked", false);
        if (isChecked){

            uid = (String) SharedPreferencesUtils.getParam(this, "uid","");
            token = (String) SharedPreferencesUtils.getParam(this, "token", "");

            Toast.makeText(this, "uid"+uid, Toast.LENGTH_SHORT).show();
            if (uid!=""){
                UserInfoPresenter userInfoPresenter = new UserInfoPresenter();
                userInfoPresenter.getUserInfoPresenterData(uid, token, new UserInfoView() {
                    @Override
                    public void LoadeViewUserInfoSuccess(UserInfoBean userInfoBean) {

                        Log.d("aaaa", "LoadeViewUserInfoSuccess: "+userInfoBean.getMsg());


                        if (userInfoBean.getData().getUsername()!=null){
                            username.setText(userInfoBean.getData().getUsername());
                        }else {
                            username.setText("");
                        }
                        nickname = (String) userInfoBean.getData().getNickname();
                        if (nickname !=null){
                            userInfo_nickname.setText(nickname);
                        }
                        if (userInfoBean.getData().getIcon()!=null){
                            fresco.setImageURI(Uri.parse(userInfoBean.getData().getIcon()));
                        }
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"mobile",userInfoBean.getData().getMobile()+"");
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"uid",userInfoBean.getData().getUid()+"");
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"username",userInfoBean.getData().getUsername());
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"icon",userInfoBean.getData().getIcon());
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"token",userInfoBean.getData().getToken());
                        SharedPreferencesUtils.setParam(UserInfoActivity.this,"isChecked", true);
                    }

                    @Override
                    public void LoadeViewUserInfoError(Throwable t) {

                    }
                });
            }
        }


    }









}
