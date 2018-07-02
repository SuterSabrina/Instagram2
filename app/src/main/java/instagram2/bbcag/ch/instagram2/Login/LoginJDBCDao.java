package instagram2.bbcag.ch.instagram2.Login;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import instagram2.bbcag.ch.instagram2.User.User;

public class LoginJDBCDao {

    ArrayList<User> userArrayList = new ArrayList<User>();

    public void checkForUserData(final String username, final String password) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    User user = new User();
                    String username = (String) messageSnapshot.child("username").getValue();
                    String name = (String) messageSnapshot.child("name").getValue();
                    String pwd = (String) messageSnapshot.child("password").getValue();
                    String email = (String) messageSnapshot.child("email").getValue();
                    String id = (String) messageSnapshot.getKey();
                    user.setName(name);
                    user.setUsername(username);
                    user.setPassword(pwd);
                    user.setEmail(email);
                    user.setId(id);
                    userArrayList.add(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public boolean doesUserExist(String username, String password) {
        for (User u : userArrayList) {
            if (u.getname().equals(username) && (u.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
}