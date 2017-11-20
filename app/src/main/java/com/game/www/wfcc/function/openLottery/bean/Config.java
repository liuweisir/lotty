package com.game.www.wfcc.function.openLottery.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Config extends BmobObject {
    String name;
    String url;
    boolean show;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
