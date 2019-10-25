package com.example.infs3634assignment2.ui;

import android.os.Bundle;
import android.os.strictmode.UnbufferedIoViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634assignment2.Model.FoodAPI;
import com.example.infs3634assignment2.R;
import com.example.infs3634assignment2.adapter.MyMenuItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MenuFragment extends Fragment {

    private MenuViewModel menuViewModel;

    Unbinder unbinder;
    @BindView(R.id.recylcer_menu)
    RecyclerView recycler_menu;
    MyMenuItemAdapter adapter;

    Gson gson = new Gson();

    String jsonString = FoodAPI.getMostViewedStoriesJsonString();

        adapter.setData(topStoriesResponse.results);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        menuViewModel =
                ViewModelProviders.of(this).get(MenuViewModel.class);
        View root = inflater,inflate(R.layout.fragment_menu,container, false);

        unbinder = ButterKnife.bind(this, root);

        final TextView textView = root.findViewByID(R.id.txt_mean_item);
        menuViewModel.getText().observe(this, new Observer<String>(){
            public void onChanged(@NonNull String s) (textView.setText(s);)
        });
        return root;
    }



}
