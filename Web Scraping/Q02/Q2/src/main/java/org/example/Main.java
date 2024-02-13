package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "https://www.nlb.lk/results/govisetha/3594";

        try {
            Document doc = Jsoup.connect(url).get();

            Elements numbers = doc.select("div.BB ol.B li");

            for (int i = 0; i < 5; i++) {
                System.out.println(numbers.get(i).text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}