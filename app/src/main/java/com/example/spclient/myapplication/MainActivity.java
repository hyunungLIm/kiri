package com.example.spclient.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int max_page = 3;
    private Button btn1,btn2,btn3;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        btn1 = (Button) findViewById(R.id.page1);
        btn2 = (Button) findViewById(R.id.page2);
        btn3 = (Button) findViewById(R.id.page3);

        btn1.setOnClickListener(btn_click);
        btn1.setTag(0);
        btn2.setOnClickListener(btn_click);
        btn2.setTag(1);
        btn3.setOnClickListener(btn_click);
        btn3.setTag(2);

    }
        View.OnClickListener btn_click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) v.getTag();
                viewPager.setCurrentItem(tag);
            }
        };



    private class pagerAdapter extends FragmentStatePagerAdapter{

        public pagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new Page1_fregment();
                case 1:
                    return new Page2_fregment();
                case 2:
                    return new Page3_fregment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
