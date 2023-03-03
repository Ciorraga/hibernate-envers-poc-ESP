package com.pocsma.hibernateenvers.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import com.pocsma.hibernateenvers.app.listener.ExtraDataRevisionListener;

@Entity
@RevisionEntity(ExtraDataRevisionListener.class)
public class ExtraDataRevision extends DefaultRevisionEntity {

	private static final long serialVersionUID = 6752442448430489553L;

	private String modifierUser;

	private LocalDateTime actionAt;
	
	private String project;
	
	public String getModifierUser() {
		return modifierUser;
	}

	public void setModifierUser(String modifierUser) {
		this.modifierUser = modifierUser;
	}

	public LocalDateTime getActionAt() {
		return actionAt;
	}

	public void setActionAt(LocalDateTime actionAt) {
		this.actionAt = actionAt;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	

}