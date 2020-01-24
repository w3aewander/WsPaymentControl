package br.wscomvix.wspaymentcontrol;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccountAdaperViewHolder extends RecyclerView.ViewHolder {

    final TextView id;
    final TextView descricao;
    final TextView vencimento;
    final TextView valor;
    final TextView status;

    public AccountAdaperViewHolder(@NonNull View view) {
        super(view);

        id = view.findViewById(R.id.txtId);
        descricao = view.findViewById(R.id.txtId);
        vencimento = view.findViewById(R.id.txtVencimento);
        valor = view.findViewById(R.id.txtValor);
        status = view.findViewById(R.id.txtStatus);

    }
}
