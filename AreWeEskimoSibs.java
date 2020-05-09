import java.util.*;

public class AreWeEskimoSibs
{
    public static void main(String[] args)
    {
        //SCANNER
        Scanner kb=new Scanner(System.in);
            
        //DEFINITION
        System.out.println("--ESKIMO SIBLINGS--");
        System.out.println("\tDefinition: a person who has hooked up");
        System.out.println("\twith at least one of the same people as you\n");
        
        
        System.out.print("How many people would you like to compare? ");
        int numPotentials=kb.nextInt();
        System.out.println();
        Potential[] potentials=new Potential[numPotentials];
        int numNopes=0;
        
        for (int n=0; n<numPotentials;n++)
        {
            System.out.print("Name of potential Eskimo family member: ");
            String tempName=kb.next();
            System.out.println("Who has "+tempName+ " hooxed? (place comma between names):");
            String tempHooxesComma=kb.next();
            String abridge5=tempHooxesComma;
            String abridge6=tempHooxesComma;
            int countTheCommas=0;
            while (abridge5.indexOf(",")>=0)
            {
                abridge5=abridge5.substring(abridge5.indexOf(",")+1);
                countTheCommas++;
            }
            int numOfHooxes=countTheCommas+1;
            String[] tempHooxes=new String[numOfHooxes];
            for (int p=0; p<numOfHooxes; p++)
            {
                if (abridge6.indexOf(",")>=1)
                {
                    tempHooxes[p]=abridge6.substring(0,abridge6.indexOf(","));
                    abridge6=abridge6.substring((abridge6.indexOf(","))+1);
                }
                else
                {
                    tempHooxes[p]=abridge6;
                    abridge6="";
                }
            }
            potentials[n]=new Potential(tempName, tempHooxes);
            System.out.println();
        }
        
        for (int k=0; k<potentials.length;k++)
        {
            for (int q=(k+1); q<potentials.length; q++)
            {
                if (potentials[k].isSibsWith(potentials[q]))
                {                
                    System.out.print(potentials[k].getName()+" is Eskimo Brothers with "+potentials[q].getName() +" (via ");
                    for (int f=0; f<(potentials[k].isSibsWithVia(potentials[q])).length; f++)
                    {
                        System.out.print((potentials[k].isSibsWithVia(potentials[q])[f]));
                        if (f!=(potentials[k].isSibsWithVia(potentials[q])).length - 1)
                            System.out.print (" & ");
                    }
                    System.out.println(")");
                }
                else
                {
                    numNopes++;
                    if (numNopes==(((potentials.length)*(potentials.length-1))/2))
                        System.out.print("There are no Eskimo siblings above! :(");   
                }
            }
            
        }
        
    }
}
    