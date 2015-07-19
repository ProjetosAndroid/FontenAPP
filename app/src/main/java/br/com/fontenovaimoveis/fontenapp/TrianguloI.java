package br.com.fontenovaimoveis.fontenapp;

import android.app.AlertDialog;
import android.bluetooth.BluetoothGattCallback;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TrianguloI extends ActionBarActivity {
Button BCalcular;
private EditText basetrainguloI;
private EditText alturatrianguloI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo_i);
        BCalcular = (Button) findViewById(R.id.buttonCalc);
        basetrainguloI = (EditText) findViewById(R.id.editTextBaseTrianguloIsoceles);
        alturatrianguloI = (EditText) findViewById(R.id.editTextAlturaTrianguloisoceles);

        BCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(basetrainguloI.getText().toString().equals("")||(alturatrianguloI.getText().toString().equals(""))){
                    Toast t = Toast.makeText(getApplicationContext(),"Informe o valor solicitado.",Toast.LENGTH_SHORT);
                    t.show();
                }else{
                    double resultado;
                    double baseIso = Float.parseFloat(basetrainguloI.getText().toString());
                    double alturaIso = Float.parseFloat(alturatrianguloI.getText().toString());

                    resultado = (baseIso*alturaIso/2);

                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(TrianguloI.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("A area do triangulo Isoceles e:" +
                            String.valueOf(resultado));
                    dialogo.setNeutralButton("OK",null);

                    dialogo.show();
                }
            }
        });



        overridePendingTransition(R.anim.activity_filho_entrando, R.anim.activity_pai_saindo);
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
