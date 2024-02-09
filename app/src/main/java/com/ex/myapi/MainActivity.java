package com.ex.myapi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String url = "https://dummyjson.com/";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<ProductsResponse> call = apiInterface.getProductsItem();
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {

                if (response.isSuccessful()) {
                ProductsResponse responseBody = response.body();
                    if (responseBody != null) {
                        List<ProductsItem> productList = responseBody.getProducts();
                        if (productList != null) {
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, productList);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


//                Data show in textview
//                        StringBuilder collectDataInSB = new StringBuilder();
//                        for (ProductsItem myData : productList) {
//                            collectDataInSB.append(myData.getTitle()).append("\n");
//                        }
//                        TextView tv = findViewById(R.id.textv);
//                        tv.setText(collectDataInSB.toString());
                        }else {
                            Log.d("Main Activity", "productList is null");
                        }
                    } else {
                        Log.d("Main Activity", "Response body is null");
                    }
                } else {
                    Log.d("Main Activity", "API call not successful. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.d("Main Activity", "OnFailure: " + t.getMessage());

            }
        });
    }
}