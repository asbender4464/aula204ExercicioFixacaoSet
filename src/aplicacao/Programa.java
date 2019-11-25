package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entidades.EntradaDeLog;

public class Programa {

	public static void main(String[] args) {
		
		/*
		 * A quest�o-chave deste exerc�cio � internalizar o fato de que os SETs N�O admitem repeti��es,
		 * ou seja, quando se adiciona novos elementos a um conjunto, as repeti��es s�o DESCARTADAS.
		 */

		/*
		 * O arquivo de entrada ler� os seguintes dados, com campos separados por " ", e data no formato ISO8601:
		 * amanda 2018-08-26T20:45:08Z
		 * alex86 2018-08-26T21:49:37Z
		 * bobbrown 2018-08-27T03:19:13Z
		 * amanda 2018-08-27T08:11:00Z
		 * jeniffer3 2018-08-27T09:19:24Z
		 * alex86 2018-08-27T22:39:52Z
		 * amanda 2018-08-28T07:42:19Z
		 */
		
		String path = "C:\\Users\\BENDER-Desktop\\Dropbox\\JAVA_Curso_Ago_2019\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			/*
			 * A escolha do 'HashSet', ao inv�s de 'TreeSet' ou 'LinkedHashSet', � porque ele � mais r�pido
			 * e, para a solu��o deste problema, a 'ordena��o' do conjunto n�o � relevante.
			 */
			Set<EntradaDeLog> conjunto = new HashSet<>();
			String linha = br.readLine();
			while (linha != null) {
				//Recorte do String e aloca��o de 'usu�rio' e 'data/hora'.
				String[] campos = linha.split(" ");
				String nomeDoUsuario = campos[0];
				Date momento = Date.from(Instant.parse(campos[1]));
				//Fazendo a entrada dos dados no conjunto(set), instanciando a Classe 'EntradaDeLog'
				conjunto.add(new EntradaDeLog(nomeDoUsuario, momento));
				//Nota: a pr�pria estrutura de dados 'Set' vai 'barrar' qualquer duplicidade de entrada.
				linha = br.readLine();
			}
			System.out.println("Total de usu�rios: " + conjunto.size()); //'size' retorna o tamanho do conjunto(set).
		} catch  (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
