package proj.lf04.processo_seletivo.base;

import java.util.InputMismatchException;
// Importações nescessárias:
import java.util.Scanner;

// Classe que vai conter os métodos que irão ser usados para analisar os dados que o candidato inseriu:
class VericacaoDados {   

    // Método que verifica o nome informado pelo usuário e pede um novo valor se for inválido:
    void verificar_nome(String nome_informado)
    

    
    // Método que verifica se o valor que o candidato informou para a sua idade é inválido:
    void verificar_idade(int idade_informada_pelo_usuario){

        // Fazendo verificação e pedindo um valor válido:
        while(idade_informada < 1 || idade_informada > 100){
            // Informando erro e pedindo o valor novamente:
            System.out.println("\nO valor que você inseriu é inválido!\nDigite um valor válido para i");
            


        }


    }   

    
}




// Classe onde os métodos que serão nescessários para o funcionamento do sistema serão implementados.
public class BaseSistema {

    // Método que vai pedir as informações gerais do candidato, como: nome, salário pretendido e etc. É o métodp introdutório do sistema.
    static void pegar_informacoes_candidato(){

        // Criando variáveis que irão armazenar os valores:
        String nome_candidato;
        int idade_candidato;
        double salario_pretendido_candidato;

        // Abrindo instância da classe 'Scanner':
        Scanner scanf = new Scanner(System.in);

        // Pedindo as informações pelo teclado:
        // Nome:
        try{
            System.out.println("Olá candidato, primeiramente nos informe o seu nome abaixo:");
            nome_candidato = scanf.next();
        }
        catch(InputMismatchException exception){
            System.out.println("Você informou um valor de tipo diferente ao solicitado!");
        }



        System.out.println("Certo " + nome_candidato + ", nos informe a sua idade abaixo:");
        idade_candidato = scanf.nextInt();





        // Fechando instância de 'Scanner':
        scanf.close();

    }



    // Método que compara e analisa o salário pretendido pelo canditado com relação ao salário base:
    static void analisar_salario_candidato(double salario_pretendido_candidato){





    } 





}
