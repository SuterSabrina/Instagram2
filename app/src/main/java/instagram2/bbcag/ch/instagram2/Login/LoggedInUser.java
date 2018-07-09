package instagram2.bbcag.ch.instagram2.Login;

import instagram2.bbcag.ch.instagram2.User.User;

public class LoggedInUser {
    public static LoggedInUser loggedInUser = new LoggedInUser();

    String id;
    String username;
    String password;
    String biography;

    public void saveLoggedInUser(User user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setBiography(user.getBiography());
        setId(user.getId());
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
