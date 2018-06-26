package instagram2.bbcag.ch.instagram2.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.R;
import instagram2.bbcag.ch.instagram2.SignUp.SignUpActivity;
import instagram2.bbcag.ch.instagram2.User.UserJDBCDao;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intent1 = new Intent(MainActivity.this, FeedActivity.class);
                startActivity(intent1);
                break;
            case R.id.noLoginButton:
                UserJDBCDao userJDBCDao = new UserJDBCDao();
                userJDBCDao.addNewUser("Hallihallo","niilaxx1232","sabrina.suter@gmx.com","123458");
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
