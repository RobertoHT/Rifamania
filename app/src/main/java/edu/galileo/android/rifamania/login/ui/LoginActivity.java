package edu.galileo.android.rifamania.login.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.RifamaniaApp;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainActivity;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.btnLogin)
    LoginButton btnLogin;
    @Bind(R.id.container)
    RelativeLayout container;

    private CallbackManager callbackManager;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        prefs = getSharedPreferences(RifamaniaApp.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);

        if(AccessToken.getCurrentAccessToken() != null){
            navigatetoMainScreen();
        }

        callbackManager = CallbackManager.Factory.create();
        btnLogin.setReadPermissions(Arrays.asList("public_profile","email"));
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try {
                                    prefs.edit().putString(RifamaniaApp.NAME_KEY,object.getString("name")).commit();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "name");
                request.setParameters(parameters);
                request.executeAsync();

                navigatetoMainScreen();
            }

            @Override
            public void onCancel() {
                Snackbar.make(container, R.string.login_cancel_error, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                String msgError = String.format(getString(R.string.login_error), error.getLocalizedMessage());
                Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void navigatetoMainScreen() {
        Intent intent = new Intent(this, RifaMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
