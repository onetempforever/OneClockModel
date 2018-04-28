package git.example.dell.clockmodel.myvideo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.bean.NearBarBean;
import git.example.dell.clockmodel.myvideo.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.myvideo.presenter.PresenterImpl;
import git.example.dell.clockmodel.myvideo.viewInter.NearDetailView;

public class NearDetailActivity extends AppCompatActivity implements NearDetailView{

    private TextView nearbar_content;
    private TextView nearbar_time;
    private JCVideoPlayerStandard nearbar_videojc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_detail);
        nearbar_content = findViewById(R.id.nearbar_detail_content);
        nearbar_time = findViewById(R.id.nearbar_detail_time);
        nearbar_videojc = findViewById(R.id.nearbar_videojc);
        int wid = getIntent().getIntExtra("wid", -1);
        Map<String,String> map=new HashMap<>();
        if (wid!=-1){
            map.put("wid",wid+"");
            Log.e("wid",wid+"");
        }
        PresenterImpl presenter = new PresenterImpl();
        presenter.showNearToView(new HotModellmpl(presenter),this,map);
    }

    @Override
    public void showNearDetail(List<NearBarBean.DataBean> data) {
        String videoUrl = data.get(0).getVideoUrl();
        nearbar_videojc.setUp(videoUrl,1);
    }

    @Override
    public void showSuccess(String json) {

    }

    @Override
    public void showError(String error) {

    }
}
