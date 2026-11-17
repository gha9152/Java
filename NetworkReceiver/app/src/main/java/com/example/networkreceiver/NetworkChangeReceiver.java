package com.example.networkreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkChangeReceiver extends BroadcastReceiver {

    public interface NetworkListener {
        void onNetworkChange(boolean isConnected, String networkType);
    }

    NetworkListener listener;

    public NetworkChangeReceiver() {
    }

    public NetworkChangeReceiver(NetworkListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
            String networkType = "نامشخص";

            if (isConnected) {
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    networkType = "وای‌فای (Wi-Fi)";
                } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    networkType = "داده همراه (Mobile Data)";
                }
            }

            if (listener != null) {
                listener.onNetworkChange(isConnected, networkType);
            }
        }
    }
}
