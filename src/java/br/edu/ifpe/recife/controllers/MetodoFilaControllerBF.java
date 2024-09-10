/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.MetodoFila;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mfControllerBF")
@ViewScoped
public class MetodoFilaControllerBF {
    private MetodoFila cadastro;
    private MetodoFila selecionado;
    
    public MetodoFilaControllerBF(){
        this.cadastro = new MetodoFila();
        this.selecionado = new MetodoFila();
    }
    
    public List<MetodoFila> readAll(){
        return ManagerDao.getCurrentInstance().read("SELECT mf FROM MetodoFila MF", MetodoFila.class);
    }
    
    public void insert(){
        
        
        ManagerDao.getCurrentInstance().insert(this.getCadastro());
        
        this.setCadastro(new MetodoFila());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O método de fila foi cadastrado!"));
    }
    
    public void update(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados do professor foram alterados!"));
    }
    
    public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O método de fila foi excluído!"));
    }

    /**
     * @return the cadastro
     */
    public MetodoFila getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(MetodoFila cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionado
     */
    public MetodoFila getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(MetodoFila selecionado) {
        this.selecionado = selecionado;
    }
}
