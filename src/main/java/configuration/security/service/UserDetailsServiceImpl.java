package configuration.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.devstale.resoconto.spese.model.Utente;
import it.devstale.resoconto.spese.repository.UtenteRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	UtenteRepository dao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utente utente = dao.findByUsername(username);
		UserBuilder builder = null;
		if (utente != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(false);
			builder.password(utente.getPassword());
			GrantedAuthority auth = new SimpleGrantedAuthority( "POSSIDENTE" );
			builder.authorities(auth);
		} else {
			logger.debug("Utente con username <<"+username+">> non trovato.");
			throw new UsernameNotFoundException("Utente non trovato.");
		}
		return builder.build();
	}
}