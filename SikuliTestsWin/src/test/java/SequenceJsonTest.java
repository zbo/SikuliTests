import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SequenceJsonTest {
    @Test
    public void testListToJson() {
        Gson gson = new Gson();
        Sequence sequence1 = new Sequence("33185642659", "Test!123", 7, 10);
        Sequence sequence2 = new Sequence("49 (69) 113-1126", "Test!123", 6, 10);
        List<Sequence> listSequence = new ArrayList<Sequence>();
        listSequence.add(sequence1);
        listSequence.add(sequence2);
        String json = gson.toJson(listSequence);
        System.out.println(json);
    }
    @Test
    public void testJsonToList() throws IOException {
        Gson gson = new Gson();
        File file = new File("config/sequence-config.json");
        InputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        String json=out.toString();
        List<Sequence> resultList = gson.fromJson(json,
                new TypeToken<List<Sequence>>() {}.getType());
        System.out.println(resultList);
    }
}
