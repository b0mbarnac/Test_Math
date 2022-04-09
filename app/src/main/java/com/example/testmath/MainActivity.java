package com.example.testmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testmath.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}