package com.exercicos.aulas.soma;
/*
bibliotecas que são necessários para o funcionamento do projeto, equivalente ao Using do C#.
Quando é necessário importar uma biblioteca a classe fica em vermelho por não ser reconhecida. Para corrigir pode :
1 - digitar o import manualmente
2 - clicar sobre a classe com erro e aguardar a solicitação do Android Studio para pressionar ALt+Tab
3 - clicar com o botão direito sobra a classe e selecionar a opção importar
*/
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
    Cria uma instância dos elementos utilizados na tela
    EditText --> Caixa de edição de texto
    TextView --> Exibição de texto ( equivale ao Label do C#)
 */

    EditText num1;
    EditText num2;
    Spinner spinOper;
    TextView result;
    Button btnCalc;

    //Variaveis locais para manipulação de Valores
    double n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
    associar os elementos locais aos elementos de tela através da propriedade ID
    onde:
        findViewById --> método que localiza os elementos
        R --> Classe autogerada que mapeia a View

 */
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        result = (TextView)findViewById(R.id.resultado);
        btnCalc = (Button)findViewById(R.id.btnCalcula);
        spinOper = (Spinner)findViewById(R.id.spinOper);

    }

    // método associado ao evento onClick do botão
    //Recebe sempre a classe View como parametrro, que contém as informações da origem da ação
    public void Calcula(View view){
        //recupera o valor do elemento
        String operacao = spinOper.getSelectedItem().toString();
        String[] options= getResources().getStringArray(R.array.spinnerArray);

        n1 = Double.parseDouble(num1.getText().toString());
        n2 = Double.parseDouble(num2.getText().toString());
        Log.println(Log.ASSERT,"soma",operacao + "==" + options[0]);
        double resp = 06.06d;
        if(operacao.equals(options[0]))
        {
            Log.println(Log.ASSERT,"soma","a");
            resp = n1 + n2;
        }
        if(operacao.equals(options[1]))
        {
            resp = n1 - n2;
        }
        if(operacao.equals(options[2]))
        {
            resp = n1 * n2;
        }
        if(operacao.equals(options[3]))
        {
            if(n2 != 0)
            {
                resp = (n1 / n2);
            }
            else
            {
                Toast.makeText(this,getResources().getString(R.string.errorMessageIV),Toast.LENGTH_LONG).show();
                return;
            }
        }
        //modifica o valor do elemento para exibir em tela
        result.setText(Double.toString(resp));
    }


}

