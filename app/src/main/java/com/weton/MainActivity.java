package com.weton;

import static com.weton.primbon.Primbon.jodoh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView btnPasar, btnKalender, btnJodoh, btnInfo, btnTabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPasar = findViewById(R.id.btn_pasar);
        btnKalender = findViewById(R.id.btn_kalender);
        btnJodoh = findViewById(R.id.btn_jodoh);
        btnInfo = findViewById(R.id.btn_info);
        btnTabel = findViewById(R.id.btn_tabel);

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
        btnPasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasaran();
            }
        });
        btnJodoh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jodoh();
            }
        });
        btnKalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalender();
            }
        });
    }

    private void kalender() {
        Intent intent = new Intent(this, KalenderActivity.class);
        startActivity(intent);
    }

    private void tabel() {
        Intent intent = new Intent(this, TabelActivity.class);
        startActivity(intent);
    }

    private void info() {
        Intent intent = new Intent(this, TentangActivity.class);
        startActivity(intent);
    }

    private void pasaran() {
        Intent intent = new Intent(this, PasaranActivity.class);
        startActivity(intent);
    }

    private void jodoh() {
        Intent intent = new Intent(this, JodohActivity.class);
        startActivity(intent);
    }
}