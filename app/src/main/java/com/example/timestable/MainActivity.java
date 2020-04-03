package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> currentTimesTable;

    public ArrayList<ArrayList<String>> getTimesTable() {
        ArrayList<ArrayList<String>> timesTableArray = new ArrayList();
        for(int i = 1; i <= 20; i++) {
            ArrayList<String> temp = new ArrayList();
            for(int j = 1; j <= 10; j++) {
                temp.add(i + " X " + j + " = " + i*j);
            }
            timesTableArray.add(temp);
        }
        return timesTableArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(19);
        seekBar.setProgress(0);
        currentTimesTable = getTimesTable().get(seekBar.getProgress());
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentTimesTable = getTimesTable().get(progress);
                recyclerView.setAdapter(new MyAdapter(currentTimesTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        recyclerView.setAdapter(new MyAdapter(currentTimesTable));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
