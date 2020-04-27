package com.example.addressbok;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DisplayContactsActivity extends AppCompatActivity {

    ContactsDB contactsDB;
    List<Contacts> contactsList;

    ListView contactListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);

        contactsDB = new ContactsDB(DisplayContactsActivity.this);

        contactListview = (ListView) findViewById(R.id.contactList);


        contactListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DisplayContactsActivity.this);
                alertDialog.setTitle("  Select Your Option?");
                // alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        contactsDB.deleteContact(contactsList.get(position).getId());

                        displaycontacts();
                    }
                });
                alertDialog.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent=new Intent(DisplayContactsActivity.this,DisplayContactsActivity.class);
                        intent.putExtra("id",contactsList.get(position).getId());
                        intent.putExtra("name",contactsList.get(position).getName());
                        intent.putExtra("mail",contactsList.get(position).getMail());
                        intent.putExtra("phone",contactsList.get(position).getPhonenumber());
                        startActivity(intent);
                    }
                });

                alertDialog.show();

                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        displaycontacts();

    }

    public class MycontactsAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return contactsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.contacts, null);

            TextView name = (TextView) convertView.findViewById(R.id.nametextView);
            TextView mail = (TextView) convertView.findViewById(R.id.mailtextView);
            TextView phoneNumber = (TextView) convertView.findViewById(R.id.phonetextView);

            name.setText(contactsList.get(position).getName());
            mail.setText(contactsList.get(position).getMail());
            phoneNumber.setText(contactsList.get(position).getPhonenumber());

            return convertView;
        }
    }

    public void displaycontacts() {

        String contactTypeString = getIntent().getStringExtra("contact_type");

        contactTypeString = contactTypeString.toLowerCase().toString();

        contactsList = contactsDB.getAllcontacts(contactTypeString.trim());

        if (contactsList.size() > 0) {
            contactListview.setAdapter(new MycontactsAdapter());

        } else {
            contactListview.setAdapter(new MycontactsAdapter());

            Toast.makeText(DisplayContactsActivity.this, "No contacts Added", Toast.LENGTH_LONG).show();
        }
    }
}
