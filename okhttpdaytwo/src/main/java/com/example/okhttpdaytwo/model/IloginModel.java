package com.example.okhttpdaytwo.model;

import com.example.okhttpdaytwo.net.RequestCallback;

import java.util.HashMap;

public interface IloginModel {
   void login(HashMap<String,String>params,RequestCallback requestcallback);
}
