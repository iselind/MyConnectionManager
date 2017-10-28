package iselind.myconnectionmanager;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

public class BluetoothController {
    public void disable() {
        //Disable bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
            Log.i("BluetoothController", "Disabled bluetooth");
        }
    }

    public void enable() {
        //Disable bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
            Log.i("BluetoothController", "Enabled bluetooth");
        }

        // TODO: keep enabled for about 30 minutes. If not connected, disconnect again.
    }
}
