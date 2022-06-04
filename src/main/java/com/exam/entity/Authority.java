package com.exam.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	private String auth;
	
	public Authority(String auth) {
		this.auth = auth;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return auth;
	}
}
