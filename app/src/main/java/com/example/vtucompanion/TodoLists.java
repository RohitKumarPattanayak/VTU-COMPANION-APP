package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TodoLists extends AppCompatActivity {
    private TextView welcome3;

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listview;
    private Button Add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_lists);
        welcome3 =findViewById(R.id.textView152);
        Add =findViewById(R.id.button4);
        listview =findViewById(R.id.listView);

    Add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            additem(view);
        }
    });
    items  = new ArrayList();
    itemsAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
    listview.setAdapter(itemsAdapter);
    setuolisview();

    welcome3.setText(" Hello "+MainActivity.forinsider+" hope you are having ");
    }

    private void setuolisview() {
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"item REMOVED",Toast.LENGTH_SHORT).show();

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem(View view){
        EditText input = findViewById(R.id.editTextTextPersonName11);
        String itemtext = input.getText().toString();


        if(!(itemtext.equals(""))){
            itemsAdapter.add(itemtext);
            input.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"please ENTER texts...",Toast.LENGTH_SHORT).show();

        }

    }
}