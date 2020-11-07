package com.example.lesson04_okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new OkHttp().execute();
    }
}
