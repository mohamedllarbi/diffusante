package com.larbibouamranemohamed.diffusante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class diffusantehome extends AppCompatActivity {
    RecyclerView drecyclerView;
    diffusanteadapter dadapter;

    static ProgressBar pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diffusanterecycler);

   pr = findViewById(R.id.progressBar);
   pr.setVisibility(View.VISIBLE);
        pr.setIndeterminate(true);
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

            drecyclerView= findViewById(R.id.diffrecycler);
            drecyclerView.setLayoutManager(layoutManager);



            FirebaseRecyclerOptions<diffusantemodel> options =
                    new FirebaseRecyclerOptions.Builder<diffusantemodel>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("programme"),diffusantemodel.class)
                            .build();

            dadapter= new diffusanteadapter(options);
            drecyclerView.setAdapter(dadapter);





    }


    public void onBackPressed() {
        Intent homeScreen = new Intent(Intent.ACTION_MAIN);
        homeScreen.addCategory(Intent.CATEGORY_HOME);
        homeScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeScreen);
    }

    public static void disableIt() {
       pr.setVisibility(View.INVISIBLE);

    }

    @Override
    protected   void onPause(){
        super.onPause();

        pr = findViewById(R.id.progressBar);
       
        pr.setIndeterminate(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        drecyclerView= findViewById(R.id.diffrecycler);
        drecyclerView.setLayoutManager(layoutManager);



        FirebaseRecyclerOptions<diffusantemodel> options =
                new FirebaseRecyclerOptions.Builder<diffusantemodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("programme"),diffusantemodel.class)
                        .build();

        dadapter= new diffusanteadapter(options);
        drecyclerView.setAdapter(dadapter);




    }




    @Override protected void onStart()
    {
        super.onStart();
        dadapter.startListening();

    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        dadapter.stopListening();

    }
}