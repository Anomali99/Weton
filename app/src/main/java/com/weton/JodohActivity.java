package com.weton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class JodohActivity extends AppCompatActivity {
    ImageView btnBack, btnInfo, btnTabel;
    TextView tvTgl1, tvTgl2, tvTotal, tvHasil, tvKeterangan;
    Button btnCari;
    AutoCompleteTextView actTgl1, actTgl2, actMetode;
    DatePickerDialog datePick;
    SimpleDateFormat tgl;
    String[] item = {"Metode 1", "Metode 2"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jodoh);

        tgl = new SimpleDateFormat("dd MMMM yyyy");
        btnBack = findViewById(R.id.btn_back);
        btnInfo = findViewById(R.id.btn_info);
        btnTabel = findViewById(R.id.btn_tabel);
        btnCari = findViewById(R.id.btn_cari);
        actTgl1 = findViewById(R.id.act_tanggal1);
        actTgl2 = findViewById(R.id.act_tanggal2);
        actMetode = findViewById(R.id.act_metode);
        tvTgl1 = findViewById(R.id.tv_tanggal1);
        tvTgl2 = findViewById(R.id.tv_tanggal2);
        tvHasil = findViewById(R.id.tv_hasil);
        tvTotal = findViewById(R.id.tv_total);
        tvKeterangan = findViewById(R.id.tv_keterangan);

        adapter = new ArrayAdapter<>(this,R.layout.list_item,item);
        actMetode.setAdapter(adapter);

        actTgl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(actTgl1);
            }
        });
        actTgl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(actTgl2);
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
            String[] neptu1 = Cari.neptu(tgl.parse(actTgl1.getText().toString()));
            int[] total1 = Primbon.neptu(neptu1);
            String[] neptu2 = Cari.neptu(tgl.parse(actTgl2.getText().toString()));
            int[] total2 = Primbon.neptu(neptu2);
            int jumlah = total1[0] + total1[1] + total2[0] + total2[1];

            String[] hasil = new String[5];
            hasil[0] = "Tanggal : "+actTgl1.getText().toString()+". Hari : "+neptu1[0]+" ("+total1[0]+"), "+neptu1[1]+" ("+total1[1]+").";
            hasil[1] = "Tanggal : "+actTgl2.getText().toString()+". Hari : "+neptu2[0]+" ("+total2[0]+"), "+neptu2[1]+" ("+total2[1]+").";
            hasil[2] = "Total -> ( "+total1[0]+" + "+total1[1]+" ) + ("+total2[0]+" + "+total2[1]+") = "+jumlah;
            switch (actMetode.getText().toString()){
                case "Metode 1":
                    hasil[3] = Primbon.jodoh(total1,total2);
                    hasil[4] = "";
                    break;
                case "Metode 2":
                    hasil[3] = Primbon.jodoh(jumlah)[0];
                    hasil[4] = Primbon.jodoh(jumlah)[1];
                    break;
            }

            tvTgl1.setText(hasil[0]);
            tvTgl2.setText(hasil[1]);
            tvTotal.setText(hasil[2]);
            tvHasil.setText(hasil[3]);
            tvKeterangan.setText(hasil[4]);
//            SpannableString text = new SpannableString(hasil[4]);
//            ForegroundColorSpan forg = new ForegroundColorSpan(Color.WHITE);
//            text.setSpan(forg,0,hasil[4].length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            tvKeterangan.setText(text);
//            text.setSpan(new android.text.style.Out(2, Color.BLACK),0, hasil[4].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        } catch (ParseException e) {
            Toast.makeText(getApplicationContext(),"Masukan tanggal terlebih dahulu.",Toast.LENGTH_SHORT).show();
        }
    }
}