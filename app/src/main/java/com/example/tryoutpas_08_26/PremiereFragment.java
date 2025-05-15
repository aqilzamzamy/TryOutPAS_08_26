package com.example.tryoutpas_08_26;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PremiereFragment extends Fragment {
    RecyclerView recyclerView;
    TeamAdapter teamAdapter;
    List<Team> teamList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiere, container, false);
        recyclerView= view.findViewById(R.id.rvPremiere);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        teamList = new ArrayList<>();
        teamAdapter = new TeamAdapter(getContext(), teamList);
        recyclerView.setAdapter(teamAdapter);

        loadTeamsFromApi();


        return view;
    }

    private void loadTeamsFromApi() {
        SportsApi api = ApiClient.getClient().create(SportsApi.class);
        Call<TeamResponse> call = api.getTeams("English Premier League");

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    teamList.clear();
                    teamList.addAll(response.body().getTeams());
                    teamAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
