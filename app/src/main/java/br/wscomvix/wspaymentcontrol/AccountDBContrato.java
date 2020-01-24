package br.wscomvix.wspaymentcontrol;

import android.provider.BaseColumns;

public final class AccountDBContrato {

    /**
     * Inicia um construtor padrão
     */
    private AccountDBContrato() {
    }

    /* Define os nomes da tabela e das colunas */
    public static class TabAccounts implements BaseColumns {
        public static final String TABLE_NAME = "tb_accounts";
        public static final String COLUNA_ID = "_ID";

        public static final String COLUNA_TIPO_LANCAMENTO = "tipo_lancamento";
        public static final String COLUNA_TIPO_DOCUMENTO = "tipo_documento";
        public static final String COLUNA_DESCRICAO = "descricao";
        public static final String COLUNA_VENCIMENTO = "vencimento";
        public static final String COLUNA_VALOR = "valor";
        public static final String COLUNA_DATA_PAGTO = "data_pagto";
        public static final String COLUNA_VALOR_PAGO = "valor_pago";
        public static final String COLUNA_STATUS = "status";
    }

}
