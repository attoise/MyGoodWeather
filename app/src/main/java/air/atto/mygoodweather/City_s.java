package air.atto.mygoodweather;

/**
 * Created by Оленька on 21.04.2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.EditText;
import android.content.Intent;
public class City_s extends Activity implements OnClickListener {

EditText MyCity;
    Button b_c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sity_select);
      //  String MySCity = MyCity.getText().toString();
      //  Intent intent = getIntent();


        MyCity= (EditText) findViewById(R.id.MyCity);

        b_c = (Button) findViewById(R.id.b_c);
        b_c.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("MySCity", MyCity.getText().toString());

        startActivity(intent);
    }
}
