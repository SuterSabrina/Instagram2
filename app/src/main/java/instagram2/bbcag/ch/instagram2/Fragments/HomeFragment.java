package instagram2.bbcag.ch.instagram2.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import instagram2.bbcag.ch.instagram2.R;

public class HomeFragment extends Fragment{

    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageURI;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        return view;
    }
}
