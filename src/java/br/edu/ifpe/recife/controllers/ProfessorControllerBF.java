/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Professor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="pControllerBF")
@ViewScoped
public class ProfessorControllerBF {
    
    private Professor cadastro;
    private Professor selecionado;
    
    public ProfessorControllerBF(){
        this.cadastro = new Professor();
        this.selecionado = new Professor();
    }
    
    public List<Professor> readAll(){
        return ManagerDao.getCurrentInstance().read("SELECT p FROM Professor P", Professor.class);
    }
    
    public void insert(String confirma){
        
        if(!confirma.equals(this.cadastro.getSenha())){
            
            FacesContext.getCurrentInstance().addMessage("formModalCadProf:txtSenha", new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro validação!", "Você digitou uma senha diferente!"));
            return;
            
        }
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        this.cadastro = new Professor();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O professor foi cadastrado!"));
    }
    
    public void update(){
        
        ManagerDao.getCurrentInstance().update(this.selecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados do professor foram alterados!"));
    }
    
    public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.selecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O professor foi excluído!"));
    }

    public Professor getCadastro() {
        return cadastro;
    }

    public void setCadastro(Professor cadastro) {
        this.cadastro = cadastro;
    }

    public Professor getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Professor selecionado) {
        this.selecionado = selecionado;
    }
    
}
