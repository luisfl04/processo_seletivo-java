package proj.lf04.processo_seletivo.face;

// Importações nescessárias:
import proj.lf04.processo_seletivo.base.BaseSistema;

// Classe que irá ser responsável por chamar os métodos e 'conversar' com o usuário:
public class ProcessoSeletivo{
    public static void main(String[] args) {

        BaseSistema.pegar_informacoes_candidato();

    }

    // Método que Dar informações de boas vindas para o usuário:
    public static void dar_boas_vindas(){

        System.out.println("* PROCESSO SELETIVO PARA VAGA DE EMPREGO *\n\nOlá canditado, primeiramente, nos informe seus dados para que possamos analisá-los e dar uma resposta para você.\n\nAguarde um momento... ");

        // Dando um pequena pausa na execução do método:
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException exception){
            exception.getMessage();
        }
        
    }



}