/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufg.engsw.mds.procuraSala;

/**
 *
 * @author Victor Stillo
 */
public class Sala {
    private CentroDeAulas centroDeAulas;
    private int numero;
    private int capacidade;
    private int computadores;
    private boolean arCondicionado;
    private boolean projetor;
    private boolean microfone;
    private boolean som;
    private boolean computadorProfessor;
    private Tipo tipo;

    public CentroDeAulas getCentroDeAulas() {
        return centroDeAulas;
    }

    public void setCentroDeAulas(CentroDeAulas centroDeAulas) {
        //Qual a exceção desse mesmo? 
        
        this.centroDeAulas = centroDeAulas;
        
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
             
        this.capacidade = capacidade;
    }

    public int getComputadores() {
        return computadores;
    }

    public void setComputadores(int computadores) {
        if (computadores < 0 ) {
         throw new IllegalArgumentException("Não há apacidade negativa!");}
        this.computadores = computadores;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isProjetor() {
        return projetor;
    }

    public void setProjetor(boolean projetor) {
        this.projetor = projetor;
    }

    public boolean isMicrofone() {
        return microfone;
    }

    public void setMicrofone(boolean microfone) {
        this.microfone = microfone;
    }

    public boolean isSom() {
        return som;
    }

    public void setSom(boolean som) {
        this.som = som;
    }

    public boolean isComputadorProfessor() {
        return computadorProfessor;
    }

    public void setComputadorProfessor(boolean computadorProfessor) {
        this.computadorProfessor = computadorProfessor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public Sala(){
        
    }
    
    public Sala(CentroDeAulas centroDeAulas, int numero, int capacidade, int 
            computadores, boolean arCondicionado, boolean projetor, 
            boolean microfone, boolean som, boolean computadorProfessor, 
            Tipo tipo) {
        this.centroDeAulas = centroDeAulas;
        this.numero = numero;
        if (capacidade < 0) {
        throw new IllegalArgumentException("Capacidade negativa? Erro!"); 
        } else {
            this.capacidade = capacidade; 
        }
        this.computadores = computadores;
        this.arCondicionado = arCondicionado;
        this.projetor = projetor;
        this.microfone = microfone;
        this.som = som;
        this.computadorProfessor = computadorProfessor;
        this.tipo = tipo;
    }
    
    public CentroDeAulas selecionaInstituto(int codigoInstituto){
        switch(codigoInstituto){
            case 1:
                this.centroDeAulas = CentroDeAulas.CentroDeAulasA;
                break;
             
            case 2:
                this.centroDeAulas = CentroDeAulas.CentroDeAulasB;
                break;
                
            case 3:
                this.centroDeAulas = CentroDeAulas.CentroDeAulasC;
                break;
            
            case 4:
                this.centroDeAulas = CentroDeAulas.INF;
                break;
                
            case 5:
                this.centroDeAulas = CentroDeAulas.IF;
                break;
                
            case 6:
                this.centroDeAulas = CentroDeAulas.IQ;
                break;
                
            case 7:
                this.centroDeAulas = CentroDeAulas.FL;
                break;
                
                
            case 8:
                this.centroDeAulas = CentroDeAulas.FAFIL;
                break;
                
            default:
                Exception("Comando Inválido!");
        }
        
        return this.centroDeAulas;
    }

    private void Exception(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
