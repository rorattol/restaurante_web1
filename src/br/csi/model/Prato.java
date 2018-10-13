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
public class Prato {
    
    private int id;
    private String nomPrato;
    private String descricaoPrato;
    private ArrayList<Ingrediente> ingredientes;
    private String categoriaPrato;
    private float precoPrato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPrato() {
        return nomPrato;
    }

    public void setNomPrato(String nomPrato) {
        this.nomPrato = nomPrato;
    }

    public String getDescricaoPrato() {
        return descricaoPrato;
    }

    public void setDescricaoPrato(String descricaoPrato) {
        this.descricaoPrato = descricaoPrato;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCategoriaPrato() {
        return categoriaPrato;
    }

    public void setCategoriaPrato(String categoriaPrato) {
        this.categoriaPrato = categoriaPrato;
    }

    public float getPrecoPrato() {
        return precoPrato;
    }

    public void setPrecoPrato(float precoPrato) {
        this.precoPrato = precoPrato;
    }
}
