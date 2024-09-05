package asahi.alert;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class autoboot extends  android.app.Service{
	public static class autoboot_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (autoboot) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, autoboot.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, BA.class);
		}

	}
    static autoboot mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return autoboot.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "asahi.alert", "asahi.alert.autoboot");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "asahi.alert.autoboot", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (autoboot) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (autoboot) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (autoboot) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (autoboot) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (autoboot) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.MqttAsyncClientWrapper _mqtt = null;
public static String _mytopic = "";
public static String _serveruri = "";
public static anywheresoftware.b4a.phone.Phone _phone = null;
public static anywheresoftware.b4a.phone.Phone.PhoneVibrate _vibrate = null;
public static int _counter = 0;
public static String _lastreceivedmessage = "";
public b4a.example.dateutils _dateutils = null;
public asahi.alert.main _main = null;
public asahi.alert.starter _starter = null;
public asahi.alert.form _form = null;
public asahi.alert.xuiviewsutils _xuiviewsutils = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 45;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return false;
}
public static void  _connectandreconnect() throws Exception{
ResumableSub_ConnectAndReconnect rsub = new ResumableSub_ConnectAndReconnect(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_ConnectAndReconnect extends BA.ResumableSub {
public ResumableSub_ConnectAndReconnect(asahi.alert.autoboot parent) {
this.parent = parent;
}
asahi.alert.autoboot parent;
boolean _success = false;
String _android_id = "";
String _str = "";

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 55;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 57;BA.debugLine="If mqtt.IsInitialized Then mqtt.Close";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._mqtt.IsInitialized()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent._mqtt.Close();
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 58;BA.debugLine="Do While mqtt.IsInitialized";
if (true) break;

case 7:
//do while
this.state = 10;
while (parent._mqtt.IsInitialized()) {
this.state = 9;
if (true) break;
}
if (true) break;

case 9:
//C
this.state = 7;
 //BA.debugLineNum = 59;BA.debugLine="Sleep(100)";
anywheresoftware.b4a.keywords.Common.Sleep(processBA,this,(int) (100));
this.state = 17;
return;
case 17:
//C
this.state = 7;
;
 if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 62;BA.debugLine="ConnectToMQTT";
_connecttomqtt();
 //BA.debugLineNum = 63;BA.debugLine="Wait For Mqtt_Connected (Success As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("mqtt_connected", processBA, this, null);
this.state = 18;
return;
case 18:
//C
this.state = 11;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 64;BA.debugLine="If Success Then";
if (true) break;

case 11:
//if
this.state = 16;
if (_success) { 
this.state = 13;
}else {
this.state = 15;
}if (true) break;

case 13:
//C
this.state = 16;
 //BA.debugLineNum = 65;BA.debugLine="Log(\"Mqtt connected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("12359308","Mqtt connected",0);
 //BA.debugLineNum = 66;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 67;BA.debugLine="Private android_id As String";
_android_id = "";
 //BA.debugLineNum = 68;BA.debugLine="android_id  = phone.GetSettings (\"android_id\")";
_android_id = parent._phone.GetSettings("android_id");
 //BA.debugLineNum = 69;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/Reply/\"&andro";
parent._mqtt.Subscribe("SmartWatchMinoGifu/Reply/"+_android_id,(int) (0));
 //BA.debugLineNum = 72;BA.debugLine="Dim str As String : str = counter";
_str = "";
 //BA.debugLineNum = 72;BA.debugLine="Dim str As String : str = counter";
_str = BA.NumberToString(parent._counter);
 //BA.debugLineNum = 73;BA.debugLine="mqtt.Publish(\"SmartWatchMinoGifu/\"& android_id &";
parent._mqtt.Publish("SmartWatchMinoGifu/"+_android_id+"/HB",_str.getBytes("UTF8"));
 //BA.debugLineNum = 75;BA.debugLine="counter= counter+1";
parent._counter = (int) (parent._counter+1);
 //BA.debugLineNum = 78;BA.debugLine="Log(\"Disconnected\")";
anywheresoftware.b4a.keywords.Common.LogImpl("12359321","Disconnected",0);
 if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 80;BA.debugLine="Log(\"Error connecting.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("12359323","Error connecting.",0);
 //BA.debugLineNum = 81;BA.debugLine="ConnectToWifi";
_connecttowifi();
 if (true) break;

case 16:
//C
this.state = -1;
;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _mqtt_connected(boolean _success) throws Exception{
}
public static String  _connecttomqtt() throws Exception{
anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper _mo = null;
 //BA.debugLineNum = 108;BA.debugLine="Sub ConnectToMQTT";
 //BA.debugLineNum = 110;BA.debugLine="mqtt.Initialize(\"mqtt\", serverURI, Rnd(0, 9999999";
_mqtt.Initialize(processBA,"mqtt",_serveruri,BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (999999999)))+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 111;BA.debugLine="Dim mo As MqttConnectOptions";
_mo = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper();
 //BA.debugLineNum = 112;BA.debugLine="mo.Initialize(\"\", \"\")";
_mo.Initialize("","");
 //BA.debugLineNum = 113;BA.debugLine="mqtt.Connect2(mo)";
_mqtt.Connect2((org.eclipse.paho.client.mqttv3.MqttConnectOptions)(_mo.getObject()));
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _connecttowifi() throws Exception{
tillekesoft.b4a.ToggleWifiData.ToggleWifiData _mywifi_test = null;
boolean _wifistatus = false;
 //BA.debugLineNum = 86;BA.debugLine="Sub ConnectToWifi";
 //BA.debugLineNum = 88;BA.debugLine="Dim myWIFI_Test As ToggleWifiData";
_mywifi_test = new tillekesoft.b4a.ToggleWifiData.ToggleWifiData();
 //BA.debugLineNum = 89;BA.debugLine="Dim WIFIstatus As Boolean";
_wifistatus = false;
 //BA.debugLineNum = 91;BA.debugLine="myWIFI_Test.Initialize";
_mywifi_test.Initialize(processBA);
 //BA.debugLineNum = 92;BA.debugLine="WIFIstatus=myWIFI_Test.isWIFI_enabled";
_wifistatus = _mywifi_test.isWIFI_enabled();
 //BA.debugLineNum = 94;BA.debugLine="If WIFIstatus == True Then";
if (_wifistatus==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 96;BA.debugLine="Return True";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 99;BA.debugLine="myWIFI_Test.toggleWIFI";
_mywifi_test.toggleWIFI();
 //BA.debugLineNum = 102;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_messagearrived(String _topic,byte[] _payload) throws Exception{
String _message = "";
 //BA.debugLineNum = 123;BA.debugLine="Private Sub mqtt_MessageArrived (Topic As String,";
 //BA.debugLineNum = 128;BA.debugLine="Log( BytesToString(Payload, 0, Payload.Length, \"u";
anywheresoftware.b4a.keywords.Common.LogImpl("12555909",anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"utf8"),0);
 //BA.debugLineNum = 129;BA.debugLine="Private Message As String = BytesToString(Payload";
_message = anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"utf8");
 //BA.debugLineNum = 132;BA.debugLine="Vibrate.Vibrate(500)";
_vibrate.Vibrate(processBA,(long) (500));
 //BA.debugLineNum = 135;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 136;BA.debugLine="LastReceivedMessage = Message";
_lastreceivedmessage = _message;
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private mqtt As MqttClient";
_mqtt = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private mytopic As String = \"SmartWatchMinoGifu\"";
_mytopic = "SmartWatchMinoGifu";
 //BA.debugLineNum = 18;BA.debugLine="Private serverURI As String = \"tcp://10.3.1.80:18";
_serveruri = "tcp://10.3.1.80:1883";
 //BA.debugLineNum = 19;BA.debugLine="Dim phone As Phone";
_phone = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 21;BA.debugLine="Dim Vibrate As PhoneVibrate";
_vibrate = new anywheresoftware.b4a.phone.Phone.PhoneVibrate();
 //BA.debugLineNum = 22;BA.debugLine="Private counter As Int = 0";
_counter = (int) (0);
 //BA.debugLineNum = 23;BA.debugLine="Dim  LastReceivedMessage As String";
_lastreceivedmessage = "";
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 29;BA.debugLine="ConnectAndReconnect";
_connectandreconnect();
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 33;BA.debugLine="StartServiceAt(Null, DateTime.Now +30 * 1000, Tru";
anywheresoftware.b4a.keywords.Common.StartServiceAt(processBA,anywheresoftware.b4a.keywords.Common.Null,(long) (anywheresoftware.b4a.keywords.Common.DateTime.getNow()+30*1000),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 34;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 35;BA.debugLine="ConnectAndReconnect";
_connectandreconnect();
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
}
