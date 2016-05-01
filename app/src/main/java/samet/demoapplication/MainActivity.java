package samet.demoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String SUCCESS_KEY = "success";

    private EditText textUsername;
    private EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUsername = (EditText) findViewById(R.id.text_user_name);
        textPassword = (EditText) findViewById(R.id.text_password);

        Button loginButton = (Button) findViewById(R.id.log_in_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra(SUCCESS_KEY, isSuccess());
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private boolean isSuccess() {
        // These are MOCKS for our login test
        String username = "Android"; // Our MOCK username
        String password = "Password"; // Our MOCK password that is super safe

        boolean equalsUsernames = textUsername.getText().toString().equals(username);
        boolean equalsPasswords = textPassword.getText().toString().equals(password);
        return equalsPasswords && equalsUsernames;
    }
}
