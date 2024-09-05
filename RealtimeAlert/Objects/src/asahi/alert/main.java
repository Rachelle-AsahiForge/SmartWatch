package asahi.alert;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "asahi.alert", "asahi.alert.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "asahi.alert", "asahi.alert.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "asahi.alert.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static anywheresoftware.b4j.objects.MqttAsyncClientWrapper _mqtt = null;
public static anywheresoftware.b4a.randomaccessfile.B4XSerializator _serializator = null;
public static String _mytopic = "";
public static String _serveruri = "";
public static anywheresoftware.b4a.phone.Phone _phone = null;
public static anywheresoftware.b4a.phone.Phone.PhoneVibrate _vibrate = null;
public static String _android_id = "";
public static String _android_name = "";
public static com.AB.ABWifi.ABWifi _wifi = null;
public static b4a.example3.keyvaluestore _kvs = null;
public static anywheresoftware.b4a.sql.SQL _sql = null;
public static String _dbfilename = "";
public static String _dbfilepath = "";
public anywheresoftware.b4a.objects.LabelWrapper _status = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button4 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button3 = null;
public static String _button1_text = "";
public static String _button2_text = "";
public static String _button4_text = "";
public static String _button3_text = "";
public anywheresoftware.b4a.objects.EditTextWrapper _editname = null;
public anywheresoftware.b4a.objects.EditTextWrapper _editserver = null;
public anywheresoftware.b4a.objects.LabelWrapper _androidid = null;
public b4a.example.dateutils _dateutils = null;
public asahi.alert.starter _starter = null;
public asahi.alert.autoboot _autoboot = null;
public asahi.alert.form _form = null;
public asahi.alert.xuiviewsutils _xuiviewsutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (form.mostCurrent != null);
return vis;}
public static class _circledata{
public boolean IsInitialized;
public double x;
public double y;
public int clr;
public void Initialize() {
IsInitialized = true;
x = 0;
y = 0;
clr = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.collections.List _result = null;
 //BA.debugLineNum = 63;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 64;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 65;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 67;BA.debugLine="kvs.Initialize(File.DirInternal, \"datastore.db\"";
_kvs._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"datastore.db");
 //BA.debugLineNum = 68;BA.debugLine="Dim result As List = kvs.ListKeys";
_result = new anywheresoftware.b4a.objects.collections.List();
_result = _kvs._listkeys();
 //BA.debugLineNum = 69;BA.debugLine="If  result.IndexOf(\"button1\") <= -1 Then";
if (_result.IndexOf((Object)("button1"))<=-1) { 
 //BA.debugLineNum = 70;BA.debugLine="kvs.Put(\"button1\",\"保全\")";
_kvs._put("button1",(Object)("保全"));
 }else if(_result.IndexOf((Object)("button2"))<=-1) { 
 //BA.debugLineNum = 72;BA.debugLine="kvs.Put(\"button2\",\"生産\")";
_kvs._put("button2",(Object)("生産"));
 }else if(_result.IndexOf((Object)("button3"))<=-1) { 
 //BA.debugLineNum = 75;BA.debugLine="kvs.Put(\"button3\",\"品質\")";
_kvs._put("button3",(Object)("品質"));
 }else if(_result.IndexOf((Object)("button4"))<=-1) { 
 //BA.debugLineNum = 78;BA.debugLine="kvs.Put(\"button4\",\"鍛造\")";
_kvs._put("button4",(Object)("鍛造"));
 }else if(_result.IndexOf((Object)("SERVER"))<=-1) { 
 //BA.debugLineNum = 82;BA.debugLine="kvs.Put(\"SERVER\",\"tcp://10.3.1.80:1883\")";
_kvs._put("SERVER",(Object)("tcp://10.3.1.80:1883"));
 }else if(_result.IndexOf((Object)("NAME"))<=-1) { 
 //BA.debugLineNum = 85;BA.debugLine="kvs.Put(\"NAME\",phone.GetSettings (\"android_id\")";
_kvs._put("NAME",(Object)(_phone.GetSettings("android_id")));
 };
 //BA.debugLineNum = 89;BA.debugLine="Log(\"list \"&kvs.ListKeys)";
anywheresoftware.b4a.keywords.Common.LogImpl("1131098","list "+BA.ObjectToString(_kvs._listkeys()),0);
 //BA.debugLineNum = 91;BA.debugLine="Log(\"Database opened.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("1131100","Database opened.",0);
 };
 //BA.debugLineNum = 99;BA.debugLine="Button1_text=	kvs.Get(\"button1\")";
