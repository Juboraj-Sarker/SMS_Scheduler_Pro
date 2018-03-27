package com.juborajsarker.smsschedulerpro.receiver;

import com.juborajsarker.smsschedulerpro.receiver.WakefulBroadcastReceiver;
import com.juborajsarker.smsschedulerpro.service.SmsDeliveredService;

/**
 * Created by jubor on 1/31/2018.
 */

public class SmsDeliveredReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return SmsDeliveredService.class;
    }
}