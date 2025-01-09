package Backtracking_ch6;

import java.util.ArrayList;
import java.util.List;

public class Task_Subsets_String {
    public static void main(String[] args) {
        String s = "abc";
        List<String> lst = new ArrayList<>();
        subsets(s , 0  , lst , "");
        System.out.println(lst);
    }
    static void subsets(String s , int n , List<String> lst , String crn){
        if (s.length() == n){
            lst.add(crn);
            return;
        }
        subsets(s , n + 1 , lst , crn + s.charAt(n));
        subsets(s , n + 1 , lst , crn);
    }
}
