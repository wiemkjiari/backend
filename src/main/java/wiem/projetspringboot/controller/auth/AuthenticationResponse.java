package wiem.projetspringboot.controller.auth;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wiem.projetspringboot.Model.Role;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationResponse {

	    private String accessToken;
	    private String refreshToken;
	    private Integer id;
	    private String firstname;
	    private String lastname;
	    private String email;
	    private Role role;
	    private String sexe ;
		


	
}
