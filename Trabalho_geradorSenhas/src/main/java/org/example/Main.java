package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario;
        System.out.println("Escreva o nome do usuario: ");
        String nome = scanner.nextLine();

        System.out.println("Escreva o email do usuario: ");
        String email = scanner.nextLine();

        usuario = new Usuario(nome,email);

        usuario.definirCriterios(12, true, true, true, true);
        String senha = usuario.gerarSenha();
        System.out.println("Senha gerada: " + senha);
    }
}