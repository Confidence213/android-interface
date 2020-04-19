package com.example.aninterface;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    HashMap<String, String> nameAddress;
    ArrayList<HashMap<String, String>> listItems;
    ListView resultsListView;
    SimpleAdapter adapter;
    String[] names;
    String[] addresses;
    CheckBox checkBox;
    Button buttonDelete;
    Button buttonCyan;
    Button buttonYellow;
    ImageView imageProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names =  getResources().getStringArray(R.array.array_ofNames);
        addresses = getResources().getStringArray(R.array.array_ofAddresses);
        resultsListView = findViewById(R.id.results_listView);
        checkBox = findViewById(R.id.checkBox);
        buttonDelete = findViewById(R.id.button_delete);
        buttonCyan = findViewById(R.id.button_cyan);
        buttonYellow = findViewById(R.id.button_yellow);
        imageProfile = findViewById(R.id.image_profile);

        listItems = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            nameAddress = new HashMap<>();
            nameAddress.put("name", names[i]);
            nameAddress.put("address", addresses[i]+"");
            listItems.add(nameAddress);
        }

        adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"name", "address"}, new int[] {R.id.textView1, R.id.textView2});

        resultsListView.setAdapter(adapter);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resultsListView.removeAllViewsInLayout();
            }
        });

        buttonCyan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resultsListView.setBackgroundColor(Color.CYAN);
            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resultsListView.setBackgroundColor(Color.YELLOW);
            }
        });

        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}
