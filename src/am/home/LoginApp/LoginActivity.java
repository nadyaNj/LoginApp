package am.home.LoginApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    EditText email;
    EditText password;
    Button loginButton;
    Toast currentToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        email=(EditText)this.findViewById(R.id.emailText);
        password=(EditText)this.findViewById(R.id.passwordText);
        loginButton=(Button)this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(Validation.validateEmail(email.getText().toString().trim()) &&
                        Validation.validatePassword(password.getText().toString().trim())) {
                    showToast(getString(R.string.login_successful));

                    Intent i = new Intent(getApplicationContext(),UserPageActivity.class);

                    i.putExtra("username",email.getText().toString().split("@")[0]);
                    startActivity(i);
                    return;

                }
                showToast(getString(R.string.invalid_login));
            }
        });
    }

    void showToast(String text)
    {
        if(currentToast == null)
        {
            currentToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        }

        currentToast.setText(text);
        currentToast.setDuration(Toast.LENGTH_SHORT);
        currentToast.show();
    }




}
