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
                //Added RWayTrieMap
                RWayTrieMap<Integer> rWayTrieMap = new RWayTrieMap<>();


                List<String> words = wordsToList("src/test/resources/books/quijoteClean.txt", j);
                List<String> reversed = wordsToList("src/test/resources/books/quijoteReversed.txt", j);
                fillMap(arrayMap, words);
                fillMap(randomizedTreeMap, words);
                fillMap(rWayTrieMap,words);

                //Testing the speed of the algorithms and counting the misses. Misses should match in both ArrayMap and RandomizedTreeMap
                long timer;
                long start;
                long end;
                int misses;
                ArrayList<Map<String,Integer>> maps = new ArrayList<>(); //Cleaner syntax to avoid repeated code
                maps.add(arrayMap);
                maps.add(randomizedTreeMap);
                maps.add(rWayTrieMap);

                String[] types = new String[] {"ArrayMap","RandomizedTreeMap","RWayTrieMap"};

                int counter = 0;
                for (Map<String,Integer> map : maps) {
                    timer = 0;
                    misses = 0;
                    for (String s : reversed) {
                        start = System.nanoTime();
                        if (map.get(s) == null) misses++;
                        end = System.nanoTime();

                        timer += (end - start);
                    }
                    writer.writeForQuijote("./QuijoteTimers",types[counter],j, timer, misses);
                    counter++;

                }
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
