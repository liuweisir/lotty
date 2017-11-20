package com.game.www.wfcc.function.openLottery.bean.remenzixun;

public class Root {
private Rows rows;

private Pagelist pagelist;

private String desc;

private String code;

    private Root Resp;

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
public void setPagelist(Pagelist pagelist){
this.pagelist = pagelist;
}
public Pagelist getPagelist(){
return this.pagelist;
}
public void setDesc(String desc){
this.desc = desc;
}
public String getDesc(){
return this.desc;
}
public void setCode(String code){
this.code = code;
}
public String getCode(){
return this.code;
}

}