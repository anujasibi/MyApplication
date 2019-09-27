package creo.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CarDetailsnew extends AppCompatActivity {
    TextView carname,drivername,destn;
    String cname,dname,imag,dest=null;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detailsnew);

        carname=findViewById(R.id.text);
        drivername=findViewById(R.id.names);
        imageView=findViewById(R.id.indicator);
        destn=findViewById(R.id.textn1);

        Bundle bundle=getIntent().getExtras();
        cname=bundle.getString("Car");
        dname=bundle.getString("Name");
        imag=bundle.getString("image");
        dest=bundle.getString("dest");

        Picasso.with(CarDetailsnew.this).load(imag ).into(imageView);
        carname.setText(cname);
        drivername.setText(dname);
        destn.setText(dest);

    }
}
