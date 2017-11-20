package com.game.www.wfcc.function.openLottery.model;

import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;
import com.game.www.wfcc.http.VolleyJsonObject;
import com.game.www.wfcc.http.VolleyString;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenLotteryModelImpl implements  OpenLotteryModel{

    private static final String SelectUrl = "http://mycp.iplay78.com/trade-web/web/opencode_detail";

    @Override
    public void selectOpenLotteryMessage(OpenLotteryQuery query, final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();
        try {
            js.put("opencode_detail",new JSONObject(MyApplication.getInstance().getGson().toJson(query.getOpencode_detail())));
            js.put("c_head",new JSONObject(MyApplication.getInstance().getGson().toJson(query.getC_head())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        VolleyJsonObject vj = new VolleyJsonObject(SelectUrl,js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void getJingCaiZuqiu( String date ,final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();
        String url = "http://ews.500.com/score/zq/info?vtype=jczq";
        if(!TextUtils.isEmpty(date)){
            String canshu = "&expect=" + date;
            url +=canshu;
        }

        VolleyJsonObject vj = new VolleyJsonObject(url,js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void getSauShi(final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();


        VolleyJsonObject vj = new VolleyJsonObject("http://ews.500.com/library/zq/leagues?areaid=0&T=1496841604424",js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void getZiXun(String lastID, final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();


        VolleyJsonObject vj = new VolleyJsonObject("https://info-api.jdd.com/info/public/mobileHandler.do?UserID=&action=100506&appVersion=1.0.0&cmdId=6001&cmdName=cpb_oppo&islogin=false&params=%7B%22fType%22:1,%22lastId%22:0,%22pageSize%22:10%7D&platformCode=Android&platformVersion=6.0.1&sign=b0ef4e09a579c5cde4fc79d45d4f1c5a&token=&username=&usertype=0&uuid=00000000-2820-33f9-ffff-ffffd02f7664",js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void getReMenZixun(int pn, final OpenLotteryListener listener) {
        Map<String , String> js = new HashMap<String , String>();
        js.put("pn",pn + "");

        VolleyString vj = new VolleyString("http://mobile.9188.com/trade/apphotnews.go",js);
        vj.initInterface(new VolleyString.JSInterface() {
            @Override
            public void getJsonString(String json) {
                listener.onSuccess(json);
            }
        });
    }

    @Override
    public void getYiCe(final OpenLotteryListener listener) {
        Map<String , String> js = new HashMap<String , String>();
        VolleyString vj = new VolleyString("http://mobile.9188.com/trade/forecast.go?name=yuce",js);
        vj.initInterface(new VolleyString.JSInterface() {
            @Override
            public void getJsonString(String json) {
                listener.onSuccess(json);
            }
        });
    }

    @Override
    public void getYuce(String gid, String pn, final OpenLotteryListener listener) {
        Map<String , String> js = new HashMap<String , String>();
        js.put("pn",pn + "");
        js.put("gid",gid + "");
        VolleyString vj = new VolleyString("http://mobile.9188.com/trade/forecast.go",js);
        vj.initInterface(new VolleyString.JSInterface() {
            @Override
            public void getJsonString(String json) {
                listener.onSuccess(json);
            }
        });
    }

    @Override
    public void getQuanziList(final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();


        VolleyJsonObject vj = new VolleyJsonObject("https://ews.500.com/sns/app/circlelist",js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void selectTuijian(QueryTuiJian queryTuiJian , final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();
        VolleyJsonObject vj = new VolleyJsonObject("http://www.310win.com/Recommend/AjaxForTj.ashx?n=0.6403141233914953&action=GetTjList&Type=1&SubType=0&OrderType=1&PageIndex=" + queryTuiJian.getPageIndex() + "&PageSize=" + queryTuiJian.getPageSize() + "&Match=",js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    @Override
    public void selectAboutUs(String appID,final OpenLotteryListener listener) {
        JSONObject js = new JSONObject();
        VolleyJsonObject vj = new VolleyJsonObject("http://103.226.153.119:8080/biz/getAppConfig?appid=" + appID,js);
        vj.initInterface(new VolleyJsonObject.JObjectInterface() {
            @Override
            public void getJsonObject(String json) {
                listener.onSuccess(json);
            }
        }, new VolleyJsonObject.RequestServerErrorInterface() {
            @Override
            public void onResponseError(VolleyError error) {
                listener.onFailure("网络异常,请稍后再试！");

            }
        });
    }

    public interface OpenLotteryListener{
        void onSuccess(String json);
        void onFailure(String msg);
    }
}
