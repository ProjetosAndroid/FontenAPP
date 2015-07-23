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


public class JurosSimples extends ActionBarActivity {
Button BCalcular;
    private EditText Capital;
    private EditText taxa;
    private EditText meses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_simples);
        BCalcular = (Button) findViewById(R.id.buttonCalc);
        Capital = (EditText) findViewById(R.id.editTextJurosCapital);
        taxa = (EditText) findViewById(R.id.editTextTaxaJuros);
        meses = (EditText) findViewById(R.id.editTextMesesJuros);

        BCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((Capital.getText().toString().equals(""))||(taxa.getText().toString().equals(""))||(meses.getText().toString().equals("")))){
                    Toast t = Toast.makeText(getApplicationContext(),"Informe o valor solicitado.",Toast.LENGTH_SHORT);
                    t.show();
                }else{
                    double juros;
                    double montante;
                    double c = Float.parseFloat(Capital.getText().toString());
                    double t = Float.parseFloat(taxa.getText().toString());
                    double m = Float.parseFloat(meses.getText().toString());

                    juros = c * t * m;
                    montante = c * (1 +(t * m));

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(JurosSimples.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("O juros e:" + String.valueOf(juros));
                    dialogo.setNeutralButton("OK",null);

                    dialogo.show();

                    AlertDialog.Builder dialogo2 = new AlertDialog.Builder(JurosSimples.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("O montante e:" + String.valueOf(montante));
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
        getMenuInflater().inflate(R.menu.menu_juros_simples, menu);
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
           // return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.acitivity_pai_antrando,R.anim.activity_filho_saindo);
    }
}
