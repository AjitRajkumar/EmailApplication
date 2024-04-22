package test1;

import java.util.*;

public class User {

    public static List<String> UserList = new ArrayList<String>();
    public String name;
    public String email;
    public String password;

    public static void print() {
        for (String names : UserList) {
            System.out.println(names);
        }
        
    }

    public static List<User> EmailUserList = new ArrayList<>();
    public List<EmailObj> Inbox = new ArrayList<>();
    public List<EmailObj> Outbox = new ArrayList<>();

    public static User getObject(String email) {
        for (User user : EmailUserList) {
            if (user.email.equals(email)) {
                return user;
            }
        }
        return null;
    }
}
