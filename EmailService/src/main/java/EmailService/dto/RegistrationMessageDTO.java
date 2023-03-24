package EmailService.dto;

import lombok.Data;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

@Data
public class RegistrationMessageDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
//    private List<RoleDTO> roles = new ArrayList<>();
//    private List<BadgeDTO> badges = new ArrayList<>();
//    private List<MembershipDTO> memberships = new ArrayList<>();

    public RegistrationMessageDTO(String json){
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        firstName = jsonObject.getString("firstName");
        lastName = jsonObject.getString("lastName");
        emailAddress = jsonObject.getString("emailAddress");
        password = jsonObject.getString("password");
    }
}
