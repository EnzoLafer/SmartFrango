package br.com.fiap.smartfrango.model;

import java.util.Random;

public record Rotina(Long id, String nome, String exercicios) {
    public Rotina(Long id, String nome, String exercicios){
        this.id = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.exercicios = exercicios;
    }
}
