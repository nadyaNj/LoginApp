package am.home.LoginApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        TextView userEmail = (TextView)findViewById(R.id.userEmail);
        TextView userPassword = (TextView)findViewById(R.id.userPassword);
        userEmail.setText("Welcome " + email);
        userPassword.setText("Your password is "+ password);


    }

    public void goToMain() {
        startActivityForResult(new Intent(this, LoginActivity.class), ActivityRequestCodes.BACK_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case  ActivityRequestCodes.BACK_REQUEST_CODE:
                goToMain();
                String email = getIntent().getStringExtra("email");
                String password = getIntent().getStringExtra("password");
                TextView userEmail = (TextView)findViewById(R.id.loginEmail);
                TextView userPassword = (TextView)findViewById(R.id.loginPassword);
                break;
            default:
                break;
        }
    }
}
