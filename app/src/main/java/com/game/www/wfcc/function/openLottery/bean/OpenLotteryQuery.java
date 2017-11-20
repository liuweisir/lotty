package com.game.www.wfcc.function.openLottery.bean;

/**
 * Created by Administrator on 2017/6/1.
 */
public class OpenLotteryQuery {

    private OpenCode opencode_detail;
    private Head c_head;

    public OpenCode getOpencode_detail() {
        return opencode_detail;
    }

    public void setOpencode_detail(OpenCode opencode_detail) {
        this.opencode_detail = opencode_detail;
    }

    public Head getC_head() {
        return c_head;
    }

    public void setC_head(Head c_head) {
        this.c_head = c_head;
    }

    public static class OpenCode{
        private int page_index;
        private int lotType;
        private int page_size;
        {
            page_index = 0;
            page_size = 10;
        }

        public int getPage_index() {
            return page_index;
        }

        public void setPage_index(int page_index) {
            this.page_index = page_index;
        }

        public int getLotType() {
            return lotType;
        }

        public void setLotType(int lotType) {
            this.lotType = lotType;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }
    }
    public static class Head{
        private String client_id;
        private String client_os;
        {
            client_id = "BY003000000000000002";
            client_os = "Android";
        }

        public String getClient_id() {
            return client_id;
        }

        public String getClient_os() {
            return client_os;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public void setClient_os(String client_os) {
            this.client_os = client_os;
        }
    }

}
