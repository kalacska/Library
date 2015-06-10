package org.pmmik.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = User.TABLE_NAME)
@Table(name = User.TABLE_NAME, schema = PersistentObject.SCHEMA)
public class User extends PersistentObject {
	
	public final static String TABLE_NAME = "users"; //$NON-NLS-1$
	public final static String USERNAME = "username"; //$NON-NLS-1$
	public final static String PASSWORD = "password"; //$NON-NLS-1$
	
	@Column(name=USERNAME, nullable=false)
	private String username;
	@Column(name=PASSWORD, nullable=false)
	private String password;
	
	public User() {}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
