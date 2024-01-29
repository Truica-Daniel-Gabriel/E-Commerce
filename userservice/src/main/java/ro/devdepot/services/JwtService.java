package ro.devdepot.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
   public String extractUsername(String token);
   public boolean isTokenValid(String token, UserDetails userDetails);
   public String generateToken(Map<String, Object> extraClaims, String username);
   public String generateToken(String username);

}
