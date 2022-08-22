package com.example.ssf_todolist_hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DataDao mDataDao;
    private ImageButton developAddButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        developAddButton = findViewById(R.id.developAddButton);
        DataDatabase database = Room.databaseBuilder(getApplicationContext(),DataDatabase.class,"TO-Do Database")
                .fallbackToDestructiveMigration() //버전 변경가능
                .allowMainThreadQueries() // Main Thread 에서 DB에 IO를 쓸수있게함
                .build();
        mDataDao = database.dataDao();

        List<Data> dataList = mDataDao.getDataAll();


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragmentHome((ArrayList<Data>) dataList)).commit();
                        return true;
                    case R.id.nav_pencil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new FragmentChange((ArrayList<Data>) dataList)).commit();
                        return true;
                }
                return false;
            }
        });
        navigation.setSelectedItemId(R.id.nav_home);
    }
}