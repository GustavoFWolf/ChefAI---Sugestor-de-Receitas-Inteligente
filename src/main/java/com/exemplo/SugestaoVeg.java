package com.exemplo;
import com.Ingredientes;

public class SugestaoVeg extends Sugestao {

    public SugestaoVeg(Ingredientes ingredientes) {
        super(ingredientes);
    }

    public void fazerSujestao() {
        String prompt = "Me diga três receitas de no máximo 30 minutos obrigatoriamente vegetarianas" +
                "com esses ingredientes e quantidades respectivamente: " +
                ingredientes.viraString() +
                " você opcinalmente pode usar alho, azeite, sal e cebola.";

        String resposta = model.generate(prompt);

        System.out.println("\nResposta da IA:\n" + resposta);
    }
}
