package com.juborajsarker.smsschedulerpro.receiver;

import com.juborajsarker.smsschedulerpro.service.ReminderService;

/**
 * Created by jubor on 1/31/2018.
 */

public class ReminderReceiver extends WakefulBroadcastReceiver {

    @Override
    protected Class getServiceClass() {
        return ReminderService.class;
    }
}
