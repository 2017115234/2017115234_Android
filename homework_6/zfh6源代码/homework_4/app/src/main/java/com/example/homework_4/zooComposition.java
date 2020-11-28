package com.example.homework_4;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework_4.R;

import java.util.ArrayList;
import java.util.List;

public class zooComposition extends RecyclerView.Adapter<zooComposition.ViewHolder> {
    private List<zoo> animal;
    private onTextChangeListener textListener;
    private ArrayList<TextWatcher> listeners;

    public void setOntextChangeListener(onTextChangeListener textListener){
        this.textListener = textListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View zooView;
        ImageView zooImage;
        EditText zooName;

        public ViewHolder(View view){
            super(view);
            zooView = view;
            zooImage = (ImageView) view.findViewById(R.id.zoo_animal);
            zooName = (EditText) view.findViewById(R.id.zoo_animal_name);
        }
    }

    public zooComposition(List<zoo> animal){
        this.animal = animal;
    }

    @Override
    public zooComposition.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zoo, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.zooView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                zoo car = animal.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + car.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.zooImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                zoo car = animal.get(position);
                Toast.makeText(v.getContext(), "you clicked image "+car.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        zoo a = animal.get(position);
        holder.zooImage.setImageResource(a.getImageId());
        holder.zooName.setText(a.getName());
        final TextWatcher textWatcher = new TextWatcher() {
            zoo car = animal.get(position);
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                textListener.onTextChanged(position, holder.zooName.getText().toString());
                car.setName(holder.zooName.getText().toString());
            }
        };

        holder.zooName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus){
                    holder.zooName.addTextChangedListener(textWatcher);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return animal.size();
    }
}
