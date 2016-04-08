package com.example.askin.merdivan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Askin on 21.12.2015.
 */
public class citySdkListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<citysdk> mCitysdkList;
    private List<citysdk> filteredCitysdkList;
    private citysdkFilter filter;

    public citySdkListAdapter(Activity activity, List<citysdk> citysdks) {
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCitysdkList = citysdks;
        filteredCitysdkList = citysdks;
        getFilter();
    }

    public Filter getFilter() {
        if (filter == null){
            filter  = new citysdkFilter();
        }
        return filter;
    }

    static class ViewHolder {
        protected TextView text;
        protected CheckBox checkbox;
    }

    private class citysdkFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint != null && constraint.toString().length() > 0)
            {
                ArrayList<citysdk> filteredItems = new ArrayList<citysdk>();

                for(int i = 0, l = mCitysdkList.size(); i < l; i++)
                {
                    citysdk m = mCitysdkList.get(i);
                    if(m.getType().toLowerCase().contains(constraint))
                        filteredItems.add(m);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                synchronized(this)
                {
                    result.values = mCitysdkList;
                    result.count = mCitysdkList.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredCitysdkList = (ArrayList<citysdk>)results.values;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mCitysdkList.size();
    }

    @Override
    public citysdk getItem(int position) {
        return mCitysdkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = mInflater.inflate(R.layout.citysdk_row_layout, null);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.belediye_icon);
        TextView textView = (TextView)rowView.findViewById(R.id.areas_name);
        TextView textView2 = (TextView)rowView.findViewById(R.id.areas_type);
        TextView textView3 = (TextView)rowView.findViewById(R.id.layer);


        citysdk cs = mCitysdkList.get(position);

        textView.setText(cs.getName());
        textView2.setText(cs.getType());
        textView3.setText(cs.getLayer());
        imageView.setImageResource(R.drawable.ibb_logo);



        return rowView;
    }


}
