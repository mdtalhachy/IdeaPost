package rocks.talha.recyclerviewtest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import rocks.talha.recyclerviewtest1.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private EditText ideaTxt;
    private EditText descriptionTxt;
    private Button saveButton;
    private Button addButton;

    private ArrayList<String> ideaTitleArrayList;
    private ArrayList<String> ideaDescriptionArrayList;
    //to pass ideaTitleArrayList text
    //and to pass ArrayList size to RecyclerViewAdapter
    public ArrayList<String> getIdeaTitleArrayList() {
        return ideaTitleArrayList;
    }

    //to pass ideaDescriptionArrayList text
    public ArrayList<String> getIdeaDescriptionArrayList() {
        return ideaDescriptionArrayList;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ideaTxt = findViewById(R.id.idea_edit_text);
        descriptionTxt = findViewById(R.id.description_edit_text);
        saveButton = findViewById(R.id.save_button);
        addButton = findViewById(R.id.add_button);

        //Initializing ArrayList to store idea title and descriptions
        ideaTitleArrayList = new ArrayList<>();
        ideaDescriptionArrayList = new ArrayList<>();


        /* Setting onclick listener to ADD button
         * when user clicks this button, the idea and description will be added to
         * RecyclerView list but the Activity won't change to SavedActivity*/
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ideaString = ideaTxt.getText().toString().trim();
                String descriptionString = descriptionTxt.getText().toString().trim();

                ideaTitleArrayList.add(ideaString);
                ideaDescriptionArrayList.add(descriptionString);

                //setting text fields to empty after clicking add button
                ideaTxt.setText("");
                descriptionTxt.setText("");
            }
        });



        /* Setting on click listener to SAVE button
         * When user clicks this button, MainActivity will go to SavedActivity
         * and display the RecyclerView/list of ideas */

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("HeyActivity", "onClick: " + ideaTitleArrayList.size());
                Intent intent = new Intent(MainActivity.this, SavedActivity.class);

                //passing arraylist values to saved activity
                intent.putStringArrayListExtra("ideas", ideaTitleArrayList);
                intent.putStringArrayListExtra("descriptions", ideaDescriptionArrayList);
                startActivity(intent);
            }
        });

    }


}