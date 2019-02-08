package com.example.interinteltest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.core.BaseActivity;
import com.example.interinteltest.api.GetDataInterface;
import com.example.interinteltest.model.JSONResponse;
import com.example.interinteltest.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private Button button;

    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        button = findViewById(R.id.get_click);
        responseText = findViewById(R.id.response_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchOrigin();
            }
        });
    }

    private void fetchOrigin() {
        GetDataInterface service = RetrofitClientInstance.getRetrofitInstance().create(GetDataInterface.class);
       Call<JSONResponse> jsonResponseCall = service.getOrigin();
       jsonResponseCall.enqueue(new Callback<JSONResponse>() {
           @Override
           public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
               Toast.makeText(MainActivity.this, response.body().getOrigin(), Toast.LENGTH_SHORT).show();
               responseText.setText(response.body().getOrigin());
               Log.d("olal", response.toString() );
           }

           @Override
           public void onFailure(Call<JSONResponse> call, Throwable t) {
               Log.d("error", t.toString());

           }
       });

    }

    public void fetchResponse(View view) {

    }
}
