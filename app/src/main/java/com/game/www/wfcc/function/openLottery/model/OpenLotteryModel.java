package com.game.www.wfcc.function.openLottery.model;

import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface OpenLotteryModel {

    void selectOpenLotteryMessage(OpenLotteryQuery query, OpenLotteryModelImpl.OpenLotteryListener listener);


    void selectTuijian(QueryTuiJian queryTuiJian, OpenLotteryModelImpl.OpenLotteryListener listener);

    void selectAboutUs(String appID , OpenLotteryModelImpl.OpenLotteryListener listener);

    void getJingCaiZuqiu(String date, final OpenLotteryModelImpl.OpenLotteryListener listener);

    void getSauShi(OpenLotteryModelImpl.OpenLotteryListener listener);


    void getZiXun(String lastID,OpenLotteryModelImpl.OpenLotteryListener listener);

    void getReMenZixun(int pn ,OpenLotteryModelImpl.OpenLotteryListener listener);

    void getYiCe(OpenLotteryModelImpl.OpenLotteryListener listener);

    void getYuce(String gid , String pn ,OpenLotteryModelImpl.OpenLotteryListener listener);

    void getQuanziList(OpenLotteryModelImpl.OpenLotteryListener listener);
}
