package it.moondroid.androidmvp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeFragment extends Fragment implements WelcomeViewInterface {

    private WelcomePresenter presenter;

    private TextView textViewMessage;
    private Button buttonLoginLogout;

    public WelcomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new WelcomePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        textViewMessage = (TextView)rootView.findViewById(R.id.text_message);
        buttonLoginLogout = (Button)rootView.findViewById(R.id.button_login);

        presenter.checkLoggedState();

        return rootView;
    }

    @Override
    public void showLoggedUser(String username) {
        textViewMessage.setText(String.format("Welcome %s!", username));
    }

    @Override
    public void showAnonymousUser() {
        textViewMessage.setText("Hello, anonymous!");
    }

    @Override
    public void showLogoutButton() {
        buttonLoginLogout.setText("LOG OUT");
        buttonLoginLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogout();
            }
        });
    }

    @Override
    public void showLoginButton() {
        buttonLoginLogout.setText("LOG IN");
        buttonLoginLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogin();
            }
        });
    }

    @Override
    public void setLogoutEnabled(boolean enabled) {
        buttonLoginLogout.setEnabled(enabled);
    }
}
