package com.example.lenovo.complaint_box;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

public class ComplaintActivity extends AppCompatActivity {

    private Firebase mRef;
    private String mUserId;
    private String itemsUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        mRef = new Firebase(Constants.FIREBASE_URL);
        if (mRef.getAuth() == null) {
            loadLoginView();
        }

        try {
            mUserId = mRef.getAuth().getUid();
        } catch (Exception e) {
            loadLoginView();
        }

        itemsUrl = Constants.FIREBASE_URL + "/users/" + mUserId + "/complaints";

        // Add items via the Button and EditText at the bottom of the view.
        final EditText descriptionText = (EditText) findViewById(R.id.complaintDescription);
        final EditText addressText = (EditText) findViewById(R.id.complaintAddress);
        final EditText phoneText = (EditText) findViewById(R.id.phone);
        final Button button = (Button) findViewById(R.id.addButton);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String description = descriptionText.getText().toString();
                final String address = addressText.getText().toString();
                final String phone = phoneText.getText().toString();
                if (description.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    Context context = getApplicationContext();
                    CharSequence text = "Please fill all the fields!!!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    new Firebase(itemsUrl)
                            .push()
                            .child("complaints")
                            .setValue("Complaint : " + description + "\n\nAddress : " + address + "\nContact : " + phone);

//                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("Compalint", description);
//                    map.put("Address", address);
//                    map.put("Contact", phone);
//                    new Firebase(itemsUrl).push().child("Complaints").setValue(map);

                    descriptionText.setText("");
                    addressText.setText("");
                    phoneText.setText("");
                    Context context = getApplicationContext();
                    CharSequence text = "Complaint Registered!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    public void viewComplaints(View view) {
        Intent i = new Intent(ComplaintActivity.this,ViewComplaintsActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            mRef.unauth();
            loadLoginView();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadLoginView() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
