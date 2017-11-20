package com.game.www.wfcc.function.openLottery.bean.saishi;

import java.util.List;

public class Root {
private String status;

private String message;

private List<Data> data ;

public void setStatus(String status){
this.status = status;
}
public String getStatus(){
return this.status;
}
public void setMessage(String message){
this.message = message;
}
public String getMessage(){
return this.message;
}
public void setData(List<Data> data){
this.data = data;
}
public List<Data> getData(){
return this.data;
}

}