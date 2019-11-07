package com.bawei.volley.presenter;

import com.bawei.volley.Contract;
import com.bawei.volley.model.Model;

public class Presenter implements Contract.IPresenter {
    private Contract.IView miView;
    private Contract.IModel miModel;
    @Override
    public void attch(Contract.IView iView) {
        this.miView=iView;
        miModel=new Model();
    }

    @Override
    public void startRequest(String url) {
        miModel.onget(url, new Contract.Mycallback() {
            @Override
            public void Sccuess(String json) {
                miView.Sccuess(json);
            }

            @Override
            public void Fidal(String error) {
                miView.Fidal(error);
            }
        });
    }

    @Override
    public void deAttch() {
        if(miView!=null){
            miView=null;
        }
        if(miModel!=null){
            miModel=null;
        }
    }
}
