package com.example.myapplication.Tuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Tuan411MainActivity extends AppCompatActivity {

    Button btnGetData;
    TextView tvKQ;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan411_main);
        T41VolleyFn volleyFn=new T41VolleyFn();
        tvKQ=findViewById(R.id.tuan411tvQK);
        btnGetData=findViewById(R.id.tuan411btn);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFn.getJsonArrayOfObject(context,tvKQ);
            }
        });
    }
}