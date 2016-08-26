package com.td.tdlog;

import android.app.Application;

import com.td.library.TDLog;

/**
 * Created by lukejun on 16/8/25.
 */
public class TDApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        TDLog.init(true);
    }
}
