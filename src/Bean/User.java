package Bean;

public class User {
    private static String userName;
    private static String userAge;

    public User(String userName,String userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public static String getUserAge() {
        return userAge;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserAge(String userAge) {
        User.userAge = userAge;
    }

    public static void setUserName(String userName) {
        User.userName = userName;
    }
}
