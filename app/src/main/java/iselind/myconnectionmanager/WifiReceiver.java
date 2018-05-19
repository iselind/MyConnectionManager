package iselind.myconnectionmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class WifiReceiver extends BroadcastReceiver {
    public static final String SERVICE_TAG = "WifiReceiver";

    private final BluetoothController btController;

    public WifiReceiver() {
        this.btController = new BluetoothController();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                handleConnectivityChanged(context);
            }
        }
    }

    private void handleConnectivityChanged(Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMan != null) {
            NetworkInfo netInfo = conMan.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d(SERVICE_TAG, "Have Wifi Connection, disabling BlueTooth");
                this.btController.disable();
            } else {
                Log.d(SERVICE_TAG, "Don't have Wifi Connection, enabling Bluetooth");
                this.btController.enable();
            }
        }
    }
}
