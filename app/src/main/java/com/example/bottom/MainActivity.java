package com.example.bottom;

import static android.app.ProgressDialog.show;
import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottom2=findViewById(R.id.bottom2);
        ReplaceFragment(new homeFragment());
        bottom2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId()==R.id.btfav){
                    ReplaceFragment(new favFragment());

                }

                 if (menuItem.getItemId()==R.id.bthhome){
                    ReplaceFragment(new homeFragment());

                }

                if (menuItem.getItemId()==R.id.btset){
                    ReplaceFragment(new setFragment());
                }
                if (menuItem.getItemId() == R.id.btpage4) {
                    ReplaceFragment(new fourthFragment());
                }

                return true;
            }
        });
    }

    void ReplaceFragment(Fragment f){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.homef,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}