public class Potential
{
    private String[] hooxes;
    private String name;
    
    public Potential(String name, String[] hooxes)
    {
        this.name=name;
        this.hooxes=hooxes;
    }
    
    public boolean isSibsWith(Potential other)
    {
        for (int b=0; b< this.hooxes.length; b++)
        {
            for (int c=0; c< other.hooxes.length; c++)
            {
                if (this.hooxes[b].equals(other.hooxes[c]))
                    return true;
            }
        }
        return false;
    }
    
    public String[] isSibsWithVia(Potential other)
    {
        String[] shareds=new String[this.numVias(other)];
        int countI=0;
        for (int b=0; b< this.hooxes.length; b++)
        {
            for (int c=0; c< other.hooxes.length; c++)
            {
                if (this.hooxes[b].equals(other.hooxes[c]))
                {    
                    shareds[countI]= this.hooxes[b]; 
                    countI++;
                }
            }
        }
        return shareds;
    }
    
    public int numVias(Potential other)
    {
        int jump=0;
        for (int b=0; b< this.hooxes.length; b++)
        {
            for (int c=0; c< other.hooxes.length; c++)
            {
                if (this.hooxes[b].equals(other.hooxes[c]))
                    jump++;     
            }
        }
        return jump;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String[] getHooxes()
    {
        return this.hooxes;
    }
}