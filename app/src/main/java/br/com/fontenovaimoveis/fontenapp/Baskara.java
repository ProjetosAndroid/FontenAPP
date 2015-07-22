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


public class Baskara extends ActionBarActivity {
Button BCalcular;
    private EditText A;
    private EditText B;
    private EditText C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baskara);
      BCalcular = (Button) findViewById(R.id.buttonCalc);
        A = (EditText) findViewById(R.id.editTextA);
        B = (EditText) findViewById(R.id.editTextB);
        C = (EditText) findViewById(R.id.editTextC);

        BCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(A.getText().toString().equals("")||(B.getText().toString().equals(""))||(C.getText().toString().equals(""))){
                    Toast t = Toast.makeText(getApplicationContext(),"Informe o valor solicitado.",Toast.LENGTH_SHORT);
                    t.show();
                } else{
                    double delta;
                    double x1;
                    double x2;
                    double a = Float.parseFloat(A.getText().toString());
                    double b = Float.parseFloat(B.getText().toString());
                    double c = Float.parseFloat(C.getText().toString());

                    delta = (b * b) -4 * (a * c);

                    if(delta < 0){
                        AlertDialog.Builder dialogo = new
                                AlertDialog.Builder(Baskara.this);
                        dialogo.setTitle("Delta menor que 0");
                        dialogo.setMessage("O delta e menor que 0:");
                        dialogo.setNeutralButton("OK",null);

                        dialogo.show();
                    } else{
                        x1 =  (((b * -1) + Math.sqrt(delta))/ (2*a));
                        x2 = (((b * -1) - Math.sqrt(delta))/ (2*a));

                        AlertDialog.Builder dialogo = new
                                AlertDialog.Builder(Baskara.this);
                        dialogo.setTitle("O Valor de x1 e");
                        dialogo.setMessage("O valor de x1 e:" +
                                String.valueOf(x1));
                        dialogo.setNeutralButton("OK",null);

                        dialogo.show();

                        AlertDialog.Builder dialogo2 = new
                                AlertDialog.Builder(Baskara.this);
                        dialogo.setTitle("O Valor de x2 e");
                        dialogo.setMessage("O valor de x2 e:" +
                                String.valueOf(x2));
                        dialogo.setNeutralButton("OK",null);

                        dialogo.show();

                        AlertDialog.Builder dialogo3 = new
                                AlertDialog.Builder(Baskara.this);
                        dialogo.setTitle("O Valor do delta e");
                        dialogo.setMessage("O valor do delta e:" +
                                String.valueOf(delta));
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
        getMenuInflater().inflate(R.menu.menu_baskara, menu);
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