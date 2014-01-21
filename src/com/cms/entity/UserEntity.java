package com.cms.entity;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.cms.util.PasswordEncryptor;

@Entity
@NamedQueries({
	@NamedQuery(name = "selectAllUsers", query = "SELECT u FROM UserEntity u"),
	@NamedQuery(name = "selectUserIdByUsername", query = "SELECT u.usrId FROM UserEntity u WHERE u.usrUserName = ?1")
})
@Table(name = "t_user")
public class UserEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")
	protected Long usrId;
	
	@Column(name = "usr_fname")
	private String usrFname;
	
	@Column(name = "usr_lname")
	private String usrLname;
	
	@Column(name = "usr_username")
	private String usrUserName;
	
	@Column(name = "usr_password")
	private String usrPassword;

	//Getters and Setters
	public Long getUsrId() {
		return usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrFname() {
		return usrFname;
	}

	public void setUsrFname(String usrFname) {
		this.usrFname = usrFname;
	}

	public String getUsrLname() {
		return usrLname;
	}

	public void setUsrLname(String usrLname) {
		this.usrLname = usrLname;
	}

	public String getUsrUserName() {
		return usrUserName;
	}

	public void setUsrUserName(String usrUserName) {
		this.usrUserName = usrUserName;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		try {
			this.usrPassword = PasswordEncryptor.encryptPassword(usrPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
