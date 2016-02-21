/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufg.engsw.mds.procuraSala;

import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime inicio;
    private Sala sala; 
    
    
    public LocalDateTime data(LocalDateTime data, int year, int month, int day, 
            int hour){
        if (day < 0 || day > 32 || ((day > 29) &&(month == 2))) {
         throw new IllegalArgumentException("Dia inválido");}
        
        if (year < 0 ) {
         throw new IllegalArgumentException("Ano inválido");}
        
        if ((month < 0) || (month > 12)) {
         throw new IllegalArgumentException("Mês inválido");}
        
        //Vamos considerar as horas, apenas as disponíveis (7-22) ou qualquer?
        if (hour < 0) {
         throw new IllegalArgumentException("Hora inválida");}
        
        data = LocalDateTime.of(year, month, day, hour, 0);
        return data;
    }
    
    public Reserva(LocalDateTime inicio, Sala sala) {
        this.inicio = inicio;
        this.sala = sala;
    }
}
