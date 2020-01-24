package br.wscomvix.wspaymentcontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AccountsDBHelper extends SQLiteOpenHelper {


    //Sempre que houver alteração no esquema do banco deve alterar a versão do banco.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "db_tarefas.db";

    /**
     * Cria a tabela
     */
    private static final String SQL_CRIAR_TABELA =
            "CREATE TABLE " + AccountDBContrato.TabAccounts.TABLE_NAME + " (" +
                    AccountDBContrato.TabAccounts.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    AccountDBContrato.TabAccounts.COLUNA_TIPO_LANCAMENTO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_TIPO_DOCUMENTO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_DESCRICAO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_VENCIMENTO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_VALOR + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_DATA_PAGTO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_VALOR_PAGO + " TEXT," +
                    AccountDBContrato.TabAccounts.COLUNA_STATUS + " TEXT)";


    /**
     * Dropa a tabela (exclui)
     */
    private static final String SQL_EXCLUIR_TABELA =
            "DROP TABLE IF EXISTS " + AccountDBContrato.TabAccounts.TABLE_NAME;


    public AccountsDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * @param db
     */
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CRIAR_TABELA);
    }

    /**
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Ao atualizar a versão excluir todos os dados e cria uma nova estrutura limpa da tabela.
        db.execSQL(SQL_EXCLUIR_TABELA);
        onCreate(db);
    }

    /**
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
