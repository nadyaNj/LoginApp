package am.home.LoginApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nadya on 7/7/14.
 */
public class UserPageActivity extends Activity {
    Button logoutButton;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_page);

        Intent myIntent = getIntent();
        if (myIntent.hasExtra("username")){
            TextView mText = (TextView)findViewById(R.id.email);
            mText.setText("Welcome "+myIntent.getStringExtra("username")+"!");
        }

        logoutButton = (Button)this.findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    return;

            }
        });
    }
}
