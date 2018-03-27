package com.juborajsarker.smsschedulerpro.receiver;

import com.juborajsarker.smsschedulerpro.receiver.WakefulBroadcastReceiver;
import com.juborajsarker.smsschedulerpro.service.SmsSenderService;

/**
 * Created by jubor on 1/31/2018.
 */

public class SmsSenderReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsSenderService.class;
    }
}
