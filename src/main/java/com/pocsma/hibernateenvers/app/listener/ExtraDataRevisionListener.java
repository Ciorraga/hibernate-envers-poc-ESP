package com.pocsma.hibernateenvers.app.listener;

import java.time.LocalDateTime;

import org.hibernate.envers.RevisionListener;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.pocsma.hibernateenvers.app.entity.ExtraDataRevision;

public class ExtraDataRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		ExtraDataRevision rev = (ExtraDataRevision) revisionEntity;
		rev.setModifierUser(getUserName());
		rev.setActionAt(LocalDateTime.now());
		rev.setProject("grid-history-poc");
	}
	
	private String getUserName() {
		String userName = "User not found";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof KeycloakPrincipal) {
			@SuppressWarnings("unchecked")
			KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) authentication
					.getPrincipal();
			userName = kp.getKeycloakSecurityContext().getToken().getPreferredUsername();
		}
		return userName;
	}
	
}
