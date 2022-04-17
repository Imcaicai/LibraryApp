package com.example.library.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.library.R;

public class MyFragment extends Fragment {
    private TextView lostIcon;
    private View view;
    LostAndFoundFragment lostAndFoundFragment = new LostAndFoundFragment();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_my, container, false);
        lostIcon = view.findViewById(R.id.lost_and_found);
        lostIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,lostAndFoundFragment);
            }
        });
        return view;
    }

}
