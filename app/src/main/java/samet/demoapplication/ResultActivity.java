package samet.demoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private final int failImage = R.drawable.android_sad;
    private final int successImage = R.drawable.android_happy;

    private final String failMessage = "You have failed to log in :(";
    private final String successMessage = "Login is Successful!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        boolean isSuccess = getIntent().getBooleanExtra(MainActivity.SUCCESS_KEY, false);
        TextView textLoginMessage = (TextView) findViewById(R.id.login_result_message);
        ImageView imageMessage = (ImageView) findViewById(R.id.result_image);
        //   Android screens have different resolutions
        //   use the density multiplication to programmatically
        //   scale your required sizes
        float screenDensity = getResources().getDisplayMetrics().density;

        if (isSuccess) {
            textLoginMessage.setText(successMessage);
            imageMessage.setImageResource(successImage);
            Log.v("DemoActivity", "Login was successful, hurray!");
        } else {
            textLoginMessage.setText(failMessage);
            imageMessage.setImageResource(failImage);
            Log.v("DemoActivity", "Login was unsuccessful!");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
