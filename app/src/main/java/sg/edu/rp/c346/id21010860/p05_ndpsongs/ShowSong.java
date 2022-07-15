package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowSong extends AppCompatActivity {

    Button btnshowsong;
    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        btnshowsong = findViewById(R.id.btnshowsong);
        lv = findViewById(R.id.lv);


        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
    }
}