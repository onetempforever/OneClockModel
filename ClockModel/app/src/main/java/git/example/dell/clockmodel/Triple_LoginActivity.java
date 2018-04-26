package git.example.dell.clockmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
import git.example.dell.clockmodel.R;

public class Triple_LoginActivity extends AppCompatActivity {
=======
public class Triple_LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView other_loginWay;
    private ImageView back_rl;
>>>>>>> c5e78887585a97d334ac40f3c06a0c5c665662f5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triple__login);

        other_loginWay = findViewById(R.id.Other_LoginWay);
        back_rl = findViewById(R.id.Back_RL);
        other_loginWay.setOnClickListener(this);
        back_rl.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Other_LoginWay:

                Intent intent = new Intent(this, Other_LoginActivity.class);
                startActivity(intent);

                break;
            case R.id.Back_RL:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);

                break;

        }
    }
}
