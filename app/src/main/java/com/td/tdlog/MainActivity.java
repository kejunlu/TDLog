package com.td.tdlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.td.library.TDLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e("tag", "test log");
                TDLog.v("test vlog");
                TDLog.d("test dlog");
                TDLog.i("test ilog");
                TDLog.w("test wlog");
                TDLog.e("test elog");
                Log.v("tag", "test vlog");

            }
        });



    }
}
