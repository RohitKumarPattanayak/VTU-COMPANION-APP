package com.example.vtucompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
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
    public static int c = 0;
    SharedPreferences Sp;
    SharedPreferences.Editor Spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_lists);

        welcome3 = findViewById(R.id.textView152);
        Add =findViewById(R.id.button4);
        listview =findViewById(R.id.listView);
        Sp = getApplicationContext().getSharedPreferences("DataBase",MODE_PRIVATE);
        Spe = Sp.edit();


    Add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            additem(view);
        }
    });

    items  = new ArrayList();
    itemsAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
    listview.setAdapter(itemsAdapter);
        if(Sp != null){
            if(Sp.contains("count")){
                c = Sp.getInt("count",0);
            }
            if(Sp.contains("todo0")) {
                itemsAdapter.add(Sp.getString("todo0", ""));
            }
            if(Sp.contains("todo1")){
                itemsAdapter.add(Sp.getString("todo1",""));
            }
            if(Sp.contains("todo2")){
                itemsAdapter.add(Sp.getString("todo2",""));
            }
            if(Sp.contains("todo3")){
                itemsAdapter.add(Sp.getString("todo3",""));
            }
            if(Sp.contains("todo4")){
                itemsAdapter.add(Sp.getString("todo4",""));
            }
            if(Sp.contains("todo5")){
                itemsAdapter.add(Sp.getString("todo5",""));
            }
            if(Sp.contains("todo6")){
                itemsAdapter.add(Sp.getString("todo6",""));
            }
            if(Sp.contains("todo7")){
                itemsAdapter.add(Sp.getString("todo7",""));
            }
            if(Sp.contains("todo8")){
                itemsAdapter.add(Sp.getString("todo8",""));
            }
            if(Sp.contains("todo9")){
                itemsAdapter.add(Sp.getString("todo8",""));
            }
            if(Sp.contains("todo10")){
                itemsAdapter.add(Sp.getString("todo8",""));
            }
        }
    setuolisview();

    welcome3.setText(" Hello "+MainActivity.forinsider+" hope you are having ");
    }

    private void setuolisview() {
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"ITEM REMOVED.",Toast.LENGTH_SHORT).show();
                //if(c<4) {c--;}else{c++}
                c--;
                Spe.remove("todo"+c+"");
                Spe.putInt("count",c);
                //Spe.putString("todo"+c+"","");
                Spe.apply();
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem(View view){
        EditText input = findViewById(R.id.editTextTextPersonName11);
        String itemtext = input.getText().toString();
        Spe.putString("todo"+c+"",itemtext);
        c++;
        if(c>=10){
            c=0;
        }
        Spe.putInt("count",c);
        Spe.apply();

        if(!(itemtext.equals(""))){
            itemsAdapter.add(itemtext);
            input.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"please enter something...!",Toast.LENGTH_SHORT).show();
        }
    }
}