package rocks.talha.recyclerviewtest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import rocks.talha.recyclerviewtest1.adapter.RecyclerViewAdapter;

public class SavedActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    MainActivity mainActivity = new MainActivity();

    private ArrayList<String> saved_idea_list;
    private ArrayList<String> saved_description_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        saved_idea_list = getIntent().getStringArrayListExtra("ideas");
        saved_description_list = getIntent().getStringArrayListExtra("descriptions");

        //Initializing RecyclerView
        recyclerView = findViewById(R.id.ideaList_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setting up RecyclerViewAdapter
        recyclerViewAdapter = new RecyclerViewAdapter(saved_idea_list, saved_description_list, SavedActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}