package asahi.alert;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class preferencesdialog extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "asahi.alert.preferencesdialog");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", asahi.alert.preferencesdialog.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public b4a.example3.customlistview _customlistview1 = null;
public anywheresoftware.b4a.objects.collections.List _prefitems = null;
public int _type_boolean = 0;
public int _type_text = 0;
public int _type_date = 0;
public int _type_options = 0;
public int _type_color = 0;
public int _type_separator = 0;
public int _type_number = 0;
public int _type_password = 0;
public int _type_shortoptions = 0;
public int _type_decimalnumber = 0;
public int _type_multilinetext = 0;
public int _type_time = 0;
public int _type_numericrange = 0;
public int _type_explanation = 0;
public asahi.alert.b4xdatetemplate _datetemplate = null;
public asahi.alert.b4xlongtexttemplate _longtexttemplate = null;
public asahi.alert.b4xdialog _dialog = null;
public int _result_showing_nested_dialog = 0;
public int _nesteddialogitemindex = 0;
public Object _mtitle = null;
public asahi.alert.b4xsearchtemplate _searchtemplate = null;
public Object _template = null;
public asahi.alert.b4xcolortemplate _colortemplate = null;
public asahi.alert.b4xcombobox _b4xcombobox1 = null;
public int _theme_dark = 0;
public int _theme_light = 0;
public int _mtheme = 0;
public int _itemsbackgroundcolor = 0;
public int _textcolor = 0;
public int _separatorbackgroundcolor = 0;
public int _separatortextcolor = 0;
public Object _mcallback = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _defaulthintfont = null;
public int _defaulthintlargesize = 0;
public b4a.example.dateutils _dateutils = null;
public asahi.alert.main _main = null;
public asahi.alert.starter _starter = null;
public asahi.alert.autoboot _autoboot = null;
public asahi.alert.form _form = null;
public asahi.alert.xuiviewsutils _xuiviewsutils = null;
public static class _b4xprefitem{
public boolean IsInitialized;
public Object Title;
public int ItemType;
public anywheresoftware.b4a.objects.collections.Map Extra;
public String Key;
public boolean Required;
public void Initialize() {
IsInitialized = true;
Title = new Object();
ItemType = 0;
Extra = new anywheresoftware.b4a.objects.collections.Map();
Key = "";
Required = false;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _addbooleanitem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="Public Sub AddBooleanItem (Key As String, Title As";
 //BA.debugLineNum = 206;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_BOOLEAN,";
_prefitems.Add((Object)(_createprefitem(_title,_type_boolean,_key)));
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return "";
}
public String  _addcoloritem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Public Sub AddColorItem(Key As String, Title As Ob";
 //BA.debugLineNum = 249;BA.debugLine="If ColorTemplate.IsInitialized = False Then";
if (_colortemplate.IsInitialized /*boolean*/ ()==__c.False) { 
 //BA.debugLineNum = 250;BA.debugLine="ColorTemplate.Initialize";
_colortemplate._initialize /*String*/ (ba);
 };
 //BA.debugLineNum = 252;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_COLOR, K";
_prefitems.Add((Object)(_createprefitem(_title,_type_color,_key)));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _adddateitem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Public Sub AddDateItem (Key As String, Title As Ob";
 //BA.debugLineNum = 245;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_DATE, Ke";
_prefitems.Add((Object)(_createprefitem(_title,_type_date,_key)));
 //BA.debugLineNum = 246;BA.debugLine="End Sub";
return "";
}
public String  _adddecimalnumberitem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 217;BA.debugLine="Public Sub AddDecimalNumberItem (Key As String, Ti";
 //BA.debugLineNum = 218;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_DECIMALN";
_prefitems.Add((Object)(_createprefitem(_title,_type_decimalnumber,_key)));
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _addexplanationitem(String _key,Object _title,Object _text) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 256;BA.debugLine="Public Sub AddExplanationItem (Key As String, Titl";
 //BA.debugLineNum = 257;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_explanation,_key);
 //BA.debugLineNum = 258;BA.debugLine="pi.Extra = CreateMap(\"text\": Text)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("text"),_text});
 //BA.debugLineNum = 259;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public String  _addmultilinetextitem(String _key,Object _title,int _height) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 221;BA.debugLine="Public Sub AddMultilineTextItem (Key As String, Ti";
 //BA.debugLineNum = 222;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_multilinetext,_key);
 //BA.debugLineNum = 223;BA.debugLine="pi.Extra = CreateMap(\"height\": Height)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("height"),(Object)(_height)});
 //BA.debugLineNum = 224;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return "";
}
public String  _addnumberitem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Public Sub AddNumberItem (Key As String, Title As";
 //BA.debugLineNum = 214;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_NUMBER,";
_prefitems.Add((Object)(_createprefitem(_title,_type_number,_key)));
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public String  _addnumericrangeitem(String _key,Object _title,double _rangestart,double _rangeend,double _interval) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 228;BA.debugLine="Public Sub AddNumericRangeItem (Key As String, Tit";
 //BA.debugLineNum = 229;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_numericrange,_key);
 //BA.debugLineNum = 230;BA.debugLine="pi.Extra = CreateMap(\"start\": RangeStart, \"end\":";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("start"),(Object)(_rangestart),(Object)("end"),(Object)(_rangeend),(Object)("interval"),(Object)(_interval)});
 //BA.debugLineNum = 231;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public String  _addoptionsitem(String _key,Object _title,anywheresoftware.b4a.objects.collections.List _options) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 188;BA.debugLine="Public Sub AddOptionsItem (Key As String, Title As";
 //BA.debugLineNum = 190;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_options,_key);
 //BA.debugLineNum = 191;BA.debugLine="If Options.IsInitialized Then";
if (_options.IsInitialized()) { 
 //BA.debugLineNum = 192;BA.debugLine="pi.Extra = CreateMap(\"options\": Options)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("options"),(Object)(_options.getObject())});
 };
 //BA.debugLineNum = 194;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _addpassworditem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Public Sub AddPasswordItem (Key As String, Title A";
 //BA.debugLineNum = 241;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_PASSWORD";
_prefitems.Add((Object)(_createprefitem(_title,_type_password,_key)));
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return "";
}
public String  _addseparator(Object _title) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub AddSeparator (Title As Object)";
 //BA.debugLineNum = 263;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_SEPARATO";
_prefitems.Add((Object)(_createprefitem(_title,_type_separator,"")));
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public String  _addshortoptionsitem(String _key,Object _title,anywheresoftware.b4a.objects.collections.List _options) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 197;BA.debugLine="Public Sub AddShortOptionsItem (Key As String, Tit";
 //BA.debugLineNum = 198;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_shortoptions,_key);
 //BA.debugLineNum = 199;BA.debugLine="If Options.IsInitialized Then";
if (_options.IsInitialized()) { 
 //BA.debugLineNum = 200;BA.debugLine="pi.Extra = CreateMap(\"options\": Options)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("options"),(Object)(_options.getObject())});
 };
 //BA.debugLineNum = 202;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _addtextitem(String _key,Object _title) throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Public Sub AddTextItem (Key As String, Title As Ob";
 //BA.debugLineNum = 210;BA.debugLine="PrefItems.Add(CreatePrefItem(Title, TYPE_TEXT, Ke";
_prefitems.Add((Object)(_createprefitem(_title,_type_text,_key)));
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public String  _addtimeitem(String _key,Object _title) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 234;BA.debugLine="Public Sub AddTimeItem (Key As String, Title As Ob";
 //BA.debugLineNum = 235;BA.debugLine="Dim pi As B4XPrefItem = CreatePrefItem(Title, TYP";
_pi = _createprefitem(_title,_type_time,_key);
 //BA.debugLineNum = 236;BA.debugLine="pi.Extra = CreateMap(\"24\": False)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/  = __c.createMap(new Object[] {(Object)("24"),(Object)(__c.False)});
 //BA.debugLineNum = 237;BA.debugLine="PrefItems.Add(pi)";
_prefitems.Add((Object)(_pi));
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public String  _b4xcombobox1_selectedindexchanged(int _index) throws Exception{
 //BA.debugLineNum = 913;BA.debugLine="Private Sub B4XComboBox1_SelectedIndexChanged (Ind";
 //BA.debugLineNum = 915;BA.debugLine="End Sub";
return "";
}
public String  _b4xswitch1_valuechanged(boolean _value) throws Exception{
 //BA.debugLineNum = 909;BA.debugLine="Private Sub B4XSwitch1_ValueChanged (Value As Bool";
 //BA.debugLineNum = 911;BA.debugLine="End Sub";
return "";
}
public boolean  _backkeypressed() throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Public Sub BackKeyPressed As Boolean";
 //BA.debugLineNum = 102;BA.debugLine="If Dialog.Visible Then";
if (_dialog._getvisible /*boolean*/ ()) { 
 //BA.debugLineNum = 103;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
_dialog._close /*boolean*/ (_xui.DialogResponse_Cancel);
 //BA.debugLineNum = 104;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 106;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return false;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 5;BA.debugLine="Public mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Public CustomListView1 As CustomListView";
_customlistview1 = new b4a.example3.customlistview();
 //BA.debugLineNum = 7;BA.debugLine="Type B4XPrefItem (Title As Object, ItemType As In";
;
 //BA.debugLineNum = 8;BA.debugLine="Public PrefItems As List";
_prefitems = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 9;BA.debugLine="Public TYPE_BOOLEAN = 1, TYPE_TEXT = 2, TYPE_DATE";
_type_boolean = (int) (1);
_type_text = (int) (2);
_type_date = (int) (3);
_type_options = (int) (4);
_type_color = (int) (5);
_type_separator = (int) (6);
_type_number = (int) (7);
_type_password = (int) (8);
_type_shortoptions = (int) (9);
_type_decimalnumber = (int) (10);
_type_multilinetext = (int) (11);
_type_time = (int) (12);
_type_numericrange = (int) (13);
_type_explanation = (int) (14);
 //BA.debugLineNum = 12;BA.debugLine="Public DateTemplate As B4XDateTemplate";
_datetemplate = new asahi.alert.b4xdatetemplate();
 //BA.debugLineNum = 13;BA.debugLine="Public LongTextTemplate As B4XLongTextTemplate";
_longtexttemplate = new asahi.alert.b4xlongtexttemplate();
 //BA.debugLineNum = 14;BA.debugLine="Public Dialog As B4XDialog";
_dialog = new asahi.alert.b4xdialog();
 //BA.debugLineNum = 15;BA.debugLine="Private RESULT_SHOWING_NESTED_DIALOG As Int = 100";
_result_showing_nested_dialog = (int) (100);
 //BA.debugLineNum = 16;BA.debugLine="Private NestedDialogItemIndex As Int";
_nesteddialogitemindex = 0;
 //BA.debugLineNum = 17;BA.debugLine="Private mTitle As Object";
_mtitle = new Object();
 //BA.debugLineNum = 18;BA.debugLine="Public SearchTemplate As B4XSearchTemplate";
_searchtemplate = new asahi.alert.b4xsearchtemplate();
 //BA.debugLineNum = 19;BA.debugLine="Private Template As Object";
_template = new Object();
 //BA.debugLineNum = 20;BA.debugLine="Public ColorTemplate As B4XColorTemplate";
_colortemplate = new asahi.alert.b4xcolortemplate();
 //BA.debugLineNum = 21;BA.debugLine="Private B4XComboBox1 As B4XComboBox";
_b4xcombobox1 = new asahi.alert.b4xcombobox();
 //BA.debugLineNum = 22;BA.debugLine="Public const THEME_DARK = 1, THEME_LIGHT = 2 As I";
_theme_dark = (int) (1);
_theme_light = (int) (2);
 //BA.debugLineNum = 23;BA.debugLine="Private mTheme As Int";
_mtheme = 0;
 //BA.debugLineNum = 24;BA.debugLine="Public ItemsBackgroundColor As Int";
_itemsbackgroundcolor = 0;
 //BA.debugLineNum = 25;BA.debugLine="Public TextColor As Int";
_textcolor = 0;
 //BA.debugLineNum = 26;BA.debugLine="Public SeparatorBackgroundColor, SeparatorTextCol";
_separatorbackgroundcolor = 0;
_separatortextcolor = 0;
 //BA.debugLineNum = 27;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
 //BA.debugLineNum = 28;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 29;BA.debugLine="Public DefaultHintFont As B4XFont";
_defaulthintfont = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
 //BA.debugLineNum = 30;BA.debugLine="Public DefaultHintLargeSize As Int";
_defaulthintlargesize = 0;
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public String  _clear() throws Exception{
 //BA.debugLineNum = 375;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 376;BA.debugLine="CustomListView1.Clear";
_customlistview1._clear();
 //BA.debugLineNum = 377;BA.debugLine="PrefItems.Clear";
_prefitems.Clear();
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public String  _colortohex(int _clr) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
 //BA.debugLineNum = 943;BA.debugLine="Private Sub ColorToHex(clr As Int) As String";
 //BA.debugLineNum = 944;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 945;BA.debugLine="Return bc.HexFromBytes(bc.IntsToBytes(Array As In";
if (true) return _bc.HexFromBytes(_bc.IntsToBytes(new int[]{_clr}));
 //BA.debugLineNum = 946;BA.debugLine="End Sub";
return "";
}
public boolean  _commitchanges(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
anywheresoftware.b4a.objects.collections.Map _temp = null;
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
asahi.alert.preferencesdialog._b4xprefitem _prefitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _itempanel = null;
boolean _required = false;
Object _value = null;
asahi.alert.b4xswitch _switch = null;
asahi.alert.b4xfloattextfield _ft = null;
double _n = 0;
int _n2 = 0;
asahi.alert.b4xplusminus _pmhours = null;
asahi.alert.b4xplusminus _pmminutes = null;
asahi.alert.b4xplusminus _pmampm = null;
b4a.example.dateutils._period _p = null;
asahi.alert.b4xplusminus _pm = null;
asahi.alert.b4xcombobox _cmb = null;
boolean _valid = false;
String _key = "";
 //BA.debugLineNum = 691;BA.debugLine="Private Sub CommitChanges (Data As Map) As Boolean";
 //BA.debugLineNum = 692;BA.debugLine="Dim Temp As Map";
_temp = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 693;BA.debugLine="Temp.Initialize";
_temp.Initialize();
 //BA.debugLineNum = 694;BA.debugLine="For i = 0 To CustomListView1.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_customlistview1._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 695;BA.debugLine="Dim Item As CLVItem = CustomListView1.GetRawList";
_item = _customlistview1._getrawlistitem(_i);
 //BA.debugLineNum = 696;BA.debugLine="If (Item.Value Is B4XPrefItem) = False Then Exit";
if ((_item.Value instanceof asahi.alert.preferencesdialog._b4xprefitem)==__c.False) { 
if (true) break;};
 //BA.debugLineNum = 697;BA.debugLine="Dim PrefItem As B4XPrefItem = Item.Value";
_prefitem = (asahi.alert.preferencesdialog._b4xprefitem)(_item.Value);
 //BA.debugLineNum = 698;BA.debugLine="Dim ItemPanel As B4XView = Item.Panel.GetView(0)";
_itempanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_itempanel = _item.Panel.GetView((int) (0));
 //BA.debugLineNum = 699;BA.debugLine="Dim Required As Boolean = PrefItem.Required";
_required = _prefitem.Required /*boolean*/ ;
 //BA.debugLineNum = 700;BA.debugLine="Dim Value As Object";
_value = new Object();
 //BA.debugLineNum = 701;BA.debugLine="Select PrefItem.ItemType";
switch (BA.switchObjectToInt(_prefitem.ItemType /*int*/ ,_type_boolean,_type_text,_type_password,_type_multilinetext,_type_number,_type_decimalnumber,_type_date,_type_time,_type_numericrange,_type_options,_type_shortoptions,_type_color,_type_separator,_type_explanation)) {
case 0: {
 //BA.debugLineNum = 703;BA.debugLine="Dim switch As B4XSwitch = ItemPanel.GetView(1)";
_switch = (asahi.alert.b4xswitch)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 704;BA.debugLine="Value = switch.Value";
_value = (Object)(_switch._getvalue /*boolean*/ ());
 break; }
case 1: 
case 2: 
case 3: {
 //BA.debugLineNum = 706;BA.debugLine="Dim ft As B4XFloatTextField = ItemPanel.GetVie";
_ft = (asahi.alert.b4xfloattextfield)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 707;BA.debugLine="Value = ft.Text";
_value = (Object)(_ft._gettext /*String*/ ());
 break; }
case 4: 
case 5: {
 //BA.debugLineNum = 710;BA.debugLine="Dim ft As B4XFloatTextField = ItemPanel.GetVie";
_ft = (asahi.alert.b4xfloattextfield)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 711;BA.debugLine="Dim n As Double";
_n = 0;
 //BA.debugLineNum = 712;BA.debugLine="If ft.Text <> \"\" Then";
if ((_ft._gettext /*String*/ ()).equals("") == false) { 
 //BA.debugLineNum = 713;BA.debugLine="If IsNumber(ft.Text) Then";
if (__c.IsNumber(_ft._gettext /*String*/ ())) { 
 //BA.debugLineNum = 714;BA.debugLine="n = ft.Text";
_n = (double)(Double.parseDouble(_ft._gettext /*String*/ ()));
 //BA.debugLineNum = 715;BA.debugLine="If PrefItem.ItemType = TYPE_NUMBER Then";
if (_prefitem.ItemType /*int*/ ==_type_number) { 
 //BA.debugLineNum = 716;BA.debugLine="Dim n2 As Int = n";
_n2 = (int) (_n);
 //BA.debugLineNum = 717;BA.debugLine="Value = n2";
_value = (Object)(_n2);
 }else {
 //BA.debugLineNum = 719;BA.debugLine="Value = n";
_value = (Object)(_n);
 };
 }else {
 //BA.debugLineNum = 722;BA.debugLine="GoToItem(i)";
_gotoitem(_i);
 //BA.debugLineNum = 723;BA.debugLine="Return False";
if (true) return __c.False;
 };
 }else {
 //BA.debugLineNum = 726;BA.debugLine="Value = \"\"";
_value = (Object)("");
 };
 break; }
case 6: {
 //BA.debugLineNum = 729;BA.debugLine="Value = DateTime.DateParse(ItemPanel.GetView(1";
_value = (Object)(__c.DateTime.DateParse(_itempanel.GetView((int) (1)).getText()));
 break; }
case 7: {
 //BA.debugLineNum = 731;BA.debugLine="Dim pmHours As B4XPlusMinus = ItemPanel.GetVie";
_pmhours = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 732;BA.debugLine="Dim pmMinutes As B4XPlusMinus = ItemPanel.GetV";
_pmminutes = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 733;BA.debugLine="Dim pmAMPM As B4XPlusMinus = ItemPanel.GetView";
_pmampm = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (2)).getTag());
 //BA.debugLineNum = 734;BA.debugLine="Dim p As Period";
_p = new b4a.example.dateutils._period();
 //BA.debugLineNum = 735;BA.debugLine="p.Initialize";
_p.Initialize();
 //BA.debugLineNum = 736;BA.debugLine="p.Hours = pmHours.SelectedValue";
_p.Hours = (int)(BA.ObjectToNumber(_pmhours._getselectedvalue /*Object*/ ()));
 //BA.debugLineNum = 737;BA.debugLine="If PrefItem.Extra.GetDefault(\"24\", False) = Fa";
if ((_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .GetDefault((Object)("24"),(Object)(__c.False))).equals((Object)(__c.False))) { 
 //BA.debugLineNum = 738;BA.debugLine="If p.Hours = 12 Then p.Hours = 0";
if (_p.Hours==12) { 
_p.Hours = (int) (0);};
 //BA.debugLineNum = 739;BA.debugLine="If pmAMPM.SelectedValue = \"pm\" Then p.Hours =";
if ((_pmampm._getselectedvalue /*Object*/ ()).equals((Object)("pm"))) { 
_p.Hours = (int) (_p.Hours+12);};
 };
 //BA.debugLineNum = 741;BA.debugLine="p.Minutes = pmMinutes.SelectedValue";
_p.Minutes = (int)(BA.ObjectToNumber(_pmminutes._getselectedvalue /*Object*/ ()));
 //BA.debugLineNum = 742;BA.debugLine="Value = p";
_value = (Object)(_p);
 break; }
case 8: {
 //BA.debugLineNum = 744;BA.debugLine="Dim pm As B4XPlusMinus = ItemPanel.GetView(0).";
_pm = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 745;BA.debugLine="Value = pm.SelectedValue";
_value = _pm._getselectedvalue /*Object*/ ();
 break; }
case 9: {
 //BA.debugLineNum = 747;BA.debugLine="Value = ItemPanel.GetView(1).Text";
_value = (Object)(_itempanel.GetView((int) (1)).getText());
 break; }
case 10: {
 //BA.debugLineNum = 749;BA.debugLine="Dim cmb As B4XComboBox = ItemPanel.GetView(1).";
_cmb = (asahi.alert.b4xcombobox)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 750;BA.debugLine="If cmb.SelectedIndex > -1 Then Value = cmb.Get";
if (_cmb._getselectedindex /*int*/ ()>-1) { 
_value = (Object)(_cmb._getitem /*String*/ (_cmb._getselectedindex /*int*/ ()));}
else {
_value = (Object)("");};
 break; }
case 11: {
 //BA.debugLineNum = 752;BA.debugLine="Value = ItemPanel.GetView(1).Color";
_value = (Object)(_itempanel.GetView((int) (1)).getColor());
 break; }
case 12: 
case 13: {
 //BA.debugLineNum = 754;BA.debugLine="Continue";
if (true) continue;
 break; }
}
;
 //BA.debugLineNum = 756;BA.debugLine="If Value = \"\" Then";
if ((_value).equals((Object)(""))) { 
 //BA.debugLineNum = 757;BA.debugLine="If Required Then";
if (_required) { 
 //BA.debugLineNum = 758;BA.debugLine="GoToItem(i)";
_gotoitem(_i);
 //BA.debugLineNum = 759;BA.debugLine="Return False";
if (true) return __c.False;
 }else {
 //BA.debugLineNum = 761;BA.debugLine="Continue";
if (true) continue;
 };
 };
 //BA.debugLineNum = 764;BA.debugLine="Temp.Put(PrefItem.Key, Value)";
_temp.Put((Object)(_prefitem.Key /*String*/ ),_value);
 }
};
 //BA.debugLineNum = 766;BA.debugLine="If mEventName <> \"\" And xui.SubExists(mCallback,";
