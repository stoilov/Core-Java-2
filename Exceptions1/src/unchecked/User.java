package unchecked;

class User {

	private String username;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		if (username.equals("")) {
			String message = String.format("Bad username: \"%s\"", username);
			throw new DatabaseCorruptedException(message);
		}

		return username;
	}

	public static void main(String[] args) {
		User user = new User();
		String username = "";
		user.setUsername(username);
		try {
			user.getUsername();
		} catch (DatabaseCorruptedException dce) {
			System.out.println(dce.getMessage());
		}
	}

}
