package DataDriven;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class JSONFileManager {
    LinkedHashMap<String, Object> data;

    public JSONFileManager(String filePath){
        try{
            FileReader fileReader = new FileReader(filePath);
            Type type = new TypeToken<LinkedHashMap<String, Object>>(){}.getType();
            data = new Gson().fromJson(fileReader, type);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Object getValue(String key){
        return data.get(key);
    }
}
