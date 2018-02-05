import java.util.ArrayList;

public class Facility {
	protected String name;
	protected ArrayList<User> users;

	public String getName() {
		return name;
	}

	public boolean canEnter(User user) {
		if (users.indexOf(user) == -1)
			return false;
		return true;
	}
}
