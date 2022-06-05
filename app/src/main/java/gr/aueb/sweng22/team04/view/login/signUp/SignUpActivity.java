package gr.aueb.sweng22.team04.view.login.signUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gr.aueb.sweng22.team04.R;
import gr.aueb.sweng22.team04.view.login.signIn.LoginActivity;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * activity for sign up
 */
public class SignUpActivity extends AppCompatActivity implements SignUpView {

    private SignUpViewModel viewModel;
    private SignUpPresenter presenter;
    private Button btnRegisterButton;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtPoliceNumberID;
    private EditText edtBirthday;
    private EditText edtScientificField;
    private EditText edtEmail;
    private EditText edtPassword;
    private TextView txtRegistrationMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        presenter = viewModel.getPresenter();
        presenter.setView(this);


        btnRegisterButton = (Button) findViewById(R.id.RegistrationButton);
        edtFirstName = (EditText) findViewById(R.id.RegistrationFirstNameField);
        edtLastName = (EditText) findViewById(R.id.RegistrationLastNameField);
        edtPoliceNumberID = (EditText) findViewById(R.id.RegistrationPoliceIDField);
        edtBirthday = (EditText) findViewById(R.id.RegistrationDayField);
        edtScientificField = (EditText) findViewById(R.id.RegistrationScientificField);
        edtEmail = (EditText) findViewById(R.id.RegistrationEmailField);
        edtPassword= (EditText) findViewById(R.id.RegistrationPasswordField);
        txtRegistrationMsg = (TextView) findViewById(R.id.RegistrationFieldMsg);

        btnRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    /**
     * this method is called when the candidate clicks the register button.
     * With the help of the method onSignUp checks if everything follows certain rules.
     */
    private void register(){
        String firstName = edtFirstName.getText().toString();
        String lastName = edtLastName.getText().toString();
        String policeNumberID = edtPoliceNumberID.getText().toString();
        String birthday = edtBirthday.getText().toString();
        String scientificField = edtScientificField.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if(viewModel.getPresenter().onSignUp(firstName, lastName, policeNumberID, birthday, email, password, scientificField)){
            Intent s = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(s);
        }

    }

    @Override
    public void emptyField() {
        txtRegistrationMsg.setText("Please fill all the fields");
    }

    @Override
    public void showInvalidEmail() {
        txtRegistrationMsg.setText("Email is invalid, please enter a correct email");
    }

    @Override
    public void showInvalidPassword() {
        txtRegistrationMsg.setText("Password is invalid, please enter a correct password");
    }

    @Override
    public void showInvalidPoliceID() {
        txtRegistrationMsg.setText("ID Number is invalid, please enter a correct ID Number");
    }
}