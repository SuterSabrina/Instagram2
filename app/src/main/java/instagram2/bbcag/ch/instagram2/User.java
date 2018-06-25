package instagram2.bbcag.ch.instagram2;

public class User {

    public String username;
    public String name;
    public String email;
    public String password;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)

    User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}