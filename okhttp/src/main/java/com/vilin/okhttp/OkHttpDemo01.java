package com.vilin.okhttp;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** @author luowei */
public class OkHttpDemo01 {

  private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

  public static void get(String url) throws IOException {
    Request request = new Request.Builder().url(url).build();

    Response response = HTTP_CLIENT.newCall(request).execute();

    ResponseBody responseBody = response.body();
    System.out.println(responseBody.string());
  }

  public static void post(String url) throws IOException {
    MediaType mediaType = MediaType.parse("application/json");

    Map params = new HashMap();
    params.put("wd", "hello");

    Gson gson = new Gson();
    String jsonBody = gson.toJson(params);

    RequestBody requestBody = RequestBody.create(jsonBody, mediaType);
    Request request = new Request.Builder().url(url).post(requestBody).build();

    Response response = HTTP_CLIENT.newCall(request).execute();
    System.out.println(response.body().string());
  }

  public static void main(String[] args) throws IOException {
//    get("http://www.baidu.com");
    post("http://www.baidu.com");
  }
}
