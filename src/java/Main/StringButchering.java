package Main;

import java.util.HashMap;
import java.util.Map;

public class StringButchering {

    public static void main(String[] args) {
       Map<String, String> params = getParams();
        System.out.println("q: " + params.get("q"));
    }

        public static Map<String, String> getParams(){
        Map<String, String> params = new HashMap<>();
            String example = "https://www.discogs.com/search/?q=thrice+vheissu&type=all";


            if (!example.contains("?")) {
            return params;
        }


        String querystring = example.split("\\?")[1];
        String[] pairs = querystring.split("&");
        for (String pair : pairs) {

            String[] cells = pair.split("=");
            String key = cells[0];
            String value = "";
            if (cells.length >= 2) {
                value = cells[1];
            }
            params.put(key, value);

        }

        return params;
    }
}

