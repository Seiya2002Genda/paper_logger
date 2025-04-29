// ✅ Open.java
package Paper_logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Open {
    public static List<Paper> loadFromFile(String filename) throws IOException {
        List<Paper> papers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            papers.add(Paper.fromCSV(line));
        }
        reader.close();
        return papers;
    }
}