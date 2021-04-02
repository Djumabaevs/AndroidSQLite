package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.data.DatabaseHandler;
import com.example.myapplication.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        contactArrayList = new ArrayList<>();

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact Jeremy = new Contact();
        Jeremy.setName("Jeremy");
        Jeremy.setPhoneNumber("123456789");

        db.addContact(Jeremy);

        db.addContact(new Contact("Bakyt", "12345"));
        db.addContact(new Contact("Oleg", "4563623"));
        db.addContact(new Contact("Talka", "563352"));
        db.addContact(new Contact("Malusk", "34535432"));
        db.addContact(new Contact("Igor", "4567"));
        db.addContact(new Contact("John", "4373473"));
        db.addContact(new Contact("Danny", "3457347"));
        db.addContact(new Contact("Asel", "97965"));
        db.addContact(new Contact("Josephene", "12345"));
        db.addContact(new Contact("Elmira", "12345"));
        db.addContact(new Contact("Chinara", "12345"));
        db.addContact(new Contact("Jennifer", "12345"));
        db.addContact(new Contact("Sharloy", "12345"));
        db.addContact(new Contact("David", "12345"));
        db.addContact(new Contact("Bob", "12345"));
        db.addContact(new Contact("Pit", "12345"));
        db.addContact(new Contact("Aidar", "12345"));
        db.addContact(new Contact("Amina", "12345"));
        db.addContact(new Contact("Elina", "12345"));
        db.addContact(new Contact("Nargiza", "12345"));

        Contact c = db.getContact(1);
        Log.d("Main", "onCreate: " + c.getName() + " , " + c.getPhoneNumber());
        c.setName("New Jeremy");
        c.setPhoneNumber("987654321");
        int updateRow = db.updateContact(c);
        Log.d("Main", "onCreate: " + updateRow);

        List<Contact> contactList = db.getAllContacts();
        for( Contact contact : contactList) {
            Log.d("Main", "onCreate: " + contact.getName());
            contactArrayList.add(contact.getName());
        }
        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactArrayList
        );
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("List", "onItemClick: " + position);
            }
        });
    }
}