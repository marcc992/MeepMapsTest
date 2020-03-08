package es.marcmauri.meepmaptest.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import es.marcmauri.meepmaptest.R;
import es.marcmauri.meepmaptest.databinding.ActivityWelcomeBinding;
import es.marcmauri.meepmaptest.maps.MapsActivity;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStart.setOnClickListener(v -> navigateToMaps());
    }

    @Override
    public void navigateToMaps() {
        startActivity(new Intent(this, MapsActivity.class));
        finish();
    }
}
