package com.example.hackeru.lesson30listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountriesAdapter extends ArrayAdapter<Country> {

    private List<Country> countries;
    private Context context;

    public CountriesAdapter(Context context, List<Country> countries) {
        super(context, R.layout.item_country, countries);
        this.context = context;
        this.countries = countries;
    }

    static class ViewContainer{
        TextView lblCountryName;
        TextView lblCountryCode;
        TextView lblCountryDialCode;
        ImageView imgCountry;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewContainer viewContainer = null;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_country, parent, false);
            viewContainer = new ViewContainer();
            viewContainer.lblCountryName = view.findViewById(R.id.lblCountryName);
            viewContainer.lblCountryCode = view.findViewById(R.id.lblCountryCode);
            viewContainer.lblCountryDialCode = view.findViewById(R.id.lblCountryDialCode);
            viewContainer.imgCountry = view.findViewById(R.id.imgCountry);
            view.setTag(viewContainer);
        }else{
            viewContainer = (ViewContainer)view.getTag();
        }
        Country country = countries.get(position);
        viewContainer.lblCountryName.setText(country.getName());
        viewContainer.lblCountryCode.setText(country.getCode());
        viewContainer.lblCountryDialCode.setText(country.getDialCode());
        viewContainer.imgCountry.setImageResource(country.getImage());
        return  view;
    }
}
