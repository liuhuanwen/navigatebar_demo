package com.liuhw.navigatebar.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuhw.navigatebar.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        super();
        /**
         * setRetainInstance()用于设置在Activity对象被重建（如配置的变化）时，是否应该保留该Fragment对象的实例。
         * 它仅适用于没有在回退堆栈中Fragment对象。如果设置为true，那么该Fragment对象的生命周期与创建Activity时有些不同：
         * 1.onDestory()方法不会被调用（但是onDetach()方法会依然被调用，因为该Fragment对象会从当前的Activity中被解除绑定）。
         * 2.onCreate(Bundle)方法不会被调用，因为该Fragment对象没有被重建；
         * 3.onAttach(Activity)和onActivityCreated(Bundle)方法会依然被调用。
         **/
        this.setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}
