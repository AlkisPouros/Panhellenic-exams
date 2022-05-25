package gr.aueb.sweng22.team04.view.login.signIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.dao.Initializer;
import gr.aueb.sweng22.team04.memorydao.MemoryInitializer;
import gr.aueb.sweng22.team04.view.login.signUp.SignUpActivity;


public class LoginActivity extends AppCompatActivity implements LoginView{
    LoginPresenter presenter;
    private Button btnLoginButton;
    private Button btnSignUpButton;
    private EditText edtEmail;
    private EditText edtPassword;
    private TextView txtLoginMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        presenter =  new LoginPresenter(this, initializer.getCandidateDAO());

        btnLoginButton = (Button) findViewById(R.id.loginInButton);
        btnSignUpButton = (Button) findViewById(R.id.signUpButton);
        edtEmail = (EditText) findViewById(R.id.EmailLoginField);
        edtPassword = (EditText) findViewById(R.id.PasswordLoginField);
        txtLoginMsg = (TextView) findViewById(R.id.LoginPageMsg);

        btnLoginButton.setOnClickListener(v -> signIn());
        btnSignUpButton.setOnClickListener(v -> signUp());

    }

    private void signIn(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        presenter.onLogin(email, password);
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