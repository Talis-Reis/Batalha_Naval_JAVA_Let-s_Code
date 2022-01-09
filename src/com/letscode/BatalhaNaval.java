package com.letscode;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class BatalhaNaval {

    public static String nome;
    public static int numColunas = 10;
    public static int numLinhas = 6;
    public static int [] linhasTabuleiros = {0,1,2,3,4,5};
    public static int quantidadeNaviosPadrao = 10;

    public static String [][] tabuleiroJogador1 = new String [numLinhas][numColunas];
    public static String [][] tabuleiroComputador = new String [numLinhas][numColunas];

    public static ArrayList<ArrayList<Integer>> posicaoNaviosCPU = new ArrayList<ArrayList<Integer>>();

    static EntradaDados entrada = new EntradaDados();

    public static void main(String[] args){

        System.out.println("Entre com o nome do jogador: ");
        nome = entrada.inputValues.nextLine();
        System.out.println(nome);

        criarTabuleiroBatalha(tabuleiroJogador1, nome);
        System.out.printf("");
        criarTabuleiroBatalha(tabuleiroComputador, "CPU");
        System.out.printf("");
        posicionarNaviosJogador();
        mostrarTabuleiro(tabuleiroJogador1, nome);
        posicionarNaviosPC();
        criarTabuleiroBatalha(tabuleiroComputador, "CPU");
        System.out.printf("");
        System.out.printf("");
        efetuarTiros();

    }

    public static void criarTabuleiroBatalha(String[][] tabuleiro, String nomeJogador) {

        System.out.println("Jogador: " + nomeJogador);
        System.out.print(" ");

        for (int i = 0; i < numColunas; i++){
            System.out.print(" | ");
            System.out.print(i);

        }
        System.out.println(" |");
        System.out.print("-------------------------------------------");
        System.out.println("");
        for(int i = 0; i < tabuleiro.length; i++){
            System.out.print(linhasTabuleiros[i] + " |");
            for(int j = 0; j < tabuleiro[i].length; j++){

                tabuleiro[i][j] = "   ";
                System.out.print(tabuleiro[i][j]);
                System.out.print("|");
            }
            System.out.println(" ");
            System.out.println("-------------------------------------------");
        }
        System.out.println(" ");
    }

    public static void mostrarTabuleiro(String[][] tabuleiro, String nomeJogador){

        System.out.println("Jogador: " + nomeJogador);
        System.out.print(" ");

        for (int i = 0; i < numColunas; i++){
            System.out.print(" | ");
            System.out.print(i);

        }
        System.out.println(" |");
        System.out.print("-------------------------------------------");
        System.out.println("");
        for(int i = 0; i < tabuleiro.length; i++){
            System.out.print(linhasTabuleiros[i] + " |");
            for(int j = 0; j < tabuleiro[i].length; j++){

                System.out.print(tabuleiro[i][j]);
                System.out.print("|");
            }
            System.out.println(" ");
            System.out.println("-------------------------------------------");
        }
        System.out.println(" ");
    }

    public static void posicionarNaviosJogador(){

        for(int i = 1; i <= quantidadeNaviosPadrao; i++){

            /*System.out.println("Selecione a linha para posicionar seu navio de numero " + i + ":");
            int posicaoLinhaNavio = entrada.inputValues.nextInt();
            System.out.println("Selecione a coluna que deseja posicionar seu navio de numero " + i + ":");
            int posicaoColunaNavio = entrada.inputValues.nextInt();

            if(tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] == "   "){
                tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] = " N ";
                mostrarTabuleiro(tabuleiroJogador1,nome);
            }else{
                mostrarTabuleiro(tabuleiroJogador1,nome);
                System.out.println("Posição escolhida já está populada por um navio!");
                i--;
            }*/

            int posicaoLinhaNavio = (int) (Math.random() * 5);
            int posicaoColunaNavio = (int) (Math.random() * 10);

            if(tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] == "   "){
                tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] = " N ";
                mostrarTabuleiro(tabuleiroJogador1,nome);
            }else{
                mostrarTabuleiro(tabuleiroJogador1,nome);
                System.out.println("Posição escolhida já está populada por um navio!");
                i--;
            }


        }
    }

    public static void posicionarNaviosPC(){

        for(;;){

            ArrayList<Integer> verificaMesmaPosicaoNavioCPU = new ArrayList<Integer>();

            int posicaoLinhaNavioPC = (int) (Math.random() * 5);
            int posicaoColunaNavioPC = (int) (Math.random() * 10);

            verificaMesmaPosicaoNavioCPU.add(posicaoLinhaNavioPC);
            verificaMesmaPosicaoNavioCPU.add(posicaoColunaNavioPC);

            for(int j=0;j<quantidadeNaviosPadrao;j++){
                if(!posicaoNaviosCPU.contains(verificaMesmaPosicaoNavioCPU)){
                    posicaoNaviosCPU.add(verificaMesmaPosicaoNavioCPU);
                }
            }

            if(posicaoNaviosCPU.toArray().length == quantidadeNaviosPadrao){
                break;
            }
        }
        System.out.println(posicaoNaviosCPU);
    }

    public static void efetuarTiros(){
        System.out.println("##############################################################################");
        System.out.println("INICIANDO BATALHA");
        System.out.println("##############################################################################");

        ArrayList<Integer> verificaPosicaoTiroJogador = new ArrayList<Integer>();

        int contadorJogador = 0;
        int contadorCPU = 0;


        for(;;){

                int linhaDoTiroJogador = -1;
                int colunaDoTiroJogador = -1;

                try{System.out.println("ESCOLHA EM QUAL LINHA DESEJA EFETUAR O TIRO: ");
                    linhaDoTiroJogador = Integer.parseInt(entrada.inputValues.nextLine());
                    System.out.println("ESCOLHA EM QUAL COLUNA DESEJA EFETUAR O TIRO: ");
                    colunaDoTiroJogador = Integer.parseInt(entrada.inputValues.nextLine());
                }catch (NumberFormatException exception){
                    System.out.println("############################################################");
                    System.out.println("JOGO ACEITA APENAS VALORES NUMÉRIOS");
                }


            if((linhaDoTiroJogador >= 0 && linhaDoTiroJogador <= 5) && (colunaDoTiroJogador >= 0 && colunaDoTiroJogador <= 10)){
                int linhaDoTiroCPU = (int) (Math.random() * 5);
                int colunaDoTiroCPU = (int) (Math.random() * 10);

                verificaPosicaoTiroJogador.clear();
                verificaPosicaoTiroJogador.add(linhaDoTiroJogador);
                verificaPosicaoTiroJogador.add(colunaDoTiroJogador);

                if(tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] == " N "){
                    System.out.println("CPU AFUNDOU UM NAVIO");
                    tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] = " * ";
                    contadorCPU += 1;

                }else if(tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] == " * "){
                }else{
                    tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] = " - ";
                }
                if(posicaoNaviosCPU.contains(verificaPosicaoTiroJogador)){
                    if(tabuleiroComputador[linhaDoTiroJogador][colunaDoTiroJogador] == " * "){
                    }else{
                        System.out.println("VOCE AFUNDOU UM NAVIO");
                        tabuleiroComputador[linhaDoTiroJogador][colunaDoTiroJogador] = " * ";
                        contadorJogador += 1;
                    }
                }else{
                    tabuleiroComputador[linhaDoTiroJogador][colunaDoTiroJogador] = " - ";
                }
                System.out.println(contadorJogador);
                System.out.println(contadorCPU);
                mostrarTabuleiro(tabuleiroJogador1,nome);
                mostrarTabuleiro(tabuleiroComputador,"CPU");

                if(contadorJogador == 10 || contadorCPU == 10){
                    if(contadorJogador == 10){
                        System.out.println(nome + " GANHOU!!!!");
                        break;
                    }
                    if( contadorCPU == 10){
                        System.out.println(" CPU GANHOU!!!!");
                        break;
                    }
                }
            }else{

                System.out.println("VALORES ESCOLHIDOS ESTÃO FORA DO PADRAO DO TABULEIRO");
                System.out.println("TABULEIRO POSSI 6 LINHAS DE 0 à 5");
                System.out.println("TABULEIRO POSSI 10 COLUNAS DE 0 à 9");
                System.out.println("############################################################");
            }
        }
    }
}
