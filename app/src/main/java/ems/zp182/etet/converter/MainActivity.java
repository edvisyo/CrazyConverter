package ems.zp182.etet.converter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText userInput;

    Button convert;
    Button reset;

    TextView km;
    TextView cm;
    TextView ml;
    TextView yd;
    TextView ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     userInput = (EditText) findViewById(R.id.inputField);

     convert = (Button) findViewById(R.id.buttonConvert);
     reset = (Button) findViewById(R.id.buttonReset);

     km = (TextView) findViewById(R.id.kilometre1);
     cm = (TextView) findViewById(R.id.centimetre1);
     ml = (TextView) findViewById(R.id.mile1);
     yd = (TextView) findViewById(R.id.yard1);
     ft = (TextView) findViewById(R.id.foot1);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userInputValue;

                try {
                    userInputValue = Integer.parseInt(userInput.getText().toString());
                } catch (Exception ex) {
                    userInputValue = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Įvesk skaičių!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if (userInputValue > 0) {

                    DecimalFormat df = new DecimalFormat("##.##");

                    km.setText(String.valueOf(df.format(userInputValue / 1000)));
                    cm.setText(String.valueOf(df.format(userInputValue)));
                    ml.setText(String.valueOf(df.format(userInputValue / 160934.4)));
                    yd.setText(String.valueOf(df.format(userInputValue / 91.44)));
                    ft.setText(String.valueOf(df.format(userInputValue / 30.48)));

                }

            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(null);

                km.setText(R.string.text_result_empty);
                cm.setText(R.string.text_result_empty);
                ml.setText(R.string.text_result_empty);
                yd.setText(R.string.text_result_empty);
                ft.setText(R.string.text_result_empty);
            }
        });

    }
}





