package com.example.day1rkao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    private EditText ednames;
    private EditText pass;
    private Button zcs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ednames = findViewById(R.id.ednames);
        pass = findViewById(R.id.pass);
        zcs = findViewById(R.id.zcs);
        zcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