mostCurrent._button1_text = BA.ObjectToString(_kvs._get("button1"));
 //BA.debugLineNum = 100;BA.debugLine="Button2_text=	kvs.Get(\"button2\")";
mostCurrent._button2_text = BA.ObjectToString(_kvs._get("button2"));
 //BA.debugLineNum = 101;BA.debugLine="Button3_text=	kvs.Get(\"button3\")";
mostCurrent._button3_text = BA.ObjectToString(_kvs._get("button3"));
 //BA.debugLineNum = 102;BA.debugLine="Button4_text=	kvs.Get(\"button4\")";
mostCurrent._button4_text = BA.ObjectToString(_kvs._get("button4"));
 //BA.debugLineNum = 103;BA.debugLine="android_name = kvs.Get(\"NAME\")";
_android_name = BA.ObjectToString(_kvs._get("NAME"));
 //BA.debugLineNum = 104;BA.debugLine="serverURI = kvs.Get(\"SERVER\")";
_serveruri = BA.ObjectToString(_kvs._get("SERVER"));
 //BA.debugLineNum = 105;BA.debugLine="If serverURI == Null Then";
if (_serveruri== null) { 
 //BA.debugLineNum = 106;BA.debugLine="serverURI =  \"tcp://10.3.1.80:1883\"";
_serveruri = "tcp://10.3.1.80:1883";
 };
 //BA.debugLineNum = 108;BA.debugLine="Log(\"serverURI\"&serverURI)";
anywheresoftware.b4a.keywords.Common.LogImpl("1131117","serverURI"+_serveruri,0);
 //BA.debugLineNum = 109;BA.debugLine="serverURI =  \"tcp://10.3.1.80:1883\"";
_serveruri = "tcp://10.3.1.80:1883";
 //BA.debugLineNum = 111;BA.debugLine="Button1.Text = Button1_text";
mostCurrent._button1.setText(BA.ObjectToCharSequence(mostCurrent._button1_text));
 //BA.debugLineNum = 112;BA.debugLine="Button2.Text = Button2_text";
mostCurrent._button2.setText(BA.ObjectToCharSequence(mostCurrent._button2_text));
 //BA.debugLineNum = 113;BA.debugLine="Button3.Text = Button3_text";
mostCurrent._button3.setText(BA.ObjectToCharSequence(mostCurrent._button3_text));
 //BA.debugLineNum = 114;BA.debugLine="Button4.Text = Button4_text";
mostCurrent._button4.setText(BA.ObjectToCharSequence(mostCurrent._button4_text));
 //BA.debugLineNum = 115;BA.debugLine="Log(\"Button1_text\"&Button1_text)";
anywheresoftware.b4a.keywords.Common.LogImpl("1131124","Button1_text"+mostCurrent._button1_text,0);
 //BA.debugLineNum = 120;BA.debugLine="android_id  = phone.GetSettings (\"android_id\")";
_android_id = _phone.GetSettings("android_id");
 //BA.debugLineNum = 121;BA.debugLine="Log(android_id)";
anywheresoftware.b4a.keywords.Common.LogImpl("1131130",_android_id,0);
 //BA.debugLineNum = 122;BA.debugLine="wifi.Initialize(\"wifi\")";
_wifi.Initialize(processBA,"wifi");
 //BA.debugLineNum = 123;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 124;BA.debugLine="ConnectToMQTT";
