package com.bawei.volley;

public interface Contract {

    interface IModel{
        void onget(String url,Mycallback mycallback);
    }
    interface IView{
        void Sccuess(String json);
        void Fidal(String error);
    }
    interface IPresenter{
        void attch(IView iView);
        void startRequest(String url);
        void deAttch();
    }

    interface Mycallback{
        void Sccuess(String json);
        void Fidal(String error);
    }
}
