package it.moondroid.androidmvp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;


public class LoginFragment extends Fragment implements LoginViewInterface {

    private LoginPresenter presenter;
    private EditText username, password;
    private ProgressBar progressBar;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        username = (EditText)rootView.findViewById(R.id.username);
        password = (EditText)rootView.findViewById(R.id.password);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress);

        rootView.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
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
    public void enableUsernameAndPassword(boolean enabled) {
        if (enabled){
            username.setEnabled(true);
            password.setEnabled(true);
        }else {
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
