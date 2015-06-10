package it.moondroid.androidmvp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class LoginFragment extends Fragment implements LoginViewInterface {

    private LoginPresenter presenter;
    private Button btnLogin;
    private EditText username, password;
    private ProgressBar progressBar;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        presenter = new LoginPresenter();
        presenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        username = (EditText)rootView.findViewById(R.id.username);
        password = (EditText)rootView.findViewById(R.id.password);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);

        btnLogin = (Button)rootView.findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
            }
        });

        return rootView;
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setLoginEnabled(boolean enabled) {
        if (enabled){
            btnLogin.setEnabled(true);
            username.setEnabled(true);
            password.setEnabled(true);
        }else {
            btnLogin.setEnabled(false);
            username.setEnabled(false);
            password.setEnabled(false);
        }
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

}
