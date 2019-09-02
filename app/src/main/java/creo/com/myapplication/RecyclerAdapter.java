package creo.com.myapplication;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context ctx;

    private int lastSelectedPosition = -1;

    private LayoutInflater inflater;

    //   private ArrayList<RecyclerPojo>recyclerPojos;

    private RecyclerPojo[] recyclerPojos;

    // RecyclerView recyclerView;
    public RecyclerAdapter(RecyclerPojo[] recyclerPojos,Context context) {
        this.recyclerPojos = recyclerPojos;
        this.ctx=context;
    }


//     public RecyclerAdapter(Context ctx, ArrayList<RecyclerPojo> recyclerPojos){
//       this.ctx=ctx;
//
//     inflater = LayoutInflater.from(ctx);
//     this.recyclerPojos = recyclerPojos;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //  View view = inflater.inflate(R.layout.choose_address_row, parent, false);
        //  MyViewHolder holder = new MyViewHolder(view);

        // return holder;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.car_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final RecyclerPojo recyclerPojo = recyclerPojos[position];
        holder.name.setText(recyclerPojos[position].getName());
        holder.image.setImageResource(recyclerPojos[position].getImage());
        holder.rat.setText(recyclerPojos[position].getRat());
        holder.distance.setText(recyclerPojos[position].getDistance());
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.startActivity(new Intent(ctx,cardetails.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return recyclerPojos.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView image;
        TextView distance;
        TextView rat;
        TextView book;

        public MyViewHolder(View itemView) {
            super(itemView);

            rat=(TextView)itemView.findViewById(R.id.rat);
            name=(TextView)itemView.findViewById(R.id.name);
            image=(ImageView)itemView.findViewById(R.id.imk);
            distance=(TextView)itemView.findViewById(R.id.phone);
            book=itemView.findViewById(R.id.bo);








        }
    }
}
