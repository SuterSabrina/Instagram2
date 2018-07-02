package instagram2.bbcag.ch.instagram2.Add;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.R;

public class OpenGallery extends AppCompatActivity{

    ImageView imageView;
    Button button;
    Button buttonCancel;
    Button buttonDone;
    Button buttonAddPicture;


    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        imageView = (ImageView)findViewById(R.id.iv);
        button = (Button)findViewById(R.id.pick);
        buttonCancel = (Button)findViewById(R.id.cancel2);
        buttonDone = (Button)findViewById(R.id.done2);


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

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveChanges();
            }
        });

    }

    private  void saveChanges(){
        Intent done = new Intent(this.getApplicationContext(), FeedActivity.class);
        done.putExtra("Tab","home");
        startActivity(done);
    }
    private void cancelAll(){
        Intent cancel = new Intent(this.getApplicationContext(), FeedActivity.class);
        cancel.putExtra("Tab","home");
        startActivity(cancel);
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageURI = data.getData();
            imageView.setImageURI(imageURI);

        }
    }
}