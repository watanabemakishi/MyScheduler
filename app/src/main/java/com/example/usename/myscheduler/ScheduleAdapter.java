package com.example.usename.myscheduler;

import android.icu.text.SimpleDateFormat;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by makishiwatanabe on 2017/09/08.
 */

public class ScheduleAdapter extends RealmBaseAdapter<Schedule> {

    private static class ViewHolder{
        TextView date;
        TextView title;
    }
    public ScheduleAdapter(@Nullable OrderedRealmCollection<Schedule> data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_2,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView)convertView.findViewById(android.R.id.text1);
            viewHolder.title = (TextView)convertView.findViewById(android.R.id.text2);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Schedule schedule = adapterData.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdf.format(schedule.getDate());
        viewHolder.date.setText(formatDate);
        viewHolder.title.setText(schedule.getTitle());
        return convertView;
    }
}
