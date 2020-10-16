package com.example.projetolol.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetolol.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Historico_Detalhe_Activity extends AppCompatActivity {

    private HorizontalBarChart chart;
    private float vantagem_gold_azul;
    private float vantagem_gold_vermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico__detalhe);

        chart = findViewById(R.id.chart_vantagem);

        BarData data = new BarData(getDataSet());
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }

    private BarDataSet getDataSet() {

        ArrayList<BarEntry> entries = new ArrayList();
        entries.add(new BarEntry(4f, vantagem_gold_azul));
        entries.add(new BarEntry(1f, vantagem_gold_vermelho));
        BarDataSet dataset = new BarDataSet(entries, "vantagem");
        dataset.setColor(android.R.color.holo_blue_light,android.R.color.holo_red_light);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);

        return dataset;
    }
}