package com.pamsillah.zciea.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pamsillah.zciea.R;
import com.pamsillah.zciea.models.ModelRecords;

import java.util.List;

public class AdapterRecords  extends BaseAdapter {
    private Context recordContext;
    private List<ModelRecords> recordsList;

    public AdapterRecords(Context recordContext, List<ModelRecords> recordsList) {
        this.recordContext = recordContext;
        this.recordsList = recordsList;
    }

    @Override
    public int getCount() {
        return recordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private static class RecordViewHolder {

        public TextView nameView;
        public TextView tradeView;
        public TextView ageView;
        public TextView territoryView;
        public TextView genderView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecordViewHolder holder;

        if( convertView == null ) {
            LayoutInflater recordInflater = (LayoutInflater)  recordContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = recordInflater.inflate(R.layout.layout_record, null);
            holder = new RecordViewHolder();
            holder.ageView  = convertView.findViewById(R.id.record_age);
            holder.genderView = convertView.findViewById(R.id.record_gender);
            holder.nameView = convertView.findViewById(R.id.record_name);
            holder.territoryView = convertView.findViewById(R.id.record_territory);
            holder.tradeView = convertView.findViewById(R.id.record_trade);
            convertView.setTag(holder);
        }else {
            holder =  (RecordViewHolder)convertView.getTag();
        }
        ModelRecords record = (ModelRecords) getItem(position);
        holder.nameView.setText(record.membername);
        holder.ageView.setText(record.age);
        holder.tradeView.setText(record.trade);
        holder.genderView.setText(record.gender);
        holder.territoryView.setText(record.territory);
        return convertView;
    }


    //What we want to do now is, when we receive an event from Pusher about a new record, we want to add that new record to our RecordAdapter and update our recordsList with that new employee record. Here’s how we achieve that:
    public void add( ModelRecords records ) {
        recordsList.add(records);
        notifyDataSetChanged();
    }
}
