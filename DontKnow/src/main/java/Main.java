public class Main
{

    public static void main(String[] args) throws Exception
    {

        CharCounter charCounter = new CharCounter();
        WordCounter wordCounter = new WordCounter();


        System.out.print("Number of characters the URL text contains: ");
        System.out.print(charCounter.countChars(charCounter.urlReader()));
        System.out.println();
        System.out.println();


        System.out.print("Number of characters Alice in Wonderland contains: ");
        System.out.print(charCounter.countChars(charCounter.getFullStory()));
        System.out.println();
        System.out.println();

        System.out.print("Number of words the story contains: ");
        wordCounter.totalWords();
        System.out.println();

        System.out.println("Characters and their number of occurances");
        charCounter.specificCharCounter();
        System.out.println();
        System.out.println();

        System.out.println("Words and their number of occurances");
        wordCounter.countSpecificWordTreeSet();
    }
}
