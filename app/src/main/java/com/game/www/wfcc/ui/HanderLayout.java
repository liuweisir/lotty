package com.game.www.wfcc.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.www.wfcc.R;


/**
 * Created by Administrator on 2016/11/26.
 */
public class HanderLayout extends RelativeLayout {

    private TextView mTvTitle;
    private ImageButton mImgBtnTitleLeft;
    private Button mBtnTitleLeft;
    private ImageButton mImgBtnTitleRight;
    private Button mBtnTitleRight;
    private View mLine;
    private RelativeLayout mParentView;




    public void setBackRound(int rid){
        mParentView.setBackgroundResource(rid);
    }

    public interface TitleBottonLinstener{
        void imgLeftLinstener(View v);
        void imgRightLinstener(View v);
        void btnLeftLinstener(View v);
        void btnRightLinstener(View v);
    }
    
    
    public HanderLayout(Context context) {
        super(context);
        initView(context);
    }

    public HanderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HanderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
         LayoutInflater.from(context).inflate( R.layout.hander, this, true);
        this.mParentView = (RelativeLayout) findViewById( R.id.parentView);
        this.mTvTitle = (TextView) findViewById(R.id.tvTitle);
        this.mImgBtnTitleLeft = (ImageButton) findViewById(R.id.imgBtnTitleLeft);
        this.mBtnTitleLeft = (Button) findViewById(R.id.btnTitleLeft);
        this.mImgBtnTitleRight = (ImageButton) findViewById(R.id.imgBtnTitleRight);
        this.mBtnTitleRight = (Button) findViewById(R.id.btnTitleRight);
        mLine = findViewById(R.id.line);
    }
    public void hideLine(){
        mLine.setVisibility(GONE);
    }
    public void showLine(){
        mLine.setVisibility(VISIBLE);
    }

    public void setVisibility(int title,int imgLeft,int imgRight,int btnLeft,int btnRight){
        mTvTitle.setVisibility(title);
        mImgBtnTitleLeft.setVisibility(imgLeft);
        mImgBtnTitleRight.setVisibility(imgRight);
        mBtnTitleLeft.setVisibility(btnLeft);
        mBtnTitleRight.setVisibility(btnRight);
    }
    public void setmImgBtnTitleLeftResources(int resId){
        this.mImgBtnTitleLeft.setBackgroundResource(resId);
    }

    public void setmImgBtnTitleRightResources(int resId){
        this.mImgBtnTitleRight.setBackgroundResource(resId);
    }



    public void setmBtnTitleLeftText(String text){
        this.mBtnTitleLeft.setText(text);
    }

    public void setmBtnTitleRightText(String text){
        this.mBtnTitleRight.setText(text);
    }


    public void setmBtnTitleLeftText(int resId){
        this.mBtnTitleLeft.setText(resId);
    }
    public void setmBtnTitleLeftTextColor(int resId){
        this.mBtnTitleLeft.setTextColor(getContext().getResources().getColor(resId));
    }
    public void setmBtnTitleRightTextColor(int resId){
        this.mBtnTitleRight.setTextColor(getContext().getResources().getColor(resId));
    }
    public void setmBtnTitleRightText(int resId){
        this.mBtnTitleRight.setText(resId);
    }




    public void setBtnLinstener(final TitleBottonLinstener linstener){
        if(linstener == null){
            return;
        }
        this.mImgBtnTitleLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linstener.imgLeftLinstener(v);
            }
        });


        this.mImgBtnTitleRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linstener.imgRightLinstener(v);
            }
        });


        this.mBtnTitleLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linstener.btnLeftLinstener(v);
            }
        });


        this.mBtnTitleRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                linstener.btnRightLinstener(v);
            }
        });
    }

    public void setTitle(String title){
        if(!TextUtils.isEmpty(title)){
            this.mTvTitle.setText(title);
        }
    }
    public void setTitle(int resId){
        this.mTvTitle.setText(resId);
    }
    public void setTitleColor(int resId){
        try {
            this.mTvTitle.setTextColor(getContext().getResources().getColor(resId));
        }catch (Exception e){

        }
    }
    public void setTitleSize(float s){
        this.mTvTitle.setTextSize(s);
    }

}
