package instagram2.bbcag.ch.instagram2.EditProfile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import instagram2.bbcag.ch.instagram2.Feed.FeedActivity;
import instagram2.bbcag.ch.instagram2.Login.LoggedInUser;
import instagram2.bbcag.ch.instagram2.R;
import instagram2.bbcag.ch.instagram2.User.UserJDBCDao;
import instagram2.bbcag.ch.instagram2.User.ValidateUserSignUp;

public class EditProfilePicture extends AppCompatActivity{

    ImageView imageView;
    Button buttonEdit;
    Button buttonCancel;
    Button buttonDone;
    Button buttonAddPicture;


    private static final int PICK_IMAGE = 100;
    Uri imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        imageView = (ImageView)findViewById(R.id.image);
        buttonEdit = (Button)findViewById(R.id.editProfilePicture);
        buttonCancel = (Button)findViewById(R.id.cancel);
        buttonDone = (Button)findViewById(R.id.done);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
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

                ValidateUserSignUp validateUserSignUp = new ValidateUserSignUp();
                final String nameOfUser = validateUserSignUp.getTextOfInputTextField(EditProfilePicture.this, R.id.nameOfUser);
                final String userName = validateUserSignUp.getTextOfInputTextField(EditProfilePicture.this, R.id.usernameEditProfile);
                final String emailOfUser = validateUserSignUp.getTextOfInputTextField(EditProfilePicture.this, R.id.emailEditProfile);
                final String biographyOfUser = validateUserSignUp.getTextOfInputTextField(EditProfilePicture.this, R.id.biographyEditProfile);

                boolean isValid = false;

                if(validateUserSignUp.isOnlyText(nameOfUser)==false){
                    EditText edittext = (EditText) findViewById(R.id.nameOfUser);
                    edittext.setError("Invalid name");
                    isValid = true;
                }
                if(validateUserSignUp.isOnlyText(userName)==false){
                    EditText edittext = (EditText) findViewById(R.id.usernameEditProfile);
                    edittext.setError("Invalid username");
                    isValid = true;
                }
                if(validateUserSignUp.isOnlyText(emailOfUser)==false){
                    EditText edittext = (EditText) findViewById(R.id.emailEditProfile);
                    edittext.setError("Invalid email");
                    isValid = true;
                }
                if(validateUserSignUp.isOnlyText(biographyOfUser)==false){
                    EditText edittext = (EditText) findViewById(R.id.biographyEditProfile);
                    edittext.setError("Invalid biography");
                    isValid = true;
                }
                if(isValid){
                    return;
                }

                UpdateProfileJDBCDao updateProfileJDBCDao = new UpdateProfileJDBCDao();
                if(updateProfileJDBCDao.updateUserProfile(LoggedInUser.loggedInUser.getId(),userName, nameOfUser, emailOfUser, biographyOfUser)){
                    doneAll();
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Check your Input";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }
    private void doneAll() {
        Intent done = new Intent(this.getApplicationContext(), FeedActivity.class);
        done.putExtra("Tab","profile");
        startActivity(done);
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