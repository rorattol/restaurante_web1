/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.csi.model;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Pedido {
    
    private int id;
    private String observacao;
    private ArrayList<Prato> pratosReservados;
    private Mesa mesaReservada;
    private String horaReservada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public ArrayList<Prato> getPratosReservados() {
        return pratosReservados;
    }

    public void setPratosReservados(ArrayList<Prato> pratosReservados) {
        this.pratosReservados = pratosReservados;
    }


    public Mesa getMesaReservada() {
        return mesaReservada;
    }

    public void setMesaReservada(Mesa mesaReservada) {
        this.mesaReservada = mesaReservada;
    }

    public String getHoraReservada() {
        return horaReservada;
    }

    public void setHoraReservada(String horaReservada) {
        this.horaReservada = horaReservada;
    }
}
