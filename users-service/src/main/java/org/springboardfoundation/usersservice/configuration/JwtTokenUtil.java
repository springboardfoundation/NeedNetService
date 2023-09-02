package org.springboardfoundation.usersservice.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.lang.Maps;
import io.jsonwebtoken.security.Keys;
import org.springbordfoundation.db.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {
    private static final String SECRET_KEY= "396537643065313838363063316438346330373739353266306130646635306135663534616631363535393235313137306239396563346439613064613864";
    public Object extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private long refreshExpiration;

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public <T> T extractClaims(String token , Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return  claimsResolvers.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJwt(token).getBody();

    }

    public String generateTokens(UserDetails userDetails){
        return generateTokens(new HashMap<>(), userDetails);

    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = (String) extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public String generateTokens(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                        .signWith(getSigninKeys(), SignatureAlgorithm.HS256).compact();
    }
    private Key getSigninKeys() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

//    public void generateRefreshToken(User userDetails) {
//
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getSigninKeys(), SignatureAlgorithm.HS256)
//                .compact();
//    }
}
