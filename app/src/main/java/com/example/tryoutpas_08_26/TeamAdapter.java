package com.example.tryoutpas_08_26;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context context;
    private List<Team> teamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList != null ? teamList : new ArrayList<>();
    }
    @NonNull
    @Override
    public TeamAdapter.TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.team_menu, parent,false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.TeamViewHolder holder, int position) {
        Team team= teamList.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        holder.tvStadium.setText(team.getStrStadium());

        Glide.with(context)
                .load(team.getStrBadge())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeamName,tvStadium;
        ImageView ivImage;
        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName=itemView.findViewById(R.id.tvTeamName);
            tvStadium=itemView.findViewById(R.id.tvStadium);
            ivImage=itemView.findViewById(R.id.ivImage);
        }
    }
}
