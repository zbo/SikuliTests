import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

/**
 * Created by bob.zhu on 1/5/16.
 */
public class AppConfig {
    public String getImgs_folder() {
        return imgs_folder;
    }

    public void setImgs_folder(String imgs_folder) {
        this.imgs_folder = imgs_folder;
    }

    public String getScreens_folder() {
        return screens_folder;
    }

    public void setScreens_folder(String screens_folder) {
        this.screens_folder = screens_folder;
    }

    public String getKiller_path() {
        return killer_path;
    }

    public void setKiller_path(String killer_path) {
        this.killer_path = killer_path;
    }

    private String imgs_folder;
    private String screens_folder;
    private String killer_path;

    public static AppConfig readAll() {
        try {
            Gson gson = new Gson();
            File file = new File("config/app-config.json");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            String json = out.toString();
            AppConfig config = gson.fromJson(json,
                    new TypeToken<AppConfig>() {
                    }.getType());
            return config;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
