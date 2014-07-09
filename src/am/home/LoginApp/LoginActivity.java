package am.home.LoginApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    EditText email;
    EditText password;
    Button loginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void userLogin(View view) {

        email=(EditText)this.findViewById(R.id.loginEmail);
        password=(EditText)this.findViewById(R.id.loginPassword);
        loginButton=(Button)this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(Validation.validateEmail(email.getText().toString().trim()) &&
                        Validation.validatePassword(password.getText().toString().trim())) {
                    Toaster.showToast(getString(R.string.login_successful));

                    Bundle extras = new Bundle();
                    extras.putString("username",email.getText().toString().split("@")[0]);
                    extras.putString("password", password.getText().toString());
                    Intent i = new Intent(getApplicationContext(),UserPageActivity.class);

                    i.putExtras(extras);
                    startActivity(i);
                    return;

                }
                Toaster.showToast(getString(R.string.invalid_login));
            }
        });
    }

    public void userRegistration(View view) {
        startActivityForResult(new Intent(this, RegistrationActivity.class), ActivityRequestCodes.BACK_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("LoginActivity", requestCode+"");
        switch (requestCode) {
            case ActivityRequestCodes.BACK_REQUEST_CODE:
                email=(EditText)this.findViewById(R.id.loginEmail);
                password=(EditText)this.findViewById(R.id.loginPassword);
                email.setText(data.getStringExtra("regLogin"));
                password.setText(data.getStringExtra("regPassword"));

                break;
            case ActivityRequestCodes.CAMERA_REQUEST_CODE:
                email=(EditText)this.findViewById(R.id.loginEmail);
                password=(EditText)this.findViewById(R.id.loginPassword);
                email.setText(data.getStringExtra("userLogin"));
                password.setText(data.getStringExtra("userPassword"));
                break;
            default:
                break;
        }

    }
}
