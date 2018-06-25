package instagram2.bbcag.ch.instagram2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class SignUpActivity extends Activity implements OnClickListener {

    String emailAdress;
    String password;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Button button = (Button) findViewById(R.id.signUpButton);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        UserModel userModel = new UserModel();
        EditText editTextEmail = (EditText) findViewById(R.id.emailSignUp);
        emailAdress = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText) findViewById(R.id.passwordSignUp);
        password = editTextEmail.getText().toString();

        EditText editTextUsername = (EditText) findViewById(R.id.usernameSignUp);
        username = editTextEmail.getText().toString();

        if (userModel.isUsernameValid(this.username) == false) {
            EditText edittext = (EditText) findViewById(R.id.usernameSignUp);
            if (edittext.getText().length() == 0) {
                edittext.setError("Field cannot be left blank");
            } else {
                edittext.setError("Invalid username");
            }
        }
        if (userModel.isEmailValid(this.emailAdress) == false) {
            EditText edittext1 = (EditText) findViewById(R.id.emailSignUp);
            if (edittext1.getText().length() == 0) {
                edittext1.setError("Field cannot be left blank");
            } else {
                edittext1.setError("Invalid email");
            }
        }
        if (userModel.isEmailValid(this.password) == false) {
            EditText edittext1 = (EditText) findViewById(R.id.passwordSignUp);
            if (edittext1.getText().length() == 0) {
                edittext1.setError("Field cannot be left blank");
            } else {
                edittext1.setError("Mini eight characters, at least one letter and one number");
            }
        }
    }
}