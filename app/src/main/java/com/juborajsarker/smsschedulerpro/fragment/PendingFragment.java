package com.juborajsarker.smsschedulerpro.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.juborajsarker.smsschedulerpro.R;
import com.juborajsarker.smsschedulerpro.activity.AddSmsActivity;
import com.juborajsarker.smsschedulerpro.activity.DetailsActivity;
import com.juborajsarker.smsschedulerpro.java_class.CustomAdapter;
import com.juborajsarker.smsschedulerpro.java_class.DbHelper;
import com.juborajsarker.smsschedulerpro.java_class.SmsModel;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class PendingFragment extends Fragment {



    private SmsModel sms;
    private final static int REQUEST_CODE = 1;
    DbHelper dbHelper = new DbHelper(getContext());
    CustomAdapter customAdapter;
    ArrayList<SmsModel> pendingList;

    String finalTime;
    String finalMonth;

    ListView listView;
    FloatingActionButton fab;

    View view;


    public PendingFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_pending, container, false);
        listView = (ListView) view.findViewById(R.id.pending_LV);




        fab = (FloatingActionButton) view.findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setMessage("Please wait ......");
                progressDialog.setCancelable(false);
                progressDialog.show();



                progressDialog.dismiss();
                startActivity(new Intent(getContext(), AddSmsActivity.class));
            }
        });


     try {

         pendingList = DbHelper.getDbHelper(getContext()).get(SmsModel.STATUS_PENDING);

         if (pendingList.isEmpty()){

             Log.d("Empty", "No pending message");

         }else {


             customAdapter = new CustomAdapter(getContext(),pendingList);
             listView.setAdapter(customAdapter);
             customAdapter.notifyDataSetChanged();



             listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                     Intent intent = new Intent(getContext(), DetailsActivity.class);

                     String message = pendingList.get(position).getMessage();
                     String number = pendingList.get(position).getRecipientNumber();
                     String name = pendingList.get(position).getRecipientName();
                     String status = pendingList.get(position).getStatus();




                     String year = String.valueOf(pendingList.get(position).getCalendar().get(GregorianCalendar.YEAR));
                     String month = String.valueOf(pendingList.get(position).getCalendar().get(GregorianCalendar.MONTH));
                     String day = String.valueOf(pendingList.get(position).getCalendar().get(GregorianCalendar.DAY_OF_MONTH));

                     String hour = String.valueOf(pendingList.get(position).getCalendar().get(Calendar.HOUR_OF_DAY));
                     String minute = String.valueOf(pendingList.get(position).getCalendar().get(Calendar.MINUTE));



                     boolean pm = false;

                     if (Integer.parseInt(hour) > 12){

                         pm = true;
                         int tempHour = Integer.parseInt(hour) - 12;
                         hour = String.valueOf(tempHour);
                     }

                     if (pm){

                         finalTime = hour + ":" + minute + " pm";

                     }else {

                         finalTime = hour + ":" + minute + " am";
                     }

                     finalMonth = getMonthForInt(Integer.parseInt(month)) + " " + day+ ", " + year;




                     intent.putExtra("message", message);
                     intent.putExtra("number", number);
                     intent.putExtra("name", name);
                     intent.putExtra("status", status);
                     intent.putExtra("time", finalTime);
                     intent.putExtra("date", finalMonth);
                     intent.putExtra("timesTrap", pendingList.get(position).getTimestampCreated());
                     intent.putExtra("fStatus",1);

                     startActivity(intent);
                 }
             });
         }

     }catch (Exception e){

         Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
     }







        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        pendingList = DbHelper.getDbHelper(getContext()).get(SmsModel.STATUS_PENDING);
        customAdapter = new CustomAdapter(getContext(),pendingList);
        listView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }



    String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }






}
