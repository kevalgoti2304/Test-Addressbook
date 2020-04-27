package com.example.addressbok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddContactHomeActivity extends AppCompatActivity {


    RadioGroup radioGroup;
    RadioButton familyRadioButton,friendsRadioButton,residenceRadioButton,collegeRadioButton,othersRadioButton;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_home);

        radioGroup= (RadioGroup) findViewById(R.id.addradiogroup);
        familyRadioButton= (RadioButton) findViewById(R.id.familyRadioButton);
        friendsRadioButton= (RadioButton) findViewById(R.id.friendsRadioButton);
        residenceRadioButton= (RadioButton) findViewById(R.id.residenceRadioButton);
        collegeRadioButton= (RadioButton) findViewById(R.id.collegeRadioButton);
        othersRadioButton= (RadioButton) findViewById(R.id.othersRadioButton);

        submitButton= (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedRadioButton=radioGroup.getCheckedRadioButtonId();

                Intent addcontact=new Intent(AddContactHomeActivity.this,ContactAddActivity.class);

                if (selectedRadioButton==familyRadioButton.getId())
                {
                    addcontact.putExtra("contact_type","family");
                }else  if (selectedRadioButton==friendsRadioButton.getId())
                {
                    addcontact.putExtra("contact_type","friends");
                }else  if (selectedRadioButton==residenceRadioButton.getId())
                {
                    addcontact.putExtra("contact_type","residence");
                }else  if (selectedRadioButton==collegeRadioButton.getId())
                {
                    addcontact.putExtra("contact_type","college");
                }else  if (selectedRadioButton==othersRadioButton.getId())
                {
                    addcontact.putExtra("contact_type","others");
                }
                startActivity(addcontact);
            }
        });

    }

}
