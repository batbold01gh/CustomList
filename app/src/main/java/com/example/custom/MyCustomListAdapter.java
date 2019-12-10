package com.example.custom;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class MyCustomListAdapter extends ArrayAdapter<Hero> {

    Context mCtx;
    int resource;
    List<Hero> heroList;

    public MyCustomListAdapter(Context mCtx, int resource, List<Hero> heroList){

        super(mCtx, resource, heroList);
        this.mCtx= mCtx;
        this.resource=resource;
        this.heroList=heroList;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.my_list_item, null);

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textTeam);
        ImageView imageView = view.findViewById(R.id.imageView);

        Hero hero = heroList.get(position);

        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());
        imageView.setImageDrawable(mCtx.getResources().getDrawable(hero.getImage()));


        view.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }


        });
        return view;
    }
        private void removeItem(int i ){
            AlertDialog.Builder builder= new AlertDialog.Builder(mCtx);
            builder.setTitle("Are you sure you want to delete?");

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    heroList.remove(i);
                    notifyDataSetChanged();
                }
            });

            builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();





        }
    }

