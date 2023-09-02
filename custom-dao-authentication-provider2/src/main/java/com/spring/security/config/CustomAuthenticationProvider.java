package com.spring.security.config;

import com.spring.security.model.User;
import com.spring.security.model.UserRole;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) {
			boolean exists = passwordEncoder.matches(password, user.get().getPassword());
			if(exists) {
				List<GrantedAuthority> authorizes = new ArrayList<GrantedAuthority>();

				List<UserRole> roles = user.get().getUserRoles();
				roles.forEach((role) -> authorizes.add(new SimpleGrantedAuthority(role.getRole().getRoleName())));
				
				return new UsernamePasswordAuthenticationToken(username, password, authorizes);
			}else {
				throw new BadCredentialsException("invalid password!");
			}
		}else {
			throw new UsernameNotFoundException("user is not found!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
