package com.retrofit.test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("users/{user}")
    Call<Student> listRepos(@Path("user") String user);
}
