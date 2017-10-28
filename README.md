MyConnectivityManager
=====================

This is an Android application/service where the Bluetooth state is controlled by the Wifi state changes.

Wifi state `[ ON -> OFF ]`: Enable Bluetooth

Wifi state `[ OFF -> ON ]`: Disable Bluetooth

Bluetooth with be disabled after 10 minutes from the point where the Wifi state went from `ON` to `OFF` unless a device is connected after those 10 minutes.
