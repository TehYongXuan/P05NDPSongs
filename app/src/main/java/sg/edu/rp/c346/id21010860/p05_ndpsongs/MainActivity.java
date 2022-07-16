package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btninsert, btnshowlist;
    TextView tvTitle, tvSinger, tvYear, tvStars;
    EditText edTextSinger, edTextTitle, edTextYear;
    RadioGroup radioGroup;
    RadioButton rg1, rg2, rg3, rg4, rg5;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    Song data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsert = findViewById(R.id.btninsert);
        btnshowlist = findViewById(R.id.btnshowlist);
        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        edTextSinger = findViewById(R.id.edTextSingers);
        edTextTitle = findViewById(R.id.edTextTitle);
        edTextYear = findViewById(R.id.edtextyear);
        radioGroup = findViewById(R.id.radioGroup);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);

        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(MainActivity.this,
                        ShowSong.class);

                startActivity(i);
            }

        });

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = edTextYear.getText().toString();
                String data1 = edTextTitle.getText().toString();
                String data2 = edTextSinger.getText().toString();
                int data3 = radioGroup.getCheckedRadioButtonId();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(data,data1,data2,data3);

                 if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllSong());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful", Toast.LENGTH_LONG).show();
                }
            }
        });


        }


    }
