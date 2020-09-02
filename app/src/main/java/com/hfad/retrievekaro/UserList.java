package com.hfad.retrievekaro;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserList extends ArrayAdapter<stuff> {
    private Activity context;
    private List<stuff> stuffList;

    public UserList(Activity context, List<stuff> stuffList) {
        super(context, R.layout.list_layout,stuffList);
        this.context = context;
        this.stuffList = stuffList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView t1 = listViewItem.findViewById(R.id.t1);
        TextView t2 = listViewItem.findViewById(R.id.t2);

        stuff stf = stuffList.get(position);

        t1.setText(stf.useremail);
        t2.setText(stf.username);

        return listViewItem;
    }
}

















