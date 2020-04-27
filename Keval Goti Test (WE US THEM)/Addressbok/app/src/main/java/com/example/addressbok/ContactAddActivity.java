package com.example.addressbok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAddActivity extends AppCompatActivity {

    EditText nameEditText, mailEditText, phoneEditText;
    Button addButton;
    String stringName, stringMail, stringPhone;

    ContactsDB contactsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);


        contactsDB = new ContactsDB(ContactAddActivity.this);

        nameEditText = (EditText) findViewById(R.id.nameeditText);
        mailEditText = (EditText) findViewById(R.id.maileditText);
        phoneEditText = (EditText) findViewById(R.id.numbereditText);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringName = nameEditText.getText().toString();
                stringMail = mailEditText.getText().toString();
                stringPhone = phoneEditText.getText().toString();

                if (stringName.length() > 0 && stringMail.length() > 0 && stringPhone.length() > 0) {

                    String contactType = getIntent().getStringExtra("contact_type");

                    contactsDB.getWritableDatabase();
                    long id = contactsDB.insertContact(stringName, stringMail, stringPhone, contactType);

                    if (id>0)
                    {
                        Toast.makeText(ContactAddActivity.this,"Contact Added Successfully",Toast.LENGTH_LONG).show();
                        nameEditText.setText("");
                        mailEditText.setText("");
                        phoneEditText.setText("");
                    }

                    contactsDB.close();

                } else {
                    Toast.makeText(ContactAddActivity.this, "Fields must not be empty", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
