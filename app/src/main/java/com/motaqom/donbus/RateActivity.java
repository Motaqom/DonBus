package com.motaqom.donbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }
    public void goNext() {
        EditText etName = findViewById(R.id.etName);
        EditText etRate = findViewById(R.id.etRate);
        Intent intent = new Intent(this, ThankyouActivity.class);
        intent.putExtra("Name", etName.getText());
        intent.putExtra("Rate", etRate.getText());
        startActivity(intent);
    }
    public void checkRating(){
        EditText etRate = findViewById(R.id.etRate);
        int rate = Integer.parseInt(etRate.getText().toString());
        if(rate>0 && rate<=5){

        }else{
            etRate.setText(getResources().getText(R.string.numHint));
            Toast.makeText(this, getResources().getText(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }
}
