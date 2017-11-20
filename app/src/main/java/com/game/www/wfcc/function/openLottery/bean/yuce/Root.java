package com.game.www.wfcc.function.openLottery.bean.yuce;

public class Root {
private Rows rows;

private String code;
private Root Resp;
private String desc;

    public Root getResp() {
        return Resp;
    }

    public void setResp(Root resp) {
        Resp = resp;
    }

    public void setRows(Rows rows){
this.rows = rows;
}
public Rows getRows(){
return this.rows;
}
public void setCode(String code){
this.code = code;
}
public String getCode(){
return this.code;
}
public void setDesc(String desc){
this.desc = desc;
}
public String getDesc(){
return this.desc;
}

}