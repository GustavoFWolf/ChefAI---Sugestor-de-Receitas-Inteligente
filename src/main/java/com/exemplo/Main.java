package com.exemplo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        Ingredientes ingredientes = new Ingredientes();
        Scanner sc = new Scanner(System.in);
        while (continuar) {
            try{
                System.out.println("Qual ingrediente vc quer adicionar?");
                String ingrediente = sc.nextLine();
                if(ingrediente.trim().isBlank())
                    throw new NullPointerException("Nenhum ingrediente informaddo");

                ingredientes.addIngrediente(ingrediente);
            }
            catch(NullPointerException e){
                System.err.println(e.getMessage());
                continue;
            }
            while(true){
                try{
                    System.out.println("Quantidade?");
                    int quant = sc.nextInt();
                    ingredientes.addQuant(quant);
                    sc.nextLine();
                    break;
                }
                catch(Exception e){
                    System.err.println("Digite um inteiro válido");
                    sc.nextLine();
                }
            }
            while(true){
                try{
                System.out.println("Escolha um por favor");
                System.out.println("[unidade] [gramas] [ml]");
                String por = sc.nextLine();
                if(por.trim().isBlank())
                    throw new IllegalArgumentException("Valor inválido");
                
                ingredientes.addPorcao(por);
                break;
                }
                catch(IllegalArgumentException e){
                    System.err.println(e.getMessage());
                }
            }
            
            System.out.println("Quer continuar? [S/N]");
            String stop = sc.nextLine();
            if(stop.equals("N") || stop.equals("n"))
                continuar = false;
        }
        while(true){
             try{
            System.out.println("Escolha um tipo de sujestao:");
            System.out.println("[Base] [Saudavel] [Vegetariano] [Sem lactose] [Sem gluten]");

            Sugestao sujs;
            
            String escolha = sc.nextLine();
            if(escolha.equals("Base"))
                sujs = new SugestaoBase(ingredientes);
            else if(escolha.equals("Saudavel"))
                sujs = new SugestaoSaudavel(ingredientes);
            else if(escolha.equals("Vegetariano"))
                sujs = new SugestaoVeg(ingredientes);
            else if(escolha.equals("Sem lactose"))
                sujs = new SugestaoLac(ingredientes);
            else if(escolha.equals("Sem gluten"))
                sujs = new SugestaoGlu(ingredientes);
            else
                throw new IllegalArgumentException("Sujestão Inválida");
            
            System.out.println("Gerando resposta da IA...");
            sujs.fazerSujestao();
            sc.close();
            break;
            }
            catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
    }
}

