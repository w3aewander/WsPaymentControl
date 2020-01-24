package br.wscomvix.wspaymentcontrol;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter {

    private AccountsDB db;
    private ArrayList<Account> accounts;
    private Context context;

    public AccountAdapter(ArrayList<Account> accounts, Context context) {
        this.accounts = getAccounts();
        this.context = context;
        db = new AccountsDB(context, AccountDBContrato.TabAccounts.TABLE_NAME, null, 1);
    }

    @Override
    public int getItemCount() {

        return accounts.size();
    }

    public ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = db.getAccounts();
        notifyDataSetChanged();

        return accounts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.account_item, parent, false);
        AccountAdaperViewHolder holder = new AccountAdaperViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        final AccountAdaperViewHolder holder = (AccountAdaperViewHolder) viewHolder;
        final Account account = accounts.get(position);

        holder.id.setText(String.valueOf(account.getId()));
        holder.descricao.setText(account.getDescricao());
        holder.valor.setText(String.valueOf(account.getValor()));
        holder.vencimento.setText(String.valueOf(account.getDataVencimento()));
        holder.status.setText(account.getStatus().toString());

        if (holder.status.getText().toString().equals("Feito")) {
            holder.status.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.checkbox_on_background, 0);
        } else {
            holder.status.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.checkbox_off_background, 0);
        }


        holder.status.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                final AlertDialog.Builder dialogo = new AlertDialog.Builder(v.getContext());

//                    View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialogo,null);
//

//                    final Button btnFeito = view.findViewById(R.id.btnFeito);

//                    btnFeito.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            db.atualizarTarefa(tarefa);
//                            tarefas = db.getTarefas();
//                            holder.status.setText(tarefa.getStatus().toString());
//                            holder.status.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.checkbox_on_background,0);
//
//                            notifyDataSetChanged();
//                            dialogo.setView(null);
//                        }
//                    });
//
//                    final Button btnExcluir = view.findViewById(R.id.btnExcluir);
//                    btnExcluir.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            db.excluir(tarefa.getId());
//                            tarefas = db.getTarefas();
//                            notifyDataSetChanged();
//
//                        }
//                    });


                dialogo.setCancelable(true);
//                    dialogo.setView(view);
//
                dialogo.show();


                return true;

                //dialogo.setTitle("Alterar status");


                //dialogo.setIcon(R.drawable.gradientoval);
                //dialogo.setMessage("Tarefa realizada?");
                //dialogo.setMessage("O que deseja?");



                /*
                dialogo.setNegativeButton("Excluir",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        db.excluir(tarefa.getId());
                        holder.status.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.checkbox_on_background,0);
                        tarefas = db.getTarefas();
                        notifyDataSetChanged();
                    }
                });
                dialogo.setPositiveButton("Atualizar",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        tarefa.setStatus(Status.Feito);
                        holder.status.setText(tarefa.getStatus().toString());
                        //int d =  android.R.drawable.checkbox_off_background;
                        db.atualizarTarefa(tarefa);
                        notifyDataSetChanged();
                        holder.status.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.checkbox_on_background,0);
                    }
                });
                dialogo.setNeutralButton("Cancelar",null);
                 */

            }
        });


    }

}
