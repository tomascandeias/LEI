import java.util.Scanner;
import static java.lang.System.*;

public class Biblioteca {

	public static final Scanner sc = new Scanner(System.in);
	private static Utilizador[] users = new Utilizador[100];
	private static int usersCount=0;
	private static Livro[] books = new Livro[100];
	private static int booksCount=0;

	public static void main(String[] args){
		while (true){
			out.print("\n\n->Biblioteca opções<-\n" +
					"1 -inscrever utilizador\n" +
					"2 -remover utilizador\n" +
					"3 -imprimir lista de utilizadores\n" +
					"4 -registar um novo livro\n" +
					"5 -imprimir lista de livros\n" +
					"6 -emprestar\n" +
					"7 -devolver\n" +
					"8 -sair\n" +
					"Opção->");

			int op = sc.nextInt();
			sc.nextLine();
			switch (op){
				case 1:
					inscrever();
					break;
				case 2:
					remover();
					break;
				case 3:
					imprimirUsers();
					break;
				case 4:
					registarLivro();
					break;
				case 5:
					imprimirLivros();
					break;
				case 6:
					emprestar();
					break;
				case 7:
					devolver();
					break;
				case 8:
					System.exit(0);
				default:
					out.println("Número inválido!");
			}
		}


	}

	private static void inscrever() {
		out.print("Nome: ");
		String nome = sc.nextLine();

		out.print("Número mecanográfico: ");
		int nmec = sc.nextInt();
		sc.nextLine();
		while(nmec<0){
			out.print("Insira um número mecanográfico válido: ");
			nmec = sc.nextInt();
			sc.nextLine();
		}

		out.print("Curso: ");
		String curso = sc.next();
		sc.nextLine();

		users[usersCount] = new Utilizador(nome, nmec, curso);
		usersCount++;
		out.println("\nSystem: Utilizador inscrito\n");
	}

	private static void remover() {
		int removeIndex = -1;

		out.print("Número mecanográfico: ");
		int nmec = sc.nextInt();
		sc.nextLine();

		for (int i=0; i<usersCount; i++){
			if (nmec == users[i].getNmec()){
				removeIndex = i;
			}
		}

		if (removeIndex == -1){
			out.println("\nSystem: Utilizador não encontrado\n");
		}else{
			for (int i=removeIndex; i<usersCount-1; i++){
				users[i] = users[i+1];
			}

			users[usersCount-1] = null;
			usersCount--;
			out.println("\nSystem: Utilizador removido\n");
		}

	}


	private static void imprimirUsers() {
		out.println("\nLista de utilizadores:");
		out.printf("%15s%15s%15s\n", "Nome", "N.Mec", "Curso");
		for (int i=0; i<usersCount; i++){
			out.printf("%15s%15s%15s\n", users[i].getNome(), users[i].getNmec(), users[i].getCurso());
		}
	}

	private static void registarLivro(){
		out.print("\nNome do livro: ");
		String nome = sc.nextLine();

		out.print("Tipo de empréstimo (1-NORMAL, 2-CONDICIONAL): ");
		int tp = sc.nextInt();
		sc.nextLine();
		while (tp != 1 && tp != 2){
			out.print("Tipo de empréstimo: ");
			tp = sc.nextInt();
			sc.nextLine();
		}

		books[booksCount] = new Livro(nome, (tp==1)? "NORMAL" : "CONDICIONAL");
		booksCount++;
		out.println("\nSystem: Livro registado\n");

	}

	private static void imprimirLivros(){
		out.println("\nLista de livros:");
		out.printf("%30s%30s\n", "Titulo", "Tipo Empréstimo");
		for (int i=0; i<booksCount; i++){
			out.printf("%30s%30s\n", books[i].getTitulo(), books[i].getTipoEmprestimo());
		}
	}

	private static void emprestar(){
		int nbooks = 0;
		int userIndex = -1;
		int bookIndex = -1;

		out.print("N.Mec a requisitar o livro: ");
		int nmec = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<usersCount; i++){
			if (nmec == users[i].getNmec()){
				userIndex = i;

				for (int j=0; j<2; j++){
					if (users[userIndex].getBooks()[j]>=100) { nbooks++; }
				}
				break;
			}
		}

		out.print("ID do livro: ");
		int id = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<booksCount; i++){
			if (id == books[i].getId()){
				bookIndex = i;
				break;
			}
		}

		if (userIndex == -1){
			out.println("\nSystem: Utilizador inválido");
		}else if (bookIndex == -1){
			out.println("\nSystem: Livro inválido\n");
		}else if (!books[bookIndex].getDisponibilidade()){
			out.println("\nSystem: Livro indisponível\n");
		}else if (nbooks == 3){
			out.println("\nSystem: Já atingiu o máximo de livros requisitáveis\n");
		}else if (books[bookIndex].getTipoEmprestimo().equals("CONDICIONAL")){
			out.println("\nSystem: Livro não requisitável\n");
		}else{
			books[bookIndex].setDisponiblidade(false);
			if (users[userIndex].getBooks()[0] == 0) users[userIndex].setBook1(books[bookIndex].getId());
			else if (users[userIndex].getBooks()[1] == 0) users[userIndex].setBook2(books[bookIndex].getId());
			else if (users[userIndex].getBooks()[2] == 0) users[userIndex].setBook3(books[bookIndex].getId());

			out.println("\nSystem: Empréstimo concluido com sucesso\n");
		}

	}


	private static void devolver(){
		int userIndex = -1;
		int bookIndex = -1;

		out.print("N.Mec a devolver1 o livro: ");
		int nmec = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<usersCount; i++){
			if (nmec == users[i].getNmec()){
				userIndex = i;
				break;
			}
		}

		out.print("ID do livro: ");
		int id = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<booksCount; i++){
			if (id == books[i].getId()){
				bookIndex = i;
				break;
			}
		}


		if (userIndex == -1){
			out.println("\nSystem: Utilizador inválido");
		}else if (bookIndex == -1){
			out.println("\nSystem: Livro inválido\n");
		}else{
			int index = -1;
			for (int i=0; i<2; i++){
				if (books[bookIndex].getId() == users[userIndex].getBooks()[i]){
					index = i;
				}
			}

			if (index == -1){
				out.println("\nSystem: Utilizador não possui o livro\n");
			}else{
				books[bookIndex].setDisponiblidade(true);
				if (index == 0) users[userIndex].setBook1(0);
				else if (index == 1) users[userIndex].setBook2(0);
				else if (index == 2) users[userIndex].setBook3(0);

				out.println("\nSystem: Devolução concluida com sucesso\n");
			}

		}



	}


}
