package wiem.projetspringboot.controller.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wiem.projetspringboot.Model.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	  private String firstname;
	  private String lastname;
	  private String email;
	  private String password;
	  private Role role ;
	  private String sexe ;
	  private String status;   
	  
}
