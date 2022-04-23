package com.example.library.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.library.R;

public class NotifyFragment extends Fragment {
    private ImageView allIcon;
    private View view;
    NotifyAllFragment notifyAllFragment = new NotifyAllFragment();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_notify, container, false);
        allIcon = view.findViewById(R.id.more_btn);
        allIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,notifyAllFragment)
                        .commit();
            }
        });
        return view;
    }
}
