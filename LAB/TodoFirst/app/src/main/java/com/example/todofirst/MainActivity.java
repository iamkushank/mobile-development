package com.example.todofirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] tasks;
    private int i = 0;
    private TextView textView;
    Resources res;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tasks", i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            i = savedInstanceState.getInt("tasks",0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();

        tasks = res.getStringArray(R.array.todos);
        textView = findViewById(R.id.textViewId);
        textView.setText(tasks[i]);
        Log.d("MainActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    public void nextClick(View view) {
        i = ++i % tasks.length;
        textView.setText(tasks[i]);
    }

    public void prevClick(View view) {
        if(i>0) {
            i = --i ^ tasks.length;
        } else {
            i = tasks.length;
        }
        i = --i % tasks.length;
        Log.d("MainActivity", i+"");
        textView.setText(tasks[i]);
    }
}
