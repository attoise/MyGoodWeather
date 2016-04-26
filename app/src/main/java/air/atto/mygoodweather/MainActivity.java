package air.atto.mygoodweather;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.text.Html;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends  AppCompatActivity implements OnClickListener {
    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Button b_update, b_city;
    TextView testV;

    void Myfunc()
    {  setContentView(R.layout.activity_main);
        b_city = (Button) findViewById(R.id.b_city);
        b_update = (Button) findViewById(R.id.b_update);
        b_update .setOnClickListener(this);
        b_city.setOnClickListener(this);
        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/meteocons-webfont.ttf");
        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);

        Function.placeIdTask asyncTask =new Function().new placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("25.180000", "89.530000");}
    Typeface weatherFont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Myfunc();

        testV = (TextView) findViewById(R.id.testV);

        Intent intent = getIntent();

        String MySCity= intent.getStringExtra("MySCity");


        testV.setText("Your name is: " + MySCity);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b_update:

                Myfunc();

                break;

            case R.id.b_city:
                Intent intent = new Intent(this, City_s.class);
                startActivity(intent);
                break;
            default:
                break;

        }

    }

}
