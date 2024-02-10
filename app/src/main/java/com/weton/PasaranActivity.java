package com.weton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weton.primbon.Cari;
import com.weton.primbon.Primbon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PasaranActivity extends AppCompatActivity {
    ImageView btnBack, btnInfo, btnTabel;
    TextView tvTgl, tvHari, tvTotal, tvSio;
    Button btnCari;
    AutoCompleteTextView actTgl;
    DatePickerDialog datePick;
    SimpleDateFormat tgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasaran);

        tgl = new SimpleDateFormat("dd MMMM yyyy");
        btnBack = findViewById(R.id.btn_back);
        btnInfo = findViewById(R.id.btn_info);
        btnTabel = findViewById(R.id.btn_tabel);
        btnCari = findViewById(R.id.btn_cari);
        actTgl = findViewById(R.id.act_tanggal);
        tvTgl = findViewById(R.id.tv_tanggal);
        tvHari = findViewById(R.id.tv_hari);
        tvTotal = findViewById(R.id.tv_total);
        tvSio = findViewById(R.id.tv_sio);

        actTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(actTgl);
            }
        });
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cari();
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
    }

    private void info() {
        Intent intent = new Intent(this, TentangActivity.class);
        startActivity(intent);
    }

    private void tabel() {
        Intent intent = new Intent(this, TabelActivity.class);
        startActivity(intent);
    }

    private void showDateDialog(AutoCompleteTextView tag) {
        Calendar kalender = Calendar.getInstance();
        datePick = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                tag.setText(tgl.format(newDate.getTime()));
            }
        }, kalender.get(Calendar.YEAR), kalender.get(Calendar.MONTH), kalender.get(Calendar.DAY_OF_MONTH));
        datePick.show();
    }

    private void cari(){
        try {
            String[] neptu = Cari.neptu(tgl.parse(actTgl.getText().toString()));
            int[] total = Primbon.neptu(neptu);
            int jumlah = total[0] + total[1];
            String[] hasil = new String[4];
            hasil[0] = "Tanggal : " + actTgl.getText().toString();
            hasil[1] = neptu[0] + " " + neptu[1];
            hasil[2] = neptu[0] + " (" + total[0] + "), " + neptu[1] + " (" + total[1] + "), [" + jumlah + "]";
            hasil[3] = Primbon.pasaran(jumlah);

            tvTgl.setText(hasil[0]);
            tvHari.setText(hasil[1]);
            tvTotal.setText(hasil[2]);
            tvSio.setText(hasil[3]);
        } catch (ParseException e) {
            Toast.makeText(getApplicationContext(),"Masukan tanggal terlebih dahulu.",Toast.LENGTH_SHORT).show();
        }
    }
}