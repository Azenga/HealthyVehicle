package com.example.vehicleproject.ui.fragments.hire;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.vehicleproject.R;
import com.example.vehicleproject.utils.Helper;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment {

    private EditText noOfPassengersEt, durationEt;
    private TextView amountTv;
    private CheckBox payCheckBox;

    private DecimalFormat mDf = new DecimalFormat("##.##");

    private int passengers = 0;
    private int duration = 0;

    public BusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        amountTv = view.findViewById(R.id.amount_tv);

        noOfPassengersEt = view.findViewById(R.id.no_of_passengers_et);

        noOfPassengersEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String sPassengers = s.toString();

                try {
                    passengers = Integer.parseInt(sPassengers);

                    String amount = mDf.format(passengers * duration * 50);

                    amountTv.setText(String.format("KSh. %s", amount));

                } catch (NumberFormatException e) {
                    Helper.toast("Error converting the number string to integer");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        durationEt = view.findViewById(R.id.duration_et);

        durationEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String sPassengers = s.toString();

                try {
                    duration = Integer.parseInt(sPassengers);

                    String amount = mDf.format(passengers * duration * 50);

                    amountTv.setText(String.format("KSh. %s", amount));

                } catch (NumberFormatException e) {
                    Helper.toast("Error converting the number string to integer");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        payCheckBox = view.findViewById(R.id.pay_check_box);

        Button completeRequestButton = view.findViewById(R.id.complete_request_button);

        completeRequestButton.setOnClickListener(btn -> {

            if (payCheckBox.isSelected()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());

                alertDialog.setTitle("Proceed to payment");
                alertDialog.setMessage("Are you sure you want to pay first?");

                alertDialog.setPositiveButton("SURE", (dialog, which) ->
                        Navigation.findNavController(btn).navigate(R.id.action_busFragment_to_transactionFragment));

                alertDialog.setNegativeButton("CANCEL", (dialog, which) -> {

                });

                alertDialog.show();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

        noOfPassengersEt.removeTextChangedListener(null);
        durationEt.removeTextChangedListener(null);
    }
}
