import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public class Sequence {

    public Sequence(String username, String password, int country, int times) {
        this.username = username;
        this.country = country;
        this.password = password;
        this.times = times;
    }

    private String username;
    private int country;
    private String password;
    private int times;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public static List<Sequence> readAll() {
        try {
            Gson gson = new Gson();
            File file = new File("config/sequence-config.json");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            String json = out.toString();
            List<Sequence> resultList = gson.fromJson(json,
                    new TypeToken<List<Sequence>>() {
                    }.getType());
            return resultList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
