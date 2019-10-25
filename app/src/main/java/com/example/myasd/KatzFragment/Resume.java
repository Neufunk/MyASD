package com.example.myasd.KatzFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.myasd.EchelleKatz;
import com.example.myasd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Resume extends Fragment {

    EditText inputNom;
    EditText inputSurname;
    EditText inputNiss;

    private OnGetFromUserClickListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnGetFromUserClickListener ) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnGetFromUserClickListener");
        }
    }

    public void getFromUser(View v) {
        if (mListener != null) {
            inputNom = v.findViewById(R.id.inputNom);
            mListener.getFromUser(inputNom.getText().toString());
        }
    }

    public interface OnGetFromUserClickListener {
        void getFromUser(String message);
    }

    public Resume() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.resume, container, false);
        inputSurname = view.findViewById(R.id.inputPrenom);
        inputNiss = view.findViewById(R.id.inputNiss);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
