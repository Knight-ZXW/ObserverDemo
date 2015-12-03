package com.zxw.observerdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zxw.observerdemo.R;
import com.zxw.observerdemo.observer.EventSubject;
import com.zxw.observerdemo.observer.EventType;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void changetxt(View view) {
        EventSubject.getInstance().notifyObserver(EventType.UPDATE_TEXT);
    }
}
