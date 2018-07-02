package instagram2.bbcag.ch.instagram2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import instagram2.bbcag.ch.instagram2.Add.OpenGallery;
import instagram2.bbcag.ch.instagram2.EditProfile.EditProfilePicture;
import instagram2.bbcag.ch.instagram2.R;

public class AddFragment extends Fragment implements View.OnClickListener {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.activity_add, container, false);

        Button button = view.findViewById(R.id.pick);
        button.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), OpenGallery.class);
        startActivity(intent);
    }
}
