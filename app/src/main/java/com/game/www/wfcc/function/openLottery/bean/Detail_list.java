package com.game.www.wfcc.function.openLottery.bean;

import java.io.Serializable;
import java.util.List;

public class Detail_list implements Serializable{
    private String PROGRESSIVE;

    private String EXPECT;

    private String OPENCODE_TIME;

    private String OPEN_CODE;

    private List<OPTIONS_LIST> OPTIONS_LIST;

    private String SALES_MONEY;

    private String OPENCODE_WEEK;

    private int LOT_ID;

    public void setPROGRESSIVE(String PROGRESSIVE) {
        this.PROGRESSIVE = PROGRESSIVE;
    }

    public String getPROGRESSIVE() {
        return this.PROGRESSIVE;
    }

    public void setEXPECT(String EXPECT) {
        this.EXPECT = EXPECT;
    }

    public String getEXPECT() {
        return this.EXPECT;
    }

    public void setOPENCODE_TIME(String OPENCODE_TIME) {
        this.OPENCODE_TIME = OPENCODE_TIME;
    }

    public String getOPENCODE_TIME() {
        return this.OPENCODE_TIME;
    }

    public void setOPEN_CODE(String OPEN_CODE) {
        this.OPEN_CODE = OPEN_CODE;
    }

    public String getOPEN_CODE() {
        return this.OPEN_CODE;
    }

    public void setOPTIONS_LIST(List<OPTIONS_LIST> OPTIONS_LIST) {
        this.OPTIONS_LIST = OPTIONS_LIST;
    }

    public List<OPTIONS_LIST> getOPTIONS_LIST() {
        return this.OPTIONS_LIST;
    }

    public void setSALES_MONEY(String SALES_MONEY) {
        this.SALES_MONEY = SALES_MONEY;
    }

    public String getSALES_MONEY() {
        return this.SALES_MONEY;
    }

    public void setOPENCODE_WEEK(String OPENCODE_WEEK) {
        this.OPENCODE_WEEK = OPENCODE_WEEK;
    }

    public String getOPENCODE_WEEK() {
        return this.OPENCODE_WEEK;
    }

    public void setLOT_ID(int LOT_ID) {
        this.LOT_ID = LOT_ID;
    }

    public int getLOT_ID() {
        return this.LOT_ID;
    }

}