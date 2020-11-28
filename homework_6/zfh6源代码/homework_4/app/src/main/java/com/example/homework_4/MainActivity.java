package com.example.homework_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.homework_4.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<zoo> animal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCars();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        zooComposition adapter = new zooComposition(animal);
        adapter.setOntextChangeListener(new onTextChangeListener() {
            @Override
            public void onTextChanged(int pos, String str) {
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initCars(){
        for(int i = 0; i < 3; i++){
            zoo panda = new zoo(getRandomLengthName("熊猫"), R.drawable.panda);
            animal.add(panda);
            zoo monkey = new zoo(getRandomLengthName("金丝猴"),R.drawable.monkey);
            animal.add(monkey);
            zoo lion = new zoo(getRandomLengthName("狮子"),R.drawable.lion);
            animal.add(lion);
            zoo sika_deer = new zoo(getRandomLengthName("梅花鹿"), R.drawable.sika_deer);
            animal.add(sika_deer);
            zoo zebra = new zoo(getRandomLengthName("斑马"), R.drawable.zebra);
            animal.add(zebra);
            zoo peacock = new zoo(getRandomLengthName("孔雀"), R.drawable.peacock);
            animal.add(peacock);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }
}