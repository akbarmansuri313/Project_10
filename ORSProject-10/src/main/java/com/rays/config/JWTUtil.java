package com.rays.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JWTUtil is a utility class for generating, validating, and extracting
 * claims from JSON Web Tokens (JWTs).
 * 
 * It supports HS256 signing algorithm and encodes/decodes JWT using Base64 URL encoding.
 * 
 * Author: Akbar Mansuri
 */
@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private long jwtExpiration; // in milliseconds

	private static final ObjectMapper objectMapper = new ObjectMapper();

	// -------------------------
	// Generate JWT token
	// -------------------------
	/**
	 * Generates a signed JWT token with userId, loginId, and role.
	 * 
	 * @param userId  Numeric ID of the user
	 * @param loginId Login ID (subject) of the user
	 * @param role    Role of the user
	 * @return Signed JWT token as a string
	 * @throws Exception If token generation fails
	 */
	public String generateToken(Long userId, String loginId, String role) throws Exception {
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + jwtExpiration;

		// JWT Header
		Map<String, Object> header = new HashMap<>();
		header.put("alg", "HS256");
		header.put("typ", "JWT");

		// JWT Payload (claims)
		Map<String, Object> payload = new HashMap<>();
		payload.put("sub", loginId); // loginId as subject
		payload.put("userId", userId); // numeric user id
		payload.put("role", role); // user role
		payload.put("iat", nowMillis); // issued at
		payload.put("exp", expMillis); // expiration

		String headerBase64 = encodeUrl(objectMapper.writeValueAsString(header));
		String payloadBase64 = encodeUrl(objectMapper.writeValueAsString(payload));
		String signatureBase64 = sign(headerBase64 + "." + payloadBase64, jwtSecret);

		return String.join(".", headerBase64, payloadBase64, signatureBase64);
	}

	// -------------------------
	// Validate JWT token
	// -------------------------
	/**
	 * Validates a JWT token against a given loginId and checks signature & expiry.
	 * 
	 * @param token         JWT token string
	 * @param expectedLoginId Expected loginId (subject) to match
	 * @return true if token is valid
	 * @throws Exception if token is invalid, expired, or signature mismatch occurs
	 */
	public boolean validateToken(String token, String expectedLoginId) throws Exception {
		
		String[] parts = token.split("\\.");
		
		if (parts.length != 3) {
			throw new Exception("Invalid JWT token");
		}
		
		String payloadJson = decode(parts[1]);
		
		String tokenLoginId = extractField(payloadJson, "sub");
		
		String expectedSignature = sign(parts[0] + "." + parts[1], jwtSecret);

		if (!expectedSignature.equals(parts[2])) {
			throw new Exception("JWT signature does not match");
		}

		if (!expectedLoginId.equals(tokenLoginId)) {
			throw new Exception("JWT subject (loginId) does not match");
		}

		if (isTokenExpired(payloadJson)) {
			throw new Exception("JWT token has expired");
		}

		return true;
	}

	// -------------------------
	// Extract claims
	// -------------------------
	/**
	 * Extracts the loginId (subject) from a JWT token.
	 */
	public String extractLoginId(String token) {
		return extractField(decode(token.split("\\.")[1]), "sub");
	}

	/**
	 * Extracts the numeric userId from a JWT token.
	 */
	public Long extractUserId(String token) {
		return Long.parseLong(extractField(decode(token.split("\\.")[1]), "userId"));
	}

	/**
	 * Extracts the role from a JWT token.
	 */
	public String extractRole(String token) {
		return extractField(decode(token.split("\\.")[1]), "role");
	}

	// -------------------------
	// Helper methods
	// -------------------------
	private boolean isTokenExpired(String payloadJson) {
		
		long exp = Long.parseLong(extractField(payloadJson, "exp"));
		
		return exp < (System.currentTimeMillis() / 1000);
	}

	private String extractField(String json, String field) {
		try {
			
			Map<String, Object> map = objectMapper.readValue(json, Map.class);
			
			return String.valueOf(map.get(field));
			
		} catch (Exception e) {
			
			return null;
		}
	}

	private String sign(String data, String key) throws Exception {
		
		Mac mac = Mac.getInstance("HmacSHA256");
		
		mac.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		
		return encodeUrl(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
	}

	private String encodeUrl(String data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}

	private String encodeUrl(byte[] data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data);
	}

	private String decode(String data) {
		return new String(Base64.getUrlDecoder().decode(data), StandardCharsets.UTF_8);
	}
}