if ((_meventname).equals("") == false && _xui.SubExists(ba,_mcallback,_meventname+"_IsValid",(int) (1))) { 
 //BA.debugLineNum = 767;BA.debugLine="Dim Valid As Boolean = CallSub2(mCallback, mEven";
_valid = BA.ObjectToBoolean(__c.CallSubNew2(ba,_mcallback,_meventname+"_IsValid",(Object)(_temp)));
 //BA.debugLineNum = 768;BA.debugLine="If Valid = False Then Return False";
if (_valid==__c.False) { 
if (true) return __c.False;};
 };
 //BA.debugLineNum = 770;BA.debugLine="For Each key As String In Temp.Keys";
{
final anywheresoftware.b4a.BA.IterableList group78 = _temp.Keys();
final int groupLen78 = group78.getSize()
;int index78 = 0;
;
for (; index78 < groupLen78;index78++){
_key = BA.ObjectToString(group78.Get(index78));
 //BA.debugLineNum = 771;BA.debugLine="Data.Put(key, Temp.Get(key))";
_data.Put((Object)(_key),_temp.Get((Object)(_key)));
 }
};
 //BA.debugLineNum = 773;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 774;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(String _eventname) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 877;BA.debugLine="Private Sub CreateLabel(EventName As String) As B4";
 //BA.debugLineNum = 878;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 879;BA.debugLine="lbl.Initialize(EventName)";
_lbl.Initialize(ba,_eventname);
 //BA.debugLineNum = 880;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 881;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlayouts(asahi.alert.preferencesdialog._b4xprefitem _prefitem) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
asahi.alert.b4xfloattextfield _ft = null;
anywheresoftware.b4a.objects.EditTextWrapper _et = null;
anywheresoftware.b4a.objects.collections.List _original = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spnr = null;
anywheresoftware.b4a.objects.collections.List _options = null;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
String _opt = "";
asahi.alert.b4xfloattextfield _tf = null;
anywheresoftware.b4a.objects.EditTextWrapper _ed = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xlbl = null;
anywheresoftware.b4a.objects.LabelWrapper _rlbl = null;
 //BA.debugLineNum = 512;BA.debugLine="Private Sub CreateLayouts (PrefItem As B4XPrefItem";
 //BA.debugLineNum = 513;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _xui.CreatePanel(ba,"");
 //BA.debugLineNum = 514;BA.debugLine="p.Width = CustomListView1.sv.ScrollViewContentWid";
_p.setWidth(_customlistview1._sv.getScrollViewContentWidth());
 //BA.debugLineNum = 515;BA.debugLine="p.Height = 50dip";
_p.setHeight(__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 516;BA.debugLine="Select PrefItem.ItemType";
switch (BA.switchObjectToInt(_prefitem.ItemType /*int*/ ,_type_boolean,_type_multilinetext,_type_time,_type_numericrange,_type_text,_type_password,_type_number,_type_decimalnumber,_type_date,_type_options,_type_shortoptions,_type_color,_type_explanation,_type_separator)) {
case 0: {
 //BA.debugLineNum = 518;BA.debugLine="p.LoadLayout(\"booleanitem\")";
_p.LoadLayout("booleanitem",ba);
 //BA.debugLineNum = 519;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(p.GetV";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_p.GetView((int) (0)),_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 520;BA.debugLine="p.GetView(0).TextColor = TextColor";
_p.GetView((int) (0)).setTextColor(_textcolor);
 break; }
case 1: {
 //BA.debugLineNum = 522;BA.debugLine="p.Height = PrefItem.Extra.Get(\"height\")";
_p.setHeight((int)(BA.ObjectToNumber(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("height")))));
 //BA.debugLineNum = 523;BA.debugLine="p.LoadLayout(\"textitemmulti\")";
_p.LoadLayout("textitemmulti",ba);
 //BA.debugLineNum = 524;BA.debugLine="Dim ft As B4XFloatTextField = p.GetView(0).Tag";
_ft = (asahi.alert.b4xfloattextfield)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 525;BA.debugLine="ft.HintText = PrefItem.Title";
_ft._hinttext /*String*/  = BA.ObjectToString(_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 526;BA.debugLine="ft.HintFont = DefaultHintFont";
_ft._hintfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _defaulthintfont;
 //BA.debugLineNum = 527;BA.debugLine="ft.LargeLabelTextSize = DefaultHintLargeSize";
_ft._largelabeltextsize /*float*/  = (float) (_defaulthintlargesize);
 //BA.debugLineNum = 528;BA.debugLine="ft.Update";
_ft._update /*String*/ ();
 break; }
case 2: {
 //BA.debugLineNum = 530;BA.debugLine="CreateTimeItem(PrefItem, p)";
_createtimeitem(_prefitem,_p);
 break; }
case 3: {
 //BA.debugLineNum = 532;BA.debugLine="CreateNumericRangeItem(PrefItem, p)";
_createnumericrangeitem(_prefitem,_p);
 break; }
case 4: 
case 5: 
case 6: 
case 7: {
 //BA.debugLineNum = 534;BA.debugLine="p.Height = 60dip";
_p.setHeight(__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 535;BA.debugLine="If PrefItem.ItemType = TYPE_PASSWORD Then";
if (_prefitem.ItemType /*int*/ ==_type_password) { 
 //BA.debugLineNum = 536;BA.debugLine="p.LoadLayout(\"passworditem\")";
_p.LoadLayout("passworditem",ba);
 }else {
 //BA.debugLineNum = 538;BA.debugLine="p.LoadLayout(\"textitem\")";
_p.LoadLayout("textitem",ba);
 //BA.debugLineNum = 539;BA.debugLine="Dim ft As B4XFloatTextField = p.GetView(0).Tag";
_ft = (asahi.alert.b4xfloattextfield)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 540;BA.debugLine="If PrefItem.ItemType = TYPE_NUMBER Then";
if (_prefitem.ItemType /*int*/ ==_type_number) { 
 //BA.debugLineNum = 542;BA.debugLine="Dim et As EditText = ft.TextField";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
_et = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_ft._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().getObject()));
 //BA.debugLineNum = 543;BA.debugLine="et.InputType = et.INPUT_TYPE_NUMBERS";
_et.setInputType(_et.INPUT_TYPE_NUMBERS);
 }else if(_prefitem.ItemType /*int*/ ==_type_decimalnumber) { 
 //BA.debugLineNum = 550;BA.debugLine="Dim et As EditText = ft.TextField";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
_et = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_ft._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().getObject()));
 //BA.debugLineNum = 551;BA.debugLine="et.InputType = et.INPUT_TYPE_DECIMAL_NUMBERS";
_et.setInputType(_et.INPUT_TYPE_DECIMAL_NUMBERS);
 };
 };
 //BA.debugLineNum = 559;BA.debugLine="Dim ft As B4XFloatTextField = p.GetView(0).Tag";
