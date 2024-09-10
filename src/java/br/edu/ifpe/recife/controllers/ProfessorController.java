/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Professor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jeron
 */

@ManagedBean(name = "profController")
@SessionScoped
public class ProfessorController {
    
    private Professor cadastro;
    private Professor selecionado;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Professor();
    }
    
    public String cadastrar(String confirma){
        
        if(!confirma.equals(this.cadastro.getSenha())){
            
           FacesContext.getCurrentInstance().addMessage("formProfessor:txtConfirma", 
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO DE VALIDAÇÃO: "
                           + "As senhas inseridas não coincidem!", "As senhas inseridas não coincidem!"));
        }else{
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor " + 
                this.cadastro.getNome() +" cadastrado com sucesso!"));
      
        this.cadastro = new Professor();
        
        return "cadastroprofessor.xhtml";
        }
        return "cadastroprofessor.xhtml";
    }
    
    public List<Professor> resgatar(){
        
        String query = "select p from Professor p";
        
        return ManagerDao.getCurrentInstance().read(query, Professor.class);
    }
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor foi editado com sucesso!"));
        
        return "apresentaprofessor.xhtml";
    }
        
    public void excluir(){
    
        ManagerDao.getCurrentInstance().delete(this.selecionado);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor excluído com sucesso!"));
    }
    
    public void resetarCamposCadastro(){

        init();
    }
    
    public Professor getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the professor to set
     */
    public void setCadastro(Professor cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionado
     */
    public Professor getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(Professor selecionado) {
        this.selecionado = selecionado;
    }
}
