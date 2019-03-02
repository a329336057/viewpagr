package com.example.administrator.imagetest;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.administrator.imagetest.Adatpter.MainActivityViewPagerAdapter;
import com.example.administrator.imagetest.fragment.fragment1;
import com.example.administrator.imagetest.fragment.fragment2;
import com.example.administrator.imagetest.fragment.fragment3;

public class MainActivity extends AppCompatActivity {
    ViewPager mainActivityViewPager;
    BottomNavigationView bottomNavView;
    MainActivityViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        bottomNavView = (BottomNavigationView) findViewById(R.id.main_bottom_nav_view);
        adapter=new MainActivityViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment1());
        adapter.addFragment(new fragment2());
        adapter.addFragment(new fragment3());
        mainActivityViewPager.setAdapter(adapter);
//        为 BottomNavigationView 的菜单项  设置监听事件
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//               获取到菜单项的Id
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.btm_nav_item1:
                        mainActivityViewPager.setCurrentItem(0);
                        break;
                    case R.id.btm_nav_item2:
                        mainActivityViewPager.setCurrentItem(1);
                        break;
                    case R.id.btm_nav_item3:
                        mainActivityViewPager.setCurrentItem(2);
                        break;


                }
                // true 会显示这个Item被选中的效果 false 则不会
                return true;
            }
        });
//        为 ViewPager 设置监听事件
        mainActivityViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                bottomNavView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
