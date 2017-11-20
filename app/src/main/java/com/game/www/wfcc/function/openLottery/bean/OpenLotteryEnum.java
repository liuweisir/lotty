package com.game.www.wfcc.function.openLottery.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/1.
 */
public enum OpenLotteryEnum implements Serializable{
    双色球(301),
    竞彩足球(701),
    大乐透(501),
    竞彩篮球(702),
    山东11选5(152),
    江西11选5(151),
    广东11选5(153),
    福彩3D(302),
    排列三(502),
    排列五(503);

    public static OpenLotteryEnum getOpenLotteryEnumByIndex(int index){
        switch (index){
            case 301:return 双色球;
            case 701:return 竞彩足球;
            case 501:return 大乐透;
            case 702:return 竞彩篮球;
            case 152:return 山东11选5;
            case 151:return 江西11选5;
            case 153:return 广东11选5;
            case 302:return 福彩3D;
            case 502:return 排列三;
            case 503:return 排列五;
        }
        return 双色球;
    }

    OpenLotteryEnum(int index){
        this.index = index;
    }

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
