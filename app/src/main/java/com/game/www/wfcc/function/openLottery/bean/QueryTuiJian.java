package com.game.www.wfcc.function.openLottery.bean;

/**
 * Created by Administrator on 2017/6/3.
 */
public class QueryTuiJian {

    private int PageIndex;
    private int PageSize;

    public int getPageIndex() {
        return PageIndex;
    }
    public QueryTuiJian(int PageIndex ,int PageSize){
        this.PageIndex = PageIndex;
        this.PageSize = PageSize;
    }
    public QueryTuiJian(){

    }
    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }
}
