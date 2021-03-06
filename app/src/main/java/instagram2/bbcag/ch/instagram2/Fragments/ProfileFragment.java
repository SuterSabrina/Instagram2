package instagram2.bbcag.ch.instagram2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import instagram2.bbcag.ch.instagram2.EditProfile.EditProfilePicture;
import instagram2.bbcag.ch.instagram2.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.activity_profile, container, false);

        Button button = view.findViewById(R.id.editBnt);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), EditProfilePicture.class);
        startActivity(intent);
    }
}
