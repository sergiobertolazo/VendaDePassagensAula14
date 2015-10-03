package com.br.sergio.vendadepassagensaula13;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    EditText dataTextInput,precoTextNumberInput;

    Button btnConsultar;
    String origem,destino, data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews() {
        origem = "";
        destino = "";
        data = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionada());
    }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "com.br.sergio.vendadepassagensaula13.ORIGEM";
    public final static String DESTINO = "com.br.sergio.vendadepassagensaula13.DESTINO";
    public final static String DATA = "com.br.sergio.vendadepassagensaula13.DATA";
    public final static String MODO = "com.br.sergio.vendadepassagensaula13.MODO";
    public final static String SIMPLES = "com.br.sergio.vendadepassagensaula13.SIMPLES";
    public final static String MELHOR = "com.br.sergio.vendadepassagensaula13.MELHOR";
    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {
        consultar(view, SIMPLES);
    }

    public void consultarVoosMelhor(View view) {
        consultar(view, MELHOR);
    }

    public void consultar(View view, String modo){
        String passarOrigem = this.origem.equals("Escolha um aeroporto")?"":origem;
        String passarDestino = this.destino.equals("Escolha um aeroporto")?"":destino;
        String passarData = this.data;

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(ORIGEM, passarOrigem);
        intent.putExtra(DESTINO, passarDestino);
        intent.putExtra(DATA, passarData);
        intent.putExtra(MODO, modo);
        startActivity(intent);
    }

}
