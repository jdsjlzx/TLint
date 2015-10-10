package com.gzsll.hupu.ui.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.gzsll.hupu.R;
import com.gzsll.hupu.presenter.LoginPresenter;
import com.gzsll.hupu.view.LoginView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

/**
 * Created by sll on 2015/9/11.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseSwipeBackActivity implements LoginView {

    @ViewById
    EditText etUserName;
    @ViewById
    TextInputLayout textInputUserName;
    @ViewById
    EditText etPassWord;
    @ViewById
    TextInputLayout textInputPassword;
    @ViewById
    Toolbar toolbar;

    private MaterialDialog dialog;

    @Inject
    LoginPresenter mLoginPresenter;

    @AfterViews
    void init() {
        initToolBar(toolbar);
        setTitle("登录");
        dialog = new MaterialDialog.Builder(this)
                .title("提示")
                .content("登录中...")
                .progress(true, 0).build();
        mLoginPresenter.setView(this);
        mLoginPresenter.initialize();
        etUserName.addTextChangedListener(new MTextWatcher(textInputUserName));
        etPassWord.addTextChangedListener(new MTextWatcher(textInputPassword));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.login) {
            doLogin();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    private void doLogin() {
        String mUserName = etUserName.getText().toString();
        String mPassword = etPassWord.getText().toString();

        if (TextUtils.isEmpty(mUserName)) {
            textInputUserName.setError("请输入用户名");
            textInputUserName.setErrorEnabled(true);
        } else if (TextUtils.isEmpty(mPassword)) {
            textInputPassword.setError("请输入密码");
            textInputPassword.setErrorEnabled(true);
        } else {
            mLoginPresenter.login(mUserName, mPassword);
        }
    }

    @UiThread(delay = 2000)
    @Override
    public void loginSuccess() {
        MainActivity_.intent(this).start();
        finish();
    }


    @Override
    public void showLoading() {
        if (!dialog.isShowing() && !isFinishing()) {
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing() && !isFinishing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    class MTextWatcher implements TextWatcher {

        TextInputLayout textInputLayout;

        public MTextWatcher(TextInputLayout textInputLayout) {
            this.textInputLayout = textInputLayout;
        }

        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            textInputLayout.setErrorEnabled(false);
        }

    }
}