_connecttomqtt();
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 132;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 133;BA.debugLine="Status.Text = Starter.LastReceivedMessage";
mostCurrent._status.setText(BA.ObjectToCharSequence(mostCurrent._starter._lastreceivedmessage /*String*/ ));
 //BA.debugLineNum = 134;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 135;BA.debugLine="ConnectToMQTT";
_connecttomqtt();
 //BA.debugLineNum = 136;BA.debugLine="Button1_text=	kvs.Get(\"button1\")";
mostCurrent._button1_text = BA.ObjectToString(_kvs._get("button1"));
 //BA.debugLineNum = 137;BA.debugLine="Button2_text=	kvs.Get(\"button2\")";
mostCurrent._button2_text = BA.ObjectToString(_kvs._get("button2"));
 //BA.debugLineNum = 138;BA.debugLine="Button3_text=	kvs.Get(\"button3\")";
mostCurrent._button3_text = BA.ObjectToString(_kvs._get("button3"));
 //BA.debugLineNum = 139;BA.debugLine="Button4_text=	kvs.Get(\"button4\")";
mostCurrent._button4_text = BA.ObjectToString(_kvs._get("button4"));
 //BA.debugLineNum = 141;BA.debugLine="Button1.Text = Button1_text";
mostCurrent._button1.setText(BA.ObjectToCharSequence(mostCurrent._button1_text));
 //BA.debugLineNum = 142;BA.debugLine="Button2.Text = Button2_text";
mostCurrent._button2.setText(BA.ObjectToCharSequence(mostCurrent._button2_text));
 //BA.debugLineNum = 143;BA.debugLine="Button3.Text = Button3_text";
mostCurrent._button3.setText(BA.ObjectToCharSequence(mostCurrent._button3_text));
 //BA.debugLineNum = 144;BA.debugLine="Button4.Text = Button4_text";
mostCurrent._button4.setText(BA.ObjectToCharSequence(mostCurrent._button4_text));
 //BA.debugLineNum = 145;BA.debugLine="Log(\"Button1_text\"&Button1_text)";
anywheresoftware.b4a.keywords.Common.LogImpl("1196623","Button1_text"+mostCurrent._button1_text,0);
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public static String  _backlabel_click() throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Private Sub BackLabel_Click";
 //BA.debugLineNum = 377;BA.debugLine="RemoveAllViews";
_removeallviews();
 //BA.debugLineNum = 378;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 283;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 285;BA.debugLine="SendAMessage(Button1.Text,android_name &\": LOW\",\"";
