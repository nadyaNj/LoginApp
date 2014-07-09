package am.home.LoginApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadya on 7/9/14.
 */
public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<MyListModel> items;

    public MyListAdapter(Context context) {
        this.context = context;
        items = new ArrayList<MyListModel>();

    }

    public void addItem(List<MyListModel> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_list, parent, false);

        MyListModel model = items.get(position);

        ((TextView)v.findViewById(R.id.list_item_text1)).setText(model.getText1());
        ((TextView)v.findViewById(R.id.list_item_text2)).setText(model.getText2());

        return v;
    }
}
