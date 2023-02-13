package cn.gail.frame;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

import cn.gail.frame.tools.Compare;
import cn.gail.frame.tools.Convert;
import cn.gail.frame.tools.EncryptUtils;

public class GailConfig {

    private static GailConfig helper;
    private String packagename,appName,versionCode;

    private SharedPreferences shared;

    public static boolean isDebug = false;

    private GailConfig(Context context){
        packagename = context.getPackageName();
        appName = context.getString(context.getResources()
                .getIdentifier("app_name", "string", packagename));
        try {
            versionCode  = context.getPackageManager().getPackageInfo(packagename, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionCode  = "0.0.0";
        }
        shared = context.getApplicationContext().getSharedPreferences(EncryptUtils
                .MD5Encoder(appName), Context.MODE_PRIVATE);
    }

    public static void init(Context context){
        if(helper==null){
            synchronized (GailConfig.class){
                if(helper==null){
                    helper = new GailConfig(context);
                }
            }
        }
    }

    public static GailConfig with(){
        if(helper==null){
            throw new IllegalStateException("GailConfig is not yet attached to the "
                    + "Application init.");
        }
        return helper;
    }

    /**
     * 是否开启调试日志
     * @param debug
     */
    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * 获取默认SharedPreferences
     * @return
     */
    public SharedPreferences getStoragePreference(){
        return shared;
    }

    /**
     * 判断是否是新版本
     * @param code
     * @return
     */
    public boolean isNewVersion(String code){
        int[] oldVersion = Convert.StringConvertIntArray(versionCode);
        int[] newVersion = Convert.StringConvertIntArray(code);
        return Compare.CompareIntArray(newVersion,oldVersion)>0;
    }

    /**
     * 获取设备号
     * @return
     */
    public String getDeviceId(){
        String uuid = "";
        return "";
    }

}
