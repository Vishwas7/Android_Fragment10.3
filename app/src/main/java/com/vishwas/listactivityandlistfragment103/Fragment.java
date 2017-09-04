package com.vishwas.listactivityandlistfragment103;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishwas on 4/3/2017.
 */

public class Fragment extends ListFragment {

    private List<UsingListViewItem> elements;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        elements = new ArrayList<UsingListViewItem>();
        Resources resources = getResources();
        //In here adding elements like image,Title and Description..
        elements.add(new UsingListViewItem(ContextCompat.getDrawable(getActivity().getApplicationContext()
                , R.drawable.youtubelogo), "YouTube", "YouTube Description"));
        //In here adding elements like image,Title and Description..
        elements.add(new UsingListViewItem(ContextCompat.getDrawable(getActivity().getApplicationContext()
                , R.drawable.bloggerlogo), "Blogger", "Blogger Description"));

        //In here setting the list adapter
        setListAdapter(new UsingListViewAdapter(getActivity(), elements));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(null);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        UsingListViewItem item = elements.get(position);
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();

    }
}
