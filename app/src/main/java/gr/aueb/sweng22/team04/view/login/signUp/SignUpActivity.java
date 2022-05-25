package gr.aueb.sweng22.team04.view.login.signUp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import gr.aueb.sweng22.team04.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}