package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowSong extends AppCompatActivity {

    Button btnshowsong;
    ListView lv;
    ArrayAdapter<Song> aa;
    ArrayList<Song> al;
    Song data;
    CustomAdapter ca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        btnshowsong = findViewById(R.id.btnshowsong);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
//        lv.setAdapter(aa);
        ca = new CustomAdapter(ShowSong.this, R.layout.row, al);

        lv.setAdapter(ca);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long identity) {
                Song song = al.get(position);
                Intent i = new Intent(ShowSong.this, ModifySong.class);
                i.putExtra("data", song);
                startActivity(i);

            }
        });

        btnshowsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowSong.this);


                dbh.close();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHelper dbh = new DBHelper(ShowSong.this);
        al.clear();
        al.addAll(dbh.getAllSong());
        aa.notifyDataSetChanged();


    }

    @Override
    protected void onStop() {
        super.onStop();

        finish();

    }
}