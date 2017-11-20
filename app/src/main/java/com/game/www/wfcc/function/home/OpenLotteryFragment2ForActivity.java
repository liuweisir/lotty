package com.game.www.wfcc.function.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.OpenCodeListActivity;
import com.game.www.wfcc.function.openLottery.bean.Detail;
import com.game.www.wfcc.function.openLottery.bean.OpenCode;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryQuery;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;
import com.game.www.wfcc.util.DateUtil;


/**
 * Created by Administrator on 2016/11/25.
 */
public class OpenLotteryFragment2ForActivity extends BaseFragmentV4 implements HanderLayout.TitleBottonLinstener, OpenLotteryView, View.OnClickListener {
    public static final String TAG = OpenLotteryFragment2ForActivity.class.getSimpleName();
    private HanderLayout mHander;
    public TextView mTvShuangOpenNum;
    public TextView mTvShuangOpenDate;
    public TextView mTvShuangOpen1;
    public TextView mTvShuangOpen2;
    public TextView mTvShuangOpen3;
    public TextView mTvShuangOpen4;
    public TextView mTvShuangOpen5;
    public TextView mTvShuangOpen6;
    public TextView mTvShuangOpen7;
    public TextView mTvDaOpenNum;
    public TextView mTvDaOpenDate;
    public TextView mTvDaOpen1;
    public TextView mTvDaOpen2;
    public TextView mTvDaOpen3;
    public TextView mTvDaOpen4;
    public TextView mTvDaOpen5;
    public TextView mTvDaOpen6;
    public TextView mTvDaOpen7;
    public TextView mTv3DOpenNum;
    public TextView mTv3DOpenDate;
    public TextView mTv3DOpen1;
    public TextView mTv3DOpen2;
    public TextView mTv3DOpen3;
    public TextView mTvPai3OpenNum;
    public TextView mTvPai3OpenDate;
    public TextView mTvPai3Open1;
    public TextView mTvPai3Open2;
    public TextView mTvPai3Open3;
    public TextView mTvPai5OpenNum;
    public TextView mTvPai5OpenDate;
    public TextView mTvPai5Open1;
    public TextView mTvPai5Open2;
    public TextView mTvPai5Open3;
    public TextView mTvPai5Open4;
    public TextView mTvPai5Open5;
    public TextView mTvSan5OpenNum;
    public TextView mTvSan5OpenDate;
    public TextView mTvSan5Open1;
    public TextView mTvSan5Open2;
    public TextView mTvSan5Open3;
    public TextView mTvSan5Open4;
    public TextView mTvSan5Open5;
    public TextView mTvGuang5OpenNum;
    public TextView mTvGuang5OpenDate;
    public TextView mTvGuang5Open1;
    public TextView mTvGuang5Open2;
    public TextView mTvGuang5Open3;
    public TextView mTvGuang5Open4;
    public TextView mTvGuang5Open5;
    public TextView mTvJiang5OpenNum;
    public TextView mTvJiang5ODate;
    public TextView mTvJiang5Open1;
    public TextView mTvJiang5Open2;
    public TextView mTvJiang5Open3;
    public TextView mTvJiang5Open4;
    public TextView mTvJiang5Open5;
    private OpenLotteryPrestener mOpenLotteryPrestener;


