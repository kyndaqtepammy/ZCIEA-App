package com.pamsillah.zciea.ui.api;

import static com.pamsillah.zciea.config.Config.HOME_MENU_ITEM_ID;
import static com.pamsillah.zciea.config.Config.VIEW_MEMBER;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.pamsillah.zciea.R;
import com.pamsillah.zciea.adapters.AdapterRecords;
import com.pamsillah.zciea.models.ModelRecords;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiCalls extends AppCompatActivity {
    public String strHomeMenuItem;
    private AdapterRecords adapterRecords;
    private ListView recordsView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get our input fields by its ID

        //conditional rendering
        strHomeMenuItem = getIntent().getStringExtra(HOME_MENU_ITEM_ID);
        switch (strHomeMenuItem){
            case VIEW_MEMBER: {
                setContentView(R.layout.layout_view_members);
                membersInfoGet();
            }
            default:
                //setContentView(R.layout.card_home_grid_menu);
        }

        adapterRecords = new AdapterRecords(this, new ArrayList<ModelRecords>());
        recordsView  = findViewById(R.id.records_view);
        recordsView.setAdapter(adapterRecords);
    }


    //fetch members information
    public void membersInfoGet() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.zciea.trade/api/reports", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray arr = response.getJSONArray("members");

                    for( int i=0; i < arr.length(); i++ ){
                        JSONObject members  = arr.getJSONObject(i);
                        String name = members.optString("name");
                        String idNumber = members.optString("id_number");
                        String territory = members.optString("territory");
                        String gender = members.optString("gender");
                        String trade = members.optString("trade");

                        ModelRecords modelRecords = new ModelRecords(
                            idNumber, name, trade, territory,idNumber, gender
                        );
                        adapterRecords.add(modelRecords);
                        recordsView.setAdapter(adapterRecords);
                        recordsView.setSelection(adapterRecords.getCount() - 1);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(ApiCalls.this);
        requestQueue.add(jsonObjectRequest);
    }
}


