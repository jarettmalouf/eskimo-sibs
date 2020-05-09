import java.util.*;
import java.lang.String;

public class EskimoSibRunner
{
    public static void main (String[] args)
    {
        //SCANNER
        Scanner kb=new Scanner(System.in);
        
        //GETTING AN ARRAY OF STRINGS (HOOXES)
        System.out.println("--ESKIMO SIBLINGS--");
        System.out.println("\tDefinition: a person who has hooked up");
        System.out.println("\twith at least one of the same people as you\n");
        System.out.println("*Do not repeat names or enter your own\n");
        System.out.println("*If you do not know of someone's affairs, or");
        System.out.println("their affairs are nonexistent, type a '?'\n");
        System.out.println("Who have you hooked up with? (place just comma between names):");
        String commaHU=kb.next();
        String abridge=commaHU;
        String abridge2=commaHU;
        int countCommas=0;
        while (abridge.indexOf(",")>=0)
        {
            abridge=abridge.substring(abridge.indexOf(",")+1);
            countCommas++;
        }
        int numHooxes=countCommas+1;
        String[] hooxes=new String[numHooxes];
        for (int x=0; x<numHooxes; x++)
        {
            if (abridge2.indexOf(",")>=1)
            {
                hooxes[x]=abridge2.substring(0,abridge2.indexOf(","));
                abridge2=abridge2.substring((abridge2.indexOf(","))+1);
            }
            else
            {
                hooxes[x]=abridge2;
                abridge2="";
            }
        }
        
        //GETTING AN ARRAY OF ESKIMO SIBLINGS
        
        String theirHooxesComma="";
        for (int i=0; i<numHooxes; i++)
        {
            System.out.println("\nWho has "+hooxes[i]+" hooxed? (place comma and space between names):");
            String after=kb.next();
            if (!after.equals("?"))
                theirHooxesComma+=after;
            if (i!=(numHooxes-1) && !after.equals("?"))
                theirHooxesComma+=",";
        }
        
        int numTheseCommas=0;
        String abridge3=theirHooxesComma;
        String abridge4=theirHooxesComma;
        while (abridge3.indexOf(",")>=0)
        {
            abridge3=abridge3.substring(abridge3.indexOf(",")+1);
            numTheseCommas++;
        }
        
        int numSiblings=numTheseCommas+1;
        String[] siblings=new String[numSiblings];
        for (int y=0; y<numSiblings; y++)
        {
            if (abridge4.indexOf(",")>0)
            {
                siblings[y]=abridge4.substring(0,abridge4.indexOf(","));
                abridge4=abridge4.substring((abridge4.indexOf(","))+1);
            }
            else
            {
                siblings[y]=abridge4;
                abridge4="";
            }
        }
        
        String tempGender;
        EskimoSib[] allSibs=new EskimoSib[numSiblings];
        for (int z=0; z<siblings.length; z++)
        {
            System.out.print("\nWhat is "+siblings[z]+"'s gender? (m/f): ");
            tempGender=kb.next();
            allSibs[z] =new EskimoSib(siblings[z], tempGender);
        }
        
        System.out.println("\nCongratulations! You have "+allSibs.length+" (known) Eskimo siblings!");
        int numEskimoBros=0;
        for (EskimoSib eskA: allSibs)
        {
            if (eskA.getGender().equalsIgnoreCase("m"))
                numEskimoBros++;
        }
        System.out.println("\n"+numEskimoBros+" ESKIMO BROTHERS:");
        String eskimoBros="", eskimoSisses="";
        for (EskimoSib esk: allSibs)
        {
            if (esk.getGender().equalsIgnoreCase("m"))
            {
                eskimoBros+=esk.getName();
                eskimoBros+="\n";
            }
        }
        int numEskimoSisses=0;
        for (EskimoSib eskB: allSibs)
        {
            if (eskB.getGender().equalsIgnoreCase("f"))
                numEskimoSisses++;
        }
        System.out.println(eskimoBros+"\n"+(numEskimoSisses)+" ESKIMO SISTERS: ");
        for (EskimoSib esks: allSibs)
        {
            if (esks.getGender().equalsIgnoreCase("f"))
            {
                eskimoSisses+=esks.getName();
                eskimoSisses+="\n";
            }
        }
        System.out.println(eskimoSisses);
    }
}
            