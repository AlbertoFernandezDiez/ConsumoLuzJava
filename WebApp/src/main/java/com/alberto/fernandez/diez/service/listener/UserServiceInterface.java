package com.alberto.fernandez.diez.service.listener;

import javax.ws.rs.core.Response;

public interface UserServiceInterface {

	Response getById(int id);

	Response checkName(String name);

	Response login(String username, String password);

	Response signIn(String username, String password);

}
