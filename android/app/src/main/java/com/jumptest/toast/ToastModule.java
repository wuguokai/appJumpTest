package com.jumptest.toast;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.jumptest.SecondActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WUGUOKAI on 2017/8/30.
 */

public class ToastModule extends ReactContextBaseJavaModule {
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModule(ReactApplicationContext reactApplicationContext){
        super(reactApplicationContext);
    }

    //ReactContextBaseJavaModule要求派生类实现getName方法。这个函数用于返回一个字符串名字，这个名字在JavaScript端标记这个模块。
    // 这里我们把这个模块叫做ToastExample，这样就可以在JavaScript中通过React.NativeModules.ToastExample访问到这个模块。
    @Override
    public String getName() {
        return "ToastModule";
    }

    //一个可选的方法getContants返回了需要导出给JavaScript使用的常量。
    // 它并不一定需要实现，但在定义一些可以被JavaScript同步访问到的预定义的值时非常有用。
    @Override
    public Map<String, Object> getConstants(){
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    //要导出一个方法给JavaScript使用，Java方法需要使用注解@ReactMethod。方法的返回类型必须为void。
    // React Native的跨语言访问是异步进行的，所以想要给JavaScript返回一个值的唯一办法是使用回调函数或者发送事件
    @ReactMethod
    public void show(String message) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();

        ReactApplicationContext context = getReactApplicationContext();
        /* Intent intent = new Intent(context, SecondActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);*/
//    (String targetpackage, String activity, String view) {
        ComponentName comp = new ComponentName("com.jumptest", "com.jumptest.SecondActivity");
        final Intent intent = new Intent();
        intent.setComponent(comp);
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
