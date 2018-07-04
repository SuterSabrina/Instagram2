package instagram2.bbcag.ch.instagram2.EditProfile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.Login.LoggedInUser;
import instagram2.bbcag.ch.instagram2.User.User;

import static android.support.v4.content.ContextCompat.startActivity;

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