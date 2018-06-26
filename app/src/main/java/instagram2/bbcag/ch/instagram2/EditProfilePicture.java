package instagram2.bbcag.ch.instagram2;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.Fragments.ProfileFragment;

import static android.app.PendingIntent.getActivity;

public class EditProfilePicture extends AppCompatActivity{

    ImageView imageView;
    Button button;
    Button buttonCancel;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        imageView = (ImageView)findViewById(R.id.image);
        button = (Button)findViewById(R.id.editProfilePicture);
        buttonCancel = (Button)findViewById(R.id.cancel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();

            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAll();
            }
        });

    }

    private void cancelAll(){
        Intent cancel = new Intent(this.getApplicationContext(), FeedActivity.class);
        cancel.putExtra("Tab","profile");
        startActivity(cancel);
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            imageView.setImageURI(imageURI);

        }
    }
}