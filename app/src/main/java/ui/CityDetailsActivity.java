package ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.myapplication.R;

import domain.City;

public class CityDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_CITY = "EXTRA_CITY";

    public static void show(Context context, City city) {
        Intent intent = new Intent(context, CityDetailsActivity.class);
        intent.putExtra(EXTRA_CITY, city);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        if (savedInstanceState == null) {
            City city = getIntent().getParcelableExtra(EXTRA_CITY);
            CitiesDetailsFragment citiesDetailsFragment = CitiesDetailsFragment.newInstance(city);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.city_details_activity, citiesDetailsFragment)
                    .commit();
        }
    }
}