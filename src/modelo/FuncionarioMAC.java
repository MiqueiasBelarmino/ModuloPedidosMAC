/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Miquéias
 */
public class FuncionarioMAC {

    private int empCodigo;
    private int pessoaCodigo;
    private int usuCodigo;
    private String nomeFuncionario;
    private final int pFisicaCodigo = 1;

    public int getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(int empCodigo) {
        this.empCodigo = empCodigo;
    }

    public int getPessoaCodigo() {
        return pessoaCodigo;
    }

    public void setPessoaCodigo(int pessoaCodigo) {
        this.pessoaCodigo = pessoaCodigo;
    }

    public int getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(int usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getpFisicaCodigo() {
        return pFisicaCodigo;
    }
    
    
}
