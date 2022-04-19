package ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geekbrains.myapplication.R;

import domain.City;

public class CitiesDetailsFragment extends Fragment {

    public static final String ARG_CITY = "arg_city";

    public CitiesDetailsFragment() {
        super(R.layout.fragment_details_cities);
    }

    public static CitiesDetailsFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(ARG_CITY, city);
        CitiesDetailsFragment fragment = new CitiesDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView icon = view.findViewById(R.id.icon_city);
        TextView title = view.findViewById(R.id.name_city);

        City city = getArguments().getParcelable(ARG_CITY);

        icon.setImageResource(city.getIcon());
        title.setText(city.getCityName());
    }
}
