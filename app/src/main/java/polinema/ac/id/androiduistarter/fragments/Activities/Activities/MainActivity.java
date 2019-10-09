package polinema.ac.id.androiduistarter.fragments.Activities.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.androiduistarter.R;
import polinema.ac.id.androiduistarter.fragments.Activities.Fragments.DiscountFragment;
import polinema.ac.id.androiduistarter.fragments.Activities.Fragments.TravelFragment;
import polinema.ac.id.androiduistarter.fragments.Activities.Fragments.foodFragment;
import polinema.ac.id.androiduistarter.fragments.Activities.Fragments.movieFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new foodFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_food:
                fragment = new foodFragment();
                break;
            case R.id.action_movie:
                fragment = new movieFragment();
                break;
            case R.id.action_discount:
                fragment = new DiscountFragment();
                break;
            case R.id.action_travel:
                fragment = new TravelFragment();
                break;
        }
        return loadFragment(fragment);
    }
}