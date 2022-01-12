package com.letscode;

import java.util.ArrayList;

public class BatalhaNaval {

    public static String nome;
    public static int numColunas = 10;
    public static int numLinhas = 6;
    public static int [] linhasTabuleiros = {0,1,2,3,4,5};
    public static int quantidadeNaviosPadrao = 10;

    public static String [][] tabuleiroJogador1 = new String [numLinhas][numColunas];
    public static String [][] tabuleiroCPU = new String [numLinhas][numColunas];

    public static ArrayList<ArrayList<Integer>> posicaoNaviosCPU = new ArrayList<ArrayList<Integer>>();

    public static EntradaDados entrada = new EntradaDados();

    public static void main(String[] args){

        System.out.println("Entre com o nome do jogador: ");
        nome = entrada.inputValues.nextLine();
        System.out.println(nome);

        criarTabuleiroBatalha(tabuleiroJogador1, nome);
        System.out.printf("");
        criarTabuleiroBatalha(tabuleiroCPU, "CPU");
        System.out.printf("");
        posicionarNaviosJogador();
        mostrarTabuleiro(tabuleiroJogador1, nome);
        posicionarNaviosPC();
        criarTabuleiroBatalha(tabuleiroCPU, "CPU");
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

        int contadorNavios = 10;

        for(int i = 0; i < quantidadeNaviosPadrao; i++){

            int posicaoLinhaNavio = -1;
            int posicaoColunaNavio = -1;

            System.out.println("VOCÊ TEM "+ contadorNavios +" NAVIOS PARA COLOCAR EM POSIÇÃO!!!");
            System.out.println("#################################################################");
            System.out.println("Selecione a linha que deseja para posicionar o navio: ");
            posicaoLinhaNavio = Integer.parseInt(entrada.inputValues.nextLine());
            System.out.println("Selecione a coluna que deseja para posicionar seu navio: ");
            posicaoColunaNavio = Integer.parseInt(entrada.inputValues.nextLine());
            System.out.println("#################################################################");

            if((posicaoLinhaNavio >= 0 && posicaoLinhaNavio <= 5) && (posicaoColunaNavio >= 0 && posicaoColunaNavio <= 10)){
                if(tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] == "   "){
                    tabuleiroJogador1[posicaoLinhaNavio][posicaoColunaNavio] = " N ";
                    mostrarTabuleiro(tabuleiroJogador1,nome);
                    contadorNavios -=1;
                }else{
                    System.out.println("Posição escolhida já está populada por um navio!");
                    i--;
                }
            }else{
                System.out.println("VALORES ESCOLHIDOS ESTÃO FORA DO PADRAO DO TABULEIRO");
                System.out.println("TABULEIRO POSSUI 6 LINHAS DE 0 à 5");
                System.out.println("TABULEIRO POSSUI 10 COLUNAS DE 0 à 9");
                System.out.println("############################################################");
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

        /*System.out.println(posicaoNaviosCPU);*/
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

                try{
                    System.out.println("ESCOLHA EM QUAL LINHA DESEJA EFETUAR O TIRO: ");
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

                if(tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] != "  "){
                    if(tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] == " N "){
                        tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] = " * ";
                        System.out.println("*******************************************");
                        System.out.println("CPU AFUNDOU UM NAVIO");
                        System.out.println("*******************************************");
                        contadorCPU += 1;

                    }else if(tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] == " * "){
                    }else{
                        tabuleiroJogador1[linhaDoTiroCPU][colunaDoTiroCPU] = " - ";
                    }
                }else{
                    continue;
                }

                if(posicaoNaviosCPU.contains(verificaPosicaoTiroJogador)){
                    if(tabuleiroCPU[linhaDoTiroJogador][colunaDoTiroJogador] == " * "){
                    }else{
                        tabuleiroCPU[linhaDoTiroJogador][colunaDoTiroJogador] = " * ";
                        System.out.println("*******************************************");
                        System.out.println("VOCE AFUNDOU UM NAVIO");
                        System.out.println("*******************************************");
                        contadorJogador += 1;
                    }
                }else{
                    tabuleiroCPU[linhaDoTiroJogador][colunaDoTiroJogador] = " - ";
                }
                mostrarTabuleiro(tabuleiroJogador1,nome);
                mostrarTabuleiro(tabuleiroCPU,"CPU");
                System.out.println("Navios Afundados " + nome + ": " + contadorJogador);
                System.out.println("Navios Afundados CPU: " + contadorCPU);

                if(contadorJogador == 10 || contadorCPU == 10){
                    if(contadorJogador == 10){
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("                  "+nome + " GANHOU!!!!                      ");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        break;
                    }
                    if( contadorCPU == 10){
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("                       CPU GANHOU!!!!                       ");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        System.out.println("############################################################");
                        break;
                    }
                }
            }else{

                System.out.println("VALORES ESCOLHIDOS ESTÃO FORA DO PADRAO DO TABULEIRO");
                System.out.println("TABULEIRO POSSUI 6 LINHAS DE 0 à 5");
                System.out.println("TABULEIRO POSSUI 10 COLUNAS DE 0 à 9");
                System.out.println("############################################################");
            }
        }
    }
}
