package com.example.ssf_todolist_hackathon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{
    private ArrayList<Data> listData= new ArrayList<>();

    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
    void addItem(Data data){
        listData.add(data);
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox1;
        private EditText editText1;
        ItemViewHolder(View itemView)
        {
            super(itemView);
            checkBox1 = itemView.findViewById(R.id.checkbox1);
            editText1 = itemView.findViewById(R.id.edittext1);
        }
        void onBind(Data data)
        {
            checkBox1.setSelected(data.isCheck());
            editText1.setText(data.getText());
        }
    }
}
