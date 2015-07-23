package br.com.fontenovaimoveis.fontenapp;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class JurosComposto extends ActionBarActivity {
Button BCalcular;
    private EditText CapitalComposto;
    private EditText TaxaComposto;
    private EditText MesesComposto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_composto);
        BCalcular = (Button) findViewById(R.id.buttonCalc);
        CapitalComposto = (EditText) findViewById(R.id.editTextCapitalJurosCompostos);
        TaxaComposto = (EditText) findViewById(R.id.editTextTaxaJurosCompostos);
        MesesComposto = (EditText) findViewById(R.id.editTextMesesJurosCompostos);

        BCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CapitalComposto.getText().toString().equals(""))||(TaxaComposto.getText().toString().equals(""))||(MesesComposto.getText().toString().equals("")))){
                    Toast t = Toast.makeText(getApplicationContext(),"Informe o valor solicitado.",Toast.LENGTH_SHORT);
                    t.show();
                }else{
                    double jurosC;
                    double montanteC;
                    double cc = Float.parseFloat(CapitalComposto.getText().toString());
                    double tc = Float.parseFloat(TaxaComposto.getText().toString());
                    double mc = Float.parseFloat(MesesComposto.getText().toString());

                    montanteC = cc * Math.pow((1 + tc), mc);
                    jurosC = montanteC - cc;

                    AlertDialog.Builder dialogo = new AlertDialog.Builder(JurosComposto.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("O juros e:" + String.valueOf(jurosC));
                    dialogo.setNeutralButton("OK",null);

                    dialogo.show();

                    AlertDialog.Builder dialogo2 = new AlertDialog.Builder(JurosComposto.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("O montante e:" + String.valueOf(montanteC));
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
        getMenuInflater().inflate(R.menu.menu_juros_composto, menu);
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
       // if (id == R.id.action_settings) {
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
