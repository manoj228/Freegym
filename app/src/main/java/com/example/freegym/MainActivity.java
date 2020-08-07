package com.example.freegym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvBrowse;
    Button btBrowse, btSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBrowse = findViewById(R.id.tvbrowse);
        btBrowse = findViewById(R.id.btnbrowse);
        btSubscribe = findViewById(R.id.btnsubscribe);

//       getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//       getSupportActionBar().setCustomView(R.layout.freegym);

        getSupportActionBar().setTitle("FreeGYM");


        // for highlighting the text in main page
        SpannableString str = new SpannableString("Browse FREE and EXCLUSIVE discounted fitness offers near you");
        ForegroundColorSpan yellow = new ForegroundColorSpan(Color.YELLOW);
        ForegroundColorSpan yel = new ForegroundColorSpan(Color.YELLOW);
        str.setSpan(yellow,7,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan(yel,16,26,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvBrowse.setText(str);

        btBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BrowseActivity.class));

            }
        });

        btSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SubscribeActivity.class));
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.login: startActivity(new Intent(MainActivity.this,LoginActivity.class));
            break;

            case R.id.signup: startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}