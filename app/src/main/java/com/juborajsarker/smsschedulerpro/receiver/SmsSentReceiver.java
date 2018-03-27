package com.juborajsarker.smsschedulerpro.receiver;

import com.juborajsarker.smsschedulerpro.service.SmsSentService;

/**
 * Created by jubor on 1/31/2018.
 */

public class SmsSentReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsSentService.class;
    }
}

