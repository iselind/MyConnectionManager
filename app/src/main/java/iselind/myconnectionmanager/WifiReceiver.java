package iselind.myconnectionmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class WifiReceiver extends BroadcastReceiver {
    BluetoothController foo;

    public WifiReceiver() {
        this.foo = new BluetoothController();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMan != null) {
            NetworkInfo netInfo = conMan.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d("WifiReceiver", "Have Wifi Connection, disabling BlueTooth");
                this.foo.disable();
            } else {
                Log.d("WifiReceiver", "Don't have Wifi Connection, enabling Bluetooth");
                this.foo.enable();
            }
        }
    }
}
