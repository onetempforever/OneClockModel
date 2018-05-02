package git.example.dell.clockmodel.mydrawer.view.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.mydrawer.bean.RegBean;
import git.example.dell.clockmodel.mydrawer.bean.UserInfoBean;
import git.example.dell.clockmodel.mydrawer.presenter.UpLoadPresenter;
import git.example.dell.clockmodel.mydrawer.presenter.UserInfoPresenter;
import git.example.dell.clockmodel.mydrawer.view.UpLoadView;
import git.example.dell.clockmodel.mydrawer.view.UserInfoView;
import git.example.dell.clockmodel.utils.SharedPreferencesUtils;
import git.example.dell.clockmodel.utils.UploadUtil;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener,UploadUtil.OnUploadProcessListener{

    private Boolean isChecked;
    private String uid;
    private TextView username;
    private TextView userInfo_nickname;
    private String nickname;
    private ImageView fresco;
    private String token;
    private static final int PHOTO_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;
    private static final int PHOTO_CLIP = 3;
    private static final int UPLOAD_INIT_PROCESS = 4;//上传初始化
    protected static final int UPLOAD_FILE_DONE = 2;//上传中
    private static final int UPLOAD_IN_PROCESS = 5;//上传文件响应

    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private Uri tempUri;
    private ProgressDialog pd;
    private File filepath;
    private Bitmap photo;
    private ImageView userInfo_retreat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        username = findViewById(R.id.userInfo_username);
        userInfo_nickname = findViewById(R.id.userInfo_nickname);
        userInfo_retreat = findViewById(R.id.userInfo_retreat);
        fresco = findViewById(R.id.userInfo_fresco);
        fresco.setOnClickListener(this);
        userInfo_retreat.setOnClickListener(this);

        initData();
    }

    private void initData() {
        isChecked = (Boolean) SharedPreferencesUtils.getParam(this, "isChecked", false);
        if (isChecked){

            uid = (String) SharedPreferencesUtils.getParam(this, "uid","");
            token = (String) SharedPreferencesUtils.getParam(this, "token", "");
            nickname = (String) SharedPreferencesUtils.getParam(this, "nickname", "");
            final String icon = (String) SharedPreferencesUtils.getParam(this, "icon", "");

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
                        /*UserInfoActivity.this.nickname = (String) userInfoBean.getData().getNickname();*/
                        if (UserInfoActivity.this.nickname !=null){
                            userInfo_nickname.setText(UserInfoActivity.this.nickname);
                        }
                        if (userInfoBean.getData().getIcon()!=null){
                            Glide.with(UserInfoActivity.this).load(icon).into(fresco);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userInfo_fresco:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("选择头像");
                String[] items={"相机","相册"};

                builder.setNegativeButton("取消",null);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i) {
                                    case CHOOSE_PICTURE:
                                        getCamera();
                                        break;
                                    case TAKE_PICTURE:
                                        getPhoto();
                                        break;

                                }
                            }
                        })

                        .show();

                break;

            case R.id.userInfo_retreat:

                finish();

                break;

        }
    }

    //调相册
    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }

    //调相机
    private void getCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 下面这句指定调用相机拍照后的照片存储的路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(
                Environment.getExternalStorageDirectory(), "hand.jpg")));
        startActivityForResult(intent,CAMERA_REQUEST);
    }
    //裁剪图片
    private void photoClip(Uri uri) {
        // 调用系统中自带的图片剪裁
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CLIP);
    }


    private void toUploadFile() {
        pd = ProgressDialog.show(this, "", "正在上传文件...");
        pd.show();
        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(this); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("userId", "");
        uploadUtil.uploadFile(filepath, fileKey, "上传头像的地址", params);
        Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onUploadDone(int responseCode, String message) {

        pd.dismiss();
        Message msg = Message.obtain();
        msg.what = UPLOAD_FILE_DONE;
        msg.arg1 = responseCode;
        msg.obj = message;
    }

    @Override
    public void onUploadProcess(int uploadSize) {

        //上传中
        Message msg = Message.obtain();
        msg.what = UPLOAD_IN_PROCESS;
        msg.arg1 = uploadSize;
    }

    @Override
    public void initUpload(int fileSize) {

        //准备上传
        Message msg = Message.obtain();
        msg.what = UPLOAD_INIT_PROCESS;
        msg.arg1 = fileSize;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CAMERA_REQUEST:
                switch (resultCode) {
                    case -1://-1表示拍照成功
                        File file = new File(Environment.getExternalStorageDirectory()
                                + "/hand.jpg");//保存图片
                        if (file.exists()) {
                            //对相机拍照照片进行裁剪
                            photoClip(Uri.fromFile(file));
                        }
                }
                break;

            case PHOTO_REQUEST://从相册取
                if (data != null) {
                    Uri uri = data.getData();
                    //对相册取出照片进行裁剪
                    photoClip(uri);

                }
                break;
            case PHOTO_CLIP:
                //完成
                if (data != null) {

                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        photo = extras.getParcelable("data");
                        try {
                            //获得图片路径
                            filepath = UploadUtil.saveFile(photo, Environment.getExternalStorageDirectory().toString(), "hand.jpg");


                            //上传照片
                            toUploadFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //上传完成将照片写入imageview与用户进行交互
                        fresco.setImageBitmap(photo);
                    }
                }
                break;
        }
    }




}
