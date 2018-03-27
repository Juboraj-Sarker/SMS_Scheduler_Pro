package com.juborajsarker.smsschedulerpro.view;

import android.view.View;

import com.juborajsarker.smsschedulerpro.java_class.SmsModel;
import com.juborajsarker.smsschedulerpro.activity.AddSmsActivity;

/**
 * Created by jubor on 1/31/2018.
 */

public abstract class Builder {

    protected View view;
    protected SmsModel sms;
    protected AddSmsActivity activity;

    abstract protected View getView();
    abstract public View build();

    public Builder setView(View view) {
        this.view = view;
        return this;
    }

    public Builder setSms(SmsModel sms) {
        this.sms = sms;
        return this;
    }

    public Builder setActivity(AddSmsActivity activity) {
        this.activity = activity;
        return this;
    }
}
