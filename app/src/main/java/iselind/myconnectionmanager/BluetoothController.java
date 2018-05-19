package iselind.myconnectionmanager;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.util.Log;

class BluetoothController {

    private static final String SERVICE_TAG = "BluetoothController";

    private boolean isConnected() {
        int profiles[] = {BluetoothProfile.HEADSET, BluetoothProfile.A2DP, BluetoothProfile.HEALTH};
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        for (int profile : profiles) {
            int state = mBluetoothAdapter.getProfileConnectionState(profile);
            if (state == BluetoothProfile.STATE_CONNECTED) {
                return true;
            }
        }
        return false;
    }

    void disable() {
        //Disable bluetooth, unless connected
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter.isEnabled() && !isConnected()) {
            mBluetoothAdapter.disable();
            Log.i(SERVICE_TAG, "Disabled bluetooth");
        }
    }

    void enable() {
        //Disable bluetooth, unless already connected
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
            Log.i(SERVICE_TAG, "Enabled bluetooth");
        }
    }
}
