package com.example.dragonhunt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int progressValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton play = findViewById(R.id.play);
        ImageButton tutorial = findViewById(R.id.tutorial);
        ImageButton options = findViewById(R.id.options);

        View.OnClickListener ButtonListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.play){
                    Intent x = new Intent(MainActivity.this, Character.class);
                    startActivity(x);
                }
                if(v.getId() == R.id.tutorial){
                    DialogFragment y = new TutorialDialogFragment();
                    y.show(getSupportFragmentManager(), "tutorial"); }
                if(v.getId() == R.id.options) {
                    DialogFragment z = new OptionsDialogFragment();
                    z.show(getSupportFragmentManager(), "options"); }
            }
        };
        tutorial.setOnClickListener(ButtonListener);
        play.setOnClickListener(ButtonListener);
        options.setOnClickListener(ButtonListener);

        SeekBar mySeekBar = findViewById(R.id.diff);

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int newProgressValue, boolean fromUser) {
                progressValue = newProgressValue;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is: " + progressValue, Toast.LENGTH_SHORT).show();
            }
        };
    }
    public static class CharacterDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = requireActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.play_ui, null));
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {}});
            return builder.create();
        }
    }
    public static class TutorialDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = requireActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.tutorial_ui, null))
                    .setPositiveButton("Understood.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {}});
            return builder.create();
        }
    }
    public static class OptionsDialogFragment extends DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = requireActivity().getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.options_ui, null))
                    .setPositiveButton("Finished.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {}});
            return builder.create();
        }
    }
}

