/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.entities.Professor;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginController {

    private Estudante estudLogado;
    private Professor profLogado;

    public String logar(String email, String senha) {

        try {

//            Professor profAux = (Professor) ManagerDao.getCurrentInstance().read("select p from Professor p where p.email=\"" + email
//                    + "\" and p.senha=\"" + senha + "\"", Professor.class).get(0);
//
//                this.profLogado = profAux;
                
            Estudante estAux = (Estudante) ManagerDao.getCurrentInstance().read("select e from Estudante e where e.email=\"" + email
                        + "\" and e.senha=\"" + senha + "\"", Estudante.class).get(0);

                this.estudLogado = estAux;

            return "index.xhtml";
            
        } catch (IndexOutOfBoundsException in) {

            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login e senha não coincidem!", ""));

            return null;
        }
//            return "index.xhtml";

//                Estudante estAux = (Estudante) ManagerDao.getCurrentInstance().read("select e from Estudante e where e.email=\"" + email
//                        + "\" and e.senha=\"" + senha + "\"", Estudante.class).get(0);
//
//                this.estudLogado = estAux;
//                
//                return "indexusuario.xhtml";
//        } catch (IndexOutOfBoundsException in) {
//
//            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                    "Login e senha não coincidem!", ""));
//
//            return null;
//        }
    }

    /**
     * @return the estudLogado
     */
    public Estudante getEstudLogado() {
        return estudLogado;
    }

    /**
     * @param estudLogado the estudLogado to set
     */
    public void setEstudLogado(Estudante estudLogado) {
        this.estudLogado = estudLogado;
    }

    /**
     * @return the profLogado
     */
    public Professor getProfLogado() {
        return profLogado;
    }

    /**
     * @param profLogado the profLogado to set
     */
    public void setProfLogado(Professor profLogado) {
        this.profLogado = profLogado;
    }

}
