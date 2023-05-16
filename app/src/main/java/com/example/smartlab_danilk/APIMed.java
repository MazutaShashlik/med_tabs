package com.example.smartlab_danilk;
import com.example.smartlab_danilk.Token;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIMed {

    @POST("sendCode")
    Call<Void> sendCode(@Header("email") String email);

    @POST("signin")
    Call<Token> signIn(@Header("email") String email, @Header("code") Integer code);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://medic.madskill.ru/api/")
            .addConverterFactory(GsonConverterFactory.create()).build();
}