package com.game.www.wfcc.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomeTabLayout extends LinearLayout implements View.OnClickListener {
    private ImageView mImgMessage;
    private TextView mTvMessage;
    private TextView unread_msgs_number;
    private RelativeLayout mLayoutMessage;
    private ImageView mImgMailList;
    private TextView mTvMailList;
    private TextView unread_mail_number;
    private RelativeLayout mLayoutMailList;
    private ImageView mImgJob;
    private TextView mTvJob;
    private TextView unread_job_number;
    private RelativeLayout mLayoutJob;
    private ImageView mImgMy;
    private TextView mTvMy;
    private TextView unread_my_number;
    private RelativeLayout mLayoutMy;

    private int index = 0;
    private int currentIndex = 0;

    private ImageView[] imgButtons;
    private TextView[] tvButtons;

    public static int MSG = 1;
    public static int MAIL = 2;
    public static int JOB = 3;
    public static int MY = 4;

    private InitFrgmentLinstener mInitFrgmentLinstener;
    public void setFrgmentLinstener(InitFrgmentLinstener initFrgmentLinstener){
        mInitFrgmentLinstener = initFrgmentLinstener;
        mInitFrgmentLinstener.messageLinstener();
    }







    public HomeTabLayout(Context context) {
        super(context);
        initView(context);
    }

    public HomeTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HomeTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate( R.layout.home_tab_layout, this, true);
        this.mImgMessage = (ImageView) findViewById(R.id.imgMessage);
        this.mTvMessage = (TextView) findViewById(R.id.tvMessage);
        this.unread_msgs_number = (TextView) findViewById(R.id.unread_msgs_number);
        this.mLayoutMessage = (RelativeLayout) findViewById(R.id.layoutMessage);
        mLayoutMessage.setOnClickListener(this);
        this.mImgMailList = (ImageView) findViewById(R.id.imgMailList);
        this.mTvMailList = (TextView) findViewById(R.id.tvMailList);
        this.unread_mail_number = (TextView) findViewById(R.id.unread_mail_number);
        this.mLayoutMailList = (RelativeLayout) findViewById(R.id.layoutMailList);
        mLayoutMailList.setOnClickListener(this);
        this.mImgJob = (ImageView) findViewById(R.id.imgJob);
        this.mTvJob = (TextView) findViewById(R.id.tvJob);
        this.unread_job_number = (TextView) findViewById(R.id.unread_job_number);
        this.mLayoutJob = (RelativeLayout) findViewById(R.id.layoutJob);
        mLayoutJob.setOnClickListener(this);
        this.mImgMy = (ImageView) findViewById(R.id.imgMy);
        this.mTvMy = (TextView) findViewById(R.id.tvMy);
        this.unread_my_number = (TextView) findViewById(R.id.unread_my_number);
        this.mLayoutMy = (RelativeLayout) findViewById(R.id.layoutMy);
        mLayoutMy.setOnClickListener(this);

        imgButtons = new ImageView[]{mImgMessage,mImgMailList,mImgJob,mImgMy};
        tvButtons = new TextView[]{mTvMessage,mTvMailList,mTvJob,mTvMy};
        setTab();
    }



    @Override
    public void onClick(View v) {
        int type = 0;
        switch (v.getId()){
            case R.id.layoutMessage:
                if(mInitFrgmentLinstener != null) mInitFrgmentLinstener.messageLinstener();
                type = 0;
                break;
            case R.id.layoutMailList:
                if(mInitFrgmentLinstener != null) mInitFrgmentLinstener.mailListLinstener();
                type = 1;
                break;
            case R.id.layoutJob:
                if(mInitFrgmentLinstener != null) mInitFrgmentLinstener.jobLinstener();
                type = 2;
                break;
            case R.id.layoutMy:
                if(mInitFrgmentLinstener != null) mInitFrgmentLinstener.myLinstener();
                type = 3;
                break;
        }
        currentIndex = index;
        index = type;
        setTab();
    }


    private void setTab(){
        imgButtons[index].setSelected(true);
        tvButtons[index].setTextColor(getContext().getResources().getColor(R.color.handerColor));
        if(currentIndex == index){
            return;
        }
        imgButtons[currentIndex].setSelected(false);
        tvButtons[currentIndex].setTextColor(getContext().getResources().getColor(R.color.homeTabTextColor));
    }

    public interface InitFrgmentLinstener{
        void messageLinstener();
        void mailListLinstener();
        void jobLinstener();
        void myLinstener();
    }





}
