/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Estudante;
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

@ManagedBean(name = "eController")
@SessionScoped
public class EstudanteController {
   
    private Estudante cadastro;
    private Estudante selecionado;
    
    @PostConstruct
    public void init(){
//        this.setCadastro(new Estudante());
          this.cadastro = new Estudante();
    }
    
    public String cadastrar(String confirma){
        
        if(!confirma.equals(this.cadastro.getSenha())){
            
           FacesContext.getCurrentInstance().addMessage("formEstudante:txtConfirma", 
                   new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO DE VALIDAÇÃO: "
                           + "As senhas inseridas não coincidem!", "As senhas inseridas não coincidem!"));
        }else{
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante " + 
                this.cadastro.getNome() +" cadastrado com sucesso!"));
      
        this.cadastro = new Estudante();
        
        return "cadastroestudante.xhtml";
        }        
        
        return "cadastroestudante.xhtml";
    }
    
    public List<Estudante> resgatar(){
        
        String query = "select e from Estudante e";
        
        return ManagerDao.getCurrentInstance().read(query, Estudante.class);
    }
    
    public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante foi editado com sucesso!"));
        
        return "apresentaestudante.xhtml";
    }
    
    public void excluir(){
    
        ManagerDao.getCurrentInstance().delete(this.getSelecionado());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Estudante excluído com sucesso!"));
    }
    
    public void resetarCamposCadastro(){

        init();
    }

    /**
     * @return the cadastro
     */
    public Estudante getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(Estudante cadastro) {
        this.cadastro = cadastro;
    }

    /**
     * @return the selecionado
     */
    public Estudante getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(Estudante selecionado) {
        this.selecionado = selecionado;
    }

}