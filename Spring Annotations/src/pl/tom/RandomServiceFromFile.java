package pl.tom;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
@Component
public class RandomServiceFromFile implements FortuneService {

   String[] getFile() throws FileNotFoundException {
       Scanner scanner = new Scanner(new File("1.txt"));
       String[] randoms = null;
       while (scanner.hasNext()) {
           randoms = scanner.nextLine().split(" ");
       }
       return randoms;
   }
       String randomSentence (String[] array){
           Random random = new Random();
           String randomtext= array[random.nextInt(array.length)];


return randomtext;
       }


       @Override
       public String getDailFortune () throws FileNotFoundException {
           return randomSentence(getFile());
       }
   }