_sendamessage(mostCurrent._button1.getText(),_android_name+": LOW","Button1");
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return "";
}
public static String  _button1_longclick() throws Exception{
 //BA.debugLineNum = 287;BA.debugLine="Private Sub Button1_LongClick";
 //BA.debugLineNum = 288;BA.debugLine="SendAMessage(Button1.Text,android_name &\":HIGH\",\"";
_sendamessage(mostCurrent._button1.getText(),_android_name+":HIGH","Button1");
 //BA.debugLineNum = 290;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
 //BA.debugLineNum = 292;BA.debugLine="Private Sub Button2_Click";
 //BA.debugLineNum = 293;BA.debugLine="SendAMessage(Button2.Text,android_name &\":LOW\",\"B";
_sendamessage(mostCurrent._button2.getText(),_android_name+":LOW","Button2");
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
return "";
}
public static String  _button2_longclick() throws Exception{
 //BA.debugLineNum = 295;BA.debugLine="Private Sub Button2_LongClick";
 //BA.debugLineNum = 297;BA.debugLine="SendAMessage(Button2.Text,android_name &\":HIGH\",\"";
_sendamessage(mostCurrent._button2.getText(),_android_name+":HIGH","Button2");
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Private Sub Button3_Click";
 //BA.debugLineNum = 303;BA.debugLine="SendAMessage(Button3.Text,android_name &\":LOW\",\"B";
_sendamessage(mostCurrent._button3.getText(),_android_name+":LOW","Button3");
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public static String  _button3_longclick() throws Exception{
 //BA.debugLineNum = 306;BA.debugLine="Private Sub Button3_LongClick";
 //BA.debugLineNum = 308;BA.debugLine="SendAMessage(Button3.Text,android_name &\":HIGH\",\"";
_sendamessage(mostCurrent._button3.getText(),_android_name+":HIGH","Button3");
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
 //BA.debugLineNum = 312;BA.debugLine="Private Sub Button4_Click";
 //BA.debugLineNum = 314;BA.debugLine="SendAMessage(Button4.Text,android_name &\":LOW\",\"B";
_sendamessage(mostCurrent._button4.getText(),_android_name+":LOW","Button4");
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public static String  _button4_longclick() throws Exception{
 //BA.debugLineNum = 317;BA.debugLine="Private Sub Button4_LongClick";
 //BA.debugLineNum = 318;BA.debugLine="SendAMessage(Button4.Text,android_name &\":HIGH\",\"";
_sendamessage(mostCurrent._button4.getText(),_android_name+":HIGH","Button4");
 //BA.debugLineNum = 320;BA.debugLine="End Sub";
return "";
}
public static String  _connecttomqtt() throws Exception{
anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper _mo = null;
 //BA.debugLineNum = 181;BA.debugLine="Sub ConnectToMQTT";
 //BA.debugLineNum = 183;BA.debugLine="mqtt.Initialize(\"mqtt\", serverURI, Rnd(0, 9999999";
_mqtt.Initialize(processBA,"mqtt",_serveruri,BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (999999999)))+BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
 //BA.debugLineNum = 184;BA.debugLine="Dim mo As MqttConnectOptions";
_mo = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper.MqttConnectOptionsWrapper();
 //BA.debugLineNum = 185;BA.debugLine="mo.Initialize(\"\", \"\")";
_mo.Initialize("","");
 //BA.debugLineNum = 186;BA.debugLine="mqtt.Connect2(mo)";
_mqtt.Connect2((org.eclipse.paho.client.mqttv3.MqttConnectOptions)(_mo.getObject()));
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _connecttowifi() throws Exception{
tillekesoft.b4a.ToggleWifiData.ToggleWifiData _mywifi_test = null;
boolean _wifistatus = false;
 //BA.debugLineNum = 158;BA.debugLine="Sub ConnectToWifi";
 //BA.debugLineNum = 160;BA.debugLine="Dim myWIFI_Test As ToggleWifiData";
_mywifi_test = new tillekesoft.b4a.ToggleWifiData.ToggleWifiData();
 //BA.debugLineNum = 161;BA.debugLine="Dim WIFIstatus As Boolean";
_wifistatus = false;
 //BA.debugLineNum = 163;BA.debugLine="myWIFI_Test.Initialize";
_mywifi_test.Initialize(processBA);
 //BA.debugLineNum = 164;BA.debugLine="WIFIstatus=myWIFI_Test.isWIFI_enabled";
_wifistatus = _mywifi_test.isWIFI_enabled();
 //BA.debugLineNum = 167;BA.debugLine="If WIFIstatus == True Then";
if (_wifistatus==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 169;BA.debugLine="Return True";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 172;BA.debugLine="myWIFI_Test.toggleWIFI";
_mywifi_test.toggleWIFI();
 //BA.debugLineNum = 174;BA.debugLine="Status.Text = \"Wifi Error\"";
mostCurrent._status.setText(BA.ObjectToCharSequence("Wifi Error"));
 //BA.debugLineNum = 175;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 45;BA.debugLine="Private Status As Label";
mostCurrent._status = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private Button1 As Button";
mostCurrent._button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private Button2 As Button";
mostCurrent._button2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private Button4 As Button";
mostCurrent._button4 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private Button3 As Button";
mostCurrent._button3 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private Button1_text As String";
mostCurrent._button1_text = "";
 //BA.debugLineNum = 54;BA.debugLine="Private Button2_text As String";
mostCurrent._button2_text = "";
 //BA.debugLineNum = 55;BA.debugLine="Private Button4_text As String";
mostCurrent._button4_text = "";
 //BA.debugLineNum = 56;BA.debugLine="Private Button3_text As String";
mostCurrent._button3_text = "";
 //BA.debugLineNum = 58;BA.debugLine="Private EditName As EditText";
mostCurrent._editname = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private EditServer As EditText";
mostCurrent._editserver = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private AndroidID As Label";
mostCurrent._androidid = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _label1_click() throws Exception{
 //BA.debugLineNum = 330;BA.debugLine="Private Sub Label1_Click";
 //BA.debugLineNum = 331;BA.debugLine="RemoveAllViews";
_removeallviews();
 //BA.debugLineNum = 332;BA.debugLine="Activity.LoadLayout(\"Form\")";
mostCurrent._activity.LoadLayout("Form",mostCurrent.activityBA);
 //BA.debugLineNum = 333;BA.debugLine="AndroidID.Tag = \"ID:\"&android_id";
mostCurrent._androidid.setTag((Object)("ID:"+_android_id));
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_connected(boolean _success) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Sub mqtt_Connected (Success As Boolean)";
 //BA.debugLineNum = 195;BA.debugLine="If Success = False Then";
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 196;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("1458754",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 //BA.debugLineNum = 198;BA.debugLine="Status.Text = \"MQTT Error\"";
mostCurrent._status.setText(BA.ObjectToCharSequence("MQTT Error"));
 }else {
 //BA.debugLineNum = 203;BA.debugLine="android_id  = phone.GetSettings (\"android_id\")";
_android_id = _phone.GetSettings("android_id");
 //BA.debugLineNum = 204;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/Reply/\"&andro";
_mqtt.Subscribe("SmartWatchMinoGifu/Reply/"+_android_id,(int) (0));
 //BA.debugLineNum = 206;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/button1/\"&and";
_mqtt.Subscribe("SmartWatchMinoGifu/button1/"+_android_id,(int) (0));
 //BA.debugLineNum = 207;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/button2/\"&and";
_mqtt.Subscribe("SmartWatchMinoGifu/button2/"+_android_id,(int) (0));
 //BA.debugLineNum = 208;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/button3/\"&and";
_mqtt.Subscribe("SmartWatchMinoGifu/button3/"+_android_id,(int) (0));
 //BA.debugLineNum = 209;BA.debugLine="mqtt.Subscribe(\"SmartWatchMinoGifu/button4/\"&and";
_mqtt.Subscribe("SmartWatchMinoGifu/button4/"+_android_id,(int) (0));
 };
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_disconnected() throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Private Sub mqtt_Disconnected";
 //BA.debugLineNum = 214;BA.debugLine="Status.Text = \"MQTT Error\"";
mostCurrent._status.setText(BA.ObjectToCharSequence("MQTT Error"));
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_messagearrived(String _topic,byte[] _payload) throws Exception{
String _message = "";
String[] _topic_type = null;
String _topic_purpose = "";
anywheresoftware.b4a.objects.NotificationWrapper _n = null;
 //BA.debugLineNum = 217;BA.debugLine="Private Sub mqtt_MessageArrived (Topic As String,";
 //BA.debugLineNum = 218;BA.debugLine="Private Message As String = BytesToString(Payload";
_message = anywheresoftware.b4a.keywords.Common.BytesToString(_payload,(int) (0),_payload.length,"utf8");
 //BA.debugLineNum = 219;BA.debugLine="Log( \"Message\"&Message)";
anywheresoftware.b4a.keywords.Common.LogImpl("1589826","Message"+_message,0);
 //BA.debugLineNum = 221;BA.debugLine="Dim Topic_Type() As String";
_topic_type = new String[(int) (0)];
java.util.Arrays.fill(_topic_type,"");
 //BA.debugLineNum = 222;BA.debugLine="Topic_Type = Regex.Split(\"/\", Topic)";
_topic_type = anywheresoftware.b4a.keywords.Common.Regex.Split("/",_topic);
 //BA.debugLineNum = 223;BA.debugLine="Dim Topic_Purpose As String";
_topic_purpose = "";
 //BA.debugLineNum = 224;BA.debugLine="Topic_Purpose = Topic_Type(1)";
_topic_purpose = _topic_type[(int) (1)];
 //BA.debugLineNum = 225;BA.debugLine="If	Topic_Purpose == \"Reply\" Then";
if ((_topic_purpose).equals("Reply")) { 
 //BA.debugLineNum = 227;BA.debugLine="Status.Text  = Message";
mostCurrent._status.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 228;BA.debugLine="Vibrate.Vibrate(1000)";
_vibrate.Vibrate(processBA,(long) (1000));
 //BA.debugLineNum = 230;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
 //BA.debugLineNum = 231;BA.debugLine="n.Initialize";
_n.Initialize();
 //BA.debugLineNum = 232;BA.debugLine="n.Icon = \"icon\"";
_n.setIcon("icon");
 //BA.debugLineNum = 233;BA.debugLine="n.SetInfo(Message,\"返事\",Me)";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(_message),BA.ObjectToCharSequence("返事"),main.getObject());
 //BA.debugLineNum = 234;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
 }else if((_topic_purpose).equals("button1")) { 
 //BA.debugLineNum = 237;BA.debugLine="Button1.Text = Message";
mostCurrent._button1.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 238;BA.debugLine="kvs.Put(\"button1\", Message)";
_kvs._put("button1",(Object)(_message));
 }else if((_topic_purpose).equals("button2")) { 
 //BA.debugLineNum = 241;BA.debugLine="Button2.Text = Message";
mostCurrent._button2.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 242;BA.debugLine="kvs.Put(\"button2\", Message)";
_kvs._put("button2",(Object)(_message));
 }else if((_topic_purpose).equals("button3")) { 
 //BA.debugLineNum = 245;BA.debugLine="Button3.Text = Message";
mostCurrent._button3.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 246;BA.debugLine="kvs.Put(\"button3\", Message)";
_kvs._put("button3",(Object)(_message));
 }else if((_topic_purpose).equals("button4")) { 
 //BA.debugLineNum = 249;BA.debugLine="Button4.Text = Message";
mostCurrent._button4.setText(BA.ObjectToCharSequence(_message));
 //BA.debugLineNum = 250;BA.debugLine="kvs.Put(\"button4\", Message)";
_kvs._put("button4",(Object)(_message));
 }else if((_topic_purpose).equals("name")) { 
 //BA.debugLineNum = 253;BA.debugLine="kvs.Put(\"NAME\",Message)";
_kvs._put("NAME",(Object)(_message));
 };
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
starter._process_globals();
autoboot._process_globals();
form._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 20;BA.debugLine="Private mqtt As MqttClient";
_mqtt = new anywheresoftware.b4j.objects.MqttAsyncClientWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private serializator As B4XSerializator";
_serializator = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
 //BA.debugLineNum = 22;BA.debugLine="Private mytopic As String = \"SmartWatchMinoGifu\"";
_mytopic = "SmartWatchMinoGifu";
 //BA.debugLineNum = 23;BA.debugLine="Type CircleData (x As Double, y As Double, clr As";
;
 //BA.debugLineNum = 27;BA.debugLine="Dim serverURI As String = \"tcp://10.3.1.80:1883\"";
_serveruri = "tcp://10.3.1.80:1883";
 //BA.debugLineNum = 28;BA.debugLine="Dim phone As Phone";
_phone = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 29;BA.debugLine="Dim Vibrate As PhoneVibrate";
_vibrate = new anywheresoftware.b4a.phone.Phone.PhoneVibrate();
 //BA.debugLineNum = 30;BA.debugLine="Dim android_id As String";
_android_id = "";
 //BA.debugLineNum = 32;BA.debugLine="Dim android_name As String";
_android_name = "";
 //BA.debugLineNum = 33;BA.debugLine="Dim wifi As ABWifi";
_wifi = new com.AB.ABWifi.ABWifi();
 //BA.debugLineNum = 34;BA.debugLine="Dim kvs As KeyValueStore";
_kvs = new b4a.example3.keyvaluestore();
 //BA.debugLineNum = 35;BA.debugLine="Dim SQL As SQL";
_sql = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 38;BA.debugLine="Dim DBFileName As String = \"datastore.db\"";
_dbfilename = "datastore.db";
 //BA.debugLineNum = 39;BA.debugLine="Dim DBFilePath As String = File.DirInternal";
_dbfilepath = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _removeallviews() throws Exception{
int _i = 0;
 //BA.debugLineNum = 323;BA.debugLine="Sub RemoveAllViews";
 //BA.debugLineNum = 324;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 326;BA.debugLine="For  i = Activity.NumberOfViews - 1 To 0 Step -1";
{
final int step2 = -1;
final int limit2 = (int) (0);
_i = (int) (mostCurrent._activity.getNumberOfViews()-1) ;
for (;_i >= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 327;BA.debugLine="Activity.RemoveViewAt(i)";
mostCurrent._activity.RemoveViewAt(_i);
 }
};
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
return "";
}
public static String  _save_click() throws Exception{
String _inputserver = "";
 //BA.debugLineNum = 363;BA.debugLine="Private Sub save_Click";
 //BA.debugLineNum = 365;BA.debugLine="Dim InputServer As String = \"tcp://\"&EditServer.T";
_inputserver = "tcp://"+mostCurrent._editserver.getText()+":1883";
 //BA.debugLineNum = 366;BA.debugLine="kvs.Put(\"SERVER\", InputServer)";
_kvs._put("SERVER",(Object)(_inputserver));
 //BA.debugLineNum = 369;BA.debugLine="kvs.Put(\"NAME\",EditName.Text)";
_kvs._put("NAME",(Object)(mostCurrent._editname.getText()));
 //BA.debugLineNum = 371;BA.debugLine="android_name = EditName.Text";
_android_name = mostCurrent._editname.getText();
 //BA.debugLineNum = 372;BA.debugLine="RemoveAllViews";
_removeallviews();
 //BA.debugLineNum = 373;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public static String  _sendamessage(String _alert,String _level,String _message) throws Exception{
String _formatted_message = "";
 //BA.debugLineNum = 260;BA.debugLine="Private Sub SendAMessage(Alert As String, Level As";
 //BA.debugLineNum = 261;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 263;BA.debugLine="If	mqtt.Connected == True Then";
if (_mqtt.getConnected()==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 264;BA.debugLine="android_id  = phone.GetSettings (\"android_id\")";
_android_id = _phone.GetSettings("android_id");
 //BA.debugLineNum = 265;BA.debugLine="Dim Formatted_message  As String  = Level &\",\"&";
_formatted_message = _level+","+_message;
 //BA.debugLineNum = 266;BA.debugLine="If Level == \"HIGH\" Then";
if ((_level).equals("HIGH")) { 
 //BA.debugLineNum = 268;BA.debugLine="mqtt.Publish(\"SmartWatchMinoGifu/\"&Alert&\"/\" &a";
_mqtt.Publish("SmartWatchMinoGifu/"+_alert+"/"+_android_id,_formatted_message.getBytes("UTF8"));
 }else {
 //BA.debugLineNum = 271;BA.debugLine="mqtt.Publish(\"SmartWatchMinoGifu/\"&Alert&\"/\" &a";
_mqtt.Publish("SmartWatchMinoGifu/"+_alert+"/"+_android_id,_formatted_message.getBytes("UTF8"));
 };
 //BA.debugLineNum = 273;BA.debugLine="Status.Text = Alert &\"に送った\"";
mostCurrent._status.setText(BA.ObjectToCharSequence(_alert+"に送った"));
 }else {
 //BA.debugLineNum = 276;BA.debugLine="ConnectToWifi";
_connecttowifi();
 //BA.debugLineNum = 277;BA.debugLine="ConnectToMQTT";
_connecttomqtt();
 };
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
}
