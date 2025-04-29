// ✅ Save.java
package Paper_logger;

import java.io.*;
import java.util.List;

public class Save {
    public static void saveToFile(List<Paper> papers, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Paper p : papers) {
            writer.write(p.toCSV());
            writer.newLine();
        }
        writer.close();
    }
}
