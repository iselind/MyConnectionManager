package iselind.myconnectionmanager;

class BluetoothKiller implements Runnable {
    @Override
    public void run() {
        BluetoothController btController = new BluetoothController();
        btController.disable();
    }
}
