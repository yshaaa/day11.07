package com.bawei.volley;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.volley.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.IView {

    private ListView listview;
    private Contract.IPresenter presenter;
    private  ArrayList<ShopBean.DataBean.GridDataBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter=new Presenter();
        presenter.attch(this);
        presenter.startRequest(HttpUrl.layout_http);
    }

    @Override
    public void Sccuess(String json) {
        List<ShopBean.DataBean.GridDataBean> gridData = new Gson().fromJson(json, ShopBean.class).getData().getGridData();
        list.addAll(gridData);
        MyAdapter myAdapter = new MyAdapter(list);
        listview.setAdapter(myAdapter);

    }

    @Override
    public void Fidal(String error) {

    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
    }
}
