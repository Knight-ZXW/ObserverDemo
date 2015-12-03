package com.zxw.observerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zxw.observerdemo.observer.EventType;

public class MainActivity extends BaseObserverActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtView = (TextView) findViewById(R.id.textView);


    }

    @Override
    protected void onChange(String eventType) {
        switch (eventType){
            case EventType.UPDATE_TEXT:
                txtView.setText("hello android");
                break;
        }
    }

    @Override
    protected String[] getObserverEventType() {

        return new String[]{EventType.UPDATE_TEXT};
    }


    public void goToSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
