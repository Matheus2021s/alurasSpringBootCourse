package br.com.mariah.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mariah.forum.modelo.Usuario;
import br.com.mariah.forum.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> opt = this.usuarioRepository.findByEmail(username);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new UsernameNotFoundException("Dados inválidos");
		
	}

}
