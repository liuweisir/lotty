package com.game.www.wfcc.function.openLottery.bean.tuijian;

import java.util.List;

public class Root {
    private int ErrCode;

    private List<Data> Data;

    private String ErrMsgShow;

    private String ErrMsg;

    public void setErrCode(int ErrCode) {
        this.ErrCode = ErrCode;
    }

    public int getErrCode() {
        return this.ErrCode;
    }

    public void setData(List<Data> Data) {
        this.Data = Data;
    }

    public List<Data> getData() {
        return this.Data;
    }

    public void setErrMsgShow(String ErrMsgShow) {
        this.ErrMsgShow = ErrMsgShow;
    }

    public String getErrMsgShow() {
        return this.ErrMsgShow;
    }

    public void setErrMsg(String ErrMsg) {
        this.ErrMsg = ErrMsg;
    }

    public String getErrMsg() {
        return this.ErrMsg;
    }
}