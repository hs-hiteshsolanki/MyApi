package com.ex.myapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("products")
    Call<ProductsResponse> getProductsItem();
}
