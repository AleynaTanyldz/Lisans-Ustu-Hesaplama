package com.example.lisansustuhesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        Button btn1;
        EditText edt1, edt2,edt3,edt4;
        RadioButton yukseklisansb, doktoraB;
        RadioGroup Rdg;
        TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        edt1 =  findViewById(R.id.mezunN);
        edt2 =  findViewById(R.id.alesN);
        edt3 =  findViewById(R.id.ydsN);
        edt4 =  findViewById(R.id.ylN);
        tv1 = findViewById(R.id.sonucText);
        yukseklisansb = findViewById(R.id.yukseklisansb);
        doktoraB = findViewById(R.id.doktoraB);

        yukseklisansb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt4.setVisibility(View.INVISIBLE);
            }
        });
        doktoraB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt4.setVisibility(View.VISIBLE);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hesapla();
            }
        });

    }

    public void hesapla () {
        final float Ales, Yds, MezNot, YlmezNot;
        Ales = Float.parseFloat((edt2.getText().toString()));
        Yds = Float.parseFloat((edt3.getText().toString()));
        MezNot = Float.parseFloat((edt1.getText().toString()));
        YlmezNot = Float.parseFloat((edt4.getText().toString()));

        final float SiralamaPuani = (float)  ((Ales * 0.5) + (Yds * 0.25) + (MezNot * 0.25));

        if (yukseklisansb.isChecked()) {
            if (Yds >= 50) {
                if (SiralamaPuani >= 60){
                    tv1.setText("Tebrikler Sıralamaya Girdiniz.");
                } else {
                    tv1.setText("Sıralama Puanı Yetersiz.");
                }
            } else {
                tv1.setText("Yüksek Lisans İçin YDS Puanı Yetersiz.");
            }
        } else if (doktoraB.isChecked()) {
            if (Yds >= 70) {
                if (YlmezNot >= 75) {
                    if (SiralamaPuani >= 80) {
                        tv1.setText("Tebrikler Doktora İçin Sıralamaya Girdiniz.");
                    } else {
                        tv1.setText("Doktora İçin Yeterli Sıralama Puanına Sahip Değilsiniz.");
                    }
                } else {
                    tv1.setText("Doktora İçin Yüksek Lisans Ortalamanız Yeterli Değil.");
                }
            } else {
                tv1.setText("YDS Puanınız Yetersiz.");
            }
        } else {
            tv1.setText("Baişvuru Tipiniz Geçerli Değil Lütfen Tekrar Deneyiniz.");
        }

    }
}