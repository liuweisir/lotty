package com.game.www.wfcc.function.openLottery.prestener;

import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface OpenLotteryPrestener {
    void selectOpenLotteryMessage(OpenLotteryQuery query);

    void selectOpenLotteryMessage(OpenLotteryQuery query, OpenLotteryView view);

    void selectTuijian(QueryTuiJian queryTuiJian);

    void selectAboutUs(String appID, OpenLotteryView view);

    void getJingCaiZuqiu(String date);

    void getSauShi();

    void getZiXun(String lastID);
    void getReMenZixun(int pn);

    void getYiCe();
    void getYuce(String gid , String pn);

    void getQuanziList();
}
