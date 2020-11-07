package com.example.lesson04_okhttp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp extends AsyncTask<Void, Void, String> {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(Void... voids) {
         HttpUrl.Builder builder = HttpUrl.parse("https://reqres.in/api/users").newBuilder();
         builder.addQueryParameter("page", "2");
         String url = builder.build().toString();

         Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            Log.d("doInBackground: ", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()){
                    throw new IOException("Invalid " + response);
                }else {
//
                }
            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }
}
