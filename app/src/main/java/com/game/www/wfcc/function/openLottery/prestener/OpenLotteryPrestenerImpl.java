package com.game.www.wfcc.function.openLottery.prestener;

import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;
import com.game.www.wfcc.function.openLottery.model.OpenLotteryModel;
import com.game.www.wfcc.function.openLottery.model.OpenLotteryModelImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenLotteryPrestenerImpl implements  OpenLotteryPrestener{

    private OpenLotteryView mOpenLotteryView;
    private OpenLotteryModel mOpenLotteryModel;

    public OpenLotteryPrestenerImpl(OpenLotteryView view){
        this.mOpenLotteryView = view;
        this.mOpenLotteryModel = new OpenLotteryModelImpl();
    }

    private OpenLotteryModelImpl.OpenLotteryListener listener = new OpenLotteryModelImpl.OpenLotteryListener() {
        @Override
        public void onSuccess(String json) {
            mOpenLotteryView.onSuccess(json);
        }

        @Override
        public void onFailure(String msg) {
            mOpenLotteryView.onFailure(msg);
        }
    };

    @Override
    public void selectOpenLotteryMessage(OpenLotteryQuery query) {
        mOpenLotteryModel.selectOpenLotteryMessage(query ,listener);
    }

    @Override
    public void selectOpenLotteryMessage(OpenLotteryQuery query,final OpenLotteryView view) {
        OpenLotteryModelImpl.OpenLotteryListener listener = new OpenLotteryModelImpl.OpenLotteryListener() {
            @Override
            public void onSuccess(String json) {
                view.onSuccess(json);
            }

            @Override
            public void onFailure(String msg) {
                view.onFailure(msg);
            }
        };
        mOpenLotteryModel.selectOpenLotteryMessage(query ,listener);
    }

    @Override
    public void selectTuijian(QueryTuiJian queryTuiJian) {
        mOpenLotteryModel.selectTuijian(queryTuiJian ,listener);
    }

    @Override
    public void selectAboutUs(String appID,final OpenLotteryView view) {
        OpenLotteryModelImpl.OpenLotteryListener listener = new OpenLotteryModelImpl.OpenLotteryListener() {
            @Override
            public void onSuccess(String json) {
                view.onSuccess(json);
            }

            @Override
            public void onFailure(String msg) {
                view.onFailure(msg);
            }
        };
        mOpenLotteryModel.selectAboutUs(appID ,listener);
    }

    @Override
    public void getJingCaiZuqiu(String date) {
        mOpenLotteryModel.getJingCaiZuqiu(date,listener);
    }

    @Override
    public void getSauShi() {
        mOpenLotteryModel.getSauShi(listener);
    }

    @Override
    public void getZiXun(String lastID) {
        mOpenLotteryModel.getZiXun(lastID,listener);
    }

    @Override
    public void getReMenZixun(int pn) {
        mOpenLotteryModel.getReMenZixun(pn,listener);

    }

    @Override
    public void getYiCe() {
        mOpenLotteryModel.getYiCe(listener);
    }

    @Override
    public void getYuce(String gid, String pn) {
        mOpenLotteryModel.getYuce(gid,pn,listener);
    }

    @Override
    public void getQuanziList() {
        mOpenLotteryModel.getQuanziList(listener);
    }

}
