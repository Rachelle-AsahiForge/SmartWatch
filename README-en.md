[JP](README.md)

# Real-time Alert Messaging System

This project uses a TicWatch E3 smartwatch to create a real-time alert messaging system for factory workers and managers, sending instant notifications.

## Project Structure
- **Android Program**:  
  The Android APK can be found at:  
  `\RealtimeAlert\Objects\RealtimeAlert.apk`

## How to Install the APK

### 1. Set Up ADB (Android Debug Bridge)
- Download the Android SDK Command Line Tools:  
  [Command Line Tools](https://dl.google.com/android/repository/commandlinetools-win-9123335_latest.zip)  
  - Unzip it to a folder like `C:\Android`.
  - Ensure you agree to the SDK license by viewing the Windows command line tools license.
  - No need for Android Studio; this will not interfere with it.

### 2. Connect the TicWatch E3
- First, connect your TicWatch E3 to your company phone that’s connected to the company's network.
- Ensure the watch is connected to Wi-Fi.
- **Important**: Disconnect and forget the company phone to ensure the watch operates as a standalone app.
  
### 3. Get the Watch IP Address
- Open a command prompt and navigate to the platform-tools folder:  
  ```
  cd C:\Android\platform-tools
  ```
- Connect your PC to the watch using the following command:  
  ```
  adb connect <smart_watch_ip>:5555
  ```
  Example:  
  ```
  adb connect 10.3.50.33:5555
  ```

### 4. Install the APK
- Open a command prompt, navigate to the APK location, and install it:
  ```
  cd \RealtimeAlert\Objects\
  adb install RealtimeAlert.apk
  ```

## How to Use the App

1. Click the "アサヒフォージ" text at the top to access settings.  
   - You can see the **Android ID** on this page.
   - Configure the watch name and MQTT server settings here.
   
   ![Main Page](ReadMeFiles/Main%20Page.png)
   ![Form Page](ReadMeFiles/Form%20Page.png)

2. The app has four configurable buttons.  
   To configure them, send the desired button's name to the following MQTT topics:
   - `SmartWatchMinoGifu/button1/&android_id`
   - `SmartWatchMinoGifu/button2/&android_id`
   - `SmartWatchMinoGifu/button3/&android_id`
   - `SmartWatchMinoGifu/button4/&android_id`

3. More details on setting up MQTT can be found here:  
   [Mosquitto Broker Setup](https://randomnerdtutorials.com/how-to-install-mosquitto-broker-on-raspberry-pi/)

### Mosquitto Configuration (mosquitto.conf)
```
pid_file /run/mosquitto/mosquitto.pid
persistence true
persistence_location /var/lib/mosquitto/
log_dest file /var/log/mosquitto/mosquitto.log
include_dir /etc/mosquitto/conf.d
port 1883
listener 9001
protocol websockets
socket_domain ipv4
allow_anonymous true
```

## Program Explanation

- **Service at Boot**:  
  The program starts a service at boot so even if the app is not open, you can still receive messages.
- **Heartbeat Signal**:  
  The watch sends a heartbeat every 10 seconds to the MQTT topic:
  ```
  SmartWatchMinoGifu/&android_id/HB
  ```

### Button Functions:
- **Short Click**: Sends a "LOW" message to the MQTT topic:
  ```
  SmartWatchMinoGifu/&android_id
  ```
- **Long Click**: Sends a "HIGH" message to the same topic.

### Send Messages to the Watch:
- **Web App**:  

   ![Webアプリ](ReadMeFiles/WebApp.png)
  The web app is an essential part of the real-time alert messaging system, providing three core functionalities to manage and interact with the TicWatch E3.

1. Notifications Page (Listening to Watch Notifications) 
This page listens for and displays real-time notifications sent from the watch. It continuously monitors the MQTT topics for updates from the watch, allowing managers to stay informed about any issues or alerts.
[http://10.3.1.80/mino/page/custom/SmartWatch/Dashboard.php?Plant=%E7%BE%8E%E6%BF%83&Department=%E4%BF%9D%E5%85%A81]

How it Works:
The web app subscribes to the MQTT topic SmartWatchMinoGifu/&android_id, displaying notifications such as alerts, heartbeats, or status updates from the connected watch in real time.

2. Message Sending Page (Send Messages to the Watch)
This page allows you to send custom messages or alerts to the watch.

How to Use:
Simply select the watch from the available devices list on the page, input your message in the provided field, and click "Send".
The message is sent to the MQTT topic SmartWatchMinoGifu/Reply/&android_id for the selected watch.
3. Settings Page (Configure Watch Details)
The settings page is used to input and manage watch details, such as the Android ID, button names, and watch name.
  
- **API (via MQTT)**:  
  Send a message to the following MQTT topic:
  ```
  SmartWatchMinoGifu/Reply/&android_id
  ```
