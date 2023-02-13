package cn.gail.frame.tools;

import android.util.Log;

import cn.gail.frame.GailConfig;

public final class GLog {

    private static final String TAG = "GLog";

    /**
     * log.i
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg){
        if(GailConfig.isDebug){
            Log.i(tag,msg);
        }
    }

    public static void i(String msg){
        Log.i(TAG,msg);
    }

    /**
     * log.d
     * @param tag
     * @param msg
     */
    public static void d(String tag,String msg){
        if(GailConfig.isDebug){
            Log.d(tag,msg);
        }
    }

    public static void d(String msg){
        d(TAG,msg);
    }

    /**
     * log.e
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg){
        if(GailConfig.isDebug){
            Log.e(tag,msg);
        }
    }

    public static void e(String msg){
        e(TAG,msg);
    }

    /**
     * debug通用
     * @param msg
     */
    public static void debug(String msg){
        d(TAG,msg);
    }

}
