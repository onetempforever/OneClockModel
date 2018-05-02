package git.example.dell.clockmodel.myvideo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import git.example.dell.clockmodel.R;

public class CreationActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ocreate_duanzi;
    private ImageView ocreate_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        ocreate_duanzi = findViewById(R.id.ocreate_duanzi);
        ocreate_video = findViewById(R.id.ocreate_video);
        ocreate_duanzi.setOnClickListener(this);
        ocreate_video.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.ocreate_duanzi:

                    startActivity(new Intent(CreationActivity.this,Cross_TalkActivity.class));
                    break;

            }
    }
}
