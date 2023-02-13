package cn.gail.frame.tools;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换工具类
 */
public final class Convert {

    public static int[] StringConvertIntArray(String from){
        if(TextUtils.isEmpty(from)||from.length()==0){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<from.length();i++){
            char c = from.charAt(i);
            if(48<=c&&c<=57){
                sb.append(c);
            } else {
                list.add(Integer.parseInt(sb.toString()));
                sb = new StringBuffer();
            }
        }
        list.add(Integer.parseInt(sb.toString()));
        int[] array = new int[list.size()];
        for(int i=0;i<list.size();i++){
            array[i] = list.get(i);
        }
        return array;
    }
}
