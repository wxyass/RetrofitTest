package com.retrofit.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 官方案例
        netRequestWithRetrofit();
    }

    public void netRequestWithRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        Call<Student> repos = service.listRepos("wxyass");
        repos.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call,Response<Student> response){
                System.out.print(response.body().getLogin());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });
    }
}
