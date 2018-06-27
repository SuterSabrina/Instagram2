package instagram2.bbcag.ch.instagram2.Login;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import instagram2.bbcag.ch.instagram2.User.User;

public class LoginJDBCDao {


    public void test(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = new User();
                for(DataSnapshot messageSnapshot : dataSnapshot.getChildren()){
                    String username = (String) messageSnapshot.child("username").getValue();
                    String name = (String) messageSnapshot.child("name").getValue();
                    String pwd = (String) messageSnapshot.child("password").getValue();
                    String email = (String) messageSnapshot.child("email").getValue();
                    user.setName(name);
                    user.setUsername(username);
                    user.setPassword(pwd);
                    user.setEmail(email);
                }
                System.out.println("Username" + user.getUsername());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

}


