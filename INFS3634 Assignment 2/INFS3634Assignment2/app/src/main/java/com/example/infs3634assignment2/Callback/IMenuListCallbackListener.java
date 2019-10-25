package com.example.infs3634assignment2.Callback;

import com.example.infs3634assignment2.Model.MenuListModel;

import java.util.List;

public interface IMenuListCallbackListener {
    void onMenuListLoadSuccess(List<MenuListModel> menuListModelList);
    void onMenuListLoadFailed(String message);
}