_ft = (asahi.alert.b4xfloattextfield)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 560;BA.debugLine="ft.HintText = PrefItem.Title";
_ft._hinttext /*String*/  = BA.ObjectToString(_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 561;BA.debugLine="ft.HintFont = DefaultHintFont";
_ft._hintfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _defaulthintfont;
 //BA.debugLineNum = 562;BA.debugLine="ft.LargeLabelTextSize = DefaultHintLargeSize";
_ft._largelabeltextsize /*float*/  = (float) (_defaulthintlargesize);
 //BA.debugLineNum = 563;BA.debugLine="ft.Update";
_ft._update /*String*/ ();
 break; }
case 8: {
 //BA.debugLineNum = 565;BA.debugLine="TwoLabelsLayout(\"lblDate\", p, PrefItem)";
_twolabelslayout("lblDate",_p,_prefitem);
 break; }
case 9: {
 //BA.debugLineNum = 567;BA.debugLine="TwoLabelsLayout(\"lblOptions\", p, PrefItem)";
_twolabelslayout("lblOptions",_p,_prefitem);
 break; }
case 10: {
 //BA.debugLineNum = 569;BA.debugLine="p.LoadLayout(\"shortoptions\")";
_p.LoadLayout("shortoptions",ba);
 //BA.debugLineNum = 570;BA.debugLine="p.GetView(0).TextColor = TextColor";
_p.GetView((int) (0)).setTextColor(_textcolor);
 //BA.debugLineNum = 571;BA.debugLine="Dim original As List = PrefItem.Extra.Get(\"opti";
_original = new anywheresoftware.b4a.objects.collections.List();
_original = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("options"))));
 //BA.debugLineNum = 579;BA.debugLine="Dim spnr As Spinner = B4XComboBox1.cmbBox";
_spnr = new anywheresoftware.b4a.objects.SpinnerWrapper();
_spnr = _b4xcombobox1._cmbbox /*anywheresoftware.b4a.objects.SpinnerWrapper*/ ;
 //BA.debugLineNum = 580;BA.debugLine="spnr.TextColor = TextColor";
_spnr.setTextColor(_textcolor);
 //BA.debugLineNum = 581;BA.debugLine="spnr.DropdownBackgroundColor = Dialog.Backgroun";
_spnr.setDropdownBackgroundColor(_dialog._backgroundcolor /*int*/ );
 //BA.debugLineNum = 582;BA.debugLine="SetBackgroundTintList(spnr, xui.Color_Gray, Tex";
_setbackgroundtintlist((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_spnr.getObject())),_xui.Color_Gray,_textcolor);
 //BA.debugLineNum = 583;BA.debugLine="Dim options As List";
_options = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 584;BA.debugLine="options.Initialize";
_options.Initialize();
 //BA.debugLineNum = 585;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 586;BA.debugLine="For Each opt As String In original";
{
final anywheresoftware.b4a.BA.IterableList group56 = _original;
final int groupLen56 = group56.getSize()
;int index56 = 0;
;
for (; index56 < groupLen56;index56++){
_opt = BA.ObjectToString(group56.Get(index56));
 //BA.debugLineNum = 587;BA.debugLine="options.Add(cs.Initialize.Alignment(\"ALIGN_OPP";
_options.Add((Object)(_cs.Initialize().Alignment(BA.getEnumFromString(android.text.Layout.Alignment.class,"ALIGN_OPPOSITE")).Typeface(__c.Typeface.DEFAULT_BOLD).Append(BA.ObjectToCharSequence(_opt)).PopAll().getObject()));
 }
};
 //BA.debugLineNum = 589;BA.debugLine="B4XComboBox1.SetItems(options)";
_b4xcombobox1._setitems /*String*/ (_options);
 //BA.debugLineNum = 593;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(p.GetV";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_p.GetView((int) (0)),_prefitem.Title /*Object*/ );
 break; }
case 11: {
 //BA.debugLineNum = 595;BA.debugLine="p.Height = 60dip";
_p.setHeight(__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 596;BA.debugLine="p.LoadLayout(\"coloritem\")";
_p.LoadLayout("coloritem",ba);
 //BA.debugLineNum = 597;BA.debugLine="Dim tf As B4XFloatTextField = p.GetView(0).Tag";
_tf = (asahi.alert.b4xfloattextfield)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 598;BA.debugLine="tf.HintFont = DefaultHintFont";
_tf._hintfont /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont*/  = _defaulthintfont;
 //BA.debugLineNum = 599;BA.debugLine="tf.LargeLabelTextSize = DefaultHintLargeSize";
_tf._largelabeltextsize /*float*/  = (float) (_defaulthintlargesize);
 //BA.debugLineNum = 600;BA.debugLine="tf.HintText = PrefItem.Title";
_tf._hinttext /*String*/  = BA.ObjectToString(_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 601;BA.debugLine="tf.Update";
_tf._update /*String*/ ();
 //BA.debugLineNum = 603;BA.debugLine="Dim ed As EditText = tf.TextField";
_ed = new anywheresoftware.b4a.objects.EditTextWrapper();
_ed = (anywheresoftware.b4a.objects.EditTextWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.EditTextWrapper(), (android.widget.EditText)(_tf._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().getObject()));
 //BA.debugLineNum = 604;BA.debugLine="ed.InputType = Bit.Or(0x00000080, 0x00080000)";
_ed.setInputType(__c.Bit.Or(((int)0x00000080),((int)0x00080000)));
 break; }
case 12: {
 //BA.debugLineNum = 607;BA.debugLine="TwoLabelsLayout(\"lblExplanation\", p, PrefItem)";
_twolabelslayout("lblExplanation",_p,_prefitem);
 break; }
case 13: {
 //BA.debugLineNum = 609;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 610;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 611;BA.debugLine="Dim xlbl As B4XView = lbl";
_xlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 612;BA.debugLine="xlbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_xlbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 613;BA.debugLine="xlbl.TextColor = SeparatorTextColor";
_xlbl.setTextColor(_separatortextcolor);
 //BA.debugLineNum = 614;BA.debugLine="xlbl.Font = xui.CreateDefaultBoldFont(14)";
_xlbl.setFont(_xui.CreateDefaultBoldFont((float) (14)));
 //BA.debugLineNum = 615;BA.debugLine="xlbl.Color = SeparatorBackgroundColor";
_xlbl.setColor(_separatorbackgroundcolor);
 //BA.debugLineNum = 616;BA.debugLine="p.Height = 30dip";
_p.setHeight(__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 617;BA.debugLine="p.AddView(xlbl, 0, 0, p.Width, p.Height)";
_p.AddView((android.view.View)(_xlbl.getObject()),(int) (0),(int) (0),_p.getWidth(),_p.getHeight());
 //BA.debugLineNum = 618;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(xlbl,";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_xlbl,_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 619;BA.debugLine="PrefItem.Required = False";
_prefitem.Required /*boolean*/  = __c.False;
 break; }
}
;
 //BA.debugLineNum = 621;BA.debugLine="If PrefItem.Required Then";
if (_prefitem.Required /*boolean*/ ) { 
 //BA.debugLineNum = 622;BA.debugLine="Dim rlbl As Label";
_rlbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 623;BA.debugLine="rlbl.Initialize(\"\")";
_rlbl.Initialize(ba,"");
 //BA.debugLineNum = 624;BA.debugLine="Dim xlbl As B4XView = rlbl";
_xlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xlbl = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_rlbl.getObject()));
 //BA.debugLineNum = 625;BA.debugLine="xlbl.Text = \"*\"";
_xlbl.setText(BA.ObjectToCharSequence("*"));
 //BA.debugLineNum = 626;BA.debugLine="xlbl.TextColor = xui.Color_Red";
_xlbl.setTextColor(_xui.Color_Red);
 //BA.debugLineNum = 627;BA.debugLine="xlbl.TextSize = 11";
_xlbl.setTextSize((float) (11));
 //BA.debugLineNum = 628;BA.debugLine="xlbl.SetTextAlignment(\"TOP\", \"LEFT\")";
_xlbl.SetTextAlignment("TOP","LEFT");
 //BA.debugLineNum = 629;BA.debugLine="p.AddView(xlbl, 01dip, 0dip, 10dip, 10dip)";
_p.AddView((android.view.View)(_xlbl.getObject()),__c.DipToCurrent((int) (01)),__c.DipToCurrent((int) (0)),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (10)));
 };
 //BA.debugLineNum = 631;BA.debugLine="p.Color = ItemsBackgroundColor";
_p.setColor(_itemsbackgroundcolor);
 //BA.debugLineNum = 632;BA.debugLine="If mTheme <> THEME_DARK Then";
if (_mtheme!=_theme_dark) { 
 //BA.debugLineNum = 633;BA.debugLine="If p.GetView(0).Tag Is B4XFloatTextField Then";
if (_p.GetView((int) (0)).getTag() instanceof asahi.alert.b4xfloattextfield) { 
 //BA.debugLineNum = 634;BA.debugLine="Dim tf As B4XFloatTextField = p.GetView(0).Tag";
_tf = (asahi.alert.b4xfloattextfield)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 635;BA.debugLine="tf.TextField.TextColor = TextColor";
_tf._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().setTextColor(_textcolor);
 //BA.debugLineNum = 636;BA.debugLine="tf.NonFocusedHintColor = TextColor";
_tf._nonfocusedhintcolor /*int*/  = _textcolor;
 //BA.debugLineNum = 637;BA.debugLine="tf.Update";
_tf._update /*String*/ ();
 //BA.debugLineNum = 638;BA.debugLine="If tf.lblClear.IsInitialized Then tf.lblClear.T";
if (_tf._lblclear /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .IsInitialized()) { 
_tf._lblclear /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTextColor(_textcolor);};
 //BA.debugLineNum = 639;BA.debugLine="If tf.lblV.IsInitialized Then tf.lblV.TextColor";
if (_tf._lblv /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .IsInitialized()) { 
_tf._lblv /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTextColor(_textcolor);};
 };
 };
 //BA.debugLineNum = 642;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 643;BA.debugLine="End Sub";
return null;
}
public String  _createnumericrangeitem(asahi.alert.preferencesdialog._b4xprefitem _prefitem,anywheresoftware.b4a.objects.B4XViewWrapper _p) throws Exception{
asahi.alert.b4xplusminus _pm = null;
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 645;BA.debugLine="Private Sub CreateNumericRangeItem (PrefItem As B4";
 //BA.debugLineNum = 646;BA.debugLine="p.LoadLayout(\"numericrange\")";
_p.LoadLayout("numericrange",ba);
 //BA.debugLineNum = 647;BA.debugLine="Dim pm As B4XPlusMinus = p.GetView(0).Tag";
_pm = (asahi.alert.b4xplusminus)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 648;BA.debugLine="pm.SetNumericRange(PrefItem.Extra.Get(\"start\"), P";
_pm._setnumericrange /*String*/ ((double)(BA.ObjectToNumber(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("start")))),(double)(BA.ObjectToNumber(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("end")))),(double)(BA.ObjectToNumber(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("interval")))));
 //BA.debugLineNum = 649;BA.debugLine="pm.Formatter.GetDefaultFormat.MaximumFractions =";
_pm._formatter /*asahi.alert.b4xformatter*/ ._getdefaultformat /*asahi.alert.b4xformatter._b4xformatdata*/ ().MaximumFractions /*int*/  = (int) (2);
 //BA.debugLineNum = 650;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(p.GetVie";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_p.GetView((int) (1)),_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 651;BA.debugLine="For Each v As B4XView In p.GetAllViewsRecursive";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group6 = _p.GetAllViewsRecursive();
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group6.Get(index6)));
 //BA.debugLineNum = 652;BA.debugLine="If v Is Label Then v.TextColor = TextColor";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
_v.setTextColor(_textcolor);};
 }
};
 //BA.debugLineNum = 654;BA.debugLine="End Sub";
return "";
}
public asahi.alert.preferencesdialog._b4xprefitem  _createprefitem(Object _title,int _itemtype,String _key) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 266;BA.debugLine="Private Sub CreatePrefItem(Title As Object, ItemTy";
 //BA.debugLineNum = 267;BA.debugLine="Dim pi As B4XPrefItem";
_pi = new asahi.alert.preferencesdialog._b4xprefitem();
 //BA.debugLineNum = 268;BA.debugLine="pi.Initialize";
_pi.Initialize();
 //BA.debugLineNum = 269;BA.debugLine="pi.Title = Title";
_pi.Title /*Object*/  = _title;
 //BA.debugLineNum = 270;BA.debugLine="pi.ItemType = ItemType";
_pi.ItemType /*int*/  = _itemtype;
 //BA.debugLineNum = 271;BA.debugLine="pi.Key = Key";
_pi.Key /*String*/  = _key;
 //BA.debugLineNum = 272;BA.debugLine="Return pi";
