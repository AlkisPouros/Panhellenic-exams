package gr.aueb.sweng22.team04.view.login.signIn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.model.User;
import gr.aueb.sweng22.team04.view.candidate.CandidateActivity;
import gr.aueb.sweng22.team04.view.examiner.ExaminerActivity;
import gr.aueb.sweng22.team04.view.login.signUp.SignUpActivity;


public class LoginActivity extends AppCompatActivity implements LoginView{

    private static boolean isFirstRun = true;
    private LoginViewModel viewModel;
    private LoginPresenter presenter;
    private Button btnLoginButton;
    private Button btnSignUpButton;
    private EditText edtEmail;
    private EditText edtPassword;
    private TextView txtLoginMsg;
    private Initializer initializer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        presenter = viewModel.getPresenter();
        presenter.setView(this);

        initializer = new MemoryInitializer();
        initializer.prepareData();

        btnLoginButton = (Button) findViewById(R.id.loginInButton);
        btnSignUpButton = (Button) findViewById(R.id.signUpButton);
        edtEmail = (EditText) findViewById(R.id.EmailLoginField);
        edtPassword = (EditText) findViewById(R.id.PasswordLoginField);
        txtLoginMsg = (TextView) findViewById(R.id.LoginPageMsg);

        btnLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        btnSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signIn(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        User user = viewModel.getPresenter().onLogin(email, password);
        if(user != null && user.getUserMode().equals("Candidate")){
            Intent s = new Intent(LoginActivity.this, CandidateActivity.class);
            s.putExtra("email",email);
            s.putExtra("password",password);
            startActivity(s);
        }else if(user != null && user.getUserMode().equals("Examiner")){
            Intent s = new Intent(LoginActivity.this, ExaminerActivity.class);
            s.putExtra("email", email);
            s.putExtra("password", password);
            startActivity(s);
        }
    }

    private void signUp(){
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    @Override
    public void EmptyField() {
        txtLoginMsg.setText("Please feel all the fields");
    }

    @Override
    public void showFailedLogin() {
        txtLoginMsg.setText("Login failed. Please try again");
    }

    @Override
    public void showInvalidEmail() {
        txtLoginMsg.setText("Email is invalid, please enter a correct email");
    }

    @Override
    public void showInvalidPassword() {
        txtLoginMsg.setText("Password is invalid, please enter a correct email");
    }
}