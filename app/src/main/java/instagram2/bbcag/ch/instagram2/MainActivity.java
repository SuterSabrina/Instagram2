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
        setContentView(R.layout.login);
        Button button = (Button) findViewById(R.id.loginBnt);

        EditText editTextEmail = (EditText)findViewById(R.id.emailSignUp);
        CharSequence emailAdress = editTextEmail.getText();

        EditText editTextPassword = (EditText)findViewById(R.id.passwordSignUp);
        CharSequence passoword = editTextEmail.getText();

        EditText editTextUsername = (EditText)findViewById(R.id.usernameSignUp);
        CharSequence username = editTextEmail.getText();

        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        UserModel userModel = new UserModel();
        if(userModel.isEmailValid(this.emailAdress)){

        }
    }
}