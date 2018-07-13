package com.example.duongtainhan555.seekbarracing;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CheckBox ckOne, ckTwo, ckThree;
    private SeekBar sbOne, sbTwo, sbThree;
    private ImageView imgPlay;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        eventClick();
    }

    private void AnhXa(){
        //Anh xa
        ckOne = findViewById(R.id.checkboxOne);
        ckTwo = findViewById(R.id.checkboxTwo);
        ckThree = findViewById(R.id.checkboxThree);
        sbOne = findViewById(R.id.seekbarOne);
        sbTwo = findViewById(R.id.seekbarTwo);
        sbThree = findViewById(R.id.seekbarThree);
        imgPlay = findViewById(R.id.imgPlay);
        //
        imgPlay.setEnabled(false);
    }
    private void eventClick() {
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(60000, 500) {
                    @Override
                    public void onTick(long l) {
                        LockSeekBarAndCheckBox();
                        random = new Random();
                        int randomOne = random.nextInt(10) + 1;
                        int randomTwo = random.nextInt(10) + 1;
                        int randomThree = random.nextInt(10) + 1;

                        sbOne.setProgress(sbOne.getProgress() + randomOne);
                        sbTwo.setProgress(sbTwo.getProgress() + randomTwo);
                        sbThree.setProgress(sbThree.getProgress() + randomThree);

                        if (sbOne.getProgress() >= 100) {
                            Toast.makeText(MainActivity.this, "Tiger Win", Toast.LENGTH_SHORT).show();
                            this.cancel();
                            CheckWin();
                            try{
                                Thread.sleep(1000);
                            }
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            Restart();
                        } else if (sbTwo.getProgress() >= 100) {
                            Toast.makeText(MainActivity.this, "Buffalo Win", Toast.LENGTH_SHORT).show();
                            this.cancel();
                            CheckWin();
                            try{
                                Thread.sleep(1000);
                            }
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            Restart();
                        } else if (sbThree.getProgress() >= 100) {
                            Toast.makeText(MainActivity.this, "Cat Win", Toast.LENGTH_SHORT).show();
                            this.cancel();
                            CheckWin();
                            try{
                                Thread.sleep(1000);
                            }
                            catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            Restart();
                        }
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                countDownTimer.start();
                imgPlay.setEnabled(false);
            }
        });
        ckOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ckOne.isChecked())
                {
                    ckOne.setChecked(true);
                    ckTwo.setChecked(false);
                    ckThree.setChecked(false);
                    imgPlay.setEnabled(true);
                }
            }
        });
        ckTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ckTwo.isChecked())
                {
                    ckTwo.setChecked(true);
                    ckOne.setChecked(false);
                    ckThree.setChecked(false);
                    imgPlay.setEnabled(true);
                }
            }
        });
        ckThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ckThree.isChecked())
                {
                    ckThree.setChecked(true);
                    ckTwo.setChecked(false);
                    ckOne.setChecked(false);
                    imgPlay.setEnabled(true);
                }
            }
        });
    }
    private void Restart()
    {
        ckOne.setEnabled(true);
        ckTwo.setEnabled(true);
        ckThree.setEnabled(true);
        ckOne.setChecked(false);
        ckTwo.setChecked(false);
        ckThree.setChecked(false);
        //
        sbOne.setProgress(0);
        sbTwo.setProgress(0);
        sbThree.setProgress(0);
        //
        imgPlay.setEnabled(false);
    }
    private void CheckWin()
    {
        if (sbOne.getProgress() >= 100) {
            if(ckOne.isChecked())
            {
                Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
            }
        } else if (sbTwo.getProgress() >= 100) {
            if(ckTwo.isChecked())
            {
                Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
            }

        } else if (sbThree.getProgress() >= 100) {
            if(ckThree.isChecked())
            {
                Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void LockSeekBarAndCheckBox()
    {
        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThree.setEnabled(false);
        //
        ckOne.setEnabled(false);
        ckTwo.setEnabled(false);
        ckThree.setEnabled(false);
    }

}
