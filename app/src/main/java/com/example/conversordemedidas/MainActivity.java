package com.example.conversordemedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    Spinner spinTipoConv;
    Spinner spinUnid;
    Spinner spinConv;
    ImageButton imTroca;
    EditText valorConverter;
    TextView valorConvertido;

    boolean orig;

    final String[] tipoConversao = new String[]{"Comprimento", "Área", "Volume", "Hectares", "Litros", "Massa", "Frequência", "Velocidade"};


    final String[] medidas1 = new String[]{"Milímetros", "Centímetros", "Decímetros", "Metros", "Decâmetros", "Hectômetros", "Quilometros"};

    final String[] medidas2 = new String[]{"Milímetros", "Centímetros", "Decímetros", "Metros", "Decâmetros", "Hectômetros", "Quilometros"};


    final String[] medidasquadradas1 = new String[]{"Milímetros quadrados", "Centímetros quadrados", "Decímetros quadrados",
            "Metros quadrados", "Decâmetros quadrados", "Hectômetros quadrados", "Quilometros quadrados"};

    final String[] medidasquadradas2 = new String[]{"Milímetros quadrados", "Centímetros quadrados", "Decímetros quadrados",
            "Metros quadrados", "Decâmetros quadrados", "Hectômetros quadrados", "Quilometros quadrados"};


    final String[] medidascubicas1 = new String[]{"Milímetros cúbicos", "Centímetros cúbicos", "Decímetros cúbicos",
            "Metros cúbicos", "Decâmetros cúbicos", "Hectômetros cúbicos", "Quilometros cúbicos"};

    final String[] medidascubicas2 = new String[]{"Milímetros cúbicos", "Centímetros cúbicos", "Decímetros cúbicos", "Metros cúbicos",
            "Decâmetros cúbicos", "Hectômetros cúbicos", "Quilometros cúbicos"};


    final String[] medidashectares1 = new String[]{"Milímetros quadrados", "Centímetros quadrados", "Decímetros quadrados",
            "Metros quadrados", "Decâmetros quadrados", "Hectômetros quadrados", "Quilometros quadrados"};

    final String[] medidashectares2 = new String[]{"Hectares"};


    final String[] medidascapacidade1 = new String[]{"Milímetros cúbicos", "Centímetros cúbicos", "Decímetros cúbicos",
            "Metros cúbicos", "Decâmetros cúbicos", "Hectômetros cúbicos", "Quilometros cúbicos"};

    final String[] medidascapacidade2 = new String[]{"Litros"};


    final String[] medidasmassa1 = new String[]{"Miligramas", "Gramas", "Quilogramas", "Toneladas"};

    final String[] medidasmassa2 = new String[]{"Miligramas", "Gramas", "Quilogramas", "Toneladas"};


    final String[] medidasfrequencia1 = new String[]{"Hertz", "Quilo-hertz", "Mega-hertz", "Gigahertz"};

    final String[] medidasfrequencia2 = new String[]{"Hertz", "Quilo-hertz", "Mega-hertz", "Gigahertz"};


    final String[] medidasvelocidade1 = new String[]{"Metros por segundo", "Quilometros por hora"};

    final String[] medidasvelocidade2 = new String[]{"Metros por segundo", "Quilometros por hora"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinTipoConv = (Spinner) findViewById(R.id.spinTipo);
        spinUnid = (Spinner) findViewById(R.id.spinUnid1);
        spinConv = (Spinner) findViewById(R.id.spinUnid2);
        imTroca = (ImageButton) findViewById(R.id.imTrocaConv);

        imTroca.setVisibility(View.INVISIBLE);
        orig = true;

        valorConverter = findViewById(R.id.editValor);
        valorConvertido = findViewById(R.id.txtConversao);

        ArrayAdapter<String> adapterTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipoConversao);

        spinTipoConv.setAdapter(adapterTipo);

        adapterTipo.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinTipoConv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {

                if (position == 0) {

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidas1);
                    spinUnid.setAdapter(adapterUnid);

                    final ArrayAdapter<String> adapterConv = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidas2);
                    spinConv.setAdapter(adapterConv);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if (position == 1){

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasquadradas1);
                    spinUnid.setAdapter(adapterUnid2);

                    final ArrayAdapter<String> adapterConv2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasquadradas2);
                    spinConv.setAdapter(adapterConv2);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 2){

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascubicas1);
                    spinUnid.setAdapter(adapterUnid3);

                    final ArrayAdapter<String> adapterConv3 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascubicas2);
                    spinConv.setAdapter(adapterConv3);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 3){

                    imTroca.setVisibility(View.VISIBLE);

                    final ArrayAdapter<String> adapterUnid4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares1);
                    spinUnid.setAdapter(adapterUnid4);

                    final ArrayAdapter<String> adapterConv4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares2);
                    spinConv.setAdapter(adapterConv4);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 4){

                    imTroca.setVisibility(View.VISIBLE);

                    final ArrayAdapter<String> adapterUnid5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade1);
                    spinUnid.setAdapter(adapterUnid5);

                    final ArrayAdapter<String> adapterConv5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade2);
                    spinConv.setAdapter(adapterConv5);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 5){

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid6 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasmassa1);
                    spinUnid.setAdapter(adapterUnid6);

                    final ArrayAdapter<String> adapterConv6 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasmassa2);
                    spinConv.setAdapter(adapterConv6);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 6){

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid7 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasfrequencia1);
                    spinUnid.setAdapter(adapterUnid7);

                    final ArrayAdapter<String> adapterConv7 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasfrequencia2);
                    spinConv.setAdapter(adapterConv7);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }

                if(position == 7){

                    imTroca.setVisibility(View.INVISIBLE);

                    final ArrayAdapter<String> adapterUnid8 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasvelocidade1);
                    spinUnid.setAdapter(adapterUnid8);

                    final ArrayAdapter<String> adapterConv8 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidasvelocidade2);
                    spinConv.setAdapter(adapterConv8);

                    valorConverter.setText("");
                    valorConvertido.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

    }

    public void onClickConversao(View v) {

        double valor;
        double convertido = 0.0;

        if (valorConverter.getText().toString().length() == 0) {

            Toast.makeText(this, "Informe um valor a converter!", Toast.LENGTH_SHORT).show();

        } else {

            valor = parseDouble(valorConverter.getText().toString());

            int escolhaTipoConv = (int) (long) spinTipoConv.getSelectedItemId();

            int escolhaUnid = (int) (long) spinUnid.getSelectedItemId();
            int escolhaConv = (int) (long) spinConv.getSelectedItemId();
            double base = 0;
            double expoente = 0;


            switch (escolhaTipoConv) {

                case 0:
                case 1:
                case 2:

                    base = 10 * Math.pow(10, escolhaTipoConv);
                    expoente = escolhaConv - escolhaUnid;
                    break;

                case 3:

                    if(orig) {

                        base = 100;
                        expoente = -(escolhaUnid - 5);
                    }

                    else{

                        base = 100;
                        expoente = escolhaConv - 5;
                    }
                    break;

                case 4:

                    if (orig) {

                        base = 1000;
                        expoente = - (escolhaUnid - 2);
                    }

                    else{

                        base = 1000;
                        expoente = escolhaConv - 2;
                    }

                    break;

                case 5:
                case 6:

                    base = 1000;
                    expoente = escolhaConv - escolhaUnid;
                    break;

                case 7:
                    base = 3.6;
                    expoente = escolhaUnid - escolhaConv;
                    break;

            }

            convertido = valor / Math.pow(base, expoente);
            valorConvertido.setText(Double.toString(convertido) + " " + spinConv.getSelectedItem().toString());
        }
    }

    public void onClickTroca (View v){

        int escolhaTipoConv = (int) (long) spinTipoConv.getSelectedItemId();
        int escolhaUnid = (int) (long) spinUnid.getSelectedItemId();
        int escolhaConv = (int) (long) spinConv.getSelectedItemId();

        orig = !orig;

        imTroca.animate().rotation(imTroca.getRotation()+180).setDuration(300).start();

        valorConverter.setText("");
        valorConvertido.setText("");

        if (orig) {

            if(escolhaTipoConv == 3) {

                final ArrayAdapter<String> adapterUnid4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares1);
                spinUnid.setAdapter(adapterUnid4);

                final ArrayAdapter<String> adapterConv4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares2);
                spinConv.setAdapter(adapterConv4);

            }

            else if (escolhaTipoConv == 4){

                final ArrayAdapter<String> adapterUnid5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade1);
                spinUnid.setAdapter(adapterUnid5);

                final ArrayAdapter<String> adapterConv5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade2);
                spinConv.setAdapter(adapterConv5);
            }
        }

        else{

            if(escolhaTipoConv == 3) {

                final ArrayAdapter<String> adapterUnid4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares1);
                spinConv.setAdapter(adapterUnid4);

                final ArrayAdapter<String> adapterConv4 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidashectares2);
                spinUnid.setAdapter(adapterConv4);
            }

            else if (escolhaTipoConv == 4){

                final ArrayAdapter<String> adapterUnid5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade1);
                spinConv.setAdapter(adapterUnid5);

                final ArrayAdapter<String> adapterConv5 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, medidascapacidade2);
                spinUnid.setAdapter(adapterConv5);

            }
        }
    }
}

