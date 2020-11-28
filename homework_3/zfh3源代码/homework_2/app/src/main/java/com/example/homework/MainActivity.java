package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        this.setTitle("活动一");

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void onStart(){
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }
}