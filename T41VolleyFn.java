package com.example.myapplication.Tuan4;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class T41VolleyFn {
    String strJSON="";
    public void getJsonArrayOfObject(Context context, TextView textView)
    {
        //1. Tao request
        RequestQueue queue= Volley.newRequestQueue(context);
        //2. URL
        String url="https://raw.githubusercontent.com/hungnttg/ThangLong-FA23-Android/main/a.json";
        //3. Goi request
        //JsonArrayRequest(url, thanhCong, thatBai)
        JsonArrayRequest request=new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Chuyen mang sang cac doi tuong
                        for (int i=0; i<response.length(); i++)
                        {
                            try {
                                JSONObject person=response.getJSONObject(i); //Lay tung doi tuong
                                String id=person.getString("id");
                                String name=person.getString("name");
                                String email= person.getString("email");
                                //
                                strJSON += "Id: "+id+"\n";
                                strJSON += "Name: "+name+"\n";
                                strJSON += "Email: "+email+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textView.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        //4. Thuc thi request
        queue.add(request);
    }
}
