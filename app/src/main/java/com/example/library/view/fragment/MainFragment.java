package com.example.library.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.library.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainFragment extends Fragment {
    public BottomNavigationView navigationView;
    private FragmentTransaction childTransaction;
    private FragmentManager childManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main_navigation, container, false);
        navigationView = view.findViewById(R.id.bottom_navigation);
        init();
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    private void init(){
        childManager = getChildFragmentManager();
        childTransaction = childManager.beginTransaction();
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content_fragment, new WelcomeFragment(), "welcome")
                .commit();
        childTransaction.commit();
        navigationView.setOnItemReselectedListener(item -> {
            switch(item.getItemId()){
                case R.id.welcome: {
                    if(navigationView.getSelectedItemId() != R.id.welcome){
                        childTransaction = getChildFragmentManager().beginTransaction();
                        hideFragment(navigationView.getSelectedItemId());
                        childTransaction.show(Objects.requireNonNull(childManager.findFragmentByTag("welcome")));
                        childTransaction.commit();
                    }
                    break;
                }
                case R.id.time:{
                    if(navigationView.getSelectedItemId() != R.id.time){
                        childTransaction = getChildFragmentManager().beginTransaction();
                        hideFragment(navigationView.getSelectedItemId());
                        if(getChildFragmentManager().findFragmentByTag("time") == null){
                            TimeFragment fragment = new TimeFragment();
                            childTransaction.add(R.id.main_content_fragment, fragment, "time");
                            childTransaction.show(fragment);
                        }else{
                            childTransaction.show(Objects.requireNonNull(childManager.findFragmentByTag("time")));
                        }
                        childTransaction.commit();
                    }
                    break;
                }
                case R.id.notify:{
                    if(navigationView.getSelectedItemId() != R.id.notify){
                        childTransaction = getChildFragmentManager().beginTransaction();
                        hideFragment(navigationView.getSelectedItemId());
                        if(getChildFragmentManager().findFragmentByTag("notify") == null){
                            NotifyFragment fragment = new NotifyFragment();
                            childTransaction.add(R.id.main_content_fragment, fragment, "notify");
                            childTransaction.show(fragment);
                        }else{
                            childTransaction.show(Objects.requireNonNull(childManager.findFragmentByTag("notify")));
                        }
                        childTransaction.commit();
                    }
                    break;
                }
                case R.id.my:{
                    if(navigationView.getSelectedItemId() != R.id.my){
                        childTransaction = getChildFragmentManager().beginTransaction();
                        hideFragment(navigationView.getSelectedItemId());
                        if(getChildFragmentManager().findFragmentByTag("my") == null){
                            MyFragment fragment = new MyFragment();
                            childTransaction.add(R.id.main_content_fragment, fragment, "my");
                            childTransaction.show(fragment);
                        }else{
                            childTransaction.show(Objects.requireNonNull(childManager.findFragmentByTag("my")));
                        }
                        childTransaction.commit();
                    }
                    break;
                }
                default:
                    break;
            }
            return;
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void hideFragment(int selectedID){
        switch (selectedID){
            case R.id.welcome:{
                if(childManager.findFragmentByTag("welcome") != null)
                    childTransaction.hide(Objects.requireNonNull(childManager.findFragmentByTag("welcome")));
                break;
            }
            case R.id.time:{
                if(childManager.findFragmentByTag("time") != null){
                    childTransaction.hide(Objects.requireNonNull(childManager.findFragmentByTag("time")));
                }
                break;
            }
            case R.id.notify:{
                if(childManager.findFragmentByTag("notify") != null){
                    childTransaction.hide(Objects.requireNonNull(childManager.findFragmentByTag("notify")));
                }
                break;
            }
            case R.id.my:{
                if(childManager.findFragmentByTag("my") != null){
                    childTransaction.hide(Objects.requireNonNull(childManager.findFragmentByTag("my")));
                }
                break;
            }
            default:
                break;
        }
    }

}
