package br.wscomvix.wspaymentcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LancamentosActivity extends AppCompatActivity {

    final int REQUEST_CALENDAR = 1000;
    private EditText edtVencimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamentos);

        Spinner spnLancamento = findViewById(R.id.spnTipoLancamento);
        String[] tipo_lancamento = getResources().getStringArray(R.array.tipo_lancamento);
        ArrayAdapter<String> adapterTipoLancamento = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipo_lancamento);
        spnLancamento.setAdapter(adapterTipoLancamento);

        Spinner spnDocumento = findViewById(R.id.spnTipoDocumento);
        String[] tipo_documento = getResources().getStringArray(R.array.tipo_documento);
        ArrayAdapter<String> adapterTipoDocumento = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipo_documento);
        spnDocumento.setAdapter(adapterTipoDocumento);


    }

    public void abrirCalendario(View v) {
        Intent i = new Intent(this, CalendarioActivity.class);
        startActivityForResult(i, REQUEST_CALENDAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CALENDAR && resultCode == RESULT_OK) {
            edtVencimento = findViewById(R.id.edtVencimento);
            edtVencimento.setText(data.getStringExtra("data_atual"));
        }
    }
}
