package instagram2.bbcag.ch.instagram2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ProfileAcitivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Button button = (Button) findViewById(R.id.editBnt);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        System.out.print("c,asdmalcmmc");
        Intent intent = new  Intent(this, EditProfilePicture.class);
        startActivity(intent);

    }
}
