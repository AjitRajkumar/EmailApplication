package test1;

import java.util.Scanner;

public class EmailApplication {
    public static void main(String[] args) {
        int choice;
        System.out.println(
                "============================================================================================================");
        System.out.println();
        System.out.println(
                "====================================Welcome to Email Application============================================");
        System.out.println();
        System.out.println(
                "============================================================================================================");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "============================================================================================================");
            System.out.println("1--->  Create new email user");
            System.out.println(
                    "============================================================================================================");
            System.out.println("2--->  Send Email");
            System.out.println(
                    "============================================================================================================");
            System.out.println("3--->  Login to the Email Account");
            System.out.println(
                    "============================================================================================================");
            System.out.println("4--->  Print Email users details");
            System.out.println(
                    "============================================================================================================");
            System.out.println("99--> Exit the Email application");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Welcome to Email Creation");
                    User u1 = new User();
                    System.out.println("Enter the name of the user");
                    u1.name = sc.next();
                    if (User.UserList.contains(u1.name)) {
                        System.out.println("User name already exist");
                        continue;
                    } else {

                        System.out.println("Enter the new email");
                        String email = sc.next();
                        if (EmailList.emailList.contains(email)) {
                            System.out.println("Email Already Exist. Please try with a new email ID");
                            continue;
                        } else {
                            User.UserList.add(u1.name);
                            u1.email = email;
                            EmailList.emailList.add(email);
                            User.EmailUserList.add(u1);
                        }
                    }
                    // User.print();
                    // EmailList.PrintEmails();
                    // User.EmailUserList.add(u1);
                    break;
                case 2:
                    System.out.println("Entering email sending block ");
                    String from = sc.next();
                    String to = sc.next();
                    String message = sc.next();
                    EmailObj obj = new EmailObj();
                    obj.from = from;
                    obj.to = to;
                    obj.message = message;
                    System.out.println(from + "---" + to + "---" + message);
                    User checkFrom = User.getObject(from);
                    User checkTo = User.getObject(to);
                    if (checkFrom != null && checkTo != null) {
                        EmailApplication.sendEmail(from, to, message, obj);
                    } else {
                        System.out.println("Mail ID is not available :( ,Mail cant be sent ");
                    }
                    break;
                case 3:
                    System.out.println("Welcome to login , Please enter your email");
                    User person = User.getObject(sc.next());
                    System.out.println("Inbox");
                    for (EmailObj inbox : person.Inbox) {
                        System.out.println("================================================================");
                        System.out.println("From: " + inbox.from);
                        System.out.println("To: " + inbox.to);
                        System.out.println("Message: " + inbox.message);
                        System.out.println("================================================================");
                    }
                    System.out.println("Outbox");
                    for (EmailObj outbox : person.Outbox) {
                        System.out.println("================================================================");
                        System.out.println("From:" + outbox.from);
                        System.out.println("To:" + outbox.to);
                        System.out.println("Message:" + outbox.message);

                    }
                    break;
                case 4:
                    System.out.println("printing email user list");
                    for (User string : User.EmailUserList) {
                        System.out.println(string.name + "  " + string.email + "  ----");

                    }
                    break;
                case 99:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    break;
            }

        }
    }

    public static void sendEmail(String from, String to, String message, EmailObj obj) {
        User recepient = User.getObject(to);
        recepient.Inbox.add(obj);
        User sender = User.getObject(from);
        sender.Outbox.add(obj);
    }
}
