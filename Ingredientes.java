package com;

import java.util.ArrayList;

public class Ingredientes {
    
    private ArrayList<String> ingredientes;
    private ArrayList<Integer> quant;
    private ArrayList<String> porcao;


    public Ingredientes(){
        ingredientes = new ArrayList<>();
        quant = new ArrayList<>();
        porcao = new ArrayList<>();
    }

    public void addIngrediente(String ingrediente){
        ingredientes.add(ingrediente);
    }

    public void addQuant(int quant){
        this.quant.add(quant);
    }

    public void addPorcao(String porcao){
        this.porcao.add(porcao);
    }

    public void print(){
        for(int i = 0; i < ingredientes.size(); i++)
            System.out.println(ingredientes.get(i) + " " + quant.get(i)+ " " + porcao.get(i));
    }

    public String viraString(){
        String str = new String();
         for(int i = 0; i < ingredientes.size(); i++)
            str += ingredientes.get(i) + " " + quant.get(i)+ " " + porcao.get(i) + ", ";
        return str;
    }

}
