package cn.gail.frame.tools;

import android.annotation.SuppressLint;

import java.util.Locale;

/**
 * 比较
 */
public final class Compare {
    /**
     * 挨个比较两个一维int数组中数据的大小
     * @param a
     * @param b
     * @return 0相等，1a大于b,-1a小于b
     */
    public static int CompareIntArray(int[] a, int[] b){
        if(a==null||b==null){
            throw new NumberFormatException("a and b can't be empty!");
        }
        GLog.d(String.format("a长度%d,b长度%d",a.length,b.length));
        int len = Math.min(a.length, b.length);
        for(int i=0;i<len;i++){
            int result = CompareNumber(a[i],b[i]);
            GLog.d(String.valueOf(result));
            if(result!=0){
                return result;
            }
        }
        return a.length > len ? 1 : -1;
    }
    public static int CompareNumber(int a,int b){
        if(a>b){
            return 1;
        }else if(a==b){
            return 0;
        }else{
            return -1;
        }
    }
}
