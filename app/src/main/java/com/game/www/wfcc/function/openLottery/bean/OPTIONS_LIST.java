package com.game.www.wfcc.function.openLottery.bean;

import java.io.Serializable;

public class OPTIONS_LIST implements Serializable{
private String award_level_name;

private String award_level;

private String each_bonus_money;

private String award_number;

public void setAward_level_name(String award_level_name){
this.award_level_name = award_level_name;
}
public String getAward_level_name(){
return this.award_level_name;
}
public void setAward_level(String award_level){
this.award_level = award_level;
}
public String getAward_level(){
return this.award_level;
}
public void setEach_bonus_money(String each_bonus_money){
this.each_bonus_money = each_bonus_money;
}
public String getEach_bonus_money(){
return this.each_bonus_money;
}
public void setAward_number(String award_number){
this.award_number = award_number;
}
public String getAward_number(){
return this.award_number;
}

}