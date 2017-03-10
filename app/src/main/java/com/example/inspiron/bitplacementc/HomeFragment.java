package com.example.inspiron.bitplacementc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inspiron.bitplacementc.Models.ServerPostResponse;
import com.example.inspiron.bitplacementc.Models.UserPost;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<UserPost> data;
    private DataAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostInterface request = retrofit.create(PostInterface.class);
        Call<ServerPostResponse> call = request.getJSON();
        call.enqueue(new Callback<ServerPostResponse>() {
            @Override
            public void onResponse(Call<ServerPostResponse> call, Response<ServerPostResponse> response) {

                ServerPostResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
            }

            @Override
            public void onFailure(Call<ServerPostResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)rootview.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
  //      loadJSON();
        adapter = new DataAdapter(data);
        recyclerView.setAdapter(adapter);


        return rootview;
    }





/*    void initializeRecyclerView() {
//        recyclerView = (RecyclerView) rootview.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new SampleAdapter(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }
*/
/*    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostInterface request = retrofit.create(PostInterface.class);
        Call<ServerPostResponse> call = request.getJSON();
        call.enqueue(new Callback<ServerPostResponse>() {
            @Override
            public void onResponse(Call<ServerPostResponse> call, Response<ServerPostResponse> response) {

                ServerPostResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ServerPostResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
*/
}

