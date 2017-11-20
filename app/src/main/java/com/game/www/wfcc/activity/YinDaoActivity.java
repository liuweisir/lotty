package com.game.www.wfcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.game.www.wfcc.R;
import com.game.www.wfcc.util.PreferencesUtil;

public class YinDaoActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private final int viewPagerCount = 4;
    private String objectUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);
        PreferencesUtil.banSpeech(true);
        objectUrl= getIntent().getStringExtra("objectUrl");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int flage= 0;
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        flage = 0 ;
                        break ;
                    case MotionEvent.ACTION_MOVE:
                        flage = 1 ;
                        break ;
                    case  MotionEvent.ACTION_UP :
                        if (flage == 0) {
                            int item = mViewPager.getCurrentItem();
                            if (item == viewPagerCount -1) {
                                Intent intent = new Intent(YinDaoActivity.this, WebActivity.class);
                                intent.putExtra("objectUrl",objectUrl);
                                startActivity(intent);
                                YinDaoActivity.this.finish();
                            }
                        }
                        break ;


                }
                return false;
            }
        });
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_yin_dao, container, false);
            LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.yinDao);
            layout.setBackgroundResource(getArguments().getInt(ARG_SECTION_NUMBER));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            int resId =0;
            switch (position){
                case 0:
                    resId = R.drawable.yindao_one;
                    break;
                case 1:
                    resId = R.drawable.yindao_two;
                    break;
                case 2:
                    resId = R.drawable.yindao_three;
                    break;
                case 3:
                    resId = R.drawable.yindao_four;
                    break;

            }
            return PlaceholderFragment.newInstance(resId);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return viewPagerCount;
        }

    }
}
