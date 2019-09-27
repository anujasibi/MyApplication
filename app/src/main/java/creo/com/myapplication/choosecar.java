package creo.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

public class choosecar extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    Context mContext=this;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecar);
       /* RecyclerPojo[] recyclerPojo = new RecyclerPojo[]{
                new RecyclerPojo("ALTO", R.drawable.alto, "    45 KM", "4.2*"),
                new RecyclerPojo("DZIRE", R.drawable.dzire, "50 KM", "3.5*"),
                new RecyclerPojo("SWIFT", R.drawable.swift, "60 KM", "4.0*"),
                new RecyclerPojo("SWIFT", R.drawable.swift, "60 KM", "4.0*"),
                new RecyclerPojo("SWIFT", R.drawable.swift, "60 KM", "4.0*"),

        };*/


        recyclerView = findViewById(R.id.re);
      //  RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerPojo,mContext);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


    }
}
