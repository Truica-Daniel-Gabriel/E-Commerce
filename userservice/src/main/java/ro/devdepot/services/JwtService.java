package ro.devdepot.services;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
   public String extractUsername(String token);
   public boolean isTokenValid(String token, UserDetails userDetails);
   public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
   public String generateToken(UserDetails userDetails);
}
