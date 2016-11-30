package com.example.custom.cunstomproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.custom.cunstomproject.R;
import com.example.custom.cunstomproject.view.PieChartView;

public class MainActivity extends AppCompatActivity {

    PieChartView pieChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChartView = (PieChartView) findViewById(R.id.pv_chart);
        float[] data = {50f,30f,20f,60f};
        pieChartView.setPecent(data);
    }
}
