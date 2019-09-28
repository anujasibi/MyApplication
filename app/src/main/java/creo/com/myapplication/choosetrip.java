package creo.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import creo.com.myapplication.utils.Global;

public class choosetrip extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    Context context = this;
    ArrayList<RecyclerPojo> dataModelArrayList;
    private String URLline = Global.BASE_URL+"user/new_cabs/sign_up/";

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosetrip);

      /*  RecyclerPojo[] recyclerPojo = new RecyclerPojo[]{
                new RecyclerPojo("ALTO", R.drawable.alto, "45 KM", "4.2*"),
                new RecyclerPojo("DZIRE", R.drawable.dzire, "50 KM", "3.5*"),
                new RecyclerPojo("SWIFT", R.drawable.swift, "60 KM", "4.0*"),


        };*/


        recyclerView = findViewById(R.id.re);
       // RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerPojo,context);



        /*recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));



        */
        TextView ty=(TextView)findViewById(R.id.go);
        ty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.VISIBLE);
                passlatlong();
            }
        });
    }

    private void passlatlong(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(choosetrip.this,response,Toast.LENGTH_LONG).show();
                        //parseData(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String ot = jsonObject.optString("message");
                            String status=jsonObject.optString("status");
                            Log.d("otp","mm"+ot);

                            Toast.makeText(choosetrip.this, ot, Toast.LENGTH_LONG).show();
                            //  JSONObject obj = new JSONObject(response);


                            dataModelArrayList = new ArrayList<>();
                            JSONArray dataArray  = jsonObject.getJSONArray("available_cabs");

                            for (int i = 0; i < dataArray.length(); i++) {

                                RecyclerPojo playerModel = new RecyclerPojo();
                                JSONObject dataobj = dataArray.getJSONObject(i);

                                playerModel.setName(dataobj.getString("Car"));
                                playerModel.setDistance(dataobj.getString("Name"));
                                playerModel.setImage(Global.BASE_URL+"media/"+dataobj.getString("image"));
                                //  playerModel.setRat(dataobj.getString(""));


                                dataModelArrayList.add(playerModel);



                                setupRecycler();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d("response","hhh"+response);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(choosetrip.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
             //   params.put("latitude", latitu);
             //   params.put("longitude", longitu);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
    @SuppressLint("WrongConstant")
    private void setupRecycler(){

        recyclerAdapter = new RecyclerAdapter(this,dataModelArrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

    }


}
