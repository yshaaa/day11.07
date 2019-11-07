package com.bawei.volley.model;

import com.bawei.volley.Contract;
import com.bawei.volley.NetUtil;

public class Model implements Contract.IModel {
    @Override
    public void onget(String url, final Contract.Mycallback mycallback) {
        NetUtil.getInstance().getInfo(url, new NetUtil.MyCallBack() {
            @Override
            public void Sccuess(String json) {
                mycallback.Sccuess(json);
            }

            @Override
            public void Errpr(String error) {

            }
        });
    }
}
