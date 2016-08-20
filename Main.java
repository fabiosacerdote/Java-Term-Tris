import java.util.Scanner;
public class Main {
	TrisLib lib=new TrisLib(this);
	int MAX=3;
	static int x;
	static int y;
	static int dimensione;
	static int second_input;
	static int player;
	static int pcresult;
	static int first_input;
	static int[][] square=new int[3][3];
	int gamemode_singleplayer=0;
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
	System.out.println("+----------------------------+");
	System.out.println("¦ --    GIOCO DEL TRIS    -- ¦");
	System.out.println("¦----------------------------¦");
	System.out.println("¦ 0)  Giocatore vs. PC       ¦");
	System.out.println("¦ 1)  Due giocatori          ¦");
	System.out.println("+----------------------------+");
	System.out.println("");
	System.out.println("Scegli -> ");
	first_input=sc.nextInt();
	if (first_input==0)
		vsPc();
	else if (first_input==1)
		twoPlayers();
}
    
    public static void vsPc() {
    	
    	System.out.println("+----------------------------+");
    	System.out.println("¦ --     PLAYER vs. PC    -- ¦");
    	System.out.println("¦----------------------------¦");
    	System.out.println("¦ 0)  N00B                   ¦");
    	System.out.println("¦ 1)  ESPERTO                ¦");;
    	System.out.println("+----------------------------+");
    	System.out.println("");
    	System.out.println("Scegli -> ");
    	second_input=sc.nextInt();
    	
    	if (second_input==0) {
    		dimensione=3;
        	player=1;
        	TrisLib.azzera_tabella(3, square);
        	while(TrisLib.check(dimensione,square)==0) {
        		TrisLib.stampa_tabella(dimensione,square);
        		do {
        			System.out.println("PLAYER [X]");
        			System.out.print("Riga -> ");
        			x=sc.nextInt();
        			System.out.print("Colonna -> ");
        			y=sc.nextInt();
        			if (x < 0 || y < 0 || x > dimensione - 1 || y > dimensione - 1)
					{
				    System.out.println("immetti di nuovo");
					continue;
					}
        		}while (square [x][y] != 0);
        		square [x][y] = player;
				pcresult = TrisLib.cercavuota (3 , square, 2);
				if (pcresult < 0)
				{
					System.out.println("errore in pcresult");
					break;
				}
        	}
        	TrisLib.stampa_tabella (dimensione, square);
			if (TrisLib.check (dimensione,square) < 0)
				System.out.println("patta");
			if (TrisLib.check (dimensione,square) == 1)
				System.out.println("complimenti, HAI VINTO!");
			if (TrisLib.check (dimensione,square) == 2)
				System.out.println("il computer ha vinto! ");
    	}
    	if (second_input==1) {
    		dimensione=3;
        	player=1;
        	TrisLib.azzera_tabella(3, square);
        	while(TrisLib.check(dimensione,square)==0) {
        		TrisLib.stampa_tabella(dimensione,square);
        		do {
        			System.out.println("PLAYER [X]");
        			System.out.print("Riga -> ");
        			x=sc.nextInt();
        			System.out.print("Colonna -> ");
        			y=sc.nextInt();
        			if (x < 0 || y < 0 || x > dimensione - 1 || y > dimensione - 1)
					{
				    System.out.println("immetti di nuovo");
					continue;
					}
    	}while (square [x][y] != 0);
        		square [x][y] = player;
        		pcresult = TrisLib.cercapericolo (3, square,2);
				if (pcresult < 0)
				{
					System.out.println("errore in pcresult");
					break;
				}
    }
        	TrisLib.stampa_tabella (dimensione, square);
			if (TrisLib.check (dimensione,square) < 0)
				System.out.println("patta");
			if (TrisLib.check (dimensione,square) == 1)
				System.out.println("complimenti, HAI VINTO!");
			if (TrisLib.check (dimensione,square) == 2)
				System.out.println("il computer ha vinto! ");
    	}
    }
    public static void twoPlayers() {
    	dimensione = 3;
		player = 1;
		TrisLib.azzera_tabella (3, square);
		while (TrisLib.check (dimensione,square) == 0)
			{
			TrisLib.stampa_tabella (dimensione, square);
			do 
				{
				System.out.println("player  " +player);
				System.out.print("riga-> ");
				x=sc.nextInt();
				System.out.print("colonna-> ");
				y=sc.nextInt();
					if (x < 0 || y < 0 || x > dimensione - 1 || y > dimensione - 1)
						{
					    System.out.println("immetti di nuovo");
						continue;
						}
				}while (square [x][y] != 0);
				square [x][y] = player;
				if (player == 1)
					player = 2;
				else player = 1;
				}
				TrisLib.stampa_tabella (dimensione, square);
				if (TrisLib.check (dimensione,square) < 0)
					System.out.println("patta");
				if (TrisLib.check (dimensione,square) == 1)
					System.out.println("player "+ player + " HAI VINTO!");
				if (TrisLib.check (dimensione,square) == 2)
					System.out.println("player "+ player + " HAI VINTO!");
			}
    }


