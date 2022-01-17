package com.example.recyclerview;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    ListView listView1;
    EditText inputtext1;
    Button btnAdd;

    ArrayList<String> foods = new ArrayList<>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listview1);
        btnAdd = (Button) findViewById(R.id.button1);
        inputtext1 = (EditText) findViewById(R.id.editTextTextPersonName);

        //setup listview

        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        listView1.setAdapter(myAdapter1);

        //ADD itemss

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringval = inputtext1.getText().toString();
                foods.add(stringval);
                myAdapter1.notifyDataSetChanged();

                inputtext1.setText("");

            }
        });
        //select item
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                item = adapterView.getItemAtPosition(i).toString() + " has been deleted ";
                indexVal = i;
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }

        });
        //Delete
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                item = adapterView.getItemAtPosition(i).toString() + " has been deleted ";
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

                foods.remove(i);
                myAdapter1.notifyDataSetChanged();

                return true;

            }
        });


    }
}