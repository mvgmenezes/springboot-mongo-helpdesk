package com.mmenezes.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mmenezes.helpdesk.api.entity.User;
import com.mmenezes.helpdesk.api.enums.ProfileEnum;

//JWT#3 - Classe para converter o nosso usuario em um usuario reconhecido pelo o Spring Security
public class JwtUserFactory {

	private JwtUserFactory() {
		
	}
	
	//Gera um jwt user com base nos dados de um usuario
	public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getProfile())
        );
    }

	//converte o perfil do usuario para o formato utilizado no spring security
    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
    		authorities.add(new SimpleGrantedAuthority(profileEnum.toString())); 
    		return   authorities ;
    }
}
