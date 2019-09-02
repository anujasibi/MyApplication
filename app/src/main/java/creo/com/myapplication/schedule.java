package creo.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class schedule extends AppCompatActivity {
    private long date;
    private DateFormat format;
    String currentDateandTime;
    private SlidingUpPanelLayout mLayout;
    EditText editText;
    CardView cardView,card;
    TextView textView,text,book;
    private RecyclerView recyclerView;
    Context mContext=this;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        final ArrayList<SlidingPojo>pojo = new ArrayList<>();
        SlidingPojo slidingPojo = new SlidingPojo("kottayam");
        SlidingPojo slidingPojo1 = new SlidingPojo("kochi");
        pojo.add(slidingPojo);
        pojo.add(slidingPojo1);
//        final SlidingPojo[] slidingPojo = new SlidingPojo[]{
//                new SlidingPojo("Kaloor"),
//                new SlidingPojo("Kottayam"),
//                new SlidingPojo("Thrissur"),
//                new SlidingPojo("Kollam"),
//                new SlidingPojo("Thrissur"),
//
//
//
//        };
        final TextView set_date = (TextView) findViewById(R.id.textj);
        final TextView set_time = (TextView) findViewById(R.id.textjj);

        book=findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(schedule.this,scheduledetails.class));
                Intent i=new Intent(schedule.this,scheduledetails.class);
                i.putExtra("name",editText.getText().toString());
                Log.d("mmvv","mm"+editText.getText());
                i.putExtra("date",set_date.getText());
                i.putExtra("time",set_time.getText());
                startActivity(i);
            }
        });
        recyclerView = findViewById(R.id.re);
        SlidingAdapter slidingAdapter = new SlidingAdapter(pojo,mContext);

        recyclerView.setAdapter(slidingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Toast.makeText(schedule.this,"You clicked"+pojo.get(position).getName(),Toast.LENGTH_SHORT).show();
                editText.setText(pojo.get(position).getName());
            }
        });


        editText=findViewById(R.id.whereto);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });
        cardView=findViewById(R.id.carder);
        card=findViewById(R.id.cau);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(schedule.this,PLACE.class));
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(schedule.this,workplace.class));
            }
        });

       textView=findViewById(R.id.teb);
       text=findViewById(R.id.work);
       Log.d("cllll","api"+Apiclient.place_name+editText.getText().toString());
       // String s=getIntent().getStringExtra("name");
        if(!(Apiclient.place_name.equals("null"))) {
            if(Apiclient.work_name.equals("null")) {
                textView.setText(Apiclient.place_name);
                editText.setText(Apiclient.place_name);
            }
        }

        if(!(Apiclient.work_name.equals("null"))) {
            if(Apiclient.place_name.equals("null")) {
                text.setText(Apiclient.work_name);
                editText.setText(Apiclient.work_name);
            }
        }
//
//        if(!(Apiclient.work_name.equals("null"))) {
//            text.setText(Apiclient.work_name);
//            editText.setText(Apiclient.work_name);
//        }
//        if(Apiclient.work_name.equals("null")){
//            text.setText("");
//            editText.setText("");
//        }
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i("kkll", "onPanelSlide, offset " + slideOffset);


            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                Log.i("lll", "onPanelStateChanged " + newState);
               /* InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);*/


            }
        });
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
            }
        });







        final long date = System.currentTimeMillis();
        final Calendar ca = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("EEE , dd  MMM");

        try {
            set_date.setText(format.format(ca.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat forma = new SimpleDateFormat("h:mm a");
        try {
            set_time.setText(forma.format(ca.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*String dateString = sdf.format(date);
        set_date.setText(dateString);

        long datev = System.currentTimeMillis();

        SimpleDateFormat sdfv = new SimpleDateFormat("h:mm a");
        String dateStringv = sdfv.format(datev);
        set_time.setText(dateStringv);*/

        final DatePickerDialog.OnDateSetListener dated = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                ca.set(Calendar.YEAR, year);
                ca.set(Calendar.MONTH, monthOfYear);
                ca.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "EEE , dd  MMM"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                set_date.setText(sdf.format(ca.getTime()));
            }

        };

        set_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(schedule.this, dated, ca
                        .get(Calendar.YEAR), ca.get(Calendar.MONTH),
                        ca.get(Calendar.DAY_OF_MONTH)).show();
            }
                
            
        });

        set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(schedule.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        String AM_PM ;
                        if(hourOfDay < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }
                        set_time.setText(hourOfDay + " : " + minutes + " " + AM_PM );


                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }

        });


    }

   
}
