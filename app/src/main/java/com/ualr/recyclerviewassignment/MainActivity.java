package com.ualr.recyclerviewassignment;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;
import com.ualr.recyclerviewassignment.model.Inbox;

import java.util.List;

// TODO 05. Create a new Adapter class and the corresponding ViewHolder class in a different file. The adapter will be used to populate
//  the recyclerView and manage the interaction with the items in the list
// TODO 06. Detect click events on the list items. Implement a new method to toggle items' selection in response to click events
// TODO 07. Detect click events on the thumbnail located on the left of every list row when the corresponding item is selected.
//  Implement a new method to delete the corresponding item in the list
// TODO 08. Create a new method to add a new item on the top of the list. Use the DataGenerator class to create the new item to be added.

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mFAB;
    private AdapterListBasic mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_multi_selection);
        initComponent();
        initRecyclerView();

        List<Inbox> items = DataGenerator.getInboxData(this);
        items.addAll(DataGenerator.getInboxData(this));
        items.addAll(DataGenerator.getInboxData(this));
        mAdapter = new AdapterListBasic(this, items);

        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Inbox obj, int position) {
                Log.d(TAG, String.format("The user has tapped on %s", obj.getFrom()));
            }
        });




    }


    private void initRecyclerView() {
        List<Inbox> items = DataGenerator.getInboxData(this);
        items.addAll(DataGenerator.getInboxData(this));
        items.addAll(DataGenerator.getInboxData(this));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new AdapterListBasic(this, items);
        recyclerView.setAdapter(mAdapter);

    }


    private void initComponent() {
        // TODO 01. Generate the item list to be displayed using the DataGenerator class
        List<Inbox> items = DataGenerator.getInboxData(this);
        items.addAll(DataGenerator.getInboxData(this));
        items.addAll(DataGenerator.getInboxData(this));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        // TODO 03. Do the setup of a new RecyclerView instance to display the item list properly
        // TODO 04. Define the layout of each item in the list
        // TODO 09. Create a new instance of the created Adapter class and bind it to the RecyclerView instance created in step 03
        mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 10. Invoke the method created to a new item to the top of the list so it's
                //  triggered when the user taps the Floating Action Button


            }
        });
    }}

