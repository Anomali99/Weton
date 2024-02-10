package com.weton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class KalenderActivity extends AppCompatActivity {
    ImageView kalender2, kalender3, btnBack, btnInfo, btnTabel, btnPanduan;
    Button btnBulan1, btnBulan2, btnTgl1, btnTgl2;
    Slider sdBulan, sdTgl;
    TextView tvBulan, tvTgl;
    double jarak = 10.286;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalender);

        kalender2 = findViewById(R.id.iv_kalender_2);
        kalender3 = findViewById(R.id.iv_kalender_3);
        sdBulan = findViewById(R.id.sd_1);
        tvBulan = findViewById(R.id.tv_sd_1);
        btnBulan1 = findViewById(R.id.btn_min_bulan);
        btnBulan2 = findViewById(R.id.btn_plus_bulan);
        sdTgl = findViewById(R.id.sd_2);
        tvTgl = findViewById(R.id.tv_sd_2);
        btnTgl1 = findViewById(R.id.btn_min_tanggal);
        btnTgl2 = findViewById(R.id.btn_plus_tanggal);
        btnBack = findViewById(R.id.btn_back);
        btnInfo = findViewById(R.id.btn_info);
        btnTabel = findViewById(R.id.btn_tabel);
        btnPanduan = findViewById(R.id.btn_manual);

        sdTgl.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int i = ubah(value);
                putar(i,kalender3);
                tvTgl.setText(String.valueOf(i));
            }
        });
        btnTgl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvTgl.getText().toString());
                i--;
                if (i < 0){
                    i = 34;
                }
                putar(i,kalender3);
                tvTgl.setText(String.valueOf(i));
                sdTgl.setValue(Float.parseFloat(String.valueOf(i)));
            }
        });
        btnTgl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvTgl.getText().toString());
                i++;
                if (i > 34){
                    i = 0;
                }
                putar(i,kalender3);
                tvTgl.setText(String.valueOf(i));
                sdTgl.setValue(Float.parseFloat(String.valueOf(i)));
            }
        });
        sdBulan.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int i = ubah(value);
                putar(i,kalender2);
                tvBulan.setText(String.valueOf(i));
            }
        });
        btnBulan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvBulan.getText().toString());
                i--;
                if (i < 0){
                    i = 34;
                }
                putar(i,kalender2);
                tvBulan.setText(String.valueOf(i));
                sdBulan.setValue(Float.parseFloat(String.valueOf(i)));
            }
        });
        btnBulan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tvBulan.getText().toString());
                i++;
                if (i > 34){
                    i = 0;
                }
                putar(i,kalender2);
                tvBulan.setText(String.valueOf(i));
                sdBulan.setValue(Float.parseFloat(String.valueOf(i)));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info();
            }
        });
        btnTabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabel();
            }
        });
        btnPanduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panduan();
            }
        });
    }

    private void panduan() {
        Intent intent = new Intent(this, PanduanActivity.class);
        startActivity(intent);
    }

    private void info() {
        Intent intent = new Intent(this, TentangActivity.class);
        startActivity(intent);
    }

    private void tabel() {
        Intent intent = new Intent(this, TabelActivity.class);
        startActivity(intent);
    }

    private int ubah(float  f){
        String s = Float.toString(f);
        char[] c = s.toCharArray();
        String ss = "";
        for(char cc : c){
            if(cc != '.')
                ss = ss + String.valueOf(cc);
            else
                break;
        }
        return Integer.parseInt(ss);
    }

    private void putar(int i, ImageView kalender) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                kalender.setRotation(Float.parseFloat(String.valueOf(i*jarak)));
            }
        },1);
    }
}