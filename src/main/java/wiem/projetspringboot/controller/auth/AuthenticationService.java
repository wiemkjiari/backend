package wiem.projetspringboot.controller.auth;


import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import wiem.projetspringboot.Model.Utilisateur;
import wiem.projetspringboot.repository.UtilisateurRepository;
import wiem.projetspringboot.services.utils.JwtService;
import wiem.projetspringboot.token.Token;
import wiem.projetspringboot.token.TokenRepository;
import wiem.projetspringboot.token.TokenType;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UtilisateurRepository repository ; 
	private final PasswordEncoder passwordEncoder ;
	private final JwtService jwtService ;
	private final AuthenticationManager authenticationManager ;
	private final TokenRepository tokenRepository ;
	
	
	
	public AuthenticationResponse authenticate(AuthenticationRequest request ) {
		 authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword()
						)
				);
		 var user = repository.findByEmail(request.getEmail())
				 .orElseThrow(); 		
		 var jwtToken = jwtService.generateToken(user);
		 revokedAllUserTokens(user);
		 saveUserToken(user, jwtToken);
		 return AuthenticationResponse.builder()
					.accessToken(jwtToken)
					.id(user.getId())
		            .firstname(user.getNom())
		            .lastname(user.getPrenom())
		            .email(user.getEmail())
		            .role(user.getRole())
					.build();
							
	}
	
	
	
	public AuthenticationResponse register(RegisterRequest request ) {
		var user = Utilisateur.builder()
				.nom(request.getFirstname())
				.prenom(request.getLastname())
				.email(request.getEmail())
				.moteDePasse(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();  

		var savedUSer= repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		saveUserToken(savedUSer, jwtToken);
		return AuthenticationResponse.builder()
				.accessToken(jwtToken)
				.refreshToken(refreshToken)
				.id(savedUSer.getId())
	            .firstname(savedUSer.getNom())
	            .lastname(savedUSer.getPrenom())
	            .email(savedUSer.getEmail())
	            .role(savedUSer.getRole())
				.build();
	}
	
	
	
	private void revokedAllUserTokens(Utilisateur user) {
		var validUserTokens =tokenRepository.findAllValidTokensByUser(user.getId());
		if(validUserTokens.isEmpty()) {
			return ; 
		}
		
		validUserTokens.forEach(t -> {
			t.setExpired(true);
			t.setRevoked(true);
			
		});
		tokenRepository.saveAll(validUserTokens);
	}
	
	
	
	private void saveUserToken(Utilisateur user, String jwtToken) {
		var token =Token.builder()
				.user(user)
				.token(jwtToken)
				.tokenType(TokenType.BEARER)
				.expired(false)
				.revoked(false)
				.build();
		tokenRepository.save(token);
	}
	
	
	
	
	

}
