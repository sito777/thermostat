/**
 * 
 */
package thermostaat;
import java.util.ArrayList;
import java.util.Scanner; //scanner wordt geimporteerd

/**
 * @author Darnell
 *
 */
public class thermodrive
{

    /**
     * @param args
     */
    static ArrayList<String> snap = new ArrayList <String>();//array voor de geschiedenis
    static thermo thermostaat = new thermo(); // thermostaat volgens de fabrieksinstellingen
    static Scanner in = new Scanner(System.in); // scanner
    
    public static void main(String[] args)
    {
	// TODO Auto-generated method stub
	boolean x = false;// boolean staat op false
	System.out.println("Wilt u uw themostaat aanzetten?" 
		+ "\n1. Ja" 
		+ "\n2. nee\t");
	int aan_uit = in.nextInt();
	if (aan_uit == 1)
	{// als je de thermostaat aan zet beland je hier
	    x = true;
	    thermostaat.setOperational(true);// de thermostaat is aan (true)	    
	    System.out.println("\nMet welke stappen wil je De temperatuur veranderen? \n1. 1 hele graad \n2. 0,5");
	    int stappen = in.nextInt();
	    if (stappen == 1)
	    {
		thermostaat.setStepSize(1); // stap grote wordt toegevoegd
	    }
	    else if (stappen == 2)
	    {
		thermostaat.setStepSize(0.5);// stap grote wordt toegevoegd
	    }
	    System.out.println("Wat uw is maximale gewenste temperatuur?");
	    int maxtemp = in.nextInt();
	    thermostaat.setMaxTemp(maxtemp);// maximale temperatur wordt toegevoegd
	    System.out.println("Wat uw is minimale gewenste temperatuur?");
	    int mintemp = in.nextInt();
	    thermostaat.setMinTemp(mintemp);// maximale temperatur wordt toegevoegd
	    System.out.println("U heeft zojuist de basis instellingen geïnstalleerd. Uw thermostaat is klaar voor gebruik!");	    
	}
	else if(aan_uit == 2) 
	{
	    x = false;
	    System.out.println("Thermostaat staat uit!");
	}
	else
	{
	    System.out.println("Onjuiste waarde ingevoerd");
	}
	while (x) //Na je basis instellingen beland je in de hoodfd menu en daar blijf je totdat je de thermostaat uitzet
	{	
    		    System.out.println("\nHOOFDMENU\n"
    		    	+ "Het is nu " + thermostaat.getCurTemp()+ " °C." //huidige temp wordt weergeven
    		    	+ "\nWelkom wat wilt u doen?"
		    		+ "\n1. Alle waardes bekijken"
		    		+ "\n2. Temperatuur instellingen"
    		    		+ "\n3. Dag/avond programma inplannen"
    		    		+ "\n4. Snapshot menu"
    		    		+ "\n5. Thermometer naar fabrieksinstellingen resetten"
    		    		+ "\n6. Therometer uitzetten");	
    		    try
    		    {
    			int keuzeHoofdmenu = in.nextInt();    //variable voor de input van de hoofdmenu
    	    		switch(keuzeHoofdmenu)//op basis van de input word je naar een case gestuurd. Als je klaar bent in de case begint de while loop weer opnieuw
    	    		{
    	        		case 1:
    	        		    System.out.println(thermostaat);
    	        		    break;
    	        		case 2: // alle instellingen opnieuw opvragen  
    	        		    System.out.println("\nWat is je huidige temp?");
    	        		    double verandertemp = in.nextInt();
    	        		    thermostaat.setCurTemp(verandertemp = clamp(verandertemp, thermostaat.getMinTemp(), thermostaat.getMaxTemp()));// de corrigeert input als de input buiten de min of max valt
    	        		    System.out.println("\nMet welke stappen wil je temperatuur veranderen? \n1. 1 hele graad \n2. 0,5");
    	        		    int stappen = in.nextInt();
    	        		    if (stappen == 1)
    	        		    {
    	        			thermostaat.setStepSize(1); // stap grote wordt toegevoegd
    	        		    }
    	        		    else if (stappen == 2)
    	        		    {
    	        			thermostaat.setStepSize(0.5);// stap grote wordt toegevoegd
    	        		    }
    	        		    
    	        		    System.out.println("\nWat uw is maximale gewenste temperatuur?");
    	        		    int maxtemp = in.nextInt();
    	        		    thermostaat.setMaxTemp(maxtemp);// maximale temperatur wordt toegevoegd
    	        		    System.out.println("\nWat uw is minimale gewenste temperatuur?");
    	        		    int mintemp = in.nextInt();
    	        		    thermostaat.setMinTemp(mintemp);// maximale temperatur wordt toegevoegd
    	        		    System.out.println("\nWilt u de dag of avond programma instellen?"
    	            		    	+ "\n1. Dag"
    	            		    	+ "\n2. Avond"
    	            		    	+ "\n3. Ik wil geen programma");
    	        		    int programma = in.nextInt(); 
    	        		    if (programma == 1)
    	        		    {
    	        			System.out.println("\nWat is uw gewenste dag temperatuur?");
    	        			int dag = in.nextInt();
    	        			thermostaat.setDayTemp(dag);
    	        			thermostaat.setProgActive(true);
    	        		    }
    	        		    else if (programma == 2)
    	        		    {
    	        			System.out.println("\nWat is uw gewenste avond temperatuur?");
    	        			int avond = in.nextInt();
    	        			thermostaat.setNightTemp(avond);
    	        			thermostaat.setProgActive(true);
    	        		    }
    	        		    else if (programma == 3)
    	        		    {
    	        			thermostaat.setProgActive(false);
    	        		    }
    	        		    else
    	        		    {
    	        			System.out.println("Onjuiste waarde ingevoerd");
    	        		    }
    	        		    break;
    	        		case 3: //dag programma menu
    	        		    System.out.println("\nWilt u de dag of avond programma instellen?"
    	        		    	+ "\n1. Dag"
    	        		    	+ "\n2. Avond");
    	        		    int daprog = in.nextInt();
    	        		    if (daprog == 1)
    	        		    {
    	        			System.out.println("\nWat is uw gewenste dag temperatuur?");
    	        			int dag = in.nextInt();
    	        			thermostaat.setDayTemp(dag);
    	        		    }
    	        		    else if (daprog == 2)
    	        		    {
    	        			System.out.println("\nWat is uw gewenste avond temperatuur?");
    	        			int avond = in.nextInt();
    	        			thermostaat.setNightTemp(avond);
    	        		    }
    	        		    else
    	        		    {
    	        			System.out.println("Onjuiste waarde ingevoerd");
    	        		    }
    	        		    thermostaat.setProgActive(true);
    	        		    break;
    	        		case 4: // geschiedenis aka snapschot
    	        		    System.out.println("\nwil je een snapshot maken of inzien? \n1. Snapshot inzien \n2. Snapshot maken");
    	        		    int snapie = in.nextInt();
    	        		    if (snapie == 1)
    	        		    {
    	        			snapZien();
    	        		    }
    	        		    if (snapie == 2)
    	        		    {
    	        			snapMaken();
    	        		    }
    	        		    break;
    	        		case 5: // alles wordt gereset
    	        		    thermostaat.setProgActive(false);
    	        		    thermostaat.setMinTemp(0);
    	        		    thermostaat.setMaxTemp(0);
    	        		    thermostaat.setCurTemp(0);
    	        		    thermostaat.setStepSize(0);
    	        		    thermostaat.setNightTemp(0);
    	        		    thermostaat.setDayTemp(0);
    	        		    System.out.println("Uw thermostaat is succesvol gereset");
    	        		    break;
    	        		case 6:
    	              		    x = false;
    	        		    System.out.println("Thermostaat staat uit!");
    	        		    break;
    	    		}
    		    } catch(Exception e)
    		    {
    			in.next();
    			System.out.println("Onjuiste waarde ingevoerd");
    		    }
    		
	}
    }
    
    public static void snapZien()
    {
	for (int i = 0; i < snap.size(); i++) //zolang i kleiner is dan de array indexes blijf loopen
	{
	    System.out.println(snap.get(i));	// print index uit    
	}
    }
    
    public static void snapMaken()
    {
	if (snap.size()!= 10)//waneer  array niet gelijk is aan 10
	{
	    snap.add(thermostaat.toString()); //voeg data toe aan array
	    return; //verlaat de functie
	}
	
	if (snap.size() == 10)
	{
	    snap.remove(0);// verwijder de eerste index zodra de array vol is
	    snap.add(thermostaat.toString());
	    return; //verlaat de functie
	}
    }
    
    public static double clamp(double var, double min, double max)
    {
	if (var >= max)
	{
	    return var = max;
	}
	
	if (var <= min)
	{
	    return var = min;
	}
	
	return var;
    }    
    
}
