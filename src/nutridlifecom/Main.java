package nutridlifecom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private Scanner l;
	private boolean executar;
	private List<Cliente> lsClientes;
	private List<FichaNutri> lsFichaNutri;
	
	public static void main(String[] args) {
		new Main();
	}
		
	private Main() {
			
		l = new Scanner(System.in);
		executar = true;
		lsClientes = new ArrayList<Cliente>();
		lsFichaNutri = new ArrayList<FichaNutri>();
		
		System.out.println("-- BEM VINDO AO NUTRIDLIFECOM -- \n");		
	
		while (executar) {
			String item = menu();

			if (item.equalsIgnoreCase("1")) {
				
				listarClientes();
				
			} else if (item.equalsIgnoreCase("2")) {
				
				listarFichas();
				
			} else if (item.equalsIgnoreCase("3")) {
				
				listarAlimentos();
				
			} else if (item.equalsIgnoreCase("4")) {
				
				System.out.println("\nAplica��o encerrada!\n");
				executar = false;
				
			} else {
				
				System.out.println("\nNenhum op��o v�lida selecionada!\n");
			}
		}
	}
	
	private String menu() {
		
		System.out.println("\nSelecione a op��o:\n");
		System.out.println("1 - Clientes");
		System.out.println("2 - Ficha dos Clientes");
		System.out.println("3 - Alimentos");
		System.out.println("4 - Sair");
		return l.nextLine();
	}
	
	private String menuClientes() {
				
		System.out.println("\nSelecione a op��o:\n");
		System.out.println("1 - Novo Cliente");
		System.out.println("2 - Voltar");
		return l.nextLine();
	}
	
	private void cadastrarCliente() {
		
		try {
		
			System.out.println("-- Cadastro de Cliente --\n");
			Cliente cliente = new Cliente();
			cliente.setNome(textInput("Nome:"));
			cliente.setEmail(textInput("E-mail: "));
			cliente.setCelular(textInput("Celular: "));
			cliente.setTelefone(textInput("Telefone: "));
			cliente.setDataNascimento(textInput("Nascimento: "));
			cliente.setEndereco(textInput("Endere�o: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				
				System.out.println("Cadastro realizado com sucesso!\n");
				lsClientes.add(cliente);
				
			} else if (cadastrar.equalsIgnoreCase("n")){
				
				System.out.println("Cadastro cancelado!\n");
			} else {
				
				System.out.println("\nOp��o inv�lida!\n");
			}
			
			String novaFicha = textInput("Gerar ficha nutricional para o cliente (S/N) ?");
			
			if(novaFicha.equalsIgnoreCase("s")) {
				
				executar = false;
				cadastrarFicha(cliente);
			} 
		} catch (Exception e) {
			
			System.out.println("[ERROR] Ops! cadastrarCliente: " + e.getMessage() + "\n");			
		}
	}
	
	private void cadastrarFicha(Cliente cliente) {
		
		try {
			
			System.out.println("-- Cadastro de Ficha Nutricional --\n");
			FichaNutri fichaNutri = new FichaNutri();
			fichaNutri.setCliente(cliente);
			fichaNutri.setDataCadastro(LocalDate.now());
			fichaNutri.setPercentualGordura(Double.valueOf(textInput("% de gordura: ")));
			fichaNutri.setPeso(textInput("Peso: "));
			fichaNutri.setSensacaoFisica(textInput("Sensa��o F�sica: "));
			
			String cadastrar = textInput("Adicionar ficha (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				
				System.out.println("Cadastro de ficha realizado com sucesso!\n");
				lsFichaNutri.add(fichaNutri);
				
				listarFichas();
				
			} else if (cadastrar.equalsIgnoreCase("n")){
				
				System.out.println("Cadastro cancelado!\n");
			} else {
				
				System.out.println("\nOp��o inv�lida!\n");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] Ops! cadastrarFicha: " + e.getMessage() + "\n");
		}
	}
	
	private void listarFichas() {
		
		if(lsFichaNutri.size() == 0) {
			
			System.out.println("\nN�o existe ficha cadastrada!\n");
		} else {
			
			System.out.println("\nLista de Fichas\n");
			for (int i = 0; i < lsFichaNutri.size(); i++) {
				
				FichaNutri f = lsFichaNutri.get(i);
				System.out.println("N� Registro: " + i + "\n" +
				"\tData Cadastro: " + f.getDataCadastro() + "\n" +
				"\tCliente: " + f.getCliente().getNome() + "\n" +
				"\t% de gordura: " + f.getPercentualGordura() + "\n" +
				"\tPeso: " + f.getPeso() + "\n" +
				"\tSensa��o F�sica: " + f.getSensacaoFisica());
			}
			System.out.println("\nFim da lista\n");
		}	
		
		executar = true;
	}
	
	private void listarClientes() {
				
		if (lsClientes.size() == 0) {
			
			System.out.println("\nN�o existe cliente cadastrado!\n");
		} else {
			
			System.out.println("\nLista de Cadastros\n");
			for (int i = 0; i < lsClientes.size(); i++) {
				Cliente c = lsClientes.get(i);
				System.out.println("N� Registro: " + i + "\n" +
				"\tNome: " + c.getNome() + "\n" + 
				"\tE-mail: " + c.getEmail() + "\n" +
				"\tCelular: " + c.getCelular() + "\n" +
				"\tEndere�o: " + c.getEndereco());
			}
			System.out.println("\nFim da lista\n");
		}
				
		while (true) {
			
			String item = menuClientes();

			if (item.equalsIgnoreCase("1")) {
				
				cadastrarCliente();
				break;
			} else if (item.equalsIgnoreCase("2")) {
				
				menu();
				break;
			} else {
				System.out.println("\nNenhum op��o v�lida selecionada!\n");
			}
		}
	}
	
	private void listarAlimentos() {
		
		if (lsClientes.size() == 0) {
			
			System.out.println("\nN�o existem alimentos cadastrados!\n");
		} else {
			
			System.out.println("\nLista de Alimentos\n");
			for (int i = 0; i < lsClientes.size(); i++) {
				Cliente d = lsClientes.get(i);
				System.out.println("Cadastro n�mero: " + i);
				System.out.println("\tNome: " + d.getNome() + "\n");
			}
			System.out.println("\nFim da lista\n");
		}
	}
	
	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
}