package instagram2.bbcag.ch.instagram2.EditProfile;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateProfileJDBCDao {

    public boolean updateUserProfile(String userID, String username, String name, String email, String biography){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        if(username != null && name != null && email != null){
            myRef.child(userID).child("username").setValue(username);
            myRef.child(userID).child("name").setValue(name);
            myRef.child(userID).child("email").setValue(email);
            myRef.child(userID).child("biography").setValue(biography);
            return true;
        }
        return false;
    }
}