package com.example.demo.Entityes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona{
    @Id
    private int per_cod;
    @Column
    private String per_nom;
    @Column
    private String per_apep;

    public Persona(int per_cod, String per_nom, String per_apep) {
        this.per_cod = per_cod;
        this.per_nom = per_nom;
        this.per_apep = per_apep;
    }

    public Persona() {
    }

    public int getPer_cod() {
        return per_cod;
    }

    public void setPer_cod(int per_cod) {
        this.per_cod = per_cod;
    }

    public String getPer_nom() {
        return per_nom;
    }

    public void setPer_nom(String per_nom) {
        this.per_nom = per_nom;
    }

    public String getPer_apep() {
        return per_apep;
    }

    public void setPer_apep(String per_apep) {
        this.per_apep = per_apep;
    }
}
