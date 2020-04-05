package com.example.baitest;

import android.content.Context;

public class ProxyNumber implements Display {

    private Context context;
    private RealLoad realLoad;

    public ProxyNumber(Context context){
        this.context = context;
    }

    @Override
    public String load() {
        if (realLoad == null){
            realLoad = new RealLoad(context);
        }
        return realLoad.load();
    }
}
