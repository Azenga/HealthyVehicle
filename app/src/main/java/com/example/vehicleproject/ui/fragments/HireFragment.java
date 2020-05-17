package com.example.vehicleproject.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vehicleproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HireFragment extends Fragment {

    public HireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hire, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.car_button).setOnClickListener(btn ->
                Navigation.findNavController(btn).navigate(R.id.action_hireFragment_to_carFragment)
        );

        view.findViewById(R.id.bus_button).setOnClickListener(btn ->
                Navigation.findNavController(btn).navigate(R.id.action_hireFragment_to_busFragment)
        );

        view.findViewById(R.id.van_button).setOnClickListener(btn ->
                Navigation.findNavController(btn).navigate(R.id.action_hireFragment_to_vanFragment)
        );

        view.findViewById(R.id.motorcycle_button).setOnClickListener(btn ->
                Navigation.findNavController(btn).navigate(R.id.action_hireFragment_to_motorcycleFragment)
        );

        view.findViewById(R.id.pickup_button).setOnClickListener(btn ->
                Navigation.findNavController(btn).navigate(R.id.action_hireFragment_to_pickupFragment)
        );
    }
}
