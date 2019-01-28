import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readSplitIPFromFile() throws Exception {
        List<String> listIP = new ArrayList<String>();
        File file = new File("C:\\Users\\vart.OFFICE\\IdeaProjects\\JavaUT\\src\\main\\resources\\blacklistIP");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                listIP.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return listIP;
    }

}
