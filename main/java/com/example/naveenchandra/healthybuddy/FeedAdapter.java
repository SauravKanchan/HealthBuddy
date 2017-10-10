package com.example.naveenchandra.healthybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NAVEENCHANDRA on 19-03-2017.
 */
public class FeedAdapter extends ArrayAdapter{
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FeedEntry currentApp = applications.get(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //viewHolder pattern

        viewHolder.Name.setText(currentApp.getTitle());
        viewHolder.Link.setText(currentApp.getLink());
        return convertView;
    }

    private class ViewHolder {
        final TextView Name;
        final TextView Link;

        ViewHolder(View v){
            this.Name = (TextView) v.findViewById(R.id.Title);
            this.Link =(TextView) v.findViewById(R.id.links);
        }

    }
}

