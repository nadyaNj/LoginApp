package am.home.LoginApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nadya on 7/9/14.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);
        MyListAdapter myListAdapter = new MyListAdapter(this);
        list.setAdapter(myListAdapter);
        List<MyListModel>models = new ArrayList<MyListModel>();
        for(int i = 0; i < 50; i ++) {
            models.add(new MyListModel("top text" +i, "botom text"+i));
        }
        myListAdapter.addItem(models);

        /*new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }, 2000);*/
    }
}