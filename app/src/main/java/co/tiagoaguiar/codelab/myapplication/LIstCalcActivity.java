package co.tiagoaguiar.codelab.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class LIstCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_calc);

        Bundle extras =  getIntent().getExtras();

        if(extras != null){
            String type = extras.getString("type");
           List<Register> registers =  SqlHelper.getInstance(this).getRegisterBy(type);
        }
    }
}