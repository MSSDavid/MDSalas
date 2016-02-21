package br.inf.ufg.engsw.mds.procuraSala;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import br.inf.ufg.engsw.mds.procuraSala.CriarSala;

/**
 *
 * @author Level 5
 */
public class SelecionarInstituto {
        public static CentroDeAulas selecionaInstituto(int codigoInstituto){
        CentroDeAulas centroDeAulas = null;     
        

           try {
               if (codigoInstituto < 0) {
                  throw new IllegalArgumentException("Erro");}
           switch(codigoInstituto){
            case 1:
                centroDeAulas = CentroDeAulas.CentroDeAulasA;
                break;
             
            case 2:
                centroDeAulas = CentroDeAulas.CentroDeAulasB;
                break;
                
            case 3:
                centroDeAulas = CentroDeAulas.CentroDeAulasC;
                break;
            
            case 4:
                centroDeAulas = CentroDeAulas.INF;
                break;
                
            case 5:
                centroDeAulas = CentroDeAulas.IF;
                break;
                
            case 6:
                centroDeAulas = CentroDeAulas.IQ;
                break;
                
            case 7:
                centroDeAulas = CentroDeAulas.FL;
                break;
                                
            case 8:
                centroDeAulas = CentroDeAulas.FAFIL;
                break;
            
        }
           } catch (InputMismatchException erro) {
               System.out.println("Digite NÚMEROS" + erro);
            
        }

                
        
        
        return centroDeAulas;
    }
    
}
