package com.example.sudokosolver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EnterSudoku extends AppCompatActivity {

    EditText img0;
    EditText img1;
    EditText img2;
    EditText img3;
    EditText img4;
    EditText img5;
    EditText img6;
    EditText img7;
    EditText img8;

    EditText[][] arr = {{img0,img1,img2},{img3,img4,img5},{img6,img7,img8}};

    int block = 0;
    int[][][] grid = {
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
            {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_sudoko);

        img0 = findViewById(R.id.imageView0);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        img7 = findViewById(R.id.imageView7);
        img8 = findViewById(R.id.imageView8);

        reset();

        TextView blockText = findViewById(R.id.currentblock);
        Button b1 = findViewById(R.id.next);
        Button b2 = findViewById(R.id.save);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (block<8){
                    store();
                    block++;
                    int temp =block+1;
                    blockText.setText("Block: "+temp);
                    reset();
                }
                else{
                    store();
                    b2.setVisibility(View.VISIBLE);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                solve();

                Intent intent = new Intent(getApplicationContext(),DisplaySolution.class);
                intent.putExtra("Solution",getGrid());
                startActivity(intent);

            }
        });

    }
    public void reset(){
        img0.setText("");
        img1.setText("");
        img2.setText("");
        img3.setText("");
        img4.setText("");
        img5.setText("");
        img6.setText("");
        img7.setText("");
        img8.setText("");

    }

    public void solve(){
        sudokomethods sudoku = new sudokomethods();
        sudoku.fill(grid);
    }

    public void store(){
        if (TextUtils.isEmpty(img0.getText().toString().trim())){
            grid [block][0][0] = 0;
        }
        else {
            grid [block][0][0] = Integer.parseInt(img0.getText().toString());
        }
        if (TextUtils.isEmpty(img1.getText().toString().trim())){
            grid [block][0][1] = 0;
        }
        else {
            grid [block][0][1] = Integer.parseInt(img1.getText().toString());
        }
        if (TextUtils.isEmpty(img2.getText().toString().trim())){
            grid [block][0][2] = 0;
        }
        else {
            grid [block][0][2] = Integer.parseInt(img2.getText().toString());
        }
        if (TextUtils.isEmpty(img3.getText().toString().trim())){
            grid [block][1][0] = 0;
        }
        else {
            grid [block][1][0] = Integer.parseInt(img3.getText().toString());
        }
        if (TextUtils.isEmpty(img4.getText().toString().trim())){
            grid [block][1][1] = 0;
        }
        else {
            grid [block][1][1] = Integer.parseInt(img4.getText().toString());
        }
        if (TextUtils.isEmpty(img5.getText().toString().trim())){
            grid [block][1][2] = 0;
        }
        else {
            grid [block][1][2] = Integer.parseInt(img5.getText().toString());
        }
        if (TextUtils.isEmpty(img6.getText().toString().trim())){
            grid [block][2][0] = 0;
        }
        else {
            grid [block][2][0] = Integer.parseInt(img6.getText().toString());
        }
        if (TextUtils.isEmpty(img7.getText().toString().trim())){
            grid [block][2][1] = 0;
        }
        else {
            grid [block][2][1] = Integer.parseInt(img7.getText().toString());
        }
        if (TextUtils.isEmpty(img8.getText().toString().trim())){
            grid [block][2][2] = 0;
        }
        else {
            grid [block][2][2] = Integer.parseInt(img8.getText().toString());
        }
    }

    public String getGrid(){
        String Solution ="";
        int i, k, j;
        for (i = 0; i < 3; i++) {
            for (k = 0; k < 3; k++) {
                for (j = 0; j < 3; j++) {
                    Solution = Solution +(grid[k][i][j]+" ");
                }
            }
            Solution = Solution + "\n";
        }
        for (i = 0; i < 3; i++) {
            for (k = 3; k < 6; k++) {
                for (j = 0; j < 3; j++) {
                    Solution = Solution +(grid[k][i][j]+" ");
                }
            }
            Solution = Solution + "\n";
        }
        for (i = 0; i < 3; i++) {
            for (k = 6; k < 9; k++) {
                for (j = 0; j < 3; j++) {
                    Solution = Solution +(grid[k][i][j]+" ");
                }
            }
            Solution = Solution + "\n";
        }
        return Solution;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this, "Opening Help", Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EnterSudoku.this);
                alertDialogBuilder.setMessage("This is a Sudoku Solver.\n" +
                        "Enter your sudoku box by box, from left to right and top to bottom.\n" +
                        "After entering a box, press (Next) to enter the next box.\n" +
                        "After entering all the boxes, press (Solve).");

                alertDialogBuilder.setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
