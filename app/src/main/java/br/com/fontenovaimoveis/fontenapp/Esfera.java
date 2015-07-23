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


public class Esfera extends ActionBarActivity {
Button BCalcular;
    private EditText raioArea;
    private EditText raioVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);
        BCalcular = (Button) findViewById(R.id.buttonCalc);
        raioArea = (EditText) findViewById(R.id.editTextAreaEsfera);
        raioVolume = (EditText) findViewById(R.id.editTextAreaVolumeEsfera);

        BCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((raioArea.getText().toString().equals(""))||(raioVolume.getText().toString().equals(""))){
                    Toast t = Toast.makeText(getApplicationContext(),"Informe o valor solicitado.",Toast.LENGTH_SHORT);
                    t.show();
                }else {

                    double rvolume;
                    double rarea;
                    double rA = Float.parseFloat(raioArea.getText().toString());
                    double rV = Float.parseFloat(raioVolume.getText().toString());

                    if(rA ==0) {
                        rvolume = 4/3*Math.PI*Math.pow(rV,3);

                        AlertDialog.Builder dialogo = new
                                AlertDialog.Builder(Esfera.this);
                        dialogo.setTitle("Resultado");
                        dialogo.setMessage("O Volume da esfera e:" +
                                String.valueOf(rvolume));
                        dialogo.setNeutralButton("OK",null);
                        dialogo.show();
                    }
                    else if(rV ==0){
                        rarea = 4*Math.PI*Math.pow(rA,2);

                        AlertDialog.Builder dialogo = new
                                AlertDialog.Builder(Esfera.this);
                        dialogo.setTitle("Resultado");
                        dialogo.setMessage("A area da esfera e:" +
                                String.valueOf(rarea));
                        dialogo.setNeutralButton("OK",null);
                        dialogo.show();
                    }
                }
            }
        });
        overridePendingTransition(R.anim.activity_filho_entrando, R.anim.activity_pai_saindo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_esfera, menu);
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
        //return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.acitivity_pai_antrando,R.anim.activity_filho_saindo);
    }
}
