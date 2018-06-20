package instagram2.bbcag.ch.instagram2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private static final String TAG = "Home_Fragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.pool, "pool"));
        list.add(new Card("drawable://" + R.drawable.pool, "pool"));
        list.add(new Card("drawable://" + R.drawable.pool, "pool"));
        list.add(new Card("drawable://" + R.drawable.pool, "pool"));
        list.add(new Card("drawable://" + R.drawable.pool, "pool"));
        list.add(new Card("drawable://" + R.drawable.pool, "pool"));

//        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_main, list);
//        mListView.setAdapter(adapter);


        return view;
    }
}