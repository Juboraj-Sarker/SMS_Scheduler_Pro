package com.juborajsarker.smsschedulerpro.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by jubor on 1/31/2018.
 */

public class BuilderMessage extends Builder {

    @Override
    protected EditText getView() {
        return (EditText) view;
    }

    @Override
    public EditText build() {
        getView().setText(sms.getMessage());
        getView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sms.setMessage(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return getView();
    }
}
