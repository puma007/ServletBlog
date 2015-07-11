package cn.com.utils;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.List;
import java.util.Map;

/**
 * Created by tanhaiyuan on 2015/7/7.
 */
public class Utils {
    public static Boolean ObjectIsNull(Object ob){
        if(ob == null) {
            return true;
        }
        if(ob instanceof String && ob=="" ){
            return true;
        }
        if(ob instanceof List && ((List) ob).size()==0){
            return true;
        }
        if(ob instanceof Map && ((Map) ob).size()==0){
            return true;
        }

        return false;
    }
    public static int ToInt(String str){
        return Integer.parseInt(str);
    }
}
