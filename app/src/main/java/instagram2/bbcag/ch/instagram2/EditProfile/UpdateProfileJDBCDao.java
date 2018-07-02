package instagram2.bbcag.ch.instagram2.EditProfile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.User.User;

public class UpdateProfileJDBCDao extends AppCompatActivity {

    public boolean updateProfile(final User user) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        ref.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getRef().child(("users")).setValue(user.getUsername());
                dataSnapshot.getRef().child(("users")).setValue(user.getEmail());
                dataSnapshot.getRef().child(("users")).setValue(user.getPassword());
                dataSnapshot.getRef().child(("users")).setValue(user.getPassword());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return false;
    }
}
