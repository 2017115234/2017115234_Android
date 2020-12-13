package com.example.homework_8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int textword2 = 1;
    private ImageView image;
    private Button a_text;

    private TextView text;
    private Handler handler = new Handler(){
      public void handleMessage(Message msg){
          switch (msg.what){
              case textword2:
                  text.setText("have a good time");
                  break;
              default:
                  break;
          }
      }
    };

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a_text = (Button) findViewById(R.id.a_text);
        text = (TextView) findViewById(R.id.textword);
        a_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = textword2;
                        handler.sendMessage(msg);
                    }
                }).start();

                break;
            default:
                break;
        }
    }


}