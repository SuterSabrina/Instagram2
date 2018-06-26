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
                UserJDBCDao userJDBCDao = new UserJDBCDao();
                userJDBCDao.addNewUser("tes1", "tes1t", "t1es", "te1st");
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
