package at.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Example extends Activity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonStar,button0,buttonClear;
    TextView numberView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        numberView = (TextView) findViewById(R.id.number_display);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonStar = (Button) findViewById(R.id.button_star);
        button0 = (Button) findViewById(R.id.button0);
        buttonClear = (Button) findViewById(R.id.button_clear);
        button1.setOnClickListener(this.appendString("1"));
        button2.setOnClickListener(this.appendString("2"));
        button3.setOnClickListener(this.appendString("3"));
        button4.setOnClickListener(this.appendString("4"));
        button5.setOnClickListener(this.appendString("5"));
        button6.setOnClickListener(this.appendString("6"));
        button7.setOnClickListener(this.appendString("7"));
        button8.setOnClickListener(this.appendString("8"));
        button9.setOnClickListener(this.appendString("9"));
        buttonStar.setOnClickListener(this.appendString("*"));
        button0.setOnClickListener(this.appendString("0"));
        buttonClear.setOnClickListener(this.appendString("Clear"));

    }

    public OnClickListener appendString(final String number){
        return new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                numberView.append(number);
            }
        };
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, Menu.FIRST, 0, "Exit").setIcon(android.R.drawable.ic_delete);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST:{
                finish();
                break;
            }
        }
        return false;
    }
}
