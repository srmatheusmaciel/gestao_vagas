package br.com.matheusmaciel.gestao_vagas.providers;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@Service
public class JWTCandidateProvider {

   

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    public DecodedJWT validateToken(String token) {
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try{
          var tokenDecoded = JWT.require(algorithm)
                          .build()
                          .verify(token);

        return tokenDecoded;
    }catch(JWTVerificationException ex){
        ex.printStackTrace();
        return null;
    }
        }


}
