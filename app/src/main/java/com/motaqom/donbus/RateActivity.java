package com.motaqom.donbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class RateActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        EditText etRate = findViewById(R.id.etRate);
        etRate.addTextChangedListener(new TextWatcher() {
            Boolean remove = false;
            Boolean erase = false;
            String value = null;
            String replace = null;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                value = etRate.getText().toString();
                int finalValue = 0;
                remove = false;
                erase = false;
                if (!etRate.getText().toString().isEmpty()) {
                    try {
                        finalValue = Integer.parseInt(value);
                    } catch (Exception e) {
                        remove = false;
                        erase = false;
                    }
                    if (finalValue != 0 && finalValue <= 5) {
                        remove = false;
                        erase = false;
                    } else {
                        if (finalValue > 9) {
                            erase = true;
                            String save = String.valueOf(finalValue);
                            replace = save.substring(0,1);
                        } else {
                            remove = true;
                            erase = false;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                while (remove){
                 etRate.setText("");
                    remove = false;
                }
                while (erase){
                    etRate.setText(replace);
                    erase = false;
                }
            }
        });
    }

    public void goNext(View view) {
        EditText etName = findViewById(R.id.etName);
        EditText etRate = findViewById(R.id.etRate);
        if(!etName.getText().toString().isEmpty() && !etRate.getText().toString().isEmpty()){
            Intent intent = new Intent(this, ThankyouActivity.class);
            intent.putExtra("Name", etName.getText().toString());
            intent.putExtra("Rate", etRate.getText().toString());
            startActivity(intent);
            }
        }

}
