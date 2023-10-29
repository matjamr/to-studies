package org.jamroz.mateusz.init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDataReader implements DataReader<String, String> {
    @Override
    public String readFrom(String URL) {
        final java.net.URL url;
        try {
            url = new URL(URL);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            final StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        } catch (Exception e) {
            System.out.println("Exception during invoking external data source");
            throw new RuntimeException(e);
        }
    }
}
