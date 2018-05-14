import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter
{

    private String fullStory = "\\Users\\Bruger\\Downloads\\AliceInWonderland.txt";

    public void totalWords() throws FileNotFoundException
    {
        File file = new File(fullStory);

        try(Scanner scanner = new Scanner(new FileInputStream(file)))
        {

            int count = 0;

            while(scanner.hasNext())
            {
                scanner.next();
                count++;
            }
            System.out.println(count);
        }
    }

    private ArrayList addWordsToArray() throws FileNotFoundException
    {

        Scanner scanner = new Scanner(new File(fullStory)).useDelimiter("\\s+");

        ArrayList<String> wordsArray = new ArrayList<>();

        while (scanner.hasNext())
        {
            String word = scanner.next();
            word = word.replaceAll("[^\\p{L}\\p{Nd}]+","");
            word = word.toLowerCase();

            wordsArray.add(word);
        }
        scanner.close();

        return wordsArray;
    }

    public void countSpecificWordTreeSet() throws Exception
    {
        List<String> words = addWordsToArray();

        List<Word> objectArrayList = new ArrayList<>();

        Collections.sort(words);

        TreeSet<String> uniqueWords = new TreeSet<>(words);

        for (String key : uniqueWords)
        {
            int frequency = Collections.frequency(words, key);

            Word word = new Word(key, frequency);
            objectArrayList.add(word);
        }


        Collections.sort(objectArrayList, new Comparator<Word>()
        {
            @Override
            public int compare(Word word1, Word word2)
            {
                if (word1.getValue() > word2.getValue())
                {
                    return 1;
                }
                if (word1.getValue() == word2.getValue())
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        });


        Collections.reverse(objectArrayList); // Her kalder jeg metoden "reverse()". Den gør at arraylisten går fra højt til lavt og ikke omvendt.

        System.out.println(objectArrayList); // Her printer jeg arraylisten med objekterne ud der har et key-field og et value-field
    }
}