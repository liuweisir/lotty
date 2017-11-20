package com.game.www.wfcc.function.openLottery.bean.newJingCai;

import java.util.List;
public class Data {
private List<Matches> matches ;

private List<String> expect_list ;

private String curr_expect;

private int servertime;

public void setMatches(List<Matches> matches){
this.matches = matches;
}
public List<Matches> getMatches(){
return this.matches;
}
public void setString(List<String> expect_list){
this.expect_list = expect_list;
}
public List<String> getString(){
return this.expect_list;
}
public void setCurr_expect(String curr_expect){
this.curr_expect = curr_expect;
}
public String getCurr_expect(){
return this.curr_expect;
}
public void setServertime(int servertime){
this.servertime = servertime;
}
public int getServertime(){
return this.servertime;
}

    public List<String> getExpect_list() {
        return expect_list;
    }

    public void setExpect_list(List<String> expect_list) {
        this.expect_list = expect_list;
    }
}