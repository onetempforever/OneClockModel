package git.example.dell.clockmodel.myvideo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import git.example.dell.clockmodel.R;
import git.example.dell.clockmodel.myvideo.model.Modellmpl.HotModellmpl;
import git.example.dell.clockmodel.myvideo.model.VideoDetailBean;
import git.example.dell.clockmodel.myvideo.presenter.PresenterImpl;
import git.example.dell.clockmodel.myvideo.viewInter.VideoDetailView;

public class VideoDetailActivity extends AppCompatActivity implements VideoDetailView{
    private static final String TAG = "VideoDetailActivity";
    private TextView content;
    private TextView time;
    private JCVideoPlayerStandard videojc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        content = findViewById(R.id.video_detail_content);
        time = findViewById(R.id.video_detail_time);
        videojc = findViewById(R.id.hot_videojc);
        int wid = getIntent().getIntExtra("wid", -1);
        Map<String,String> map=new HashMap<>();
        if (wid!=-1){
            map.put("wid",wid+"");
            Log.e("wid",wid+"");
        }
        PresenterImpl presenter = new PresenterImpl();
        presenter.showDetailToView(new HotModellmpl(presenter),this,map);
        Log.e("videoUrl","on");
    }

    @Override
    public void showVideoDetail(VideoDetailBean.DataBean data) {
        String videoUrl = data.getVideoUrl();
        videojc.setUp(videoUrl, 1);
        content.setText(data.getComments().get(0).getContent());
        time.setText(data.getCreateTime());
    }

    @Override
    public void showSuccess(String json) {
        Log.d(TAG, "showSuccess: 成功"+json);
    }

    @Override
    public void showError(String json) {
        Log.d(TAG, "showError: 失败"+json);
    }
}
