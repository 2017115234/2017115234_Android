package com.example.homework_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView text;
    private ProgressBar pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWindow();
    }

    private void initWindow(){
        this.button = (Button) findViewById(R.id.d1);
        this.pro = (ProgressBar) findViewById(R.id.p1);
        this.text = (TextView) findViewById(R.id.t1);

        this.button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        DownloadTask task = new DownloadTask();
        task.execute(100);
    }

    class DownloadTask extends AsyncTask<Integer, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... params) {


            for(int i = 0; i <= 100; i++) {
                pro.setProgress(i);
                publishProgress(i);

                try {
                    Thread.sleep(params[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                };
            }
            return "文件传输完成";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            text.setText(values[0]+"%");
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            setTitle(result);
            super.onPostExecute(result);

        }
    }

}