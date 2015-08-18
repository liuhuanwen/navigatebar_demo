package com.liuhw.navigatebar.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.liuhw.navigatebar.R;
import com.liuhw.navigatebar.fragment.FirstFragment;
import com.liuhw.navigatebar.fragment.FourFragment;
import com.liuhw.navigatebar.fragment.SecondFragment;
import com.liuhw.navigatebar.fragment.ThreeFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private int last = -1; //上一个fragment的标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        fragments = new Fragment[4];
        fragments[0] = new FirstFragment();
        fragments[1] = new SecondFragment();
        fragments[2] = new ThreeFragment();
        fragments[3] = new FourFragment();
        RadioGroup navigateRg = (RadioGroup) findViewById(R.id.navigate_bar_rg);
        navigateRg.setOnCheckedChangeListener(this);
        // 默认第一个选中
        RadioButton firstRb = (RadioButton) findViewById(R.id.first_rb);
        firstRb.setChecked(true);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.first_rb:
                switchFragment(0);
                break;
            case R.id.second_rb:
                switchFragment(1);
                break;
            case R.id.three_rb:
                switchFragment(2);
                break;
            case R.id.four_rb:
                switchFragment(3);
                break;
        }
    }

    /**
     * 实现fragment的切换显示
     * @param tag 当前的fragment的tag
     * */
    private void switchFragment(int tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentManager.findFragmentByTag(String.valueOf(tag)) == null) {
            if (last >= 0) {
                fragmentTransaction.hide(fragments[last]);
            }
            fragmentTransaction.add(R.id.fragment, fragments[tag], String.valueOf(tag));
        } else {
            fragmentTransaction.hide(fragments[last]);
            fragmentTransaction.show(fragments[tag]);
        }
        fragmentTransaction.commit();
        last = tag;
    }
}
