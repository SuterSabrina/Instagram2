package instagram2.bbcag.ch.instagram2.Login;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.util.Map;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.R;
import instagram2.bbcag.ch.instagram2.SignUp.SignUpActivity;
import instagram2.bbcag.ch.instagram2.User.User;
import instagram2.bbcag.ch.instagram2.User.UserJDBCDao;
import instagram2.bbcag.ch.instagram2.User.ValidateUserSignUp;

public class MainActivity extends Activity implements View.OnClickListener {

    public static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = new Bus(ThreadEnforcer.MAIN);
        bus.register(this);
        setContentView(R.layout.login);
        Button loginButton = (Button) findViewById(R.id.loginBnt);
        loginButton.setOnClickListener(this);
        Button noLoginButton = (Button) findViewById(R.id.noLoginButton);
        noLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBnt:
                LoginJDBCDao loginJDBCDao = new LoginJDBCDao();
                ValidateUserSignUp validateUserSignUp = new ValidateUserSignUp();
                String userName = validateUserSignUp.getTextOfInputTextField(MainActivity.this, R.id.usernameLogin);
                String password = validateUserSignUp.getTextOfInputTextField(MainActivity.this, R.id.passwordLogin);

                //Prüfung muss innerhalb dieser Klasse ausgeführt werden!
                loginJDBCDao.checkForUserData(userName, password);
                    Intent intent1 = new Intent(MainActivity.this, FeedActivity.class);
                    startActivity(intent1);
                break;

            case R.id.noLoginButton:
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
