package am.home.LoginApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nadya on 7/9/14.
 */
public class RegistrationActivity extends Activity {
    String firstName;
    String secondName;
    String email;
    String password;
    String confirmPassword;

    Button registrationButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void registration(View view) {
        firstName = ((EditText)this.findViewById(R.id.firstName)).getText().toString().trim();
        secondName = ((EditText)this.findViewById(R.id.secondName)).getText().toString().trim();
        email = ((EditText)this.findViewById(R.id.regEmail)).getText().toString().trim();
        password = ((EditText)this.findViewById(R.id.regPassword)).getText().toString().trim();
        confirmPassword = ((EditText)this.findViewById(R.id.confirmPassword)).getText().toString().trim();
        registrationButton = (Button)this.findViewById(R.id.userRegistration);

        if(firstName.equals("")||secondName.equals("")||email.equals("")||password.equals("") || confirmPassword.equals("")) {
            Toaster.showToast("Please add Parameter");
            return;
        }

        if(!password.equals(confirmPassword)) {
            Toaster.showToast("Password doesn't match");
            return;
        }

       if(Validation.validateEmail(email) && Validation.validatePassword(password)) {
            Intent intent = new Intent(this, LoginActivity.class);
            Bundle extras = new Bundle();
            extras.putString("regLogin", email);
            extras.putString("regPassword", password);
            Toaster.showToast("Your account created");
            intent.putExtras(extras);

            setResult(RESULT_OK, intent);
            finish();
           LayoutInflater inflater = getLayoutInflater();
           //this.getSystemService(Context.LAYOUT_INFLATER_SERVICE); if we have only context not activity


       }



    }
}
