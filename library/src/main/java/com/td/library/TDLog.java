package com.td.library;

import android.util.Log;

/**
 * Created by lukejun on 16/8/25.
 * 日志操作类
 */
public class TDLog {
    private static final String TAG = TDLog.class.getSimpleName();
    private static final int VERBOSE = 2;
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int WARN = 5;
    private static final int ERROR = 6;

    private static boolean isShowLog = true;

    public TDLog(){

    }

    /**
     * 初始化日志是否打印
     * @param isShowLog
     */
    public static void init(boolean isShowLog){
        TDLog.isShowLog = isShowLog;
    }

    public static void i(Object obj){
        print(INFO, null, obj);
    }

    public static void i(String tag, Object obj){
        print(INFO, tag, obj);
    }

    public static void d(Object obj){
        print(DEBUG, null, obj);
    }

    public static void d(String tag, Object obj){
        print(DEBUG, tag, obj);
    }

    public static void w(Object obj){
        print(WARN, null, obj);
    }

    public static void w(String tag, Object obj){
        print(WARN, tag, obj);
    }

    public static void e(Object obj){
        print(ERROR, null, obj);
    }

    public static void e(String tag, Object obj){
        print(ERROR, tag, obj);
    }

    public static void v(Object obj){
        print(VERBOSE, null, obj);
    }

    public static void v(String tag, Object obj){
        print(VERBOSE, tag, obj);
    }

    /**
     * 打印日志
     * @param type
     * @param tag
     * @param obj
     */
    private static void print(int type, String tag, Object obj){
        if(!isShowLog){
            return;
        }

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int index = 4;
        String className = stackTrace[index].getFileName();   //类名
        String methodName = stackTrace[index].getMethodName();//方法
        int lineNumber = stackTrace[index].getLineNumber();   //行数

        String tagStr = (tag == null ? className : tag);
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ").append(methodName).append(":").append(lineNumber).append(" ] ");

        if (obj == null || (obj.toString().length() == 0)) {
            stringBuilder.append("Log no Object");
        } else {
            stringBuilder.append(obj.toString());
        }

        String logStr = stringBuilder.toString();
        switch (type) {
            case VERBOSE:
                Log.v(tagStr, logStr);
                break;
            case DEBUG:
                Log.d(tagStr, logStr);
                break;
            case INFO:
                Log.i(tagStr, logStr);
                break;
            case WARN:
                Log.w(tagStr, logStr);
                break;
            case ERROR:
                Log.e(tagStr, logStr);
                break;
        }
    }

}