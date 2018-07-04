package instagram2.bbcag.ch.instagram2.User;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import instagram2.bbcag.ch.instagram2.Login.LoggedInUser;

public class UserJDBCDao {

    public void addNewUser(String username, String name, String email, String password){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
        String userId = myRef.push().getKey();
        User user = new User(username, name, email, password, "");
        LoggedInUser.loggedInUser.saveLoggedInUser(user);
        myRef.child(userId).setValue(user);
    }
}
