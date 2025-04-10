package com.mycompany.proyecto1_bd2;

public class UsuarioInfo {
    private String nombreCompleto;
    private int cuentaId;
    private double saldo;

    public UsuarioInfo(String nombreCompleto, int cuentaId, double saldo) {
        this.nombreCompleto = nombreCompleto;
        this.cuentaId = cuentaId;
        this.saldo = saldo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public double getSaldo() {
        return saldo;
    }
}
