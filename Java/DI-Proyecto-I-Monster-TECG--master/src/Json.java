import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 *  Class Json for objects
 */
public class Json {
    private ObjectMapper ObjectMapper = new ObjectMapper();

    public <A> A parse(String jsonSource, Class<A> clazz) throws JsonProcessingException {
        return ObjectMapper.readValue(jsonSource, clazz);
    }
    public JsonNode parsing(String string) throws JsonProcessingException {
        return ObjectMapper.readTree(string);
    }
    public String toJson(Object data){
        try{
            return ObjectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}