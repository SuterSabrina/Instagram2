package instagram2.bbcag.ch.instagram2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class ProfileActivity extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        System.out.print("Hello IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        Button button = (Button) findViewById(R.id.editBnt);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.print("Hello DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        Intent intent = new Intent(this, EditProfilePicture.class);
        startActivity(intent);

    }
}
