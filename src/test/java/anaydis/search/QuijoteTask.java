package anaydis.search;

import anaydis.sort.CsvWriter;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuijoteTask {
    //Cleaned book in: https://textcleaner.net/
    //Reversed book in : https://www.textreverse.com/


    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.naturalOrder();

        int[] nSize = new int[]{5000, 50000, 100000, 150000, 200000};

        try{
            CsvWriter writer = new CsvWriter();
            writer.writeHeaders("./QuijoteTimers","Type,size,time,misses\n");
            for (int j : nSize) {
                Map<String, Integer> arrayMap = new ArrayMap<>(comparator);
                Map<String, Integer> randomizedTreeMap = new ArrayMap<>(comparator);

                List<String> words = wordsToList("src/test/resources/books/quijoteClean.txt", j);
                List<String> reversed = wordsToList("src/test/resources/books/quijoteReversed.txt", j);
                fillMap(arrayMap, words);
                fillMap(randomizedTreeMap, words);


                //Testing the speed of the algorithms

                long arrayMapTimer = 0;
                long randomizedTimer = 0;
                long start;
                long end;
                int missesArrayMap = 0;
                int missesRandomized = 0;

                for (String s : reversed) {
                    start = System.nanoTime();
                    if (arrayMap.get(s) == null) missesArrayMap++;
                    end = System.nanoTime();

                    arrayMapTimer += (end - start);

                    start = System.nanoTime();
                    if (randomizedTreeMap.get(s) == null) missesRandomized++;
                    end = System.nanoTime();
                    randomizedTimer = (end - start);
                }
                writer.writeForQuijote("./QuijoteTimers", "ArrayMap", j, arrayMapTimer, missesArrayMap);
                writer.writeForQuijote("./QuijoteTimers", "RandomizedTreeMap", j, randomizedTimer, missesRandomized);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillMap(Map<String,Integer> map, List<String> list){

        for (final String word: list) {
            @Nullable final Integer occurrences = map.get(word);
            map.put(word,occurrences == null ? 1: occurrences + 1);
        }
    }
    public static List<String> wordsToList(String path, int amount) throws IOException {

        BufferedReader bfReader = new BufferedReader(new FileReader(path));
        String line;
        List<String> wordsList = new ArrayList<>();
        int counter = 0;
        while ((line = bfReader.readLine()) != null && counter <= amount){
            String[] words = line.split(" ");
            for(int i = 0; i< words.length && counter <= amount ; i++){
                wordsList.add(words[i]);
                counter++;
            }
        }
        return wordsList;
    }
}
