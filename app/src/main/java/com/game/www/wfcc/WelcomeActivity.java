package com.game.www.wfcc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import com.game.www.wfcc.activity.WebActivity;
import com.game.www.wfcc.activity.WebActivity2;
import com.game.www.wfcc.activity.WebActivity3;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.util.PreferencesUtil;

import org.json.JSONException;
import org.json.JSONObject;

import Decoder.BASE64Decoder;

/**
 * Created by Administrator on 2017/6/2.
 */
public class WelcomeActivity extends AppCompatActivity implements OpenLotteryView {

//    private String Bmob_AppId = "cbdd0df9e7cc93babbae8dcd06917e09";
//    private String objectId = "tFvLfDDf";
////    private String objectId = "3QuGxxxB";
//    private String objectUrl;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_one);
//        Bmob.initialize(this, Bmob_AppId);
//        queryPersonByObjectId();
//
//    }
//
//    private void queryPersonByObjectId() {
//        BmobQuery<Config> bmobQuery = new BmobQuery<Config>();
//        bmobQuery.getObject(this, objectId, new GetListener<Config>() {
//            @Override
//            public void onSuccess(Config object) {
//                objectUrl = object.getUrl();
//                PreferencesUtil.putUrl(objectUrl);
//                if (object.getShow()) {
//                    Integer time = 2000;//设置等待时间，单位为毫秒
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Intent intent = new Intent(WelcomeActivity.this, WebActivity.class);
//                            intent.putExtra("objectUrl",objectUrl);
//                            startActivity(intent);
//                            WelcomeActivity.this.finish();
//                        }
//                    }, time);
//                } else {
//                    Integer time = 2000;//设置等待时间，单位为毫秒
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            WelcomeActivity.this.finish();
//                        }
//                    }, time);
//                }
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Integer time = 2000;//设置等待时间，单位为毫秒
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        WelcomeActivity.this.finish();
//                    }
//                }, time);
//            }
//        });
//    }


    private Integer time = 0;//

    private OpenLotteryPrestener mOpenLotteryPrestener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
        setContentView(R.layout.activity_main_one);
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        queryPersonByObjectId();

    }


    private void queryPersonByObjectId() {
        String id = "lw2017112119";
        mOpenLotteryPrestener.selectAboutUs(id, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                try {
                    Log.e("liuwei","json="+json
                    );
                    JSONObject jsonObj = new JSONObject(json);
//                     jsonObj  = jsonObj.getJSONObject("AppConfig");
                    String str = jsonObj.getString("data");
                    String obj = getFromBASE64(str);
                    jsonObj = new JSONObject(obj);
                    Log.e("liuwei", obj);
//                    int status = jsonObj.getInt("ShowWeb");
                    int status = jsonObj.getInt("show_url");
                    if (status == 1) {
//                        int isshowwap = jsonObj.getInt("ShowWeb");
                        final String wapurl = jsonObj.getString("url");
                        if (!TextUtils.isEmpty(wapurl)) {
                            PreferencesUtil.putUrl(wapurl);
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
//                                    if(PreferencesUtil.isBanSpeech()){
//                                        Intent intent = new Intent(WelcomeActivity.this, WebActivity.class);
//                                        intent.putExtra("objectUrl",wapurl);
//                                        startActivity(intent);
//                                        WelcomeActivity.this.finish();
//                                    }else{
//                                        Intent intent = new Intent(WelcomeActivity.this, YinDaoActivity.class);
//                                        intent.putExtra("objectUrl",wapurl);
//                                        startActivity(intent);
//                                        WelcomeActivity.this.finish();
//                                    }
                                    Intent intent = new Intent(WelcomeActivity.this, WebActivity.class);
                                    intent.putExtra("objectUrl", wapurl);
                                    startActivity(intent);
                                    WelcomeActivity.this.finish();

                                }
                            }, time);
                        } else {
                            Integer time = 2000;//璁剧疆绛夊緟鏃堕棿锛屽崟浣嶄负姣
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    WelcomeActivity.this.finish();
                                }
                            }, time);
                        }

                    } else {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                                startActivity(intent);
                                WelcomeActivity.this.finish();
                            }
                        }, time);
                    }
                } catch (JSONException e) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                            startActivity(intent);
                            WelcomeActivity.this.finish();
                        }
                    }, time);
                }
            }

            @Override
            public void onFailure(String msg) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });
    }

    //将 BASE64 编码的字符串 s 进行解码
    public static String getFromBASE64(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onFailure(String msg) {

    }
}
