
public class TrisLib {
    private Main main;
	public TrisLib(Main main) {
		this.main=main;
	}
	
	public static void azzera_tabella(int dim, int square[][]) {
		int i;
		int j;
		for (j=0; j<dim;j++) {
			for (i=0;i<dim;i++) {
				square[j][i]=0;
			}
		}
	}
	
	public static int cercavuota(int dim, int square[][], int usr) {
		int i;
		int j;
		for (j=0;j<dim;j++) {
			for (i=0; i<dim; i++) {
				if(square[j][i]==0) {
					square[j][i]=usr;
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static int check(int dim, int square[][]) {
		int i,j;
		int tot=0;
		int player1=0;
		int player2=0;
		int nulle=0;
		
		for (j=0;j<dim;j++) {//righe
			tot=0;
			for(i=1;i<dim;i++) {
				if (square [j][i] == square [j][0] && square [j][0] != 0)
					tot ++;
				if (square [j][i] == 0)
					nulle++;
			}
			if (tot == dim - 1)
			{
			if (square [j][0] == 1)
				player1 ++;
			if (square [j][0] == 2)
				player2 ++;
			if (square [j][0] != 1 && square [j][0] != 2)
				System.out.println("error 1");
			}
		}
		for (i=0;i<dim;i++) { //colonne
			tot = 0;
			for (j = 1; j < dim; j++)
				if (square [j][i] == square [0][i] && square [0][i] != 0)
					tot ++;
			if (tot == dim - 1)
				{
				if (square [0][i] == 1)
					player1 ++;
				if (square [0][i] == 2)
					player2 ++;
				if (square [0][i] != 1 && square [0][i] != 2)
					System.out.println("error 2");
				}
		}
		tot = 0; //diag1
		for (j = 1; j < dim; j++)
				if (square [j][j] == square [0][0] && square [0][0] != 0)
					tot ++;
			if (tot == dim - 1)
				{
				if (square [0][0] == 1)
					player1 ++;
				if (square [0][0] == 2)
					player2 ++;
				if (square [0][0] != 1 && square [0][0] != 2)
					System.out.println("error 3");
				}
			tot = 0; //diag2
			for (j = 1; j < dim; j++)
					if (square [j][dim - 1 - j] == square [0][dim - 1] && square [0][dim - 1] != 0)
						tot ++;
				if (tot == dim - 1)
					{
					if (square [0][dim -1] == 1)
						player1 ++;
					if (square [0][dim -1] == 2)
						player2 ++;
					if (square [0][dim -1] != 1 && square [0][dim - 1] != 2)
						System.out.println("error 4");
					}
			if (player1 == 0 && player2 == 0)
				return 0;
			if (player1 == 0)
				return 2;
			if (player2 == 0)
				return 1;
			if (nulle == 0)
				return -2; //gioco finito pari
			return -1;
				
	}
	
	public static void stampa_tabella(int dim, int square[][]) {
		int i;
		int j; 
		int error=0;
		System.out.print("+");
		for (i=1;i<dim;i++) {
			System.out.print("----");
		}
		System.out.println("---+");
		for (j=0;j<dim;j++) {
			for (i=0;i<dim;i++) {
				System.out.print("¦ ");
				if (square[j][i]==1) {
					System.out.print("X");
				}
				else 
				{
				if (square [j][i] == 2)
					System.out.print("O");
				else 
					if (square [j][i] != 0)
						{
						System.out.print("-");
						error ++;
						}
					else 
						System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println("¦");
			
			if (j!=dim-1) {
				System.out.print("¦");
				for (i=1;i<dim;i++) {
					System.out.print("---+");
				}
				System.out.println("---¦");
			}
			else {
				System.out.print("+");
				for(i=1;i<dim;i++) {
					System.out.print("----");
				}
				System.out.println("---+");
			}
		}
		}
	public static int cercapericolo(int dim, int square[][], int usr) {
		int nv, me, ro_v = 0,co_v=0;
		int i;
		int j;
		for (j = 0; j < dim; j++)	
		{
			nv = 0;	//numero delle cella vuote
			me = 0; //numerod delle di user
			ro_v = 0; //riga in cui c'è la cella vuota (una)
			co_v = 0; //colonna in cui c'è la cella vuota
			
			for (i = 0; i < dim; i++)
			{
			if (square [j][i] == 0)
				{
				ro_v = j;
				co_v = i;
				nv++;
				}
			if (square [j][i] == usr)
				{
				me++;
				}
			}
			if (me==0 && nv==1) {
				square[ro_v][co_v]=usr;
				return 1;
			}
		}
		for (j = 0; j < dim; j++)	
		{
		nv = 0;	//numero delle cella vuote
		me = 0; //numerod delle di user
		ro_v = 0; //riga in cui c'è la cella vuota (una)
		co_v = 0; //colonna in cui c'è la cella vuota

		for (i = 0; i < dim; i++)
			{
			if (square [i][j] == 0)
				{
				ro_v = i;
				co_v = j;
				nv++;
				}
			if (square [i][j] == usr)
				{
				me++;
				}
			}
		if (me==0&&nv==1) {
			square[ro_v][co_v]=usr;
			return 1;
		}
		}
		nv = 0;me=0;
		for (i = 0; i < dim; i++)
			{
			if (square [i][i] == 0)
				{
				ro_v = i;
				co_v = i;
				nv++;
				}
			if (square [i][i] == usr) 
				{
				me++;
				}	
			}	
		if (me == 0 && nv == 1)
			{
			square [ro_v][co_v] = usr;
			return 1;
			}
		
		nv = 0;me=0;
		for (i = 0; i < dim; i++)
			{
			if (square [i][dim -i -1] == 0)
				{
				co_v = dim -i -1;
				ro_v = i;
				nv++;
				}
			if (square [i][dim -i -1] == usr)
				{
				me++;
				}	
			}	

		if (me == 0 && nv == 1)
			{
			square [ro_v][co_v] = usr;
			return 1;
			}

	return cercavuota (dim, square, usr);	
	}
}
	
