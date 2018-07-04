package instagram2.bbcag.ch.instagram2.User;

public class User {

    private String id;
    private String username;
    private String name;
    private String email;
    private String password;
    private String biography;

    public User(String username, String name, String email, String password, String biography) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.biography = biography;
    }

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

}