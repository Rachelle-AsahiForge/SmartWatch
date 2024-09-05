B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=12
@EndOfDesignText@
#Region  Service Attributes 
 	#StartAtBoot: True
    #StartCommandReturnValue: android.app.Service.START_STICKY
	#ExcludeFromLibrary: True
	
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private mqtt As MqttClient
	
	
	Private mytopic As String = "SmartWatchMinoGifu"
	'Private serverURI As String = "tcp://10.0.2.2:51044" 'emulator
	'Private serverURI As String = "tcp://broker.hivemq.com:1883"
	
	Private serverURI As String = "tcp://10.3.1.80:1883"
	Dim phone As Phone
	
	Dim Vibrate As PhoneVibrate
	Private counter As Int = 0
	Dim  LastReceivedMessage As String
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	ConnectAndReconnect
End Sub

Sub Service_Start (StartingIntent As Intent)
	StartServiceAt(Null, DateTime.Now +30 * 1000, True) ' 900 seconds/60 = 15 minutes from the current second
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
	ConnectAndReconnect
	
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub


Sub ConnectAndReconnect
	
	ConnectToWifi
	'Do While working
	If mqtt.IsInitialized Then mqtt.Close
	Do While mqtt.IsInitialized
		Sleep(100)
	Loop
    
	ConnectToMQTT
	Wait For Mqtt_Connected (Success As Boolean)
	If Success Then
		Log("Mqtt connected")
		ConnectToWifi
		Private android_id As String
		android_id  = phone.GetSettings ("android_id")
		mqtt.Subscribe("SmartWatchMinoGifu/Reply/"&android_id, 0)
		'Do While  mqtt.Connected
		'mqtt.Publish2("SmartWatchMinoGifu/HB", Array As Byte(0), 1, False) 'change the ping topic as needed
		Dim str As String : str = counter
		mqtt.Publish("SmartWatchMinoGifu/"& android_id &"/HB",  str.GetBytes("UTF8")) 'change the ping topic as needed
		
		counter= counter+1
		'	Sleep(5000)
		'	Loop
		Log("Disconnected")
	Else
		Log("Error connecting.")
		ConnectToWifi
	End If
	'Sleep(5000)
End Sub

Sub ConnectToWifi
	
	Dim myWIFI_Test As ToggleWifiData
	Dim WIFIstatus As Boolean
	 
	myWIFI_Test.Initialize
	WIFIstatus=myWIFI_Test.isWIFI_enabled
	
	If WIFIstatus == True Then
		'Status.Text = "Connected"
		Return True
		
	Else
		myWIFI_Test.toggleWIFI
		
		'	Status.Text = "Wifi Error"
		Return False
		
	End If
	
End Sub

Sub ConnectToMQTT
	
	mqtt.Initialize("mqtt", serverURI, Rnd(0, 999999999) & DateTime.Now)
	Dim mo As MqttConnectOptions
	mo.Initialize("", "")
	mqtt.Connect2(mo)
	
	'Private android_id As String
	'android_id = phone.GetSettings("android_id")
'	mqtt.Subscribe("SmartWatchMinoGifu/Reply/"&android_id, 0)
	'mytopic = "drawers/" & mqtt.ClientId
	
End Sub


Private Sub mqtt_MessageArrived (Topic As String, Payload() As Byte)
	'Dim obj As Object = serializator.ConvertBytesToObject(Payload)
	
	'Dim s As String = obj
'	Log(Payload)
	Log( BytesToString(Payload, 0, Payload.Length, "utf8"))
	Private Message As String = BytesToString(Payload, 0, Payload.Length, "utf8")
		
	'Status.Text  = BytesToString(Payload, 0, Payload.Length, "utf8")
	Vibrate.Vibrate(500)
	
	
	StartActivity(Main)
	LastReceivedMessage = Message
'	Dim n As Notification
'	n.Initialize
'	n.Icon = "icon"
'	n.SetInfo(Message,"返事", Main)
'	n.Notify(1)
   
End Sub