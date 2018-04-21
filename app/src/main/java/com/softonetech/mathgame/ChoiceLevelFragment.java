package com.softonetech.mathgame;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ChoiceLevelFragment extends DialogFragment {


    Button btn_Plus;
    Button btn_Minus;
    Button btn_Multiplication;
    Button btn_Division;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_choice_level, container, false);
        getDialog().setTitle("Choice Level");
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_Holo);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_Plus = view.findViewById(R.id.btn_fragment_plus);
        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Levels.Operator = Operators.Plus.getCode();
                MainActivity.IsPlaying = true;
                dismiss();
            }
        });

        btn_Minus=view.findViewById(R.id.btn_fragment_minus);
        btn_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Levels.Operator = Operators.Minus.getCode();
                MainActivity.IsPlaying = true;
                dismiss();
            }
        });

        btn_Multiplication=view.findViewById(R.id.btn_fragment_multiplication);
        btn_Multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Levels.Operator = Operators.Multiplication.getCode();
                MainActivity.IsPlaying = true;
                dismiss();
            }
        });

        btn_Division=view.findViewById(R.id.btn_fragment_division);
        btn_Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Levels.Operator = Operators.Division.getCode();
                MainActivity.IsPlaying = true;
                dismiss();
            }
        });
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }
}
