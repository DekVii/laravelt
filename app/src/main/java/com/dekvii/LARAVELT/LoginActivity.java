package com.dekvii.LARAVELT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dekvii.LARAVELT.API.ClientService;
import com.dekvii.LARAVELT.API.RetrofitClient;
import com.dekvii.LARAVELT.Model.product.CategoryItem;
import com.dekvii.LARAVELT.Model.product.Product;
import com.dekvii.LARAVELT.helper.PreferenceHelper;
import com.google.api.Context;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView linkSignup;

    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edit_username);
        edtPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
        linkSignup = findViewById(R.id.link_signup);

        instance = PreferenceHelper.getInstance(getApplicationContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Retrofit retrofit = RetrofitClient.connect();
//                ClientService service = retrofit.create(ClientService.class);
//                final Call<ResponseBody> request = service.login(edtEmail.getText().toString(), edtPassword.getText().toString());
//                request.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        String json
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                    }
//                });
                validate();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                login();
            }
        });

        linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    public void buttonLogin(View view){
        String User = edtEmail.getText().toString();
        String Pass = edtPassword.getText().toString();
        Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
        instance.setLogin(true);
        instance.setName(User);
        instance.setPass(Pass);

        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_AppBarOverlay);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 5000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);

        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(LoginActivity.this, "Login failed" + edtEmail, Toast.LENGTH_SHORT).show();

        btnLogin.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            edtEmail.setError("enter a valid email address");
            valid = false;
        } else {
            edtEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            edtPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            edtPassword.setError(null);
        }

        return valid;
    }

}
