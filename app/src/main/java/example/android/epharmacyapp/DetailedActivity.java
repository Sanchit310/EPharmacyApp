package example.android.epharmacyapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedActivity extends AppCompatActivity {
    TextView text1,text2;
    String versionName, version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        text1 = findViewById(R.id.versionname);
        text2 = findViewById(R.id.version);

        versionName = getIntent().getStringExtra("versionName");
        version = getIntent().getStringExtra("version");

        text1.setText(versionName);
        text2.setText(version);
    }
}