    public static OpenLotteryFragment2ForActivity newInstance() {
        final OpenLotteryFragment2ForActivity f = new OpenLotteryFragment2ForActivity();
        return f;
    }


    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_open_lottery2;
    }

    @Override
    public void initView(View rootView) {
        this.mTvShuangOpenNum = (TextView) rootView.findViewById( R.id.tvShuangOpenNum);
        this.mTvShuangOpenDate = (TextView) rootView.findViewById(R.id.tvShuangOpenDate);
        this.mTvShuangOpen1 = (TextView) rootView.findViewById(R.id.tvShuangOpen1);
        this.mTvShuangOpen2 = (TextView) rootView.findViewById(R.id.tvShuangOpen2);
        this.mTvShuangOpen3 = (TextView) rootView.findViewById(R.id.tvShuangOpen3);
        this.mTvShuangOpen4 = (TextView) rootView.findViewById(R.id.tvShuangOpen4);
        this.mTvShuangOpen5 = (TextView) rootView.findViewById(R.id.tvShuangOpen5);
        this.mTvShuangOpen6 = (TextView) rootView.findViewById(R.id.tvShuangOpen6);
        this.mTvShuangOpen7 = (TextView) rootView.findViewById(R.id.tvShuangOpen7);
        this.mTvDaOpenNum = (TextView) rootView.findViewById(R.id.tvDaOpenNum);
        this.mTvDaOpenDate = (TextView) rootView.findViewById(R.id.tvDaOpenDate);
        this.mTvDaOpen1 = (TextView) rootView.findViewById(R.id.tvDaOpen1);
        this.mTvDaOpen2 = (TextView) rootView.findViewById(R.id.tvDaOpen2);
        this.mTvDaOpen3 = (TextView) rootView.findViewById(R.id.tvDaOpen3);
        this.mTvDaOpen4 = (TextView) rootView.findViewById(R.id.tvDaOpen4);
        this.mTvDaOpen5 = (TextView) rootView.findViewById(R.id.tvDaOpen5);
        this.mTvDaOpen6 = (TextView) rootView.findViewById(R.id.tvDaOpen6);
        this.mTvDaOpen7 = (TextView) rootView.findViewById(R.id.tvDaOpen7);
        this.mTv3DOpenNum = (TextView) rootView.findViewById(R.id.tv3DOpenNum);
        this.mTv3DOpenDate = (TextView) rootView.findViewById(R.id.tv3DOpenDate);
        this.mTv3DOpen1 = (TextView) rootView.findViewById(R.id.tv3DOpen1);
        this.mTv3DOpen2 = (TextView) rootView.findViewById(R.id.tv3DOpen2);
        this.mTv3DOpen3 = (TextView) rootView.findViewById(R.id.tv3DOpen3);
        this.mTvPai3OpenNum = (TextView) rootView.findViewById(R.id.tvPai3OpenNum);
        this.mTvPai3OpenDate = (TextView) rootView.findViewById(R.id.tvPai3OpenDate);
        this.mTvPai3Open1 = (TextView) rootView.findViewById(R.id.tvPai3Open1);
        this.mTvPai3Open2 = (TextView) rootView.findViewById(R.id.tvPai3Open2);
        this.mTvPai3Open3 = (TextView) rootView.findViewById(R.id.tvPai3Open3);
        this.mTvPai5OpenNum = (TextView) rootView.findViewById(R.id.tvPai5OpenNum);
        this.mTvPai5OpenDate = (TextView) rootView.findViewById(R.id.tvPai5OpenDate);
        this.mTvPai5Open1 = (TextView) rootView.findViewById(R.id.tvPai5Open1);
        this.mTvPai5Open2 = (TextView) rootView.findViewById(R.id.tvPai5Open2);
        this.mTvPai5Open3 = (TextView) rootView.findViewById(R.id.tvPai5Open3);
        this.mTvPai5Open4 = (TextView) rootView.findViewById(R.id.tvPai5Open4);
        this.mTvPai5Open5 = (TextView) rootView.findViewById(R.id.tvPai5Open5);
        this.mTvSan5OpenNum = (TextView) rootView.findViewById(R.id.tvSan5OpenNum);
        this.mTvSan5OpenDate = (TextView) rootView.findViewById(R.id.tvSan5OpenDate);
        this.mTvSan5Open1 = (TextView) rootView.findViewById(R.id.tvSan5Open1);
        this.mTvSan5Open2 = (TextView) rootView.findViewById(R.id.tvSan5Open2);
        this.mTvSan5Open3 = (TextView) rootView.findViewById(R.id.tvSan5Open3);
        this.mTvSan5Open4 = (TextView) rootView.findViewById(R.id.tvSan5Open4);
        this.mTvSan5Open5 = (TextView) rootView.findViewById(R.id.tvSan5Open5);
        this.mTvGuang5OpenNum = (TextView) rootView.findViewById(R.id.tvGuang5OpenNum);
        this.mTvGuang5OpenDate = (TextView) rootView.findViewById(R.id.tvGuang5OpenDate);
        this.mTvGuang5Open1 = (TextView) rootView.findViewById(R.id.tvGuang5Open1);
        this.mTvGuang5Open2 = (TextView) rootView.findViewById(R.id.tvGuang5Open2);
        this.mTvGuang5Open3 = (TextView) rootView.findViewById(R.id.tvGuang5Open3);
        this.mTvGuang5Open4 = (TextView) rootView.findViewById(R.id.tvGuang5Open4);
        this.mTvGuang5Open5 = (TextView) rootView.findViewById(R.id.tvGuang5Open5);
        this.mTvJiang5OpenNum = (TextView) rootView.findViewById(R.id.tvJiang5OpenNum);
        this.mTvJiang5ODate = (TextView) rootView.findViewById(R.id.tvJiang5ODate);
        this.mTvJiang5Open1 = (TextView) rootView.findViewById(R.id.tvJiang5Open1);
        this.mTvJiang5Open2 = (TextView) rootView.findViewById(R.id.tvJiang5Open2);
        this.mTvJiang5Open3 = (TextView) rootView.findViewById(R.id.tvJiang5Open3);
        this.mTvJiang5Open4 = (TextView) rootView.findViewById(R.id.tvJiang5Open4);
        this.mTvJiang5Open5 = (TextView) rootView.findViewById(R.id.tvJiang5Open5);

        rootView.findViewById(R.id.layout3D).setOnClickListener(this);
        rootView.findViewById(R.id.layoutShuang).setOnClickListener(this);
        rootView.findViewById(R.id.layoutDa).setOnClickListener(this);
        rootView.findViewById(R.id.layoutPai3).setOnClickListener(this);
        rootView.findViewById(R.id.layoutPai5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutJiang5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutGuang5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutSan5).setOnClickListener(this);

        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setBtnLinstener(this);
        mHander.setVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("中奖查询");
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void doBusiness(Context mContext) {

        OpenLotteryQuery.Head head = new OpenLotteryQuery.Head();
        OpenLotteryQuery shuangQuery = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode shuangOpen = new OpenLotteryQuery.OpenCode();
        shuangQuery.setC_head(head);
        shuangOpen.setLotType(OpenLotteryEnum.双色球.getIndex());
        shuangOpen.setPage_index(0);
        shuangOpen.setPage_size(1);
        shuangQuery.setOpencode_detail(shuangOpen);
        mOpenLotteryPrestener.selectOpenLotteryMessage(shuangQuery, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split("\\|");
                        String[] openHoneCodes = shuangCode[0].split(",");
                        mTvShuangOpen1.setText(openHoneCodes[0]);
                        mTvShuangOpen2.setText(openHoneCodes[1]);
                        mTvShuangOpen3.setText(openHoneCodes[2]);
                        mTvShuangOpen4.setText(openHoneCodes[3]);
                        mTvShuangOpen5.setText(openHoneCodes[4]);
                        mTvShuangOpen6.setText(openHoneCodes[5]);
                        mTvShuangOpen7.setText(shuangCode[1]);
                        mTvShuangOpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvShuangOpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery DaQuery = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode DaOpen = new OpenLotteryQuery.OpenCode();
        DaQuery.setC_head(head);
        DaOpen.setLotType(OpenLotteryEnum.大乐透.getIndex());
        DaOpen.setPage_index(0);
        DaOpen.setPage_size(1);
        DaQuery.setOpencode_detail(DaOpen);
        mOpenLotteryPrestener.selectOpenLotteryMessage(DaQuery, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split("\\|");
                        String[] openHoneCodes = shuangCode[0].split(",");
                        String[] openLanCodes = shuangCode[1].split(",");
                        mTvDaOpen1.setText(openHoneCodes[0]);
                        mTvDaOpen2.setText(openHoneCodes[1]);
                        mTvDaOpen3.setText(openHoneCodes[2]);
                        mTvDaOpen4.setText(openHoneCodes[3]);
                        mTvDaOpen5.setText(openHoneCodes[4]);
                        mTvDaOpen6.setText(openLanCodes[0]);
                        mTvDaOpen7.setText(openLanCodes[1]);
                        mTvDaOpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvDaOpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery D3Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode D3Open = new OpenLotteryQuery.OpenCode();
        D3Query.setC_head(head);
        D3Open.setLotType(OpenLotteryEnum.福彩3D.getIndex());
        D3Open.setPage_index(0);
        D3Open.setPage_size(1);
        D3Query.setOpencode_detail(D3Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(D3Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTv3DOpen1.setText(shuangCode[0]);
                        mTv3DOpen2.setText(shuangCode[1]);
                        mTv3DOpen3.setText(shuangCode[2]);
                        mTv3DOpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTv3DOpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery pai3Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode pai3Open = new OpenLotteryQuery.OpenCode();
        pai3Query.setC_head(head);
        pai3Open.setLotType(OpenLotteryEnum.排列三.getIndex());
        pai3Open.setPage_index(0);
        pai3Open.setPage_size(1);
        pai3Query.setOpencode_detail(pai3Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(pai3Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTvPai3Open1.setText(shuangCode[0]);
                        mTvPai3Open2.setText(shuangCode[1]);
                        mTvPai3Open3.setText(shuangCode[2]);
                        mTvPai3OpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvPai3OpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });


        OpenLotteryQuery pai5Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode pai5Open = new OpenLotteryQuery.OpenCode();
        pai5Query.setC_head(head);
        pai5Open.setLotType(OpenLotteryEnum.排列五.getIndex());
        pai5Open.setPage_index(0);
        pai5Open.setPage_size(1);
        pai5Query.setOpencode_detail(pai5Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(pai5Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] openCodes = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTvPai5Open1.setText(openCodes[0]);
                        mTvPai5Open2.setText(openCodes[1]);
                        mTvPai5Open3.setText(openCodes[2]);
                        mTvPai5Open4.setText(openCodes[3]);
                        mTvPai5Open5.setText(openCodes[4]);
                        mTvPai5OpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvPai5OpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery san5Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode san5Open = new OpenLotteryQuery.OpenCode();
        san5Query.setC_head(head);
        san5Open.setLotType(OpenLotteryEnum.山东11选5.getIndex());
        san5Open.setPage_index(0);
        san5Open.setPage_size(1);
        san5Query.setOpencode_detail(san5Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(san5Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTvSan5Open1.setText(shuangCode[0]);
                        mTvSan5Open2.setText(shuangCode[1]);
                        mTvSan5Open3.setText(shuangCode[2]);
                        mTvSan5Open4.setText(shuangCode[3]);
                        mTvSan5Open5.setText(shuangCode[4]);
                        mTvSan5OpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvSan5OpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery guang5Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode guang5Open = new OpenLotteryQuery.OpenCode();
        guang5Query.setC_head(head);
        guang5Open.setLotType(OpenLotteryEnum.广东11选5.getIndex());
        guang5Open.setPage_index(0);
        guang5Open.setPage_size(1);
        guang5Query.setOpencode_detail(guang5Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(guang5Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTvGuang5Open1.setText(shuangCode[0]);
                        mTvGuang5Open2.setText(shuangCode[1]);
                        mTvGuang5Open3.setText(shuangCode[2]);
                        mTvGuang5Open4.setText(shuangCode[3]);
                        mTvGuang5Open5.setText(shuangCode[4]);
                        mTvGuang5OpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvGuang5OpenDate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });

        OpenLotteryQuery jiang5Query = new OpenLotteryQuery();
        OpenLotteryQuery.OpenCode jiang5Open = new OpenLotteryQuery.OpenCode();
        jiang5Query.setC_head(head);
        jiang5Open.setLotType(OpenLotteryEnum.江西11选5.getIndex());
        jiang5Open.setPage_index(0);
        jiang5Open.setPage_size(1);
        jiang5Query.setOpencode_detail(jiang5Open);
        mOpenLotteryPrestener.selectOpenLotteryMessage(jiang5Query, new OpenLotteryView() {
            @Override
            public void onSuccess(String json) {
                OpenCode openCode = MyApplication.getInstance().getGson().fromJson(json, OpenCode.class);
                if (openCode != null && openCode.getOpencode_detail() != null) {
                    if (openCode.getOpencode_detail().getDetail() != null) {
                        Detail detail = openCode.getOpencode_detail().getDetail();
                        String[] shuangCode = detail.getDetail_list().get(0).getOPEN_CODE().split(",");
                        mTvJiang5Open1.setText(shuangCode[0]);
                        mTvJiang5Open2.setText(shuangCode[1]);
                        mTvJiang5Open3.setText(shuangCode[2]);
                        mTvJiang5Open4.setText(shuangCode[3]);
                        mTvJiang5Open5.setText(shuangCode[4]);
                        mTvJiang5OpenNum.setText(detail.getDetail_list().get(0).getEXPECT() + "期");
                        mTvJiang5ODate.setText(DateUtil.dateTimeToStr(DateUtil.strToDate(detail.getDetail_list().get(0).getOPENCODE_TIME())) + " 周" + detail.getDetail_list().get(0).getOPENCODE_WEEK());
                    }
                }
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }

    @Override
    public void imgLeftLinstener(View v) {
        getActivity().finish();
    }

    @Override
    public void imgRightLinstener(View v) {
    }

    @Override
    public void btnLeftLinstener(View v) {

    }

    @Override
    public void btnRightLinstener(View v) {
    }


    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onFailure(String msg) {

    }

    public void selectOpenCodeList(OpenLotteryEnum lotteryEnum) {
        Intent intent = new Intent(getActivity(), OpenCodeListActivity.class);
        intent.putExtra("lotteryEnum",lotteryEnum);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout3D:
                selectOpenCodeList(OpenLotteryEnum.福彩3D);
                break;
            case R.id.layoutGuang5:
                selectOpenCodeList(OpenLotteryEnum.广东11选5);
                break;
            case R.id.layoutJiang5:
                selectOpenCodeList(OpenLotteryEnum.江西11选5);
                break;
            case R.id.layoutSan5:
                selectOpenCodeList(OpenLotteryEnum.山东11选5);
                break;
            case R.id.layoutShuang:
                selectOpenCodeList(OpenLotteryEnum.双色球);
                break;
            case R.id.layoutDa:
                selectOpenCodeList(OpenLotteryEnum.大乐透);
                break;
            case R.id.layoutPai3:
                selectOpenCodeList(OpenLotteryEnum.排列三);
                break;
            case R.id.layoutPai5:
                selectOpenCodeList(OpenLotteryEnum.排列五);
                break;
        }
    }
}
