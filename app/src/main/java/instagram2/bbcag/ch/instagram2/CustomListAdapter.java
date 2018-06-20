package instagram2.bbcag.ch.instagram2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class CustomListAdapter extends ArrayAdapter<Card> {

    public CustomListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
