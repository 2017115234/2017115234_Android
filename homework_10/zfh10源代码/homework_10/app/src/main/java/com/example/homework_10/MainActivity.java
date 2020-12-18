package com.example.homework_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button open;
    private Button close;
    public static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = findViewById(R.id.open);
        close = findViewById(R.id.close);
        textView = findViewById(R.id.text_content);
        open.setOnClickListener(this);
        close.setOnClickListener(this);
        textView.setText("当前线程名为"+Thread.currentThread().getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open:
                Log.d("MainService", "onCreate被执行"+"此时线程id为"+Thread.currentThread().getId());
                Intent start_intent = new Intent(this, MYS.class);
                startService(start_intent);
                break;
            case R.id.close:
                Intent stop_intent = new Intent(this, MYS.class);
                stopService(stop_intent);
                break;
            default:
                break;
        }
    }
}

class Task extends AsyncTask<Integer, Integer, Void>{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Integer... params) {
        try {
                publishProgress(params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        MainActivity.textView.setText("线程"+Thread.currentThread().getName()+
                "正在运行第"+values[1]+"次");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}