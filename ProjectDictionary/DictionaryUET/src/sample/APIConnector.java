package sample;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class APIConnector {

    public String parseJSON(String word, String langFrom, String langTo){
        String result = "";
        try {
            String urlAPI = "https://translate.googleapis.com/translate_a/single?" +
                    "client=gtx&" +
                    "sl=" + langFrom +
                    "&tl=" + langTo +
                    "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");
            URL url = new URL(urlAPI);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                JSONParser parse = new JSONParser();

                JSONArray jsonArray1 = (JSONArray) parse.parse(String.valueOf(informationString));
                JSONArray jsonArray2 = (JSONArray) jsonArray1.get(0);

                for (int i = 0; i < jsonArray2.size(); i++) {
                    JSONArray jsonArray3 = (JSONArray) jsonArray2.get(i);
                    result = result + (String) jsonArray3.get(0);
                }
            }
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
