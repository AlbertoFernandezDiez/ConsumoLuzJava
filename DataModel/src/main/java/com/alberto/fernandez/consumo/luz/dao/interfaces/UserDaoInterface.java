package com.alberto.fernandez.consumo.luz.dao.interfaces;

import com.alberto.fernandez.consumo.luz.pojo.User;

public interface UserDaoInterface {

	/**
	 * Gets a user by its <code>id</code>
	 * 
	 * @param id
	 *            {@code int} The id of a <code>User</code> in the database
	 * @return {@code User} If the <code>id</code> exists returns the
	 *         <code>User</code>, else <code>null</code>
	 */
	User getById(int id);

	/**
	 * Gets a user by its <code>name</code>
	 * 
	 * @param name
	 *            {@code String} The name of a <code>User</code> in the database
	 * @return {@code boolean}
	 *         <ul>
	 *         <li><strong>true</strong> If the <code>name</code> does not exist
	 *         </li>
	 *         <li><strong>false</strong> If the <code>name</code> exists</li>
	 *         </ul>
	 */
	boolean checkName(String name);

	/**
	 * Gets a user by its username and password
	 * 
	 * @param username
	 *            {@code String} the username of a <code>user</code>
	 * @param password
	 *            {@code String} the password of a <code>user</code>
	 * @return {@code User} If the user exists returns the <code>User</code>,
	 *         else <code>null</code>
	 */
	User login(String username, String password);

	/**
	 * Creates a new user in the database
	 * 
	 * @param username {@code String} the username of a <code>user</code>
	 * @param password {@code String} the password of a <code>user</code>
	 * @return {@code boolean}
	 *         <ul>
	 *         <li><strong>true</strong> if the user is created in the database
	 *         </li>
	 *         <li><strong>false</strong> if the user is not created in the
	 *         database</li>
	 *         </ul>
	 */
	boolean signIn(String username, String password);

	/**
	 * Deletes a user by the given id
	 * 
	 * @param id {@code int} the id of the user to delete
	 * @return {@cod boolean}
	 *         <ul>
	 *         <li><strong>true</strong> if the user is deleted</li>
	 *         <li><strong>false</strong> if the user is not deleted</li>
	 *         </ul>
	 */
	boolean deleteUser(int id);

}
