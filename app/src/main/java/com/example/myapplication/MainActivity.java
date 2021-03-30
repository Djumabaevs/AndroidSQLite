package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.data.DatabaseHandler;
import com.example.myapplication.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact Jeremy = new Contact();
        Jeremy.setName("Jeremy");
        Jeremy.setPhoneNumber("123456789");

        db.addContact(Jeremy);

        List<Contact> contactList = db.getAllContacts();
        for( Contact contact : contactList) {
            Log.d("Main", "onCreate: " + contact.getName());
        }
    }
}