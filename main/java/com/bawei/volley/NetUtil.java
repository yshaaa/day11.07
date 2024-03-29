package com.bawei.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.volley.app.MyApp;

import java.util.Map;

public class NetUtil {

    private final RequestQueue requestQueue;

    private NetUtil(){
        requestQueue = Volley.newRequestQueue(MyApp.context);
    }
    private static class NetUrl{
        private static NetUtil netUtil=new NetUtil();
    }
    public static NetUtil getInstance(){
        return NetUrl.netUtil;
    }

    public void getInfo(String httpUrl, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.Sccuess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.Errpr(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public void postInfo(String httpUrl, final Map<String,String>map, final MyCallBack myCallBack){
        StringRequest stringRequest = new StringRequest(httpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.Sccuess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.Errpr(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(map!=null){
                    return map;
                }
                return super.getParams();
            }
        };
        requestQueue.add(stringRequest);
    }



    public interface MyCallBack{
        void Sccuess(String json);
        void Errpr(String error);
    }

}
