package br.wscomvix.wspaymentcontrol;

import java.util.Date;

public class Account {

    private int id;
    private String tipoLancamento; //Entrada, Saída
    private String tipoDocumento;  //Água, Luz, Telefone, Aluguel Boleto,
    private String descricao;
    private Date dataVencimento;
    private double valor;
    private Status status;  //EmDia, Vencido, Pago
    private Date dataPagto; //Data do pagamento
    private double valorPago; //VAlor pago


    public Account(String tipoLancamento, String tipoDocumento, String descricao, Date dataVencimento, double valor, Status status, Date dataPagto, double valorPago) {
        this.tipoLancamento = tipoLancamento;
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.status = status;
        this.dataPagto = dataPagto;
        this.valorPago = valorPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(Date dataPagto) {
        this.dataPagto = dataPagto;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
