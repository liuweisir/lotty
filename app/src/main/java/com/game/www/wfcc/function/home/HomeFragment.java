package com.game.www.wfcc.function.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.game.www.wfcc.R;
import com.game.www.wfcc.base.BaseFragmentV4;
import com.game.www.wfcc.base.MyApplication;
import com.game.www.wfcc.function.openLottery.activity.OpenCodeListActivity;
import com.game.www.wfcc.function.openLottery.activity.ZuqiuActivity;
import com.game.www.wfcc.function.openLottery.bean.OpenLotteryEnum;
import com.game.www.wfcc.ui.HanderLayout;

/**
 * Created by zhangdaweisir on 2017/6/5.
 */
public class HomeFragment extends BaseFragmentV4 implements  HanderLayout.TitleBottonLinstener, View.OnClickListener {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private HanderLayout mHander;


    public static HomeFragment newInstance() {
        final HomeFragment f = new HomeFragment();
        return f;
    }
//    private ConvenientBanner mCb;
//    private List<Integer> mImageList;

    public ImageView mImgShuang;
    public ImageView mImgDa;
    public ImageView mImg3D;
    public ImageView mImgPai3;
    public ImageView mImgPai5;
    public ImageView mImgSan5;
    public ImageView mImgGuang5;
    public ImageView mImgJiang5;
    private ImageView mImgZuqiu;
    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View rootView) {
        mHander = (HanderLayout) rootView.findViewById(R.id.hander);
        mHander.setBtnLinstener(this);
        mHander.setVisibility(View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE);
        mHander.setTitle("首页");
//        mCb = (ConvenientBanner) rootView.findViewById(R.id.id_cb);
//        mImageList = new ArrayList<>();
//        mImageList.add(R.drawable.one);
//        mImageList.add(R.drawable.two);
//        mImageList.add(R.drawable.three);
//        mImageList.add(R.drawable.four);
//        mImageList.add(R.drawable.five);
        this.mImgShuang = (ImageView) rootView.findViewById(R.id.imgShuang);
        this.mImgDa = (ImageView) rootView.findViewById(R.id.imgDa);
        this.mImg3D = (ImageView) rootView.findViewById(R.id.img3D);
        this.mImgPai3 = (ImageView) rootView.findViewById(R.id.imgPai3);
        this.mImgPai5 = (ImageView) rootView.findViewById(R.id.imgPai5);
        this.mImgSan5 = (ImageView) rootView.findViewById(R.id.imgSan5);
        this.mImgGuang5 = (ImageView) rootView.findViewById(R.id.imgGuang5);
        this.mImgJiang5 = (ImageView) rootView.findViewById(R.id.imgJiang5);
        mImgZuqiu = (ImageView) rootView.findViewById(R.id.imgZqiu);
        rootView.findViewById(R.id.layoutShuang).setOnClickListener(this);
        rootView.findViewById(R.id.layoutDa).setOnClickListener(this);
        rootView.findViewById(R.id.layout3D).setOnClickListener(this);

        rootView.findViewById(R.id.layoutPai3).setOnClickListener(this);
        rootView.findViewById(R.id.layoutPai5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutSan5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutJiang5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutGuang5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutJiang5).setOnClickListener(this);
        rootView.findViewById(R.id.layoutZuqiu).setOnClickListener(this);
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
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_ssq.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgShuang);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_dlt.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgDa);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_fc3d.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImg3D);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_pl5.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgPai5);
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_pls.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgPai3);
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
        Glide.with(MyApplication.getInstance()).load("http://mycp.iplay78.com/res/lot/icon_jczq.png")
                .centerCrop()
                .placeholder(R.drawable.user_icon)
                .crossFade()
                .into(mImgZuqiu);

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void doBusiness(Context mContext) {
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




    public void selectOpenCodeList(OpenLotteryEnum lotteryEnum) {
        Intent intent = new Intent(getActivity(), OpenCodeListActivity.class);
        intent.putExtra("lotteryEnum", lotteryEnum);
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
            case R.id.layoutZuqiu:
                startActivity(new Intent(getActivity(), ZuqiuActivity.class));
                break;

        }
    }

}
