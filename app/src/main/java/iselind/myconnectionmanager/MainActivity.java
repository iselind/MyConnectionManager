package iselind.myconnectionmanager;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConnectivityManager cm =
                (ConnectivityManager) getBaseContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            System.out.println("Cannot create ConnectivityManager");
            return;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork == null) {
            System.out.println("Cannot get active networks");
            return;
        }

        boolean isConnected = activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            System.out.print("You are connected");
        } else {
            System.out.print("You are not connected");
        }

        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;

        if (isWiFi) {
            System.out.println(" to wifi");
        } else {
            System.out.println(" to something other that wifi");
        }

        if (isWiFi && isConnected) {
            disableBluetooth();
        }

        setContentView(R.layout.activity_main);
    }

    private void disableBluetooth() {
        //Disable bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
            System.out.println("Disabled bluetooth");
        }
    }

    private void enableBluetooth() {
        //Disable bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
            System.out.println("Enabled bluetooth");
        }

        // TODO: keep enabled for about 30 minutes. If not connected, disconnect again.
    }
}
