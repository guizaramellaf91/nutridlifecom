package nutridlifecom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			
		System.out.println("-- BEM VINDO AO NUTRIDLIFECOM -- \n");
		
		l = new Scanner(System.in);
		executar = true;
		lsClientes = new ArrayList<Cliente>();
		lsFichaNutri = new ArrayList<FichaNutri>();
		
		while (executar) {
			String item = menu();

			if (item.equalsIgnoreCase("c")) {
				
				listarClientes();
				
			} else if (item.equalsIgnoreCase("f")) {
				
				listarFichas();
				
			} else if (item.equalsIgnoreCase("a")) {
				
				listarAlimentos();
				
			} else if (item.equalsIgnoreCase("e")) {
				
				System.out.println("\nAplicação encerrada!\n");
				executar = false;
				
			} else {
				
				System.out.println("\nNenhum opção válida selecionada!\n");
			}
		}
	}
	
	private String menu() {
		
		System.out.println("\nSelecione a opção:\n");
		System.out.println("[C] - Clientes");
		System.out.println("[F] - Ficha dos Clientes");
		System.out.println("[A] - Alimentos");
		System.out.println("[E] - Sair");
		return l.nextLine();
	}
	
	private String menuClientes() {
				
		System.out.println("\nSelecione a opção:\n");
		System.out.println("[1] - Novo Cliente");
		System.out.println("[2] - Voltar");
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
			cliente.setEndereco(textInput("Endereço: "));

			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				
				System.out.println("Cadastro realizado com sucesso!\n");
				lsClientes.add(cliente);
				
			} else if (cadastrar.equalsIgnoreCase("n")){
				
				System.out.println("Cadastro cancelado!\n");
			} else {
				
				System.out.println("\nOpção inválida!\n");
			}
			
			String novaFicha = textInput("Gerar ficha nutricional para o cliente (S/N) ?");
			
			if(novaFicha.equalsIgnoreCase("s")) {
				
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
			fichaNutri.setDataCadastro(LocalDateTime.now());
			fichaNutri.setPercentualGordura(Double.valueOf(textInput("% de gordura: ")));
			fichaNutri.setPeso(textInput("Peso: "));
			fichaNutri.setSensacaoFisica(textInput("Sensação Física: "));
			
			String cadastrar = textInput("Adicionar ficha (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				
				System.out.println("Cadastro de ficha realizado com sucesso!\n");
				lsFichaNutri.add(fichaNutri);
				
				listarFichas();
				
			} else if (cadastrar.equalsIgnoreCase("n")){
				
				System.out.println("Cadastro cancelado!\n");
			} else {
				
				System.out.println("\nOpção inválida!\n");
			}
		} catch (Exception e) {
			System.out.println("[ERROR] Ops! cadastrarFicha: " + e.getMessage() + "\n");
		}
	}
	
	private void listarFichas() {
		
		if(lsFichaNutri.size() == 0) {
			
			System.out.println("\nNão existe ficha cadastrada!\n");
		} else {
			
			System.out.println("\nLista de Fichas\n");
			for (int i = 0; i < lsFichaNutri.size(); i++) {
				
				FichaNutri f = lsFichaNutri.get(i);
				System.out.println("N° Ficha: " + i + "\n" +
				"\tData Cadastro: " + f.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n" +
				"\tCliente: " + f.getCliente().getNome() + "\n" +
				"\t% de gordura: " + f.getPercentualGordura() + "\n" +
				"\tPeso: " + f.getPeso() + "\n" +
				"\tSensação Física: " + f.getSensacaoFisica());
			}
			System.out.println("\nFim da lista\n");
		}	
	}
	
	private void listarClientes() {
				
		if (lsClientes.size() == 0) {
			
			System.out.println("\nNão existe cliente cadastrado!\n");
		} else {
			
			System.out.println("\nLista de Cadastros\n");
			for (int i = 0; i < lsClientes.size(); i++) {
				Cliente c = lsClientes.get(i);
				System.out.println("N° Cliente: " + i + "\n" +
				"\tNome: " + c.getNome() + "\n" + 
				"\tE-mail: " + c.getEmail() + "\n" +
				"\tCelular: " + c.getCelular() + "\n" +
				"\tEndereço: " + c.getEndereco());
			}
			System.out.println("\nFim da lista\n");
		}
				
		while (true) {
			
			String item = menuClientes();

			if (item.equalsIgnoreCase("1")) {
				
				cadastrarCliente();

			} else if (item.equalsIgnoreCase("2")) {
				
				return;

			} else {
				System.out.println("\nNenhum opção válida selecionada!\n");
			}
		}
	}
	
	private void listarAlimentos() {
		
		if (lsClientes.size() == 0) {
			
			System.out.println("\nNão existem alimentos cadastrados!\n");
		} else {
			
			System.out.println("\nLista de Alimentos\n");
			for (int i = 0; i < lsClientes.size(); i++) {
				Cliente d = lsClientes.get(i);
				System.out.println("Cadastro número: " + i);
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