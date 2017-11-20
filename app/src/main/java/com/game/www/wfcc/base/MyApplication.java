package com.game.www.wfcc.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.game.www.wfcc.http.HTTPSTrustManager;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;

import cn.jpush.android.api.JPushInterface;


public class MyApplication extends Application {

    private static final String TAG = "JPush";


    private Gson gson;
    private static MyApplication instance;//
    private static RequestQueue queues;


    private static Context context;


    /***
     * 寄存整个应用Activity
     **/
    private final Stack<WeakReference<Activity>> activitys = new Stack<WeakReference<Activity>>();

    public class HurlStackExtends extends HurlStack {
        /**
         * Create an {@link HttpURLConnection} for the specified {@code url}.
         */
        protected HttpURLConnection createConnection(URL url) throws IOException {
            if ("https".equals(url.getProtocol())) {
                HTTPSTrustManager.allowAllSSL();
            }
            return (HttpURLConnection) url.openConnection();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        instance = this;
        queues = Volley.newRequestQueue(getApplicationContext(), new HurlStackExtends());
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Log.d("jiguang ID:", JPushInterface.getRegistrationID(this));
    }
    public Gson getGson(){
        if(gson == null){
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        }
        return gson;
    }




    //返回
    public static Context getContextObject() {
        return context;
    }

    public static RequestQueue getHttpQueues() {
        return queues;
    }


    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    public void addActivity(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除
     *
     * @param task
     */
    public void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    public void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex)
            activitys.remove(taskIndex);
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    public void removeToTop() {
        int end = activitys.size();
        int start = 1;
        for (int i = end - 1; i >= start; i--) {
            if (!activitys.get(i).get().isFinishing()) {
                activitys.get(i).get().finish();
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    public void removeAll() {
        //finish所有的Activity
        for (WeakReference<Activity> task : activitys) {
            if (task.get() != null && !task.get().isFinishing()) {
                task.get().finish();
            }
        }
    }
    public static MyApplication getInstance() {
        return instance;
    }


}
