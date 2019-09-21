package creo.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import creo.com.myapplication.utils.Global;

public class signup extends AppCompatActivity {
    TextView signup;
    TextView login;
    Context context=this;
    String phone_no = null;
    TextInputEditText name,email,phoneno,password;
    private String URLline = Global.BASE_URL+"user/new_cabs/sign_up/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        email=findViewById(R.id.ema);
        phoneno=findViewById(R.id.phnn);
        password=findViewById(R.id.names);
        signup=findViewById(R.id.tb);
        login=findViewById(R.id.si);
        Bundle bundle = getIntent().getExtras();
        phone_no = bundle.getString("phone_no");
        Log.d("phone","mm"+phone_no);
        phoneno.setText(phone_no);
        phoneno.setEnabled(false);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupuser();
             //   startActivity(new Intent(signup.this,Login.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,Login.class));
            }
        });


    }

    private void signupuser() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(signup.this,response,Toast.LENGTH_LONG).show();
                        //parseData(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String ot = jsonObject.optString("message");
                            String status=jsonObject.optString("status");
                            Log.d("otp","mm"+ot);
                            if(status.equals("400")){
                                Toast.makeText(signup.this, ot, Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(signup.this, ot, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(signup.this, MainActivity.class);
                                startActivity(intent);

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
                        Toast.makeText(signup.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("name",name.getText().toString());
                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());
                params.put("phone_no",phoneno.getText().toString());
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }



    }

