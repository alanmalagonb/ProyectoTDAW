package escom.ipn.restaurantes.data.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author alanm
 */
public abstract class DTO implements Serializable{
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr="";
        try {
            jsonStr = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(this.getClass().getName());
        }
        return jsonStr;
    }
}
