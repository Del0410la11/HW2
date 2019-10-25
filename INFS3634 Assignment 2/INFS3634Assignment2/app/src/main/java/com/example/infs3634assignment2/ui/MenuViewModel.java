package com.example.infs3634assignment2.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.infs3634assignment2.Callback.IMenuListCallbackListener;
import com.example.infs3634assignment2.Common.Common;
import com.example.infs3634assignment2.Model.MenuListModel;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MenuViewModel extends ViewModel implements IMenuListCallbackListener {
    
    private MutableLiveData<List<MenuListModel>> menuListMultable;
    private MutableLiveData<String> messageError;
    private IMenuListCallbackListener menuListCallbackListener;

    public MenuViewModel() {
        menuListCallbackListener = this;

    }

    public MutableLiveData<List<MenuListModel>> getMenuListMultable() {
       if(menuListMultable == null)
       {
           menuListMultable = new MutableLiveData<>();
           messageError = new MutableLiveData<>();
           loadMenuLists();

       }
       return menuListMultable;
    }

    private void loadMenuLists() {
        final List<MenuListModel> tempList = new ArrayList<>();
        DatabaseReference menuRef = FirebaseDatabase.getInstance().getReference(Common.MENU_REF);
        menuRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapShot:dataSnapshot.getChildren())
                {
                    MenuListModel menuListModel = dataSnapshot.getValue(MenuListModel.class);
                    menuListModel.setMenu_id(dataSnapshot.getKey());
                    tempList.add(menuListModel);
                }
                menuListCallbackListener.onMenuListLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                menuListCallbackListener.onMenuListLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onMenuListLoadSuccess(List<MenuListModel> menuListModelList) {
        menuListMultable.setValue(menuListModelList);
    }

    @Override
    public void onMenuListLoadFailed(String message) {
        messageError.setValue(message);

    }
}
