package com.example.ssf_todolist_hackathon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentChange extends Fragment {
    private RecyclerAdapter adapterDevelop;
    private RecyclerAdapter adapterDesign;
    private ArrayList<Data> dataList;

    public FragmentChange(ArrayList<Data> dataList) {
        this.dataList = dataList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change,container,false);
        RecyclerView recyclerViewDevelop = view.findViewById(R.id.fragmentChangeDevelopRecyclerView);
        RecyclerView recyclerViewDesign = view.findViewById(R.id.fragmentChangeDesignRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());

        recyclerViewDevelop.setLayoutManager(linearLayoutManager);
        recyclerViewDesign.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapterDevelop = new RecyclerAdapter();
        recyclerViewDevelop.setAdapter(adapterDevelop);

        adapterDesign = new RecyclerAdapter();
        recyclerViewDesign.setAdapter(adapterDesign);

        Data data1 = new Data(false,1,"develop");
        adapterDevelop.addItem(data1);
        return view;
    }
}