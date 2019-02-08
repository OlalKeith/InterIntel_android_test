package com.example.interinteltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.core.BaseActivity;
import com.example.interinteltest.api.GetDataInterface;
import com.example.interinteltest.model.RetroOrigin;
import com.example.interinteltest.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        Call <RetroOrigin> retroOriginCall = service.getOrigin();

        retroOriginCall.enqueue(new Callback<RetroOrigin>() {
            @Override
            public void onResponse(Call<RetroOrigin> call, Response<RetroOrigin> response) {
                if (response.body() != null)
                {
                    RetroOrigin retroOrigin = response.body();
                    responseText.setText(retroOrigin.getOrigin());



                Log.d("olal", response.toString());
            }
            }

            @Override
            public void onFailure(Call<RetroOrigin> call, Throwable t) {

            }
        });

    }

    public void fetchResponse(View view) {
    }
}
