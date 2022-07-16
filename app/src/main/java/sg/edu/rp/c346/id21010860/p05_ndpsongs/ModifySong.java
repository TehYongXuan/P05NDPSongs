package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ModifySong extends AppCompatActivity {


    TextView tvTitle, tvSinger, tvYear, tvStars, tvID;
    EditText edTextSinger, edTextTitle, edTextYear;
    RadioGroup radioGroup;
    RadioButton rg1, rg2, rg3, rg4, rg5;
    Button btnupdate, btndelete, btncancel;
    Song data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        tvID = findViewById(R.id.tvID);
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


        //initialize the variables with UI here

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                data.setSingers(edTextSinger.getText().toString());
                data.setTitle(edTextTitle.getText().toString());

                dbh.updateSong(data);
                dbh.close();
            }
        });
    }
}
//        btndelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(ModifySong.this);
//                dbh.deleteSong(data.getId());
//
//
//                btncancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        DBHelper dbh = new DBHelper(ModifySong.this);
//                        dbh.deleteSong(data.getId());

//