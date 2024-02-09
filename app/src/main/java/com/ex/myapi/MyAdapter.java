package com.ex.myapi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Activity context;
    private final List<ProductsItem> productArrayList;

    public MyAdapter(Activity context, List<ProductsItem> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        ProductsItem currentItem = productArrayList.get(position);
        holder.title.setText(currentItem.getTitle());
        //Type cast integer to String
        holder.price.setText(String.valueOf(currentItem.getPrice()));
        holder.stock.setText(String.valueOf(currentItem.getStock()));
        holder.reting.setText(currentItem.getRating().toString());
        Picasso.get().load(currentItem.getThumbnail()).into(holder.image);
        //Picasso.get().load(currentItem.getImages()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, stock, reting;
        ShapeableImageView image;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.productTitle);
            price = itemView.findViewById(R.id.productPrise);
            stock = itemView.findViewById(R.id.productStock);
            reting = itemView.findViewById(R.id.productRating);
            image=itemView.findViewById(R.id.productImage);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
