/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufg.engsw.mds.procuraSala;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.time.DateTimeException;
import br.inf.ufg.engsw.mds.procuraSala.CriarSala;
/**
 *
 * @author Victor Stillo
 */
public class ProcuraSala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Sala> salas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Sala sala = new Sala();
        LocalDateTime data = LocalDateTime.now();
        int opcao = 0;
        do{
            System.out.println("\n\nEscolha a opcao desejada:\n");
            System.out.println("1 - Criar Sala\n2 - Ver Lista de Salas\n"
                    + "3 - Reservar Sala\n4 - Ver Horários\n0 - Sair");
            int flag;
            flag = 0;
            do { 
            try {            
            opcao = Integer.parseInt(scanner.nextLine());
            flag = 0;
            if ((opcao < 0) || (opcao > 4)) {
                throw new Exception("Operação inválida.");
            }
        } catch (Exception error) {
            System.out.print("OPERAÇÃO INVÁLIDA. TENTE NOVAMENTE.");
            System.out.println("\nEscolha novamente a opcao desejada:\n");
            System.out.println("1 - Criar Sala\n2 - Ver Lista de Salas\n"
                    + "3 - Reservar Sala\n4 - Ver Horários\n0 - Sair");
            flag = 1;
        }
        } while (flag == 1);           
                    
            switch(opcao){
                case 1:
                    sala = CriarSala.criaSala();
                    salas.add(sala);
                    break;
                
                case 2:
                    for(Sala s : salas){
                        
                        
                        System.out.print("\nSala " + s.getNumero() +
                                "\nTipo: " + s.getTipo() +
                                "\nCapacidade: " + s.getCapacidade() + 
                                " alunos\n"+ "Número de Computadores: " + 
                                s.getComputadores());
                        
                                System.out.print("\nAr Condicionado:");
                                if (s.isArCondicionado() == true) {
                                    System.out.print(" SIM");
                                 } else {
                                    System.out.print(" NÃO");
                                 }

                                
                                System.out.print("\nMicrofone:");      
                                if (s.isMicrofone() == true) {
                                    System.out.print(" SIM");
                                 } else {
                                    System.out.print(" NÃO");
                                 }
                                
                                System.out.print("\nSom:");
                                if (s.isSom() == true) {
                                    System.out.print(" SIM");
                                 } else {
                                    System.out.print(" NÃO");
                                 } 
                                
                                System.out.print("\nProjetor:");
                                if (s.isProjetor() == true) {
                                    System.out.print(" SIM");
                                 } else {
                                    System.out.print(" NÃO");
                                 }
                                
                                System.out.print("\nComputador Para uso do Professor?");
                                if (s.isComputadorProfessor() == true) {
                                    System.out.print(" SIM");
                                 } else {
                                    System.out.print(" NÃO");
                                 }                               
                    }
                    break;
                    
                case 3:
                    if(sala == null){
                        CriarSala.criaSala();
                    }
                    realizarReserva(data, sala);
                    break;
                    
                case 4:
                    exibirReservas(data, sala, salas);
                    break;
                    
                case 0:
                    return;
                default:
                    Exception("Opção inválida, tente novamente.");
                    //Necessita-se um laço, aqui. 
            }
        }while(opcao != 0);
        
    }
    
    public static int selecionaInstituto(Scanner scanner){
        int opcao;
        System.out.println("Selecione o Centro De Aulas:\n1 - Centro De Aulas A"
                + "\n2 - Centro De Aulas B\n3 - Centro De Aulas C\n4 - INF\n5 -"
                + " IF\n6 - IQ\n7 - Faculdade De Letras\n8 - Faculdade de Filos"
                + "ofia");
        
        opcao = scanner.nextInt();
        return opcao;
    }
    
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



    private static void Exception(String comando_Inválido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
   private static void realizarReserva(LocalDateTime data, Sala sala){
       int year = 0;
       int month = 1;
       int day = 1;
       int hour = 7;
       Scanner scanner = new Scanner(System.in);
       
       int flag;
      /* flag = 0;
       do { 
        try {        
       System.out.println("Digite o ano da reserva:\n");
       year = Integer.parseInt(scanner.nextLine());
       flag = 1;
        } catch (DateTimeException erro) {
       System.out.println("Erro total\n");
       flag = 0;
        }} while (flag == 0);
       System.out.println("Erro total\n" + flag);*//*
       System.out.println("Digite o mes da reserva:\n");
       month = scanner.nextInt();
       scanner.nextLine();
       
       System.out.println("Digite o dia da reserva:\n");
       day = scanner.nextInt();
       scanner.nextLine();
       
       System.out.println("Digite a hora da reserva:\n");
       hour = scanner.nextInt();
       scanner.nextLine();*/
       
       flag = 0;
       LocalDateTime inicio_0 = LocalDateTime.of(1, 1, 1, 0, 0);
       do { 
        try { 
       System.out.println("Digite o ano da reserva ZXX:\n");
       year = Integer.parseInt(scanner.nextLine());     
       inicio_0 = LocalDateTime.of(year, month, day, hour, 0);
       flag = 1;
               } catch (Exception erro) {
       System.out.println("ANO INVÁLIDO!\n");
       flag = 0;
        }} while (flag == 0);
///
       do { 
        try { 
       System.out.println("Digite o mês da reserva ZXX:\n");
       month = Integer.parseInt(scanner.nextLine());     
       inicio_0 = LocalDateTime.of(year, month, day, hour, 0);
       flag = 1;
               } catch (Exception erro) {
       System.out.println("MÊS INVÁLIDO!\n");
       flag = 0;
        }} while (flag == 0);
///
       do { 
        try { 
       System.out.println("Digite o dia da reserva:\n");
       day = Integer.parseInt(scanner.nextLine());     
       inicio_0 = LocalDateTime.of(year, month, day, hour, 0);
       flag = 1;
               } catch (Exception erro) {
       System.out.println("DIA INVÁLIDO!\n");
       flag = 0;
        }} while (flag == 0);
//
       do { 
        try { 
       System.out.println("Digite o dia da reserva ZXX:\n");
       hour = Integer.parseInt(scanner.nextLine());     
       inicio_0 = LocalDateTime.of(year, month, day, hour, 0);
       //Hora inicial: 7h + Até Hora Final 22h
       if ((hour < 7) || (hour < 22)){
           throw new Exception("Horário Inválido.");
       }
       flag = 1;
               } catch (Exception erro) {
       System.out.println("HORÁRIO INVÁLIDO!\n");
       System.out.println("Note que o horário permitido é de 7h-22h\n");
       flag = 0;
        }} while (flag == 0);       
       
        LocalDateTime inicio = inicio_0;
       
       
       
       
       Reserva reserva = new Reserva(inicio, sala);
   }
   private static void exibirReservas(LocalDateTime data, Sala sala, 
           ArrayList<Sala> salas){
       for(Sala s: salas){
           System.out.println("Horario\t Sala");
           for(int i = 7; i <= 22; i++){
               if( i == (data.getHour())){
                    System.out.println(i + "h reservado\t" + s.getNumero());
               }
               else {
                    System.out.println(i + "h -----\t" + s.getNumero());
               }
           }
       }
   }
}
