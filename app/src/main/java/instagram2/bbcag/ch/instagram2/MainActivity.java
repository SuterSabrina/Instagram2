package instagram2.bbcag.ch.instagram2;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

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
        EditText editTextEmail = (EditText)findViewById(R.id.emailSignUp);
        emailAdress = editTextEmail.getText().toString();

        EditText editTextPassword = (EditText)findViewById(R.id.passwordSignUp);
        password = editTextEmail.getText().toString();

        EditText editTextUsername = (EditText)findViewById(R.id.usernameSignUp);
        username = editTextEmail.getText().toString();

        if(userModel.isEmailValid(this.emailAdress)){

        }
    }
}