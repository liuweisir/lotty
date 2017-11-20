package com.game.www.wfcc.function.openLottery.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenCode {

    private String result_msg;

    private String result_code;

    private Opencode_detail opencode_detail;

    public void setResult_msg(String result_msg){
        this.result_msg = result_msg;
    }
    public String getResult_msg(){
        return this.result_msg;
    }
    public void setResult_code(String result_code){
        this.result_code = result_code;
    }
    public String getResult_code(){
        return this.result_code;
    }
    public void setOpencode_detail(Opencode_detail opencode_detail){
        this.opencode_detail = opencode_detail;
    }
    public Opencode_detail getOpencode_detail(){
        return this.opencode_detail;
    }
}
