import java.util.Scanner;

abstract class Cofre {
  	protected String tipo;
  	protected String metodoAbertura;

  	public Cofre(String tipo, String metodoAbertura) {
    	this.tipo = tipo;
    	this.metodoAbertura = metodoAbertura;
  	}

  	public void imprimirInformacoes() {
    	System.out.println("Tipo: " + this.tipo);
    	System.out.println("Metodo de abertura: " + this.metodoAbertura);
  	}
}

class CofreDigital extends Cofre {

  	private int senha;

  	public CofreDigital(int senha) {
    	super("Cofre Digital", "Senha");
    	this.senha = senha;
  	}

  	public boolean validarSenha(int confirmacaoSenha) {
    	return confirmacaoSenha == this.senha;
  	}

	public void abrirCofre(int senha){
		if(validarSenha(senha)){
			System.out.println("Cofre aberto!");
		} else {
			System.out.println("Senha incorreta!");
		}
	}
}

class CofreFisico extends Cofre {

  	public CofreFisico() {
	    super("Cofre Fisico", "Chave");
  	}

}

public class DesafioII {
  	public static void main(String[] args) {
    	// Lê o tipo de cofre (primeira linha da entrada)
    	Scanner scanner = new Scanner(System.in);
    	String tipoCofre = scanner.nextLine();
    
    	// TODO: Implemente a condição necessário para a verificação dos cofres seguros:
    	if (tipoCofre.equalsIgnoreCase("digital")) {
			int senha = scanner.nextInt();
			CofreDigital digital = new CofreDigital(senha);

			int tentativa = scanner.nextInt();

			digital.imprimirInformacoes();
			digital.abrirCofre(tentativa);
    	} else {
			Cofre fisico = new CofreFisico();
			fisico.imprimirInformacoes();
		}
    
    	scanner.close();
  	}
}