if (true) return _pi;
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return null;
}
public String  _createtimeitem(asahi.alert.preferencesdialog._b4xprefitem _prefitem,anywheresoftware.b4a.objects.B4XViewWrapper _p) throws Exception{
boolean _is24 = false;
asahi.alert.b4xplusminus _pmhours = null;
asahi.alert.b4xplusminus _pmminutes = null;
asahi.alert.b4xplusminus _pmampm = null;
int _clr = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 656;BA.debugLine="Private Sub CreateTimeItem (PrefItem As B4XPrefIte";
 //BA.debugLineNum = 657;BA.debugLine="p.Height = 60dip";
_p.setHeight(__c.DipToCurrent((int) (60)));
 //BA.debugLineNum = 658;BA.debugLine="Dim is24 As Boolean = PrefItem.Extra.GetDefault(\"";
_is24 = BA.ObjectToBoolean(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .GetDefault((Object)("24"),(Object)(__c.False)));
 //BA.debugLineNum = 659;BA.debugLine="If is24 Then";
if (_is24) { 
 //BA.debugLineNum = 660;BA.debugLine="p.LoadLayout(\"timeitem24\")";
_p.LoadLayout("timeitem24",ba);
 }else {
 //BA.debugLineNum = 662;BA.debugLine="p.LoadLayout(\"timeitem\")";
_p.LoadLayout("timeitem",ba);
 };
 //BA.debugLineNum = 664;BA.debugLine="Dim pmHours As B4XPlusMinus = p.GetView(0).Tag";
_pmhours = (asahi.alert.b4xplusminus)(_p.GetView((int) (0)).getTag());
 //BA.debugLineNum = 665;BA.debugLine="pmHours.RapidPeriod2 = 100";
_pmhours._rapidperiod2 /*int*/  = (int) (100);
 //BA.debugLineNum = 666;BA.debugLine="Dim pmMinutes As B4XPlusMinus = p.GetView(1).Tag";
_pmminutes = (asahi.alert.b4xplusminus)(_p.GetView((int) (1)).getTag());
 //BA.debugLineNum = 667;BA.debugLine="Dim pmAMPM As B4XPlusMinus = p.GetView(2).Tag";
_pmampm = (asahi.alert.b4xplusminus)(_p.GetView((int) (2)).getTag());
 //BA.debugLineNum = 668;BA.debugLine="If xui.IsB4J = False Then";
if (_xui.getIsB4J()==__c.False) { 
 //BA.debugLineNum = 669;BA.debugLine="Dim clr As Int = CustomListView1.sv.ScrollViewIn";
_clr = _customlistview1._sv.getScrollViewInnerPanel().getColor();
 //BA.debugLineNum = 670;BA.debugLine="pmHours.mBase.SetColorAndBorder(xui.Color_Transp";
_pmhours._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetColorAndBorder(_xui.Color_Transparent,__c.DipToCurrent((int) (1)),_clr,(int) (0));
 //BA.debugLineNum = 671;BA.debugLine="pmMinutes.mBase.SetColorAndBorder(xui.Color_Tran";
_pmminutes._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetColorAndBorder(_xui.Color_Transparent,__c.DipToCurrent((int) (1)),_clr,(int) (0));
 //BA.debugLineNum = 672;BA.debugLine="pmAMPM.mBase.SetColorAndBorder(xui.Color_Transpa";
_pmampm._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetColorAndBorder(_xui.Color_Transparent,__c.DipToCurrent((int) (1)),_clr,(int) (0));
 };
 //BA.debugLineNum = 675;BA.debugLine="If is24 Then";
if (_is24) { 
 //BA.debugLineNum = 676;BA.debugLine="pmHours.SetNumericRange(0, 23, 1)";
_pmhours._setnumericrange /*String*/ (0,23,1);
 }else {
 //BA.debugLineNum = 678;BA.debugLine="pmHours.SetNumericRange(1, 12, 1)";
_pmhours._setnumericrange /*String*/ (1,12,1);
 };
 //BA.debugLineNum = 680;BA.debugLine="pmMinutes.SetNumericRange(0, 59, 1)";
_pmminutes._setnumericrange /*String*/ (0,59,1);
 //BA.debugLineNum = 681;BA.debugLine="pmMinutes.Formatter.GetDefaultFormat.MinimumInteg";
_pmminutes._formatter /*asahi.alert.b4xformatter*/ ._getdefaultformat /*asahi.alert.b4xformatter._b4xformatdata*/ ().MinimumIntegers /*int*/  = (int) (2);
 //BA.debugLineNum = 683;BA.debugLine="pmAMPM.SetStringItems(Array(\"am\", \"pm\"))";
_pmampm._setstringitems /*String*/ (anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("am"),(Object)("pm")}));
 //BA.debugLineNum = 684;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(p.GetVie";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_p.GetView((int) (3)),_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 685;BA.debugLine="For Each v As B4XView In p.GetAllViewsRecursive";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group27 = _p.GetAllViewsRecursive();
final int groupLen27 = group27.getSize()
;int index27 = 0;
;
for (; index27 < groupLen27;index27++){
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group27.Get(index27)));
 //BA.debugLineNum = 686;BA.debugLine="If v Is Label Then v.TextColor = TextColor";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
_v.setTextColor(_textcolor);};
 }
};
 //BA.debugLineNum = 688;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 904;BA.debugLine="Private Sub DialogClosed(Result As Int) 'ignore";
 //BA.debugLineNum = 906;BA.debugLine="End Sub";
return "";
}
public String  _filldata(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
asahi.alert.preferencesdialog._b4xprefitem _prefitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _itempanel = null;
asahi.alert.b4xswitch _switch = null;
asahi.alert.b4xfloattextfield _ft = null;
asahi.alert.b4xcombobox _cmb = null;
anywheresoftware.b4a.objects.collections.List _options = null;
asahi.alert.b4xplusminus _pmhours = null;
asahi.alert.b4xplusminus _pmminutes = null;
asahi.alert.b4xplusminus _pmampm = null;
b4a.example.dateutils._period _p = null;
int _hour = 0;
String _m = "";
asahi.alert.b4xplusminus _pm = null;
 //BA.debugLineNum = 381;BA.debugLine="Private Sub FillData (Data As Map)";
 //BA.debugLineNum = 382;BA.debugLine="For i = 0 To CustomListView1.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_customlistview1._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 383;BA.debugLine="Dim Item As CLVItem = CustomListView1.GetRawList";
_item = _customlistview1._getrawlistitem(_i);
 //BA.debugLineNum = 384;BA.debugLine="If (Item.Value Is B4XPrefItem) = False Then Exit";
if ((_item.Value instanceof asahi.alert.preferencesdialog._b4xprefitem)==__c.False) { 
if (true) break;};
 //BA.debugLineNum = 385;BA.debugLine="Dim PrefItem As B4XPrefItem = Item.Value";
_prefitem = (asahi.alert.preferencesdialog._b4xprefitem)(_item.Value);
 //BA.debugLineNum = 386;BA.debugLine="Dim ItemPanel As B4XView = Item.Panel.GetView(0)";
_itempanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_itempanel = _item.Panel.GetView((int) (0));
 //BA.debugLineNum = 387;BA.debugLine="Select PrefItem.ItemType";
switch (BA.switchObjectToInt(_prefitem.ItemType /*int*/ ,_type_boolean,_type_text,_type_password,_type_number,_type_decimalnumber,_type_multilinetext,_type_date,_type_options,_type_shortoptions,_type_color,_type_time,_type_separator,_type_explanation,_type_numericrange)) {
case 0: {
 //BA.debugLineNum = 389;BA.debugLine="Dim switch As B4XSwitch = ItemPanel.GetView(1)";
_switch = (asahi.alert.b4xswitch)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 390;BA.debugLine="switch.Value = GetPrefItemValue(PrefItem, Fals";
_switch._setvalue /*boolean*/ (BA.ObjectToBoolean(_getprefitemvalue(_prefitem,(Object)(__c.False),_data)));
 break; }
case 1: 
case 2: 
case 3: 
case 4: 
case 5: {
 //BA.debugLineNum = 392;BA.debugLine="Dim ft As B4XFloatTextField = ItemPanel.GetVie";
_ft = (asahi.alert.b4xfloattextfield)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 393;BA.debugLine="ft.Text = GetPrefItemValue(PrefItem, \"\", Data)";
_ft._settext /*String*/ (BA.ObjectToString(_getprefitemvalue(_prefitem,(Object)(""),_data)));
 break; }
case 6: {
 //BA.debugLineNum = 395;BA.debugLine="ItemPanel.GetView(1).Text = DateTime.Date(GetP";
_itempanel.GetView((int) (1)).setText(BA.ObjectToCharSequence(__c.DateTime.Date(BA.ObjectToLongNumber(_getprefitemvalue(_prefitem,(Object)(__c.DateTime.getNow()),_data)))));
 break; }
case 7: {
 //BA.debugLineNum = 397;BA.debugLine="ItemPanel.GetView(1).Text = GetPrefItemValue(P";
_itempanel.GetView((int) (1)).setText(BA.ObjectToCharSequence(_getprefitemvalue(_prefitem,(Object)(""),_data)));
 break; }
case 8: {
 //BA.debugLineNum = 399;BA.debugLine="Dim cmb As B4XComboBox = ItemPanel.GetView(1).";
_cmb = (asahi.alert.b4xcombobox)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 400;BA.debugLine="Dim options As List = PrefItem.Extra.Get(\"opti";
_options = new anywheresoftware.b4a.objects.collections.List();
_options = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("options"))));
 //BA.debugLineNum = 401;BA.debugLine="cmb.SelectedIndex = Max(0, options.IndexOf(Get";
_cmb._setselectedindex /*int*/ ((int) (__c.Max(0,_options.IndexOf(_getprefitemvalue(_prefitem,(Object)(""),_data)))));
 break; }
case 9: {
 //BA.debugLineNum = 403;BA.debugLine="SetLabelColor(ItemPanel.GetView(1), GetPrefIte";
_setlabelcolor(_itempanel.GetView((int) (1)),(int)(BA.ObjectToNumber(_getprefitemvalue(_prefitem,(Object)(_xui.Color_Red),_data))));
 //BA.debugLineNum = 404;BA.debugLine="ItemPanel.GetView(2).Text = \"Pick\"";
_itempanel.GetView((int) (2)).setText(BA.ObjectToCharSequence("Pick"));
 break; }
case 10: {
 //BA.debugLineNum = 406;BA.debugLine="Dim pmHours As B4XPlusMinus = ItemPanel.GetVie";
_pmhours = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 407;BA.debugLine="Dim pmMinutes As B4XPlusMinus = ItemPanel.GetV";
_pmminutes = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (1)).getTag());
 //BA.debugLineNum = 408;BA.debugLine="Dim pmAMPM As B4XPlusMinus = ItemPanel.GetView";
_pmampm = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (2)).getTag());
 //BA.debugLineNum = 409;BA.debugLine="Dim p As Period";
_p = new b4a.example.dateutils._period();
 //BA.debugLineNum = 410;BA.debugLine="p = GetPrefItemValue(PrefItem, p, Data)";
_p = (b4a.example.dateutils._period)(_getprefitemvalue(_prefitem,(Object)(_p),_data));
 //BA.debugLineNum = 411;BA.debugLine="Dim hour As Int = p.Hours";
_hour = _p.Hours;
 //BA.debugLineNum = 412;BA.debugLine="Dim m As String";
_m = "";
 //BA.debugLineNum = 413;BA.debugLine="If PrefItem.Extra.GetDefault(\"24\", False) = Fa";
if ((_prefitem.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .GetDefault((Object)("24"),(Object)(__c.False))).equals((Object)(__c.False))) { 
 //BA.debugLineNum = 414;BA.debugLine="If hour <= 11 Then";
if (_hour<=11) { 
 //BA.debugLineNum = 415;BA.debugLine="m = \"am\"";
_m = "am";
 }else {
 //BA.debugLineNum = 417;BA.debugLine="m = \"pm\"";
_m = "pm";
 //BA.debugLineNum = 418;BA.debugLine="hour = hour - 12";
_hour = (int) (_hour-12);
 };
 //BA.debugLineNum = 420;BA.debugLine="If hour = 0 Then hour = 12";
if (_hour==0) { 
_hour = (int) (12);};
 };
 //BA.debugLineNum = 422;BA.debugLine="pmHours.SelectedValue = hour";
_pmhours._setselectedvalue /*Object*/ ((Object)(_hour));
 //BA.debugLineNum = 423;BA.debugLine="pmMinutes.SelectedValue = p.Minutes";
_pmminutes._setselectedvalue /*Object*/ ((Object)(_p.Minutes));
 //BA.debugLineNum = 424;BA.debugLine="pmAMPM.SelectedValue = m";
_pmampm._setselectedvalue /*Object*/ ((Object)(_m));
 break; }
case 11: 
case 12: {
 break; }
case 13: {
 //BA.debugLineNum = 427;BA.debugLine="Dim pm As B4XPlusMinus = ItemPanel.GetView(0).";
_pm = (asahi.alert.b4xplusminus)(_itempanel.GetView((int) (0)).getTag());
 //BA.debugLineNum = 428;BA.debugLine="pm.SelectedValue = GetPrefItemValue(PrefItem,";
_pm._setselectedvalue /*Object*/ (_getprefitemvalue(_prefitem,(Object)(0),_data));
 break; }
default: {
 //BA.debugLineNum = 430;BA.debugLine="Log(\"Unknown type: \" & PrefItem.ItemType)";
__c.LogImpl("94456497","Unknown type: "+BA.NumberToString(_prefitem.ItemType /*int*/ ),0);
 break; }
}
;
 }
};
 //BA.debugLineNum = 433;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(asahi.alert.b4xdialog _dialog1) throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Public Sub GetPanel (Dialog1 As B4XDialog) As B4XV";
 //BA.debugLineNum = 368;BA.debugLine="Return mBase";
if (true) return _mbase;
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return null;
}
public asahi.alert.preferencesdialog._b4xprefitem  _getprefitem(String _key) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 897;BA.debugLine="Public Sub GetPrefItem (Key As String) As B4XPrefI";
 //BA.debugLineNum = 898;BA.debugLine="For Each pi As B4XPrefItem In PrefItems";
{
final anywheresoftware.b4a.BA.IterableList group1 = _prefitems;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_pi = (asahi.alert.preferencesdialog._b4xprefitem)(group1.Get(index1));
 //BA.debugLineNum = 899;BA.debugLine="If pi.Key = Key Then Return pi";
if ((_pi.Key /*String*/ ).equals(_key)) { 
if (true) return _pi;};
 }
};
 //BA.debugLineNum = 901;BA.debugLine="Return Null";
if (true) return (asahi.alert.preferencesdialog._b4xprefitem)(__c.Null);
 //BA.debugLineNum = 902;BA.debugLine="End Sub";
