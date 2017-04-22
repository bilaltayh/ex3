package com.example.bilalt.bilal;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.io.*;

import java.util.Date;


public class MainActivity extends Activity {

    private com.example.bilalt.bilal.ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private int counter = 0;
    private String title;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.display);
        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.activity_main);
        listView.setAdapter(chatArrayAdapter);
        final Context main = this;
      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                final int N = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(main);
                View view = ((MainActivity)main).getLayoutInflater().inflate(R.layout.reminder, null);
                TextView Text =  (TextView) view.findViewById(R.id.text_edit);
                Button deleteM =  (Button) view.findViewById(R.id.delete);
                Text.setText(Text.getText());

                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                deleteM.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View v) {
                                chatArrayAdapter.delete(N);
                                dialog.dismiss();

                            }
                        }
                );
            }
          }); */



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id)
            {
                final int N = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(main);
                View view = ((MainActivity)main).getLayoutInflater().inflate(R.layout.alert, null);
                TextView Text =  (TextView) view.findViewById(R.id.text_edit);
                Button deleteM =  (Button) view.findViewById(R.id.delete);
                Text.setText(Text.getText());

                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                deleteM.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View v) {
                                chatArrayAdapter.delete(N);
                                dialog.dismiss();

                            }
                        }
                );
                return true;
            }
        });





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                final int N = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(main);
                View view = ((MainActivity)main).getLayoutInflater().inflate(R.layout.pop, null);
                TextView Text1 =  (TextView) view.findViewById(R.id.text_edit1);
                TextView Text2 =  (TextView) view.findViewById(R.id.text_edit2);
                Button doneM =  (Button) view.findViewById(R.id.done);
                Text2.setText(chatArrayAdapter.getItem(position).reminderText);
                Text1.setText(chatArrayAdapter.getItem(position).date);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();

                doneM.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View v) {
                                dialog.dismiss();

                            }
                        }
                );
            }
        });



    }






    public void selfMessage1(View v) {
        final EditText text = (EditText) findViewById(R.id.input);
        text.setHint("enter reminder Title");
        String txt = text.getText().toString();
        text.getText().clear();
        DatePicker d = (DatePicker) findViewById(R.id.date_picker);
        int day = d.getDayOfMonth();
        int month = d.getMonth();
        int year = d.getYear();
        String s = Integer.toString(day) +"/"+ Integer.toString(month)+"/" + Integer.toString(year);
        findViewById(R.id.display).setVisibility(View.VISIBLE);
        findViewById(R.id.button).setVisibility(View.VISIBLE);
        findViewById(R.id.DELETE).setVisibility(View.GONE);
        findViewById(R.id.ADD).setVisibility(View.GONE);
        findViewById(R.id.date_picker).setVisibility(View.GONE);
        chatArrayAdapter.add(new MessageOBJ(counter, s , txt,title));
    }

    public void selfMessage2(View v) {
        final EditText text = (EditText) findViewById(R.id.input);
        text.setHint("enter reminder Title");
        text.getText().clear();
        findViewById(R.id.display).setVisibility(View.VISIBLE);
        findViewById(R.id.button).setVisibility(View.VISIBLE);
        findViewById(R.id.DELETE).setVisibility(View.GONE);
        findViewById(R.id.ADD).setVisibility(View.GONE);
        findViewById(R.id.date_picker).setVisibility(View.GONE);
    }

    public void selfMessage(View v) {
        final EditText text = (EditText) findViewById(R.id.input);
        text.setHint("enter reminder content");
        title = text.getText().toString();
        text.getText().clear();
        findViewById(R.id.display).setVisibility(View.GONE);
        findViewById(R.id.button).setVisibility(View.GONE);
        findViewById(R.id.DELETE).setVisibility(View.VISIBLE);
        findViewById(R.id.ADD).setVisibility(View.VISIBLE);
        findViewById(R.id.date_picker).setVisibility(View.VISIBLE);
    }



}