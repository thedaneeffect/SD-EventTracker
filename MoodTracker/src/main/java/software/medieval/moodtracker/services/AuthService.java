package software.medieval.moodtracker.services;

import software.medieval.moodtracker.entities.User;

public interface AuthService {
	
	static final Error ERROR_INVALID = new Error("Invalid username or password.");
	static final Error ERROR_NAME_TAKEN = new Error("Name already taken.");
	
	class Error extends Exception {
		private static final long serialVersionUID = 8345265139824446845L;
		
		public Error(String message) {
			super(message);
		}
	}
	
	User getUserByName(String name);
	
	int getUserIdByName(String name);

	User register(User user) throws Exception;
}
