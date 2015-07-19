package br.com.fontenovaimoveis.fontenapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class TrianguloI extends ActionBarActivity {
Button BCalcular;
private EditText basetrainguloI;
private EditText alturatrianguloI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_i);
        BCalcular = (Button) findViewById(R.id.buttonCalc);
        basetrainguloI = (EditText) findViewById(R.id.editTextB);



        overridePendingTransition(R.anim.activity_filho_entrando,R.anim.activity_pai_saindo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_triangulo_i, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                return true;
            //noinspection SimplifiableIfStatement

            //if (id == R.id.action_settings) {
            //    return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.acitivity_pai_antrando,R.anim.activity_filho_saindo);
    }
}
