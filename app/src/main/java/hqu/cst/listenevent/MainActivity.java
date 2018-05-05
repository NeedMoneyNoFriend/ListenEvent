package hqu.cst.listenevent;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity implements  OnClickListener{
    EditText txt;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);

        txt = (EditText)findViewById(R.id.edittext);

        class MyClickListener implements  OnClickListener{
            public void  onClick(View v){
                EditText txt = (EditText)findViewById(R.id.edittext);
                txt.setText("内部类");
            }
        }
        class ExtentEvent implements  OnClickListener{
            private Activity act;
            private EditText txt;
            public ExtentEvent(Activity act,EditText txt){
                this.act = act;
                this.txt = txt;
            }
            public void onClick(View v){
                txt.setText("外部类");
            }
        }
        btn1.setOnClickListener(new MyClickListener());
        btn2.setOnClickListener(new ExtentEvent(this,txt));
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("匿名内部类");
            }
        });
    }
    public void  clickHandler(View source){
        EditText et = (EditText)findViewById(R.id.edittext);
        et.setText("绑定到标签");
    }
    public void onClick(View v){
        txt.setText("Activity");
    }
}