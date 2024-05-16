package wiem.projetspringboot.token;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wiem.projetspringboot.Model.Utilisateur;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ; 
	private String token ;
	@Enumerated(EnumType.STRING)
	private TokenType tokenType ;
	private boolean expired ;
	private boolean revoked ;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur user ;
	
	
	public Token(String token, Utilisateur user) {
        super();
        this.token = token;
        this.user = user;
       
    }





}
