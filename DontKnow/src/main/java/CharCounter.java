import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class CharCounter
{


    // OPRETTER ET GLOBALT CHAR-ARRAY OG INDSÆTTER HELE ALFABETET
    private char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n' , 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    //Bruger her JSoup
    public String urlReader() throws IOException
    {

        //URL url = new URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt");
        URL url = new URL("http://classics.mit.edu/Homer/odyssey.mb.txt");

        Document doc = Jsoup.parse(url, 0);

        String text = doc.body().text();

        String textLowerCase = text.toLowerCase();

        return textLowerCase;
    }

    // METODE DER TAGER TXT. FILEN OG PUTTER DEN IND I EN STRING VARIABLE OG KONVETERER DEREFTER HELE STRINGEN TIL LOWERCASE BOGSTAVER
    public String getFullStory() throws FileNotFoundException
    {

        String fullStory = new Scanner(new File("\\Users\\Bruger\\Downloads\\AliceInWonderland.txt")).useDelimiter("\\Z").next();
        String fullStoryLowerCase = fullStory.toLowerCase();

        return fullStoryLowerCase;
    }


    public double specificCharCounter() throws IOException
    {
        String fullStoryLowerCase = getFullStory();
        double count = 0;

        for (int j = 0; j < charArray.length; j++)
        {
            count = 0;

            for (int i = 0; i < fullStoryLowerCase.length(); i++)
            {
                if (fullStoryLowerCase.charAt(i) == charArray[j])
                {
                    count++;
                }
            }
            System.out.println(charArray[j] + " " + (int) count + "        Percentage: " + charPercentage (count));
            count += count;
        }

        return count;
    }

    public double countChars(String text) throws IOException
    {

        String fullStoryLowerCase = text;
        double count = 0;

        for (int i = 0; i < charArray.length; i++)
        {
            for (int j = 0; j < fullStoryLowerCase.length(); j++)
            {
                if(fullStoryLowerCase.charAt(j) == charArray[i])
                {
                    count++;
                }
            }
        }
        return count;
    }

    private double charPercentage(double count) throws IOException
    {
        double storyLength = countChars(getFullStory());
        double result;

        result = (count / storyLength);
        result = result * 100;

        return result;
    }
}