package com.example.tryoutpas_08_26;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LaligaFragment extends Fragment {

    TextView tvLaliga;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laliga, container, false);

        tvLaliga = view.findViewById(R.id.tvLaliga);

        return view;
    }
}
