package com.app.ivansuhendra.warehousegla;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.ivansuhendra.warehousegla.ui.activity.SplashActivity;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(RootActivity.this, SplashActivity.class));
        finish();
    }
}
