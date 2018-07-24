package java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AlbumSearch {
    public static void main(String[] args) {
        getAlbumArtUrl("dieantwoord");
    }

    public static String getAlbumArtUrl(String query) {
        try{
            String url = "https://www.discogs.com/search/?q=" + query + "&type=all";
            Document doc = Jsoup.connect(url).get();

            Elements albumCovers = doc.select(".thumbnail_center");
            Element span = albumCovers.get(0);
            Element img = span.child(0);
            String src = img.attr("data-src");
            System.out.println(src);

        }catch (IOException e){
            e.printStackTrace();
        }

        return "default";
    }
}