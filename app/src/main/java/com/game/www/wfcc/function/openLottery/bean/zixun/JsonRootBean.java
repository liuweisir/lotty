/**
  * Copyright 2017 bejson.com 
  */
package com.game.www.wfcc.function.openLottery.bean.zixun;
import java.util.List;

/**
 * Auto-generated: 2017-06-08 21:14:3
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private int Code;
    private List<Data> Data;
    private String Msg;
    private int Stamp;
    public void setCode(int Code) {
         this.Code = Code;
     }
     public int getCode() {
         return Code;
     }

    public void setData(List<Data> Data) {
         this.Data = Data;
     }
     public List<Data> getData() {
         return Data;
     }

    public void setMsg(String Msg) {
         this.Msg = Msg;
     }
     public String getMsg() {
         return Msg;
     }

    public void setStamp(int Stamp) {
         this.Stamp = Stamp;
     }
     public int getStamp() {
         return Stamp;
     }

}