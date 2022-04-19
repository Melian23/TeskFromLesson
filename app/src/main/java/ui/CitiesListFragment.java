package ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geekbrains.myapplication.R;

import java.util.List;

import domain.City;
import domain.InMemoryCitiesRepository;

public class CitiesListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout container = view.findViewById(R.id.container_cities);

        List<City> cities = InMemoryCitiesRepository.getInstance(requireContext()).getAll();

        for (City city : cities) {

            View itemView = getLayoutInflater().inflate(R.layout.item_city, container, false);
            container.addView(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    CityDetailsActivity.show(requireContext(), city);
                   // Toast.makeText(requireContext(), city.getCityName(), Toast.LENGTH_SHORT).show();
                }
            });

            ImageView icon = itemView.findViewById(R.id.city_image);
            icon.setImageResource(city.getIcon());

            TextView title = itemView.findViewById(R.id.city_name);
            title.setText(city.getCityName());

        }
    }
}