return null;
}
public Object  _getprefitemvalue(asahi.alert.preferencesdialog._b4xprefitem _prefitem,Object _defaultvalue,anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
 //BA.debugLineNum = 441;BA.debugLine="Private Sub GetPrefItemValue (PrefItem As B4XPrefI";
 //BA.debugLineNum = 442;BA.debugLine="Return Data.GetDefault(PrefItem.Key, DefaultValue";
if (true) return _data.GetDefault((Object)(_prefitem.Key /*String*/ ),_defaultvalue);
 //BA.debugLineNum = 443;BA.debugLine="End Sub";
return null;
}
public int  _gettheme() throws Exception{
 //BA.debugLineNum = 445;BA.debugLine="Public Sub getTheme As Int";
 //BA.debugLineNum = 446;BA.debugLine="Return mTheme";
if (true) return _mtheme;
 //BA.debugLineNum = 447;BA.debugLine="End Sub";
return 0;
}
public Object  _gettitle() throws Exception{
 //BA.debugLineNum = 69;BA.debugLine="Public Sub getTitle As Object";
 //BA.debugLineNum = 70;BA.debugLine="Return mTitle";
if (true) return _mtitle;
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return null;
}
public void  _gotoitem(int _i) throws Exception{
ResumableSub_GoToItem rsub = new ResumableSub_GoToItem(this,_i);
rsub.resume(ba, null);
}
public static class ResumableSub_GoToItem extends BA.ResumableSub {
public ResumableSub_GoToItem(asahi.alert.preferencesdialog parent,int _i) {
this.parent = parent;
this._i = _i;
}
asahi.alert.preferencesdialog parent;
int _i;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _duration = 0;
int step3;
int limit3;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 789;BA.debugLine="CustomListView1.JumpToItem(i)";
parent._customlistview1._jumptoitem(_i);
 //BA.debugLineNum = 790;BA.debugLine="Dim p As B4XView = CustomListView1.GetPanel(i)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = parent._customlistview1._getpanel(_i);
 //BA.debugLineNum = 791;BA.debugLine="For i = 0 To 3";
if (true) break;

case 1:
//for
this.state = 4;
step3 = 1;
limit3 = (int) (3);
_i = (int) (0) ;
this.state = 5;
if (true) break;

case 5:
//C
this.state = 4;
if ((step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3)) this.state = 3;
if (true) break;

case 6:
//C
this.state = 5;
_i = ((int)(0 + _i + step3)) ;
if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 792;BA.debugLine="Dim duration As Int = 100 - i * 20";
_duration = (int) (100-_i*20);
 //BA.debugLineNum = 793;BA.debugLine="p.SetLayoutAnimated(duration, -10dip, 0, p.Width";
_p.SetLayoutAnimated(_duration,(int) (-parent.__c.DipToCurrent((int) (10))),(int) (0),_p.getWidth(),_p.getHeight());
 //BA.debugLineNum = 794;BA.debugLine="Sleep(duration)";
parent.__c.Sleep(ba,this,_duration);
this.state = 7;
return;
case 7:
//C
this.state = 6;
;
 //BA.debugLineNum = 795;BA.debugLine="p.SetLayoutAnimated(duration, 10dip, 0, p.Width,";
_p.SetLayoutAnimated(_duration,parent.__c.DipToCurrent((int) (10)),(int) (0),_p.getWidth(),_p.getHeight());
 //BA.debugLineNum = 796;BA.debugLine="Sleep(duration)";
parent.__c.Sleep(ba,this,_duration);
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 if (true) break;
if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 798;BA.debugLine="p.SetLayoutAnimated(50, 0, 0, p.Width, p.Height)";
_p.SetLayoutAnimated((int) (50),(int) (0),(int) (0),_p.getWidth(),_p.getHeight());
 //BA.debugLineNum = 799;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public int[]  _hextocolor(String _hex) throws Exception{
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
int[] _res = null;
int[] _ints = null;
 //BA.debugLineNum = 948;BA.debugLine="Private Sub HexToColor(Hex As String) As Int()";
 //BA.debugLineNum = 949;BA.debugLine="Dim bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 950;BA.debugLine="Hex = Hex.ToLowerCase";
_hex = _hex.toLowerCase();
 //BA.debugLineNum = 951;BA.debugLine="If Hex.StartsWith(\"#\") Then";
if (_hex.startsWith("#")) { 
 //BA.debugLineNum = 952;BA.debugLine="Hex = Hex.SubString(1)";
_hex = _hex.substring((int) (1));
 }else if(_hex.startsWith("0x")) { 
 //BA.debugLineNum = 954;BA.debugLine="Hex = Hex.SubString(2)";
_hex = _hex.substring((int) (2));
 };
 //BA.debugLineNum = 956;BA.debugLine="If Hex.Length = 6 Then Hex = \"ff\" & Hex";
if (_hex.length()==6) { 
_hex = "ff"+_hex;};
 //BA.debugLineNum = 958;BA.debugLine="Dim res() As Int";
_res = new int[(int) (0)];
;
 //BA.debugLineNum = 959;BA.debugLine="If Regex.IsMatch(\"[0-9a-f]{8}\", Hex) = False Then";
if (__c.Regex.IsMatch("[0-9a-f]{8}",_hex)==__c.False) { 
if (true) return _res;};
 //BA.debugLineNum = 960;BA.debugLine="Dim ints() As Int = bc.IntsFromBytes(bc.HexToByte";
_ints = _bc.IntsFromBytes(_bc.HexToBytes(_hex));
 //BA.debugLineNum = 961;BA.debugLine="Return ints";
if (true) return _ints;
 //BA.debugLineNum = 962;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.B4XViewWrapper _parent,Object _title,int _width,int _height) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 33;BA.debugLine="Public Sub Initialize (Parent As B4XView, Title As";
 //BA.debugLineNum = 34;BA.debugLine="Dialog.Initialize(Parent)";
_dialog._initialize /*String*/ (ba,_parent);
 //BA.debugLineNum = 35;BA.debugLine="Dialog.VisibleAnimationDuration = 0";
_dialog._visibleanimationduration /*int*/  = (int) (0);
 //BA.debugLineNum = 36;BA.debugLine="mTitle = Title";
_mtitle = _title;
 //BA.debugLineNum = 37;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_mbase = _xui.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 38;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, Width, Height)";
_mbase.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 39;BA.debugLine="mBase.LoadLayout(\"ListTemplate\")";
_mbase.LoadLayout("ListTemplate",ba);
 //BA.debugLineNum = 40;BA.debugLine="mBase.SetColorAndBorder(xui.Color_Transparent, 0,";
_mbase.SetColorAndBorder(_xui.Color_Transparent,(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 41;BA.debugLine="CustomListView1.sv.SetColorAndBorder(xui.Color_Tr";
_customlistview1._sv.SetColorAndBorder(_xui.Color_Transparent,(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 42;BA.debugLine="CustomListView1.PressedColor = xui.Color_Transpar";
_customlistview1._pressedcolor = _xui.Color_Transparent;
 //BA.debugLineNum = 43;BA.debugLine="PrefItems.Initialize";
_prefitems.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="SearchTemplate.Initialize";
_searchtemplate._initialize /*String*/ (ba);
 //BA.debugLineNum = 45;BA.debugLine="DateTemplate.Initialize";
_datetemplate._initialize /*String*/ (ba);
 //BA.debugLineNum = 46;BA.debugLine="LongTextTemplate.Initialize";
_longtexttemplate._initialize /*String*/ (ba);
 //BA.debugLineNum = 47;BA.debugLine="LongTextTemplate.CustomListView1.PressedColor = 0";
_longtexttemplate._customlistview1 /*b4a.example3.customlistview*/ ._pressedcolor = (int) (0);
 //BA.debugLineNum = 48;BA.debugLine="Dialog.OverlayColor = xui.Color_Transparent";
_dialog._overlaycolor /*int*/  = _xui.Color_Transparent;
 //BA.debugLineNum = 57;BA.debugLine="DefaultHintFont = xui.CreateDefaultBoldFont(16)";
_defaulthintfont = _xui.CreateDefaultBoldFont((float) (16));
 //BA.debugLineNum = 59;BA.debugLine="DefaultHintLargeSize = 16";
_defaulthintlargesize = (int) (16);
 //BA.debugLineNum = 60;BA.debugLine="setTheme(THEME_DARK)";
_settheme(_theme_dark);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _keyboardheightchanged(int _height) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
asahi.alert.b4xfloattextfield _f = null;
int _index = 0;
 //BA.debugLineNum = 77;BA.debugLine="Public Sub KeyboardHeightChanged (Height As Int)";
 //BA.debugLineNum = 78;BA.debugLine="If Dialog.Visible Then";
if (_dialog._getvisible /*boolean*/ ()) { 
 //BA.debugLineNum = 86;BA.debugLine="CustomListView1.sv.Height = Min(CustomListView1.A";
_customlistview1._sv.setHeight((int) (__c.Min(_customlistview1._asview().getHeight(),_height-_customlistview1._asview().getParent().getTop()-_customlistview1._asview().getParent().getParent().getTop())));
 //BA.debugLineNum = 89;BA.debugLine="For Each v As B4XView In CustomListView1.AsView.";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _customlistview1._asview().GetAllViewsRecursive();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_v = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group3.Get(index3)));
 //BA.debugLineNum = 90;BA.debugLine="If v.Tag Is B4XFloatTextField Then";
if (_v.getTag() instanceof asahi.alert.b4xfloattextfield) { 
 //BA.debugLineNum = 91;BA.debugLine="Dim f As B4XFloatTextField = v.Tag";
_f = (asahi.alert.b4xfloattextfield)(_v.getTag());
 //BA.debugLineNum = 92;BA.debugLine="If f.Focused Then";
if (_f._focused /*boolean*/ ) { 
 //BA.debugLineNum = 93;BA.debugLine="Dim index As Int = CustomListView1.GetItemFro";
_index = _customlistview1._getitemfromview(_f._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 94;BA.debugLine="CustomListView1.ScrollToItem(index)";
_customlistview1._scrolltoitem(_index);
 };
 };
 }
};
 };
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _lblcolors_click() throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pref = null;
 //BA.debugLineNum = 853;BA.debugLine="Private Sub lblColors_Click";
 //BA.debugLineNum = 855;BA.debugLine="NestedDialogItemIndex = CustomListView1.GetItemFr";
_nesteddialogitemindex = _customlistview1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
 //BA.debugLineNum = 856;BA.debugLine="Dim pref As B4XPrefItem = CustomListView1.GetValu";
_pref = (asahi.alert.preferencesdialog._b4xprefitem)(_customlistview1._getvalue(_nesteddialogitemindex));
 //BA.debugLineNum = 857;BA.debugLine="Dialog.Title = pref.Title";
_dialog._title /*Object*/  = _pref.Title /*Object*/ ;
 //BA.debugLineNum = 858;BA.debugLine="ColorTemplate.SelectedColor = CustomListView1.Get";
_colortemplate._setselectedcolor /*int*/ (_customlistview1._getpanel(_nesteddialogitemindex).GetView((int) (1)).getColor());
 //BA.debugLineNum = 859;BA.debugLine="Template = ColorTemplate";
_template = (Object)(_colortemplate);
 //BA.debugLineNum = 860;BA.debugLine="Dialog.Close(RESULT_SHOWING_NESTED_DIALOG)";
_dialog._close /*boolean*/ (_result_showing_nested_dialog);
 //BA.debugLineNum = 861;BA.debugLine="End Sub";
return "";
}
public String  _lbldate_click() throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pref = null;
 //BA.debugLineNum = 839;BA.debugLine="Private Sub lblDate_Click";
 //BA.debugLineNum = 841;BA.debugLine="NestedDialogItemIndex = CustomListView1.GetItemFr";
_nesteddialogitemindex = _customlistview1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
 //BA.debugLineNum = 842;BA.debugLine="Dim pref As B4XPrefItem = CustomListView1.GetValu";
_pref = (asahi.alert.preferencesdialog._b4xprefitem)(_customlistview1._getvalue(_nesteddialogitemindex));
 //BA.debugLineNum = 843;BA.debugLine="Dialog.Title = pref.Title";
_dialog._title /*Object*/  = _pref.Title /*Object*/ ;
 //BA.debugLineNum = 844;BA.debugLine="DateTemplate.Date = DateTime.DateParse(CustomList";
_datetemplate._setdate /*long*/ (__c.DateTime.DateParse(_customlistview1._getpanel(_nesteddialogitemindex).GetView((int) (1)).getText()));
 //BA.debugLineNum = 845;BA.debugLine="Template = DateTemplate";
_template = (Object)(_datetemplate);
 //BA.debugLineNum = 846;BA.debugLine="Dialog.Close(RESULT_SHOWING_NESTED_DIALOG)";
_dialog._close /*boolean*/ (_result_showing_nested_dialog);
 //BA.debugLineNum = 847;BA.debugLine="End Sub";
return "";
}
public String  _lblexplanation_click() throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pref = null;
 //BA.debugLineNum = 867;BA.debugLine="Private Sub lblExplanation_Click";
 //BA.debugLineNum = 869;BA.debugLine="NestedDialogItemIndex = CustomListView1.GetItemFr";
_nesteddialogitemindex = _customlistview1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
 //BA.debugLineNum = 870;BA.debugLine="Dim pref As B4XPrefItem = CustomListView1.GetValu";
_pref = (asahi.alert.preferencesdialog._b4xprefitem)(_customlistview1._getvalue(_nesteddialogitemindex));
 //BA.debugLineNum = 871;BA.debugLine="Dialog.Title = pref.Title";
_dialog._title /*Object*/  = _pref.Title /*Object*/ ;
 //BA.debugLineNum = 872;BA.debugLine="LongTextTemplate.Text = pref.Extra.Get(\"text\")";
_longtexttemplate._text /*Object*/  = _pref.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("text"));
 //BA.debugLineNum = 873;BA.debugLine="Template = LongTextTemplate";
_template = (Object)(_longtexttemplate);
 //BA.debugLineNum = 874;BA.debugLine="Dialog.Close(RESULT_SHOWING_NESTED_DIALOG)";
_dialog._close /*boolean*/ (_result_showing_nested_dialog);
 //BA.debugLineNum = 875;BA.debugLine="End Sub";
return "";
}
public String  _lbloptions_click() throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pref = null;
 //BA.debugLineNum = 820;BA.debugLine="Private Sub lblOptions_Click";
 //BA.debugLineNum = 822;BA.debugLine="NestedDialogItemIndex = CustomListView1.GetItemFr";
_nesteddialogitemindex = _customlistview1._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
 //BA.debugLineNum = 823;BA.debugLine="Dim pref As B4XPrefItem = CustomListView1.GetValu";
