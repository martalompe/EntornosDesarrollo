
package  primas_marta;

import java.util.Scanner;

/**<h2>PROBLEMA DE CALCULO DE LA PRIMA</h2>
* <h3>Se calcula la prima que corresponde a un empleado seg�n una serie de par�metros<br/>
* Estos par�metros se introducir�n por teclado previa petici�n</h3>
* @author Marta Lombardero
* @version v1.2022
*/
public class PrimaMainMetodos {
		
	/**Variable est�tica para la entrada de datos por teclado*/
	public static Scanner  teclado=new Scanner(System.in);
	

/** M�todo que solicita datos de entrada de los trabajadores
 * @param args Solicita introducir n�mero del empleado, nombre del empleado, meses de trabajo y si es directivo o no.
 */
  
	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;
		

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			
			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');		
	}

/**M�todo que halla el tipo de prima
 * @param esDirectivo Car�cter que indica si lo es o no
 * @param meses Entero que almacena el n�mero de meses de antiguedad del empleado
 * @return <ul>
 * <li>P1 si es directivo y tiene al menos una antig�edad mayor o igual de 12 meses </li>
 * <li>P2 si es directivo y tiene una antig�edad menor de 12 meses </li>
 * <li>P3 si no es directivo y tiene al menos una antig�edad mayor o igual de 12 meses </li>
 * <li>P4 si no es directivo y tiene una antig�edad menor de 12 meses </li>
  </ul>*/
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

/**M�todo que lee el n�mero del empleado
 *@return Un entero con el n�mero del empleado
 */
	
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}

/**M�todo que lee el nombre del empleado
 *@return Una cadena con el nombre del empleado
 */
	
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}


/**M�todo que lee la antig�edad del empleado
 *@return Un entero con el n�mero de meses de antiguedad del empleado
 */

	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	

/**M�todo que lee por teclado si el empleado es directivo o no
 *@return <ul>
 *<li>+ si es directivo</li>
 *<li>- si no es directivo</li>
 </ul>
 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}
