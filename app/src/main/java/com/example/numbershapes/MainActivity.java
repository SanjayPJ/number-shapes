package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class Number{
        int number;

        public boolean isTriangular()
        {
            // Base case
            if (number < 0)
                return false;

            // A Triangular number must be
            // sum of first n natural numbers
            int sum = 0;

            for (int n = 1; sum <= number; n++)
            {
                sum = sum + n;
                if (sum == number)
                    return true;
            }

            return false;
        }

        public boolean checkPerfectSquare()
        {

            // finding the square root of given number
            double sq = Math.sqrt(number);

            /* Math.floor() returns closest integer value, for
             * example Math.floor of 984.1 is 984, so if the value
             * of sq is non integer than the below expression would
             * be non-zero.
             */
            return ((sq - Math.floor(sq)) == 0);
        }
    }

    public void test_number(View view){
        String str;
        EditText numberEditText = (EditText) findViewById(R.id.number);
        int number = Integer.parseInt(numberEditText.getText().toString());
        Number my_number = new Number();
        my_number.number = number;
        if(my_number.isTriangular() == true && my_number.checkPerfectSquare()){
            str = "number is square and triangular.";
        }else if(my_number.isTriangular()){
            str = "number is triangular not square.";
        }else if(my_number.checkPerfectSquare()){
            str = "number is square not triangular.";
        }else{
            str = "number is neither triangular nor square.";
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
