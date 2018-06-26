package instagram2.bbcag.ch.instagram2.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.R;
import instagram2.bbcag.ch.instagram2.User.UserJDBCDao;
import instagram2.bbcag.ch.instagram2.User.ValidateUserSignUp;

public class SignUpActivity extends Activity implements OnClickListener {

    private String emailAdress;
    private String password;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button button = (Button) findViewById(R.id.signUpButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ValidateUserSignUp validateUserSignUp = new ValidateUserSignUp();

        emailAdress = validateUserSignUp.getTextOfInputTextField(SignUpActivity.this, R.id.emailSignUp);
        password = validateUserSignUp.getTextOfInputTextField(SignUpActivity.this, R.id.passwordSignUp);
        username = validateUserSignUp.getTextOfInputTextField(SignUpActivity.this, R.id.usernameSignUp);

        boolean goBack = false;

            if (validateUserSignUp.isUsernameValid(this.username) == false) {
                EditText edittext = (EditText) findViewById(R.id.usernameSignUp);
                edittext.setError("Invalid username");
                goBack = true;
            }
            if (validateUserSignUp.isEmailValid(this.emailAdress) == false) {
                EditText edittext1 = (EditText) findViewById(R.id.emailSignUp);
                edittext1.setError("Invalid email");
                goBack = true;
            }
            if (validateUserSignUp.isPasswordValid(this.password) == false) {
                EditText edittext2 = (EditText) findViewById(R.id.passwordSignUp);
                edittext2.setError("Invalid Password");
                goBack = true;
            }
            if (goBack){
                return;
            }

        UserJDBCDao userJDBCDao = new UserJDBCDao();
        userJDBCDao.addNewUser(username, "", emailAdress, password);
        Intent intent1 = new Intent(SignUpActivity.this, FeedActivity.class);
        startActivity(intent1);

        }

    }