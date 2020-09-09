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
	private List<Alimento> lsAlimentos;
	
	public static void main(String[] args) {
		new Main();
	}
		
	private Main() {
			
		System.out.println("-- BEM VINDO AO NUTRIDLIFECOM -- \n");
		
		l = new Scanner(System.in);
		executar = true;
		lsClientes = new ArrayList<Cliente>();
		lsFichaNutri = new ArrayList<FichaNutri>();
		lsAlimentos = new ArrayList<Alimento>();
		
		populaAlimentos();
		
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
			fichaNutri.setRestricaoAlimentar(textInput("Restrição Alimentar: "));
			
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
				System.out.println("\tN° Ficha: " + i + "\n" +
				"\tData Cadastro: " + f.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n" +
				"\tCliente: " + f.getCliente().getNome() + "\n" +
				"\t% de gordura: " + f.getPercentualGordura() + "\n" +
				"\tPeso: " + f.getPeso() + "\n" +
				"\tSensação Física: " + f.getSensacaoFisica() + "\n" +
				"\tRestrição Alimentar: " + f.getRestricaoAlimentar() + "\n" + 
				"\tInforme a meta de calorias: " + f.getMetaCalorica());
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
				System.out.println("\tN° Cliente: " + i + "\n" +
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
		
		if (lsAlimentos.size() == 0) {
			
			System.out.println("\nNão existe alimento cadastrado!\n");
		} else {
			
			System.out.println("\nLista de Alimentos\n");
			for (int i = 0; i < lsAlimentos.size(); i++) {
				Alimento a = lsAlimentos.get(i);
				System.out.println("N° Alimento: " + i);
				System.out.println("\tNome: " + a.getNome() + "\n" +
				"\tGrupo Alimentar: " + a.getGrupoAlimentar() + "\n" +
				"\tValor Calórico: " + a.getCaloria() + "\n");
			}
			System.out.println("\nFim da lista\n");
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
	
	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
	
	private void populaAlimentos() {
		
		Alimento a1 = new Alimento();
		a1.setNome("Cereal");
		a1.setGrupoAlimentar("Grupo 1");
		a1.setCaloria(150);
		lsAlimentos.add(a1);
		
		Alimento a2 = new Alimento();
		a2.setNome("Pão");
		a2.setGrupoAlimentar("Grupo 1");
		a2.setCaloria(100);
		lsAlimentos.add(a2);
		
		Alimento a3 = new Alimento();
		a3.setNome("Chuchu");
		a3.setGrupoAlimentar("Grupo 2");
		a3.setCaloria(15);
		lsAlimentos.add(a3);
		
		Alimento a4 = new Alimento();
		a4.setNome("Berinjela");
		a4.setGrupoAlimentar("Grupo 2");
		a4.setCaloria(20);
		lsAlimentos.add(a4);
		
		Alimento a5 = new Alimento();
		a5.setNome("Banana");
		a5.setGrupoAlimentar("Grupo 3");
		a5.setCaloria(50);
		lsAlimentos.add(a5);
		
		Alimento a6 = new Alimento();
		a6.setNome("Uva");
		a6.setGrupoAlimentar("Grupo 3");
		a6.setCaloria(65);
		lsAlimentos.add(a6);
	}
}