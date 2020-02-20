package example.android.epharmacyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){

                        case R.id.home:
                            selectedFragment =new HomeFragment();
                            break;
                        case R.id.notification:
                            selectedFragment =new NotificationFragment();
                            break;
                        case R.id.account:
                            selectedFragment =new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }

            };

//    public void openMyOrder(){
//        Intent i = new Intent(Main2Activity.this, MyOrder.class);
//        startActivity(i);
//    }
//    public void openMyCart(){
//        Intent i = new Intent(Main2Activity.this, MyCart.class);
//        startActivity(i);
//    }
//    public void openCallToOrder(){
//        Intent i = new Intent(Main2Activity.this, CallToOrder.class);
//        startActivity(i);
//    }
//    public void openStoreLocator(){
//        Intent i = new Intent(Main2Activity.this, StoreLocator.class);
//        startActivity(i);
//    }
}
