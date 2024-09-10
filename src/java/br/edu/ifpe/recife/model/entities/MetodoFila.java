/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MetodoFila {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(length = 100, nullable = false)
    private String descricaoCurta;
    @Lob
    private String descricaoLonga;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricaoCurta
     */
    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    /**
     * @param descricaoCurta the descricaoCurta to set
     */
    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    /**
     * @return the descricaoLonga
     */
    public String getDescricaoLonga() {
        return descricaoLonga;
    }

    /**
     * @param descricaoLonga the descricaoLonga to set
     */
    public void setDescricaoLonga(String descricaoLonga) {
        this.descricaoLonga = descricaoLonga;
    }
}
