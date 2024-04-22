package test1;

import java.util.*;

public class EmailList {

    public static List<String> emailList = new ArrayList<String>();

    public static void PrintEmails() {
        for (String string : emailList) {
            System.out.println(string);
        }
        
    }

}
