package br.wscomvix.wspaymentcontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.sql.Date;
import java.util.ArrayList;

public class AccountsDB extends AccountsDBHelper {

    public AccountsDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * @param t
     */
    public void inserirAccount(@org.jetbrains.annotations.NotNull Account t) {

        //Abre o banco no mode de gravação
        SQLiteDatabase db = getWritableDatabase();

        //Cria um map contendo valores que serão incluídos no campo
        ContentValues values = new ContentValues();
        values.put(AccountDBContrato.TabAccounts.COLUNA_DESCRICAO, t.getDescricao());
        values.put(AccountDBContrato.TabAccounts.COLUNA_STATUS, t.getStatus().toString());

        // Insere a linha e retorna o ID do registro inserido
        long newRowId = db.insert(
                AccountDBContrato.TabAccounts.TABLE_NAME,
                null, values);
    }

    /**
     * @return
     */
    public ArrayList<Account> getAccounts() {

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                AccountDBContrato.TabAccounts.COLUNA_TIPO_LANCAMENTO,
                AccountDBContrato.TabAccounts.COLUNA_TIPO_DOCUMENTO,
                AccountDBContrato.TabAccounts.COLUNA_DESCRICAO,
                AccountDBContrato.TabAccounts.COLUNA_VENCIMENTO,
                AccountDBContrato.TabAccounts.COLUNA_VALOR,
                AccountDBContrato.TabAccounts.COLUNA_STATUS,
                AccountDBContrato.TabAccounts.COLUNA_DATA_PAGTO,
                AccountDBContrato.TabAccounts.COLUNA_VALOR_PAGO
        };

        // Filtra resultados com a clausula WHERE "descricao" = 'descricao'
        //        String selection = TarefasDBContrato.TabTarefas.COLUNA_DESCRICAO + " = ?";
        //        String[] selectionArgs = { "My Title" };

        // Ordena a saida de resultados
        String sortOrder =
                BaseColumns._ID + " DESC";

        //Cursor cursor = db.rawQuery("select * from tb_tarefas",null);
        Cursor cursor = db.query(
                AccountDBContrato.TabAccounts.TABLE_NAME,   // The table to query
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        //cursor.moveToFirst();

        ArrayList<Account> accounts = new ArrayList<>();

        while (cursor.moveToNext()) {

            Status status = Status.valueOf(
                    cursor.getString(
                            cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_STATUS)));

            Account account = new Account(
                    cursor.getString(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_TIPO_LANCAMENTO)),
                    cursor.getString(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_TIPO_DOCUMENTO)),
                    cursor.getString(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_DESCRICAO)),
                    Date.valueOf(cursor.getString(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_VENCIMENTO))),
                    cursor.getDouble(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_VALOR)),
                    status, Date.valueOf(cursor.getString(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_DATA_PAGTO))),
                    cursor.getDouble(cursor.getColumnIndex(AccountDBContrato.TabAccounts.COLUNA_VALOR_PAGO))
            );


            accounts.add(account);

        }

        cursor.close();
        return accounts;
    }

    /**
     * @param id
     * @return
     */
    public int excluir(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Define a condição para a deleção usando a clausula WHERE.
        String selection = AccountDBContrato.TabAccounts.COLUNA_ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = {String.valueOf(id)};
// Issue SQL statement.
        int deletedRows = db.delete(AccountDBContrato.TabAccounts.TABLE_NAME, selection, selectionArgs);

        return deletedRows;
    }

    public int atualizarTarefa(Account t) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AccountDBContrato.TabAccounts.COLUNA_DESCRICAO, t.getDescricao());
        values.put(AccountDBContrato.TabAccounts.COLUNA_STATUS, t.getStatus().toString());

// Which row to update, based on the title
        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = {String.valueOf(t.getId())};

        int count = db.update(
                AccountDBContrato.TabAccounts.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return count;

    }
}