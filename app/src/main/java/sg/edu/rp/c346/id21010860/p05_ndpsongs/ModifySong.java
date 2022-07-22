package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ModifySong extends AppCompatActivity {


    TextView tvTitle, tvSinger, tvYear, tvStars, tvID;
    EditText edTextSinger, edTextTitle, edTextYear;
    RadioGroup radioGroup,radiogroupedit;
    RadioButton rg0,rg1, rg2, rg3, rg4, rg5;
    Button btnupdate, btndelete, btncancel;
    Song data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        btncancel = findViewById(R.id.btncancel);
        tvID = findViewById(R.id.tvID);
        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        edTextSinger = findViewById(R.id.edtxtsingers);
        edTextTitle = findViewById(R.id.edtxtsongtitle);
        edTextYear = findViewById(R.id.edtxtyear);
        radioGroup = findViewById(R.id.radioGroupEdit);


        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);


        //initialize the variables with UI here

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
        tvID.setText("Song ID : " +data.getId()+"");



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                data.setSingers(edTextSinger.getText().toString());
                data.setTitle(edTextTitle.getText().toString());
                data.setYear(Integer.parseInt(edTextYear.getText().toString()));
                int rg = radioGroup.getCheckedRadioButtonId();
                rg0 = findViewById(rg);
               int rate = Integer.parseInt(rg0.getText().toString());
                Log.d("result", rg0+"");
                Log.d("result", rg0+);




//                switch (radioGroup.getCheckedRadioButtonId()) {
//                    case R.id.rg1:
//                        rg = 1;
//                        break;
//                    case R.id.rg2:
//                        rg = 2;
//                        break;
//                    case R.id.rg3:
//                        rg = 3;
//                        break;
//                    case R.id.rg4:
//                        rg = 4;
//                        break;
//                    case R.id.rg5:
//                        rg = 5;
//                        break;
//                }

                data.setStars(rate);

                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                int id = data.getId();
                Log.d("song id: ", id+"");

                dbh.deleteSong(data.getId());
                finish();

            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
