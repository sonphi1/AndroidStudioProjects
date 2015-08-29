package at.exam;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		//Thiết lập giao diện lấy từ file main.xml
		setContentView(R.layout.activity_main);
		//Lấy về các thành phần trong main.xml thông qua id
		final EditText edit = (EditText) findViewById(R.id.edit_text);
		final TextView text = (TextView) findViewById(R.id.text_view);
		//Thiết lập xử lý cho sự kiện nhấn nút giữa của điện thoại
		edit.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN
					&& keyCode == KeyEvent.KEYCODE_ENTER) {text.setText(edit.getText().toString()); edit.setText("");
					return true;
				}
				else {
					return false;
				}
			}
		});
	}
}
