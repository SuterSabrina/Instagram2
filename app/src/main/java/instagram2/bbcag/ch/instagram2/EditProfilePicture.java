package instagram2.bbcag.ch.instagram2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

public class EditProfilePicture extends AppCompatActivity{

    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.edit_profile);

        imageView = (ImageView)findViewById(R.id.image);
        button = (Button)findViewById(R.id.editProfilePicture);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openGallery();

            }
        });

    }



}