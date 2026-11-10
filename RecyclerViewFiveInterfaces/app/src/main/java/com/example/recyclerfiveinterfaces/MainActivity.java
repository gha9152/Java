package com.example.recyclerfiveinterfaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerfiveinterfaces.interface1.ActivityInterface1;
import com.example.recyclerfiveinterfaces.interface2.ActivityInterface2;
import com.example.recyclerfiveinterfaces.interface3.ActivityInterface3;
import com.example.recyclerfiveinterfaces.interface4.ActivityInterface4;
import com.example.recyclerfiveinterfaces.interface5.ActivityInterface5;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnInterface1);
        btn2 = findViewById(R.id.btnInterface2);
        btn3 = findViewById(R.id.btnInterface3);
        btn4 = findViewById(R.id.btnInterface4);
        btn5 = findViewById(R.id.btnInterface5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInterface1.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInterface2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInterface3.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInterface4.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInterface5.class);
                startActivity(intent);
            }
        });
    }
}
