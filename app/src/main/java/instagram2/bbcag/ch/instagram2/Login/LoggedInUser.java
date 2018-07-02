package instagram2.bbcag.ch.instagram2.Login;

import instagram2.bbcag.ch.instagram2.User.User;

public class LoggedInUser {
    public static LoggedInUser loggedInUser = new LoggedInUser();

    String id;
    String username;
    String password;

    public void saveLoggedInUser(User user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setId(user.getId());
    }

    private String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
