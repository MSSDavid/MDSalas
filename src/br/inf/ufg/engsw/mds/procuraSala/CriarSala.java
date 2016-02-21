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
import static br.inf.ufg.engsw.mds.procuraSala.ProcuraSala.selecionaInstituto;
import java.util.Scanner;

/**
 *
 * @author Level 5
 */
public class CriarSala {

    

   
 
    public static Sala criaSala(){
        int capacidade = 0;
        int computadores = 0;
        int flag = 0;
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        
        int opcao = selecionaInstituto(scanner);
        CentroDeAulas centroDeAulas = selecionaInstituto(opcao);
        scanner.nextLine();
                
        flag = 0;
         do { 
        try {
        System.out.println("Digite o número da sala:");
        numero = Integer.parseInt(scanner.nextLine());    
        flag = 0;
        if (numero < 0) {
        throw new Exception("Erroooo");
        flag = 1;
        }
        }
         catch (Exception error) {
            System.out.println("Tipo de dado não suportado. Tente novamente.");
            flag = 1;
        }
        } while (flag == 1);           
        
        
        
        // Trate um erro com carinho
        
        do { 
        try {
        System.out.println("Quantos alunos a sala suporta?");
        capacidade = Integer.parseInt(scanner.nextLine());        
        flag = 0;
        if (capacidade < 0) {
        throw new Exception("Tipo de dado não suportado. Tente novamente.");
        flag = 1;
        }
        }
         catch (Exception error) {
            System.out.println("Tipo de dado não suportado. Tente novamente.");
            flag = 1;
        }
        } while (flag == 1);
        
        
        flag = 0;
         do { 
        try {
        System.out.println("Quantos computadores para uso do aluno tem na sala?"
                + "");
        computadores = Integer.parseInt(scanner.nextLine());    
        flag = 0;
        if (computadores < 0) {
        throw new Exception("Tipo de dado não suportado. Tente novamente.");
        flag = 1;
        }
        }
         catch (Exception error) {
            System.out.println("Dado incorreto! Repita a operação.");
            flag = 1;
        }
        } while (flag == 1);         
         
         
         
         
         
        boolean arCondicionado = isArcondicionado(scanner);
        boolean projetor = isProjetor(scanner);
        boolean microfone = isMicrofone(scanner);
        boolean som = isSom(scanner);
        boolean computadorProfessor = isComputador(scanner);
        Tipo tipo = escolherTipo(scanner);
        
        Sala sala = new Sala(centroDeAulas, numero, capacidade, computadores, 
                arCondicionado, projetor, microfone, som, computadorProfessor, 
                tipo);
        
        return sala;
    }    
    
        private static boolean isArcondicionado(Scanner scanner) {
        System.out.println("Possui Arcondicionado? S/n");
        String temArcondicionado = scanner.nextLine();
        if(temArcondicionado.equalsIgnoreCase("S"))
            return true;
        else
            return false;   
        
    }
    
    private static boolean isProjetor(Scanner scanner) {
        System.out.println("Possui Projetor? S/n");
        String temArcondicionado = scanner.nextLine();
        if(temArcondicionado.equalsIgnoreCase("S"))
            return true;
        else
            return false;   
        
    }
    
    private static boolean isMicrofone(Scanner scanner) {
        System.out.println("Possui Microfone? S/n");
        String temArcondicionado = scanner.nextLine();
        if(temArcondicionado.equalsIgnoreCase("S"))
            return true;
        else
            return false;   
        
    }
    
    private static boolean isSom(Scanner scanner) {
        System.out.println("Possui estrutura de áudio? S/n");
        String temArcondicionado = scanner.nextLine();
        if(temArcondicionado.equalsIgnoreCase("S"))
            return true;
        else
            return false;   
        
    }
    
    private static boolean isComputador(Scanner scanner) {
        System.out.println("Possui Computador para uso do Professor? S/n");
        String temArcondicionado = scanner.nextLine();
        if(temArcondicionado.equalsIgnoreCase("S"))
            return true;
        else
            return false;   
        
    }
 
       private static Tipo escolherTipo(Scanner scanner){
       int opcao;
       Tipo tipo;
       System.out.println("Qual o tipo de sala?\n1 - Sala de Aula\n2 - Laborató"
               + "rio\n3 - Auditorio");
       opcao = scanner.nextInt();
       scanner.nextLine();
       
       switch(opcao){
           case 1:
               tipo = Tipo.Sala;
               break;
            
           case 2:
               tipo = Tipo.Laboratorio;
               break;
               
           case 3:
               tipo = Tipo.Auditorio;
               break;
               
           default:
               tipo = Tipo.Sala;
               Exception("Comando Inválido!");
       }
       
       return tipo;
   }
    
}
