package hust.soict.hedspi.aims.utils;
import hust.soict.hedspi.aims.utils.MyDate;
import java.util.*;

public class DateUtils {
    public static boolean compareDate(MyDate d1, MyDate d2){
        if(d1.getYear()> d2.getYear()){
            return true;
        }else if(d1.getYear() < d2.getYear()){
            return false;
        }else{
            if(d1.getMonth() > d2.getMonth()){
                return true;
            }else if(d1.getMonth() < d2.getMonth()){
                return false;
            }else{
                return d1.getDay() > d2.getDay();
            }
        }
    }
    
    public static MyDate[] sort(MyDate list[]){
        MyDate tmp;
        for(int i = 0; i < list.length; i++){
            for(int j = i; j < list.length; j++){
                if(compareDate(list[i], list[j])){
                    tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
        return list;
    }
    
}