_pref = (asahi.alert.preferencesdialog._b4xprefitem)(_customlistview1._getvalue(_nesteddialogitemindex));
 //BA.debugLineNum = 824;BA.debugLine="Dialog.Title = pref.Title";
_dialog._title /*Object*/  = _pref.Title /*Object*/ ;
 //BA.debugLineNum = 825;BA.debugLine="If pref.Extra.ContainsKey(\"index\") Then";
if (_pref.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .ContainsKey((Object)("index"))) { 
 //BA.debugLineNum = 826;BA.debugLine="SearchTemplate.SetIndex(pref.Extra.Get(\"index\"))";
_searchtemplate._setindex /*String*/ (_pref.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("index")));
 }else {
 //BA.debugLineNum = 828;BA.debugLine="pref.Extra.Put(\"index\", SearchTemplate.SetItems(";
_pref.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("index"),_searchtemplate._setitems /*Object*/ ((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_pref.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Get((Object)("options"))))));
 };
 //BA.debugLineNum = 830;BA.debugLine="SearchTemplate.SelectedItem = CustomListView1.Get";
_searchtemplate._selecteditem /*String*/  = _customlistview1._getpanel(_nesteddialogitemindex).GetView((int) (1)).getText();
 //BA.debugLineNum = 831;BA.debugLine="Template = SearchTemplate";
_template = (Object)(_searchtemplate);
 //BA.debugLineNum = 832;BA.debugLine="Dialog.Close(RESULT_SHOWING_NESTED_DIALOG)";
_dialog._close /*boolean*/ (_result_showing_nested_dialog);
 //BA.debugLineNum = 833;BA.debugLine="End Sub";
return "";
}
public String  _loadfromjson(String _json) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _p = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _theme = "";
anywheresoftware.b4a.objects.collections.List _items = null;
anywheresoftware.b4a.objects.collections.Map _item = null;
String _key = "";
String _title = "";
boolean _required = false;
String _itemtype = "";
anywheresoftware.b4a.objects.collections.List _l = null;
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
String _text = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
 //BA.debugLineNum = 109;BA.debugLine="Public Sub LoadFromJson (Json As String)";
 //BA.debugLineNum = 110;BA.debugLine="Dim p As JSONParser";
_p = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 111;BA.debugLine="p.Initialize(Json)";
_p.Initialize(_json);
 //BA.debugLineNum = 112;BA.debugLine="Dim m As Map = p.NextObject";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = _p.NextObject();
 //BA.debugLineNum = 113;BA.debugLine="Dim theme As String = m.GetDefault(\"Theme\", \"Dark";
_theme = BA.ObjectToString(_m.GetDefault((Object)("Theme"),(Object)("Dark Theme")));
 //BA.debugLineNum = 114;BA.debugLine="Select theme";
switch (BA.switchObjectToInt(_theme,"Dark Theme","Light Theme")) {
case 0: {
 //BA.debugLineNum = 116;BA.debugLine="setTheme(THEME_DARK)";
_settheme(_theme_dark);
 break; }
case 1: {
 //BA.debugLineNum = 118;BA.debugLine="setTheme(THEME_LIGHT)";
_settheme(_theme_light);
 break; }
}
;
 //BA.debugLineNum = 120;BA.debugLine="Dim items As List = m.Get(\"Items\")";
_items = new anywheresoftware.b4a.objects.collections.List();
_items = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_m.Get((Object)("Items"))));
 //BA.debugLineNum = 121;BA.debugLine="For Each item As Map In items";
_item = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group12 = _items;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_item = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (java.util.Map)(group12.Get(index12)));
 //BA.debugLineNum = 122;BA.debugLine="Dim key As String = item.Get(\"key\")";
_key = BA.ObjectToString(_item.Get((Object)("key")));
 //BA.debugLineNum = 123;BA.debugLine="Dim title As String = item.Get(\"title\")";
_title = BA.ObjectToString(_item.Get((Object)("title")));
 //BA.debugLineNum = 124;BA.debugLine="Dim required As Boolean = item.Get(\"required\")";
_required = BA.ObjectToBoolean(_item.Get((Object)("required")));
 //BA.debugLineNum = 125;BA.debugLine="Dim itemType As String = item.Get(\"type\")";
_itemtype = BA.ObjectToString(_item.Get((Object)("type")));
 //BA.debugLineNum = 126;BA.debugLine="Select itemType";
switch (BA.switchObjectToInt(_itemtype,"Separator","Boolean","Text","Date","Short Options","Color","Number","Password","Options","Decimal Number","Multiline Text","Time","Numeric Range","Explanation")) {
case 0: {
 //BA.debugLineNum = 128;BA.debugLine="AddSeparator(title)";
_addseparator((Object)(_title));
 break; }
case 1: {
 //BA.debugLineNum = 130;BA.debugLine="AddBooleanItem(key, title)";
_addbooleanitem(_key,(Object)(_title));
 break; }
case 2: {
 //BA.debugLineNum = 132;BA.debugLine="AddTextItem(key, title)";
_addtextitem(_key,(Object)(_title));
 break; }
case 3: {
 //BA.debugLineNum = 134;BA.debugLine="AddDateItem(key, title)";
_adddateitem(_key,(Object)(_title));
 break; }
case 4: {
 //BA.debugLineNum = 136;BA.debugLine="AddShortOptionsItem(key, title, item.Get(\"opti";
_addshortoptionsitem(_key,(Object)(_title),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options")))));
 break; }
case 5: {
 //BA.debugLineNum = 138;BA.debugLine="AddColorItem(key, title)";
_addcoloritem(_key,(Object)(_title));
 break; }
case 6: {
 //BA.debugLineNum = 140;BA.debugLine="AddNumberItem(key, title)";
_addnumberitem(_key,(Object)(_title));
 break; }
case 7: {
 //BA.debugLineNum = 142;BA.debugLine="AddPasswordItem(key, title)";
_addpassworditem(_key,(Object)(_title));
 break; }
case 8: {
 //BA.debugLineNum = 144;BA.debugLine="AddOptionsItem(key, title, item.Get(\"options\")";
_addoptionsitem(_key,(Object)(_title),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options")))));
 break; }
case 9: {
 //BA.debugLineNum = 146;BA.debugLine="AddDecimalNumberItem(key, title)";
_adddecimalnumberitem(_key,(Object)(_title));
 break; }
case 10: {
 //BA.debugLineNum = 148;BA.debugLine="Dim l As List = item.Get(\"options\")";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options"))));
 //BA.debugLineNum = 149;BA.debugLine="If l.IsInitialized = False Or l.Size = 0 Or Is";
if (_l.IsInitialized()==__c.False || _l.getSize()==0 || __c.IsNumber(BA.ObjectToString(_l.Get((int) (0))))==__c.False) { 
 //BA.debugLineNum = 150;BA.debugLine="AddMultilineTextItem(key, title, 100dip)";
_addmultilinetextitem(_key,(Object)(_title),__c.DipToCurrent((int) (100)));
 }else {
 //BA.debugLineNum = 152;BA.debugLine="AddMultilineTextItem(key, title, DipToCurrent";
_addmultilinetextitem(_key,(Object)(_title),__c.DipToCurrent((int)(BA.ObjectToNumber(_l.Get((int) (0))))));
 };
 break; }
case 11: {
 //BA.debugLineNum = 155;BA.debugLine="AddTimeItem(key, title)";
_addtimeitem(_key,(Object)(_title));
 //BA.debugLineNum = 156;BA.debugLine="Dim l As List = item.Get(\"options\")";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options"))));
 //BA.debugLineNum = 157;BA.debugLine="If l.IsInitialized And l.Size > 0 Then";
if (_l.IsInitialized() && _l.getSize()>0) { 
 //BA.debugLineNum = 158;BA.debugLine="Dim pi As B4XPrefItem = PrefItems.Get(PrefIte";
_pi = (asahi.alert.preferencesdialog._b4xprefitem)(_prefitems.Get((int) (_prefitems.getSize()-1)));
 //BA.debugLineNum = 159;BA.debugLine="pi.Extra.Put(\"24\", l.Get(0) = \"24\")";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("24"),(Object)((_l.Get((int) (0))).equals((Object)("24"))));
 };
 break; }
case 12: {
 //BA.debugLineNum = 163;BA.debugLine="Dim l As List = item.Get(\"options\")";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options"))));
 //BA.debugLineNum = 164;BA.debugLine="If l.IsInitialized = False Or l.Size < 3 Or Is";
if (_l.IsInitialized()==__c.False || _l.getSize()<3 || __c.IsNumber(BA.ObjectToString(_l.Get((int) (0))))==__c.False || __c.IsNumber(BA.ObjectToString(_l.Get((int) (1))))==__c.False || __c.IsNumber(BA.ObjectToString(_l.Get((int) (2))))==__c.False) { 
 //BA.debugLineNum = 165;BA.debugLine="AddNumericRangeItem(key, title, 0, 100, 1)";
_addnumericrangeitem(_key,(Object)(_title),0,100,1);
 }else {
 //BA.debugLineNum = 167;BA.debugLine="AddNumericRangeItem(key, title, l.Get(0), l.G";
_addnumericrangeitem(_key,(Object)(_title),(double)(BA.ObjectToNumber(_l.Get((int) (0)))),(double)(BA.ObjectToNumber(_l.Get((int) (1)))),(double)(BA.ObjectToNumber(_l.Get((int) (2)))));
 };
 break; }
case 13: {
 //BA.debugLineNum = 170;BA.debugLine="Dim l As List = item.Get(\"options\")";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_item.Get((Object)("options"))));
 //BA.debugLineNum = 171;BA.debugLine="Dim text As String";
_text = "";
 //BA.debugLineNum = 172;BA.debugLine="If l.IsInitialized Then";
if (_l.IsInitialized()) { 
 //BA.debugLineNum = 173;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 174;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 175;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step65 = 1;
final int limit65 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit65 ;_i = _i + step65 ) {
 //BA.debugLineNum = 176;BA.debugLine="If i > 0 Then sb.Append(CRLF)";
if (_i>0) { 
_sb.Append(__c.CRLF);};
 //BA.debugLineNum = 177;BA.debugLine="sb.Append(l.Get(i))";
_sb.Append(BA.ObjectToString(_l.Get(_i)));
 }
};
 //BA.debugLineNum = 179;BA.debugLine="text = sb.ToString";
_text = _sb.ToString();
 };
 //BA.debugLineNum = 181;BA.debugLine="AddExplanationItem(key, title, text)";
_addexplanationitem(_key,(Object)(_title),(Object)(_text));
 break; }
}
;
 //BA.debugLineNum = 183;BA.debugLine="Dim pi As B4XPrefItem = PrefItems.Get(PrefItems.";
_pi = (asahi.alert.preferencesdialog._b4xprefitem)(_prefitems.Get((int) (_prefitems.getSize()-1)));
 //BA.debugLineNum = 184;BA.debugLine="pi.Required = required";
