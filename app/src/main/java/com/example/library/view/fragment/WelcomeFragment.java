package com.example.library.view.fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.library.R;
import com.example.library.sharedata.Map;

public class WelcomeFragment extends Fragment {
    private View view;
    private ImageView scanCode;
    private ImageView map;
    private ImageView popular;
    private ImageView newBook;
    ScanCodeFragment scanCodeFragment = new ScanCodeFragment();
    MapFragment mapFragment = new MapFragment();
    BookNewFragment bookNewFragment = new BookNewFragment();
    BookPopularFragment bookPopularFragment = new BookPopularFragment();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_welcome, container, false);
        scanCode = view.findViewById(R.id.scan_code_btn);
        scanCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,scanCodeFragment)
                        .commit();
            }
        });

        map = view.findViewById(R.id.map_btn);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,mapFragment)
                        .commit();
            }
        });

        popular = view.findViewById(R.id.popular_btn);
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,bookPopularFragment)
                        .commit();
            }
        });

        newBook = view.findViewById(R.id.new_book_btn);
        newBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,bookNewFragment)
                        .commit();
            }
        });

        return view;
    }

}
