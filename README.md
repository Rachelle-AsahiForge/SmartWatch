[English](README-en.md)


# リアルタイムアラートメッセージングシステム

このプロジェクトは、TicWatch E3スマートウォッチを使用して、工場の作業員や管理者にリアルタイムで通知を送信するアラートメッセージングシステムを構築するものです。

## プロジェクト構成
- **Androidプログラム**:  
  Android APKは以下の場所にあります：  
  `\RealtimeAlert\Objects\RealtimeAlert.apk`

## APKのインストール方法

### 1. ADB（Android Debug Bridge）のセットアップ
- Android SDKのコマンドラインツールをダウンロードしてください：  
  [Command Line Tools](https://dl.google.com/android/repository/commandlinetools-win-9123335_latest.zip)  
  - これを`C:\Android`のようなフォルダに解凍します。
  - コマンドラインツールのライセンスに同意してください。
  - Android Studioは不要です。これがインストールされていても影響はありません。

### 2. TicWatch E3を接続する
- まず、TicWatch E3を会社のネットワークに接続された会社のスマホに接続します。
- ウォッチがWi-Fiに接続されていることを確認してください。
- **重要**：ウォッチがスタンドアロンアプリとして動作するために、会社のスマホとの接続を解除して「忘れる」操作を行います。

### 3. ウォッチのIPアドレスを取得する
- コマンドプロンプトを開き、`platform-tools`フォルダに移動します：  
  ```
  cd C:\Android\platform-tools
  ```
- 次のコマンドでPCをウォッチに接続します：  
  ```
  adb connect <smart_watch_ip>:5555
  ```
  例:  
  ```
  adb connect 10.3.50.33:5555
  ```

### 4. APKをインストールする
- コマンドプロンプトを開き、APKの場所に移動してインストールします：
  ```
  cd \RealtimeAlert\Objects\
  adb install RealtimeAlert.apk
  ```

## アプリの使い方

1. 画面上部の「アサヒフォージ」のテキストをクリックして設定にアクセスします。  
   - このページで**Android ID**を確認できます。
   - ウォッチ名やMQTTサーバーの設定をここで行います。
   
   ![メインページ](ReadMeFiles/Main%20Page.png)
   ![設定ページ](ReadMeFiles/Form%20Page.png)

2. アプリには4つの設定可能なボタンがあります。  
   これらのボタンを設定するには、次のMQTTトピックにボタン名を送信します：
   - `SmartWatchMinoGifu/button1/&android_id`
   - `SmartWatchMinoGifu/button2/&android_id`
   - `SmartWatchMinoGifu/button3/&android_id`
   - `SmartWatchMinoGifu/button4/&android_id`

3. MQTTのセットアップに関する詳細はこちらをご覧ください：  
   [Mosquitto Broker Setup](https://randomnerdtutorials.com/how-to-install-mosquitto-broker-on-raspberry-pi/)

### Mosquitto設定（mosquitto.conf）
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

## プログラムの説明

- **起動時のサービス**:  
  プログラムは起動時にサービスを開始し、アプリが開いていなくてもメッセージを受信できます。
- **ハートビート信号**:  
  ウォッチは10秒ごとに次のMQTTトピックにハートビートを送信します：
  ```
  SmartWatchMinoGifu/&android_id/HB
  ```

### ボタン機能：
- **短押し**: 「LOW」メッセージを次のMQTTトピックに送信します：
  ```
  SmartWatchMinoGifu/&android_id
  ```
- **長押し**: 「HIGH」メッセージを同じトピックに送信します。

### ウォッチにメッセージを送信する：
- **Webアプリ**:  

   ![Webアプリ](ReadMeFiles/WebApp.png)
  Webアプリはリアルタイムアラートメッセージングシステムの重要な部分であり、TicWatch E3を管理し、操作するための3つの主要機能を提供します。

1. **通知ページ（ウォッチ通知をリスニングする）**  
   このページは、ウォッチから送信されたリアルタイム通知を表示します。  
   常にMQTTトピックを監視し、ウォッチからの更新を受け取ることで、管理者は問題やアラートについて常に把握できます。

   [http://10.3.1.80/mino/page/custom/SmartWatch/Dashboard.php?Plant=%E7%BE%8E%E6%BF%83&Department=%E4%BF%9D%E5%85%A81]

2. **メッセージ送信ページ（ウォッチにメッセージを送信する）**  
   このページでは、カスタムメッセージやアラートをウォッチに送信できます。

   **使い方**:  
   ページ上のデバイスリストからウォッチを選択し、メッセージを入力して「送信」ボタンをクリックします。  
   メッセージは選択されたウォッチのMQTTトピックに送信されます：
   ```
   SmartWatchMinoGifu/Reply/&android_id
   ```

3. **設定ページ（ウォッチの詳細を設定する）**  
   このページでは、Android ID、ボタンの情報、ウォッチ名などの詳細を入力し、管理できます。

- **API (via MQTT)**:  
  メッセージを次のMQTTトピックに送信します：
  ```
  SmartWatchMinoGifu/Reply/&android_id
  ```