_pi.Required /*boolean*/  = _required;
 }
};
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public String  _raisebeforedialogdisplayed(Object _temp) throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Private Sub RaiseBeforeDialogDisplayed (Temp As Ob";
 //BA.debugLineNum = 361;BA.debugLine="If mEventName <> \"\" And  xui.SubExists(mCallback,";
if ((_meventname).equals("") == false && _xui.SubExists(ba,_mcallback,_meventname+"_BeforeDialogDisplayed",(int) (1))) { 
 //BA.debugLineNum = 362;BA.debugLine="CallSub2(mCallback, mEventName & \"_BeforeDialogD";
__c.CallSubNew2(ba,_mcallback,_meventname+"_BeforeDialogDisplayed",_temp);
 };
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return "";
}
public String  _scrolltoitemwitherror(String _key) throws Exception{
int _i = 0;
b4a.example3.customlistview._clvitem _item = null;
asahi.alert.preferencesdialog._b4xprefitem _prefitem = null;
 //BA.debugLineNum = 777;BA.debugLine="Public Sub ScrollToItemWithError (key As String)";
 //BA.debugLineNum = 778;BA.debugLine="For i = 0 To CustomListView1.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_customlistview1._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 779;BA.debugLine="Dim Item As CLVItem = CustomListView1.GetRawList";
_item = _customlistview1._getrawlistitem(_i);
 //BA.debugLineNum = 780;BA.debugLine="Dim PrefItem As B4XPrefItem = Item.Value";
_prefitem = (asahi.alert.preferencesdialog._b4xprefitem)(_item.Value);
 //BA.debugLineNum = 781;BA.debugLine="If PrefItem.Key = key Then";
if ((_prefitem.Key /*String*/ ).equals(_key)) { 
 //BA.debugLineNum = 782;BA.debugLine="GoToItem(i)";
_gotoitem(_i);
 //BA.debugLineNum = 783;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 786;BA.debugLine="End Sub";
return "";
}
public String  _setbackgroundtintlist(anywheresoftware.b4a.objects.ConcreteViewWrapper _view,int _active,int _enabled) throws Exception{
int[][] _states = null;
int[] _color = null;
anywheresoftware.b4j.object.JavaObject _csl = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 918;BA.debugLine="Private Sub SetBackgroundTintList(View As View,Act";
 //BA.debugLineNum = 919;BA.debugLine="Dim States(2,1) As Int";
_states = new int[(int) (2)][];
{
int d0 = _states.length;
int d1 = (int) (1);
for (int i0 = 0;i0 < d0;i0++) {
_states[i0] = new int[d1];
}
}
;
 //BA.debugLineNum = 920;BA.debugLine="States(0,0) = 16842908     'Active";
_states[(int) (0)][(int) (0)] = (int) (16842908);
 //BA.debugLineNum = 921;BA.debugLine="States(1,0) = 16842910    'Enabled";
_states[(int) (1)][(int) (0)] = (int) (16842910);
 //BA.debugLineNum = 922;BA.debugLine="Dim Color(2) As Int = Array As Int(Active,Enabled";
_color = new int[]{_active,_enabled};
 //BA.debugLineNum = 923;BA.debugLine="Dim CSL As JavaObject";
_csl = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 924;BA.debugLine="CSL.InitializeNewInstance(\"android.content.res.Co";
_csl.InitializeNewInstance("android.content.res.ColorStateList",new Object[]{(Object)(_states),(Object)(_color)});
 //BA.debugLineNum = 925;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 926;BA.debugLine="jo.InitializeStatic(\"android.support.v4.view.View";
_jo.InitializeStatic("androidx.core.view.ViewCompat");
 //BA.debugLineNum = 927;BA.debugLine="jo.RunMethod(\"setBackgroundTintList\", Array(View,";
_jo.RunMethod("setBackgroundTintList",new Object[]{(Object)(_view.getObject()),(Object)(_csl.getObject())});
 //BA.debugLineNum = 928;BA.debugLine="End Sub";
return "";
}
public String  _seteventslistener(Object _callback,String _eventname) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Public Sub SetEventsListener(Callback As Object, E";
 //BA.debugLineNum = 65;BA.debugLine="mCallback = Callback";
_mcallback = _callback;
 //BA.debugLineNum = 66;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public String  _setexplanation(String _key,Object _explanation) throws Exception{
 //BA.debugLineNum = 892;BA.debugLine="Public Sub SetExplanation (Key As String, Explanat";
 //BA.debugLineNum = 893;BA.debugLine="GetPrefItem(Key).Extra.Put(\"text\", Explanation)";
_getprefitem(_key).Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("text"),_explanation);
 //BA.debugLineNum = 894;BA.debugLine="End Sub";
return "";
}
public String  _setlabelcolor(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,int _clr) throws Exception{
asahi.alert.b4xfloattextfield _ft = null;
 //BA.debugLineNum = 435;BA.debugLine="Private Sub SetLabelColor(lbl As B4XView, clr As I";
 //BA.debugLineNum = 436;BA.debugLine="Dim ft As B4XFloatTextField = lbl.Parent.GetView(";
_ft = (asahi.alert.b4xfloattextfield)(_lbl.getParent().GetView((int) (0)).getTag());
 //BA.debugLineNum = 437;BA.debugLine="ft.Text = ColorToHex(clr)";
_ft._settext /*String*/ (_colortohex(_clr));
 //BA.debugLineNum = 438;BA.debugLine="lbl.SetColorAndBorder(clr, 1dip, Dialog.BorderCol";
_lbl.SetColorAndBorder(_clr,__c.DipToCurrent((int) (1)),_dialog._bordercolor /*int*/ ,__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _setoptions(String _key,anywheresoftware.b4a.objects.collections.List _options) throws Exception{
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
 //BA.debugLineNum = 884;BA.debugLine="Public Sub SetOptions (Key As String, Options As L";
 //BA.debugLineNum = 885;BA.debugLine="Dim pi As B4XPrefItem = GetPrefItem(Key)";
_pi = _getprefitem(_key);
 //BA.debugLineNum = 886;BA.debugLine="If pi.Extra.IsInitialized = False Then";
if (_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .IsInitialized()==__c.False) { 
 //BA.debugLineNum = 887;BA.debugLine="pi.Extra.Initialize";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
 };
 //BA.debugLineNum = 889;BA.debugLine="pi.Extra.Put(\"options\", Options)";
_pi.Extra /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("options"),(Object)(_options.getObject()));
 //BA.debugLineNum = 890;BA.debugLine="End Sub";
return "";
}
public String  _settheme(int _t) throws Exception{
int _dividercolor = 0;
b4a.example3.customlistview _clv = null;
anywheresoftware.b4a.objects.B4XViewWrapper _b = null;
 //BA.debugLineNum = 449;BA.debugLine="Public Sub setTheme (t As Int)";
 //BA.debugLineNum = 450;BA.debugLine="If t <> mTheme Then";
if (_t!=_mtheme) { 
 //BA.debugLineNum = 451;BA.debugLine="mTheme = t";
_mtheme = _t;
 //BA.debugLineNum = 452;BA.debugLine="CustomListView1.Clear";
_customlistview1._clear();
 //BA.debugLineNum = 453;BA.debugLine="Dim DividerColor As Int";
_dividercolor = 0;
 //BA.debugLineNum = 454;BA.debugLine="Select mTheme";
switch (BA.switchObjectToInt(_mtheme,_theme_dark,_theme_light)) {
case 0: {
 //BA.debugLineNum = 456;BA.debugLine="ItemsBackgroundColor = 0xFF626262";
_itemsbackgroundcolor = ((int)0xff626262);
 //BA.debugLineNum = 457;BA.debugLine="SeparatorBackgroundColor = 0xFFC0C0C0";
_separatorbackgroundcolor = ((int)0xffc0c0c0);
 //BA.debugLineNum = 458;BA.debugLine="SeparatorTextColor = xui.Color_Black";
_separatortextcolor = _xui.Color_Black;
 //BA.debugLineNum = 459;BA.debugLine="TextColor = xui.Color_White";
_textcolor = _xui.Color_White;
 //BA.debugLineNum = 460;BA.debugLine="DividerColor = 0xFF464646";
_dividercolor = ((int)0xff464646);
 //BA.debugLineNum = 461;BA.debugLine="Dialog.BackgroundColor = 0xFF555555";
_dialog._backgroundcolor /*int*/  = ((int)0xff555555);
 //BA.debugLineNum = 462;BA.debugLine="Dialog.ButtonsColor = 0xFF555555";
_dialog._buttonscolor /*int*/  = ((int)0xff555555);
 //BA.debugLineNum = 463;BA.debugLine="Dialog.BorderColor = 0xff000000";
_dialog._bordercolor /*int*/  = ((int)0xff000000);
 //BA.debugLineNum = 464;BA.debugLine="Dialog.ButtonsTextColor = 0xFF89D5FF";
_dialog._buttonstextcolor /*int*/  = ((int)0xff89d5ff);
 //BA.debugLineNum = 465;BA.debugLine="DateTemplate.DaysInWeekColor = xui.Color_Gray";
_datetemplate._daysinweekcolor /*int*/  = _xui.Color_Gray;
 //BA.debugLineNum = 466;BA.debugLine="DateTemplate.SelectedColor = 0xFF0BA29B";
_datetemplate._selectedcolor /*int*/  = ((int)0xff0ba29b);
 break; }
case 1: {
 //BA.debugLineNum = 468;BA.debugLine="ItemsBackgroundColor = xui.Color_White";
_itemsbackgroundcolor = _xui.Color_White;
 //BA.debugLineNum = 469;BA.debugLine="SeparatorBackgroundColor = 0xFFD0D0D0";
_separatorbackgroundcolor = ((int)0xffd0d0d0);
 //BA.debugLineNum = 470;BA.debugLine="SeparatorTextColor = 0xFF4E4F50";
_separatortextcolor = ((int)0xff4e4f50);
 //BA.debugLineNum = 471;BA.debugLine="TextColor = 0xFF5B5B5B";
_textcolor = ((int)0xff5b5b5b);
 //BA.debugLineNum = 472;BA.debugLine="DividerColor = 0xFFDFDFDF";
_dividercolor = ((int)0xffdfdfdf);
 //BA.debugLineNum = 473;BA.debugLine="Dialog.BackgroundColor = xui.Color_White";
_dialog._backgroundcolor /*int*/  = _xui.Color_White;
 //BA.debugLineNum = 474;BA.debugLine="Dialog.ButtonsColor = xui.Color_White";
_dialog._buttonscolor /*int*/  = _xui.Color_White;
 //BA.debugLineNum = 475;BA.debugLine="Dialog.BorderColor = xui.Color_Gray";
_dialog._bordercolor /*int*/  = _xui.Color_Gray;
 //BA.debugLineNum = 476;BA.debugLine="Dialog.ButtonsTextColor = 0xFF007DC3";
_dialog._buttonstextcolor /*int*/  = ((int)0xff007dc3);
 //BA.debugLineNum = 477;BA.debugLine="DateTemplate.DaysInWeekColor = xui.Color_Black";
_datetemplate._daysinweekcolor /*int*/  = _xui.Color_Black;
 //BA.debugLineNum = 478;BA.debugLine="DateTemplate.SelectedColor = 0xFF39D7CE";
_datetemplate._selectedcolor /*int*/  = ((int)0xff39d7ce);
 break; }
}
;
 //BA.debugLineNum = 481;BA.debugLine="SearchTemplate.SearchField.TextField.TextColor =";
_searchtemplate._searchfield /*asahi.alert.b4xfloattextfield*/ ._gettextfield /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().setTextColor(_textcolor);
 //BA.debugLineNum = 482;BA.debugLine="SearchTemplate.SearchField.NonFocusedHintColor =";
_searchtemplate._searchfield /*asahi.alert.b4xfloattextfield*/ ._nonfocusedhintcolor /*int*/  = _textcolor;
 //BA.debugLineNum = 483;BA.debugLine="Dialog.BorderCornersRadius = 0";
_dialog._bordercornersradius /*int*/  = (int) (0);
 //BA.debugLineNum = 484;BA.debugLine="Dialog.BorderWidth = 1dip";
_dialog._borderwidth /*int*/  = __c.DipToCurrent((int) (1));
 //BA.debugLineNum = 485;BA.debugLine="DateTemplate.HighlightedColor = 0xFF00CEFF";
_datetemplate._highlightedcolor /*int*/  = ((int)0xff00ceff);
 //BA.debugLineNum = 486;BA.debugLine="DateTemplate.DaysInMonthColor = TextColor";
_datetemplate._daysinmonthcolor /*int*/  = _textcolor;
 //BA.debugLineNum = 487;BA.debugLine="DateTemplate.lblMonth.TextColor = TextColor";
_datetemplate._lblmonth /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTextColor(_textcolor);
 //BA.debugLineNum = 488;BA.debugLine="DateTemplate.lblYear.TextColor = TextColor";
_datetemplate._lblyear /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTextColor(_textcolor);
 //BA.debugLineNum = 489;BA.debugLine="For Each clv As CustomListView In Array(CustomLi";
{
final Object[] group39 = new Object[]{(Object)(_customlistview1),(Object)(_searchtemplate._customlistview1 /*b4a.example3.customlistview*/ ),(Object)(_longtexttemplate._customlistview1 /*b4a.example3.customlistview*/ )};
final int groupLen39 = group39.length
;int index39 = 0;
;
for (; index39 < groupLen39;index39++){
_clv = (b4a.example3.customlistview)(group39[index39]);
 //BA.debugLineNum = 490;BA.debugLine="clv.sv.ScrollViewInnerPanel.Color = DividerColo";
_clv._sv.getScrollViewInnerPanel().setColor(_dividercolor);
 //BA.debugLineNum = 491;BA.debugLine="clv.sv.Color = Dialog.BackgroundColor";
_clv._sv.setColor(_dialog._backgroundcolor /*int*/ );
 //BA.debugLineNum = 492;BA.debugLine="clv.DefaultTextBackgroundColor = ItemsBackgroun";
_clv._defaulttextbackgroundcolor = _itemsbackgroundcolor;
 //BA.debugLineNum = 493;BA.debugLine="clv.DefaultTextColor = TextColor";
_clv._defaulttextcolor = _textcolor;
 }
};
 //BA.debugLineNum = 501;BA.debugLine="For Each b As B4XView In Array(DateTemplate.btnM";
_b = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final Object[] group45 = new Object[]{(Object)(_datetemplate._btnmonthleft /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(Object)(_datetemplate._btnmonthright /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(Object)(_datetemplate._btnyearleft /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(Object)(_datetemplate._btnyearright /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject())};
final int groupLen45 = group45.length
;int index45 = 0;
;
for (; index45 < groupLen45;index45++){
_b = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(group45[index45]));
 //BA.debugLineNum = 502;BA.debugLine="b.Color = xui.Color_Transparent";
_b.setColor(_xui.Color_Transparent);
 //BA.debugLineNum = 503;BA.debugLine="b.TextColor = TextColor";
_b.setTextColor(_textcolor);
 }
};
 };
 //BA.debugLineNum = 510;BA.debugLine="End Sub";
return "";
}
public String  _settitle(Object _o) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Public Sub setTitle(o As Object)";
 //BA.debugLineNum = 74;BA.debugLine="mTitle = o";
_mtitle = _o;
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _show(asahi.alert.b4xdialog _dialog1) throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Private Sub Show (Dialog1 As B4XDialog) 'ignore";
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _showdialog(anywheresoftware.b4a.objects.collections.Map _data,Object _yes,Object _cancel) throws Exception{
ResumableSub_ShowDialog rsub = new ResumableSub_ShowDialog(this,_data,_yes,_cancel);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ShowDialog extends BA.ResumableSub {
public ResumableSub_ShowDialog(asahi.alert.preferencesdialog parent,anywheresoftware.b4a.objects.collections.Map _data,Object _yes,Object _cancel) {
this.parent = parent;
this._data = _data;
this._yes = _yes;
this._cancel = _cancel;
}
asahi.alert.preferencesdialog parent;
anywheresoftware.b4a.objects.collections.Map _data;
Object _yes;
Object _cancel;
asahi.alert.b4xfloattextfield _lasttextfield = null;
asahi.alert.preferencesdialog._b4xprefitem _pi = null;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
asahi.alert.b4xfloattextfield _tf = null;
int _scrollviewoffset = 0;
Object _rs = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
int _result = 0;
Object _y = null;
Object _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
String _value = "";
anywheresoftware.b4a.BA.IterableList group3;
int index3;
int groupLen3;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 282;BA.debugLine="If CustomListView1.Size = 0 Then";
if (true) break;

case 1:
//if
this.state = 21;
if (parent._customlistview1._getsize()==0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 283;BA.debugLine="Dim LastTextField As B4XFloatTextField";
_lasttextfield = new asahi.alert.b4xfloattextfield();
 //BA.debugLineNum = 284;BA.debugLine="For Each pi As B4XPrefItem In PrefItems";
if (true) break;

case 4:
//for
this.state = 15;
group3 = parent._prefitems;
index3 = 0;
groupLen3 = group3.getSize();
this.state = 64;
if (true) break;

case 64:
//C
this.state = 15;
if (index3 < groupLen3) {
this.state = 6;
_pi = (asahi.alert.preferencesdialog._b4xprefitem)(group3.Get(index3));}
if (true) break;

case 65:
//C
this.state = 64;
index3++;
if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 285;BA.debugLine="Dim pnl As B4XView = CreateLayouts(pi)";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = parent._createlayouts(_pi);
 //BA.debugLineNum = 286;BA.debugLine="CustomListView1.Add (pnl, pi)";
parent._customlistview1._add(_pnl,(Object)(_pi));
 //BA.debugLineNum = 287;BA.debugLine="If pnl.GetView(0).Tag Is B4XFloatTextField Then";
if (true) break;

case 7:
//if
this.state = 14;
if (_pnl.GetView((int) (0)).getTag() instanceof asahi.alert.b4xfloattextfield) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 288;BA.debugLine="Dim tf As B4XFloatTextField = pnl.GetView(0).T";
_tf = (asahi.alert.b4xfloattextfield)(_pnl.GetView((int) (0)).getTag());
 //BA.debugLineNum = 289;BA.debugLine="If LastTextField.IsInitialized Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_lasttextfield.IsInitialized /*boolean*/ ()) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 290;BA.debugLine="LastTextField.NextField = tf";
_lasttextfield._setnextfield /*asahi.alert.b4xfloattextfield*/ (_tf);
 if (true) break;

case 13:
//C
this.state = 14;
;
 //BA.debugLineNum = 292;BA.debugLine="LastTextField = tf";
_lasttextfield = _tf;
 if (true) break;

case 14:
//C
this.state = 65;
;
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 297;BA.debugLine="If LastTextField.IsInitialized Then LastTextFiel";

case 15:
//if
this.state = 20;
if (_lasttextfield.IsInitialized /*boolean*/ ()) { 
this.state = 17;
;}if (true) break;

case 17:
//C
this.state = 20;
_lasttextfield._setnextfield /*asahi.alert.b4xfloattextfield*/ (_lasttextfield);
if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 300;BA.debugLine="Dialog.InternalAddStubToCLVIfNeeded(CustomListVi";
parent._dialog._internaladdstubtoclvifneeded /*String*/ (parent._customlistview1,parent._customlistview1._defaulttextbackgroundcolor);
 if (true) break;

case 21:
//C
this.state = 22;
;
 //BA.debugLineNum = 302;BA.debugLine="FillData (Data)";
parent._filldata(_data);
 //BA.debugLineNum = 303;BA.debugLine="Dim ScrollViewOffset As Int 'ignore";
_scrollviewoffset = 0;
 //BA.debugLineNum = 304;BA.debugLine="Do While True";
if (true) break;

case 22:
//do while
this.state = 63;
while (parent.__c.True) {
this.state = 24;
if (true) break;
}
if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 305;BA.debugLine="Dialog.Title = mTitle";
parent._dialog._title /*Object*/  = parent._mtitle;
 //BA.debugLineNum = 306;BA.debugLine="Dialog.PutAtTop = xui.IsB4A Or xui.IsB4i";
parent._dialog._putattop /*boolean*/  = parent._xui.getIsB4A() || parent._xui.getIsB4i();
 //BA.debugLineNum = 307;BA.debugLine="Dim rs As Object = Dialog.ShowTemplate(Me, Yes,";
_rs = parent._dialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent,_yes,(Object)(""),_cancel);
 //BA.debugLineNum = 309;BA.debugLine="If ScrollViewOffset > 0 Then";
if (true) break;

case 25:
//if
this.state = 28;
if (_scrollviewoffset>0) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 310;BA.debugLine="Sleep(50)";
parent.__c.Sleep(ba,this,(int) (50));
this.state = 66;
return;
case 66:
//C
this.state = 28;
;
 //BA.debugLineNum = 311;BA.debugLine="Dim sv As ScrollView = CustomListView1.sv";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
_sv = (anywheresoftware.b4a.objects.ScrollViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ScrollViewWrapper(), (android.widget.ScrollView)(parent._customlistview1._sv.getObject()));
 //BA.debugLineNum = 312;BA.debugLine="sv.ScrollToNow(ScrollViewOffset)";
_sv.ScrollToNow(_scrollviewoffset);
 if (true) break;

case 28:
//C
this.state = 29;
;
 //BA.debugLineNum = 315;BA.debugLine="RaiseBeforeDialogDisplayed(Me)";
parent._raisebeforedialogdisplayed(parent);
 //BA.debugLineNum = 316;BA.debugLine="Wait For (rs) Complete (Result As Int)";
parent.__c.WaitFor("complete", ba, this, _rs);
this.state = 67;
return;
case 67:
//C
this.state = 29;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 317;BA.debugLine="ScrollViewOffset = CustomListView1.sv.ScrollView";
_scrollviewoffset = parent._customlistview1._sv.getScrollViewOffsetY();
 //BA.debugLineNum = 318;BA.debugLine="If Result <> RESULT_SHOWING_NESTED_DIALOG Then";
if (true) break;

case 29:
//if
this.state = 62;
if (_result!=parent._result_showing_nested_dialog) { 
this.state = 31;
}else {
this.state = 41;
}if (true) break;

case 31:
//C
this.state = 32;
 //BA.debugLineNum = 319;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 32:
//if
this.state = 39;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 34;
}if (true) break;

case 34:
//C
this.state = 35;
 //BA.debugLineNum = 320;BA.debugLine="If CommitChanges(Data) = False Then";
if (true) break;

case 35:
//if
this.state = 38;
if (parent._commitchanges(_data)==parent.__c.False) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
 //BA.debugLineNum = 321;BA.debugLine="ScrollViewOffset = 0";
_scrollviewoffset = (int) (0);
 //BA.debugLineNum = 322;BA.debugLine="Continue";
this.state = 22;
if (true) break;;
 if (true) break;

case 38:
//C
this.state = 39;
;
 if (true) break;

case 39:
//C
this.state = 62;
;
 //BA.debugLineNum = 325;BA.debugLine="Return Result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
 if (true) break;

case 41:
//C
this.state = 42;
 //BA.debugLineNum = 327;BA.debugLine="Dim y As Object";
_y = new Object();
 //BA.debugLineNum = 328;BA.debugLine="Dim c As Object = Cancel";
_c = _cancel;
 //BA.debugLineNum = 329;BA.debugLine="If Template = ColorTemplate Then";
if (true) break;

case 42:
//if
this.state = 49;
if ((parent._template).equals((Object)(parent._colortemplate))) { 
this.state = 44;
}else if((parent._template).equals((Object)(parent._longtexttemplate))) { 
this.state = 46;
}else {
this.state = 48;
}if (true) break;

case 44:
//C
this.state = 49;
 //BA.debugLineNum = 330;BA.debugLine="y = Yes";
_y = _yes;
 if (true) break;

case 46:
//C
this.state = 49;
 //BA.debugLineNum = 332;BA.debugLine="y = Yes";
_y = _yes;
 //BA.debugLineNum = 333;BA.debugLine="c = \"\"";
_c = (Object)("");
 if (true) break;

case 48:
//C
this.state = 49;
 //BA.debugLineNum = 335;BA.debugLine="y = \"\"";
_y = (Object)("");
 if (true) break;

case 49:
//C
this.state = 50;
;
 //BA.debugLineNum = 337;BA.debugLine="Dialog.PutAtTop = xui.IsB4A Or xui.IsB4i";
parent._dialog._putattop /*boolean*/  = parent._xui.getIsB4A() || parent._xui.getIsB4i();
 //BA.debugLineNum = 338;BA.debugLine="Dim rs As Object = Dialog.ShowTemplate(Template";
_rs = parent._dialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (parent._template,_y,(Object)(""),_c);
 //BA.debugLineNum = 339;BA.debugLine="RaiseBeforeDialogDisplayed(Template)";
parent._raisebeforedialogdisplayed(parent._template);
 //BA.debugLineNum = 340;BA.debugLine="Wait For (rs) Complete (Result As Int)";
parent.__c.WaitFor("complete", ba, this, _rs);
this.state = 68;
return;
case 68:
//C
this.state = 50;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 341;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 50:
//if
this.state = 61;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 52;
}if (true) break;

case 52:
//C
this.state = 53;
 //BA.debugLineNum = 342;BA.debugLine="Dim lbl As B4XView = CustomListView1.GetPanel(";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = parent._customlistview1._getpanel(parent._nesteddialogitemindex).GetView((int) (1));
 //BA.debugLineNum = 343;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 344;BA.debugLine="If Template = DateTemplate Then";
if (true) break;

case 53:
//if
this.state = 60;
if ((parent._template).equals((Object)(parent._datetemplate))) { 
this.state = 55;
}else if((parent._template).equals((Object)(parent._searchtemplate))) { 
this.state = 57;
}else if((parent._template).equals((Object)(parent._colortemplate))) { 
this.state = 59;
}if (true) break;

case 55:
//C
this.state = 60;
 //BA.debugLineNum = 345;BA.debugLine="value = DateTime.Date(DateTemplate.Date)";
_value = parent.__c.DateTime.Date(parent._datetemplate._getdate /*long*/ ());
 //BA.debugLineNum = 346;BA.debugLine="lbl.Text = value";
_lbl.setText(BA.ObjectToCharSequence(_value));
 if (true) break;

case 57:
//C
this.state = 60;
 //BA.debugLineNum = 348;BA.debugLine="value = SearchTemplate.SelectedItem";
_value = parent._searchtemplate._selecteditem /*String*/ ;
 //BA.debugLineNum = 349;BA.debugLine="lbl.Text = value";
_lbl.setText(BA.ObjectToCharSequence(_value));
 if (true) break;

case 59:
//C
this.state = 60;
 //BA.debugLineNum = 351;BA.debugLine="value = ColorTemplate.SelectedColor";
_value = BA.NumberToString(parent._colortemplate._getselectedcolor /*int*/ ());
 //BA.debugLineNum = 352;BA.debugLine="SetLabelColor(lbl, value)";
parent._setlabelcolor(_lbl,(int)(Double.parseDouble(_value)));
 if (true) break;

case 60:
//C
this.state = 61;
;
 if (true) break;

case 61:
//C
this.state = 62;
;
 if (true) break;

case 62:
//C
this.state = 22;
;
 if (true) break;

case 63:
//C
this.state = -1;
;
 //BA.debugLineNum = 357;BA.debugLine="Return -1 'never happens";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(-1));return;};
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(int _result) throws Exception{
}
public String  _tfcolorcode_enterpressed() throws Exception{
asahi.alert.b4xfloattextfield _ft = null;
int[] _clr = null;
int _index = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 931;BA.debugLine="Private Sub tfColorCode_EnterPressed";
 //BA.debugLineNum = 932;BA.debugLine="Dim ft As B4XFloatTextField = Sender";
_ft = (asahi.alert.b4xfloattextfield)(__c.Sender(ba));
 //BA.debugLineNum = 933;BA.debugLine="Dim clr() As Int = HexToColor(ft.Text)";
_clr = _hextocolor(_ft._gettext /*String*/ ());
 //BA.debugLineNum = 934;BA.debugLine="Dim index As Int = CustomListView1.GetItemFromVie";
_index = _customlistview1._getitemfromview(_ft._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
 //BA.debugLineNum = 935;BA.debugLine="Dim lbl As B4XView = CustomListView1.GetPanel(ind";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _customlistview1._getpanel(_index).GetView((int) (1));
 //BA.debugLineNum = 936;BA.debugLine="If clr.Length = 1 Then";
if (_clr.length==1) { 
 //BA.debugLineNum = 937;BA.debugLine="SetLabelColor(lbl, clr(0))";
_setlabelcolor(_lbl,_clr[(int) (0)]);
 }else {
 //BA.debugLineNum = 939;BA.debugLine="ft.Text = ColorToHex(lbl.Color)";
_ft._settext /*String*/ (_colortohex(_lbl.getColor()));
 };
 //BA.debugLineNum = 941;BA.debugLine="End Sub";
return "";
}
public String  _twolabelslayout(String _eventname,anywheresoftware.b4a.objects.B4XViewWrapper _p,asahi.alert.preferencesdialog._b4xprefitem _prefitem) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lbltitle = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbldate = null;
 //BA.debugLineNum = 801;BA.debugLine="Private Sub TwoLabelsLayout (EventName As String,";
 //BA.debugLineNum = 802;BA.debugLine="Dim lblTitle As B4XView = CreateLabel(EventName)";
_lbltitle = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbltitle = _createlabel(_eventname);
 //BA.debugLineNum = 803;BA.debugLine="lblTitle.SetTextAlignment(\"CENTER\", \"LEFT\")";
_lbltitle.SetTextAlignment("CENTER","LEFT");
 //BA.debugLineNum = 804;BA.debugLine="lblTitle.TextColor = TextColor";
_lbltitle.setTextColor(_textcolor);
 //BA.debugLineNum = 805;BA.debugLine="Dim fnt As B4XFont = xui.CreateDefaultBoldFont(16";
_fnt = _xui.CreateDefaultBoldFont((float) (16));
 //BA.debugLineNum = 806;BA.debugLine="lblTitle.Font = fnt";
_lbltitle.setFont(_fnt);
 //BA.debugLineNum = 807;BA.debugLine="Dialog.InternalSetTextOrCSBuilderToLabel(lblTitle";
_dialog._internalsettextorcsbuildertolabel /*String*/ (_lbltitle,_prefitem.Title /*Object*/ );
 //BA.debugLineNum = 808;BA.debugLine="p.AddView(lblTitle, 10dip, 10dip, p.Width - 110di";
_p.AddView((android.view.View)(_lbltitle.getObject()),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (10)),(int) (_p.getWidth()-__c.DipToCurrent((int) (110))),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 809;BA.debugLine="Dim lblDate As B4XView = CreateLabel(EventName)";
_lbldate = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbldate = _createlabel(_eventname);
 //BA.debugLineNum = 810;BA.debugLine="lblDate.TextColor = TextColor";
_lbldate.setTextColor(_textcolor);
 //BA.debugLineNum = 811;BA.debugLine="lblDate.SetTextAlignment(\"CENTER\", \"RIGHT\")";
_lbldate.SetTextAlignment("CENTER","RIGHT");
 //BA.debugLineNum = 812;BA.debugLine="lblDate.Font = fnt";
_lbldate.setFont(_fnt);
 //BA.debugLineNum = 813;BA.debugLine="p.AddView(lblDate, p.Width - 108dip, 10dip, 98dip";
_p.AddView((android.view.View)(_lbldate.getObject()),(int) (_p.getWidth()-__c.DipToCurrent((int) (108))),__c.DipToCurrent((int) (10)),__c.DipToCurrent((int) (98)),__c.DipToCurrent((int) (30)));
 //BA.debugLineNum = 814;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "DIALOGCLOSED"))
	return _dialogclosed(((Number)args[0]).intValue());
if (BA.fastSubCompare(sub, "GETPANEL"))
	return _getpanel((asahi.alert.b4xdialog) args[0]);
if (BA.fastSubCompare(sub, "SHOW"))
	return _show((asahi.alert.b4xdialog) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
