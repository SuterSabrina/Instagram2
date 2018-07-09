package instagram2.bbcag.ch.instagram2.Login;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.User.User;

public class LoginJDBCDao {

    public void checkForUserData(final Activity main, final String username, final String password) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    User user = new User();
                    user.setName((String) messageSnapshot.child("name").getValue());
                    user.setUsername((String) messageSnapshot.child("username").getValue());
                    user.setPassword((String) messageSnapshot.child("password").getValue());
                    user.setEmail((String) messageSnapshot.child("email").getValue());
                    user.setId(messageSnapshot.getKey());

                    if (doesUserExist(user, username, password)){
                        LoggedInUser.loggedInUser.saveLoggedInUser(user);
                        Intent intent1 = new Intent(main, FeedActivity.class);
                        main.startActivity(intent1);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    //public void getUserInformation(String userId) {
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("users");

    //}

    private boolean doesUserExist(User user, String username, String password) {
            if (user.getUsername().equals(username) && (user.getPassword().equals(password))) {
                return true;
            }else{
                return false;
            }
    }
}