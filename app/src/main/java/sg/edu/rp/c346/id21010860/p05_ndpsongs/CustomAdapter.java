package sg.edu.rp.c346.id21010860.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        this.parent_context = context;
        this.layout_id = resource;    //Layout file for the row
        this.versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvT);
        TextView tvYear = rowView.findViewById(R.id.tvY);
        TextView tvStars = rowView.findViewById(R.id.tvST);
        TextView tvSingers = rowView.findViewById(R.id.tvSi);


        // Obtain the Android Version information based on the position
        Song currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYear()+"");
        tvSingers.setText(currentVersion.getSingers());


        String star = "";
        if (currentVersion.getStars()==1) {
            star = " * ";
        }
            else if(currentVersion.getStars() == 2){
                star = " * * ";
            }
        else if(currentVersion.getStars() == 3){
            star = " * * * ";
        }
        else if(currentVersion.getStars() == 4){
            star = " * * * * ";
        }
        else
            star = " * * * * * ";
        tvStars.setText(star);

        return rowView;
    }

}


