package git.example.dell.clockmodel.myvideo.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.donkingliang.imageselector.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import git.example.dell.clockmodel.MainActivity;
import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.api.API;
import git.example.dell.clockmodel.myvideo.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.myvideo.presenter.PresenterImpl;
import git.example.dell.clockmodel.myvideo.viewInter.ShangChuanView;
import git.example.dell.clockmodel.shangchuanduanzi.CrossTalkBean;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Cross_TalkActivity extends AppCompatActivity implements ShangChuanView{

    private TextView txt_main_title;
    private PresenterImpl presenter;
    private EditText content;
    private ImageView cross_phone;
    private TextView quxiao;
    List<ImageView> imas = new ArrayList<>();
    private List<MultipartBody.Part> listParts;
    private ArrayList<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross__talk);

    inview();



    }

    private void inview() {
        txt_main_title = findViewById(R.id.txt_main_title);
        quxiao = findViewById(R.id.back6);
        content = findViewById(R.id.content);
        cross_phone = findViewById(R.id.cross_phone);
        presenter = new PresenterImpl();

        txt_main_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tag","dsdasdad");
                presenter.getshangchuan(new HotModellmpl(presenter),Cross_TalkActivity.this, content.getText().toString().trim());
            }
        });
        cross_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopwindow();
            }


        });

    }
    private void showPopwindow() {
        View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        View popView = View.inflate(this, R.layout.camera_pop_menu, null);

        Button btn_pop_yes_or_no = (Button) popView.findViewById(R.id.btn_pop_yes_or_no);
        Button btnCamera = (Button) popView.findViewById(R.id.btn_pop_baocun);
        Button btnAlbum = (Button) popView.findViewById(R.id.btn_pop_no_baocun);
        Button btnCancel = (Button) popView.findViewById(R.id.btn_pop_cancel);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        final PopupWindow popWindow = new PopupWindow(popView, width, height);
//        popWindow.setAnimationStyle(R.style.AnimBottom);
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);// 设置允许在外点击消失

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_pop_yes_or_no:

                        break;
                    case R.id.btn_pop_baocun:

                        break;
                    case R.id.btn_pop_no_baocun:

                        break;
                    case R.id.btn_pop_cancel:

                        break;
                }
                popWindow.dismiss();
            }
        };

        btnCamera.setOnClickListener(listener);
        btnAlbum.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);
        btn_pop_yes_or_no.setOnClickListener(listener);
        ColorDrawable dw = new ColorDrawable(0x30000000);
        popWindow.setBackgroundDrawable(dw);
        popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @Override
    public void ShangChuanView(Object o) {

        CrossTalkBean crossTalkBean= (CrossTalkBean) o;
        Toast.makeText(this, ((CrossTalkBean) o).getMsg()+"", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void ShangChuanViewError(String json) {
        Toast.makeText(this, json+"", Toast.LENGTH_SHORT).show();
    }
}
