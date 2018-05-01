package git.example.dell.clockmodel.myvideo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.myvideo.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.myvideo.presenter.PresenterImpl;
import git.example.dell.clockmodel.myvideo.viewInter.ShangChuanView;
import git.example.dell.clockmodel.shangchuanduanzi.CrossTalkBean;

public class Cross_TalkActivity extends AppCompatActivity implements ShangChuanView{

    private TextView txt_main_title;
    private PresenterImpl presenter;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross__talk);

    inview();



    }

    private void inview() {
        txt_main_title = findViewById(R.id.txt_main_title);
        content = findViewById(R.id.content);
        presenter = new PresenterImpl();

        txt_main_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("tag","dsdasdad");
                presenter.getshangchuan(new HotModellmpl(presenter),Cross_TalkActivity.this, content.getText().toString().trim());
            }
        });

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
