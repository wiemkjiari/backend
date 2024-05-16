package wiem.projetspringboot.controller.auth;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import wiem.projetspringboot.Model.Utilisateur;
import wiem.projetspringboot.repository.UtilisateurRepository;


@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
	
	private final AuthenticationService service;
	private final UtilisateurRepository userRepository ;

	
	 @PostMapping("/register")
	  public ResponseEntity<Object> register(@RequestBody RegisterRequest registrationRequest) {
		 var response = service.register(registrationRequest);
		 return ResponseEntity.ok(response)  ; 
	  }
	         
	  @PostMapping("/authenticate")
	  public ResponseEntity<Object> authenticate( @RequestBody AuthenticationRequest request ) {
		  Optional<Utilisateur> optionalUser  = userRepository.findByEmail(request.getEmail());
	        return ResponseEntity.ok(service.authenticate(request));

	  }
	  
	 
	
	
}
