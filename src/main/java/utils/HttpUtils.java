package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {

    public static String fetchData(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("x-rapidapi-key", "b4a0d8763amsh99412c790e6fd33p1042efjsnc569ed6bb8c4");
        //con.setRequestProperty("x-rapidapi-host", "wft-geo-db.p.rapidapi.com");
        //con.setRequestProperty("useQueryString", "true");
        //con.setRequestProperty("Accept", "application/json");
        //con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
}
