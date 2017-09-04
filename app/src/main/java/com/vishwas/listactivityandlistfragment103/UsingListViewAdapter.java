package com.vishwas.listactivityandlistfragment103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vishwas on 4/3/2017.
 * creating a class UsingListViewAdapter and extends ArrayAdapter..
 */

public class UsingListViewAdapter extends ArrayAdapter
{
    //declaring
    Context context;
    //creating constructor..
    public UsingListViewAdapter(Context context,List<UsingListViewItem> items)
    {
        super(context, R.layout.list_item_layout, items);

        this.context = context;
    }
    //creating myViewHolder and declaring fields...
    private static class MyViewHolder
    {
        ImageView imageView;
        TextView textViewForTitle;
        TextView textViewForDescription;
    }

    /**
     * in here using getView..
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        MyViewHolder myViewHolder;

        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);

            //in here initializing the myViewHolder
            myViewHolder = new MyViewHolder();
            // casting all variable here
            myViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageLogo);
            myViewHolder.textViewForTitle = (TextView) convertView.findViewById(R.id.LogoTitle);
            myViewHolder.textViewForDescription = (TextView) convertView.findViewById(R.id.LogoDescription);
            convertView.setTag(myViewHolder);
        } else
            {
                myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //to update view, creating a object of UsingListViewItem class and getting the position..
        UsingListViewItem listOfItem= (UsingListViewItem) getItem(position);
        myViewHolder.imageView.setImageDrawable(listOfItem.logo);
        myViewHolder.textViewForTitle.setText(listOfItem.title);
        myViewHolder.textViewForDescription.setText(listOfItem.description);
        return convertView;
    }
}
