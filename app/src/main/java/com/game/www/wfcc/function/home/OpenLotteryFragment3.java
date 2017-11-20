package com.game.www.wfcc.function.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.OpenCodeListActivity;
import com.game.www.wfcc.function.openLottery.activity.OpenCodeListDetailActivity;
import com.game.www.wfcc.function.openLottery.activity.TuiJianDetailActivity;
import com.game.www.wfcc.function.openLottery.adapter.TuiJianAdapter;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.function.openLottery.bean.QueryTuiJian;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Data;
import com.game.www.wfcc.function.openLottery.bean.tuijian.Root;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestener;
import com.game.www.wfcc.function.openLottery.prestener.OpenLotteryPrestenerImpl;
import com.game.www.wfcc.function.openLottery.view.OpenLotteryView;
import com.game.www.wfcc.ui.HanderLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class OpenLotteryFragment3 extends BaseFragmentV4 implements HanderLayout.TitleBottonLinstener, OpenLotteryView, View.OnClickListener {
    public static final String TAG = OpenLotteryFragment3.class.getSimpleName();
    private HanderLayout mHander;
    private OpenLotteryPrestener mOpenLotteryPrestener;


    public static OpenLotteryFragment3 newInstance() {
        final OpenLotteryFragment3 f = new OpenLotteryFragment3();
        return f;
    }
    private ImageView mCb;
    private List<Integer> mImageList;

    private LayoutInflater inflater;
    private View handerView;
    public ImageView mImgShuang;
    public ImageView mImgDa;
    public ImageView mImg3D;
    public ImageView mImgPai3;
    public ImageView mImgPai5;
    public ImageView mImgSan5;
    public ImageView mImgGuang5;
    public ImageView mImgJiang5;
    private ListView listView;
    private TuiJianAdapter mAdapter;
    @Override
    public int bindLayout() {
        mOpenLotteryPrestener = new OpenLotteryPrestenerImpl(this);
        return R.layout.fragment_open_lottery;
    }

    @Override
    public void initView(View rootView) {
        inflater = LayoutInflater.from(getActivity());
        handerView = inflater.inflate(R.layout.hander_open_lottery3 , null);
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setBtnLinstener(this);
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("首页");
        mCb = (ImageView) handerView.findViewById(R.id.id_cb);
        mCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , OpenCodeListDetailActivity.class);
                startActivity(intent);
            }
        });
        mImageList = new ArrayList<>();
        mImageList.add(R.drawable.one);
        mImageList.add(R.drawable.two);
//        mImageList.add(R.drawable.three);
//        mImageList.add(R.drawable.four);
        mImageList.add(R.drawable.five);
        this.mImgShuang = (ImageView) handerView.findViewById(R.id.imgShuang);
        this.mImgDa = (ImageView) handerView.findViewById(R.id.imgDa);
        this.mImg3D = (ImageView) handerView.findViewById(R.id.img3D);
        this.mImgPai3 = (ImageView) handerView.findViewById(R.id.imgPai3);
        this.mImgPai5 = (ImageView) handerView.findViewById(R.id.imgPai5);
        this.mImgSan5 = (ImageView) handerView.findViewById(R.id.imgSan5);
        this.mImgGuang5 = (ImageView) handerView.findViewById(R.id.imgGuang5);
        this.mImgJiang5 = (ImageView) handerView.findViewById(R.id.imgJiang5);
        mImgShuang.setOnClickListener(this);
        mImgDa.setOnClickListener(this);
        mImg3D.setOnClickListener(this);
        mImgPai3.setOnClickListener(this);
        mImgPai5.setOnClickListener(this);
        mImgSan5.setOnClickListener(this);
        mImgGuang5.setOnClickListener(this);
        mImgJiang5.setOnClickListener(this);

//        mCb.setPages(new CBViewHolderCreator() {
//            @Override
//            public ImageViewHolder createHolder() {
//                return new ImageViewHolder();
//            }
//        }, mImageList)
//                .setPageIndicator(new int[]{R.drawable.ponit_normal, R.drawable.point_select}) //设置两个点作为指示器
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL); //设置指示器的方向水平  居中
//        mCb.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(getActivity(), "点击了条目" + position, Toast.LENGTH_LONG).show();
//            }
//        });
//        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_ssq.png")
//                .centerCrop()
//                .placeholder(R.drawable.user_icon)
//                .crossFade()
//                .into(mImgShuang);
//        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_dlt.png")
//                .centerCrop()
//                .placeholder(R.drawable.user_icon)
//                .crossFade()
//                .into(mImgDa);
//        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_fc3d.png")
//                .centerCrop()
//                .placeholder(R.drawable.user_icon)
//                .crossFade()
//                .into(mImg3D);
//        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_pl5.png")
//                .centerCrop()
//                .placeholder(R.drawable.user_icon)
//                .crossFade()
//                .into(mImgPai5);
//        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_pls.png")
//                .centerCrop()
//                .placeholder(R.drawable.user_icon)
//                .crossFade()
//                .into(mImgPai3);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_jx11X5.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgJiang5);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_sd11X5.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgSan5);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_gd11X5.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgGuang5);
        listView = (ListView) rootView.findViewById(R.id.listView);
        listView.addHeaderView(handerView);
        mAdapter = new TuiJianAdapter(getActivity());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity() , TuiJianDetailActivity.class);
                Data date = (Data) mAdapter.getItem((int) id);
                if(date == null)return;
                int rid =  date.getRecommendInfo().getId();
                intent.putExtra("rId" ,rid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void doBusiness(Context mContext) {
        mOpenLotteryPrestener.selectTuijian(new QueryTuiJian(0,15));
    }

    @Override
    public void imgLeftLinstener(View v) {

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
        Root root = MyApplication.getInstance().getGson().fromJson(json,Root.class);
        if(root != null && root.getData() != null && root.getData().size() > 0){
            mAdapter.addItem(root.getData());
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailure(String msg) {

    }

    public void selectOpenCodeList(OpenLotteryEnum lotteryEnum , String url) {
        Intent intent = new Intent(getActivity(), OpenCodeListActivity.class);
        intent.putExtra("lotteryEnum", lotteryEnum);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img3D:
                selectOpenCodeList(OpenLotteryEnum.福彩3D, "http://m.500.com/datachart/sd/jb.html");
                break;
            case R.id.imgGuang5:
                selectOpenCodeList(OpenLotteryEnum.广东11选5, "http://m.500.com/datachart/gdsyxw/jb.html");
                break;
            case R.id.imgJiang5:
                selectOpenCodeList(OpenLotteryEnum.江西11选5, "http://m.500.com/datachart/dlc/jb.html");
                break;
            case R.id.imgSan5:
                selectOpenCodeList(OpenLotteryEnum.山东11选5, "http://m.500.com/datachart/shdsyxw/jb.html");
                break;
            case R.id.imgShuang:
                selectOpenCodeList(OpenLotteryEnum.双色球 , "http://m.500.com/datachart/ssq/jb.html");
                break;
            case R.id.imgDa:
                selectOpenCodeList(OpenLotteryEnum.大乐透, "http://m.500.com/datachart/dlt/jb.html");
                break;
            case R.id.imgPai3:
                selectOpenCodeList(OpenLotteryEnum.排列三, "http://m.500.com/datachart/pls/jb.html");
                break;
            case R.id.imgPai5:
                selectOpenCodeList(OpenLotteryEnum.排列五, "http://m.500.com/datachart/plw/zx/0.html");
                break;
        }
    }

}
