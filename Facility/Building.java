import java.util.ArrayList;

public class Building extends Facility {

	private int minFloor;
	private int maxFloor;
	private int capacity;
	private ArrayList<Room> rooms;

	public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
		if (minFloor > maxFloor) {
			throw new IllegalArgumentException();
		}
		capacity = 0;
		this.name = name;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
		rooms = new ArrayList<>();
		users = new ArrayList<>();
	}

	public int getMinFloor() {
		return minFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	@Override
	public String toString() {
		return "Building(" + name + ")";
	}

	public int getCapacity() {
		return capacity;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void add(Room room) throws DuplicateRoomException {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).equals(room))
				throw new DuplicateRoomException();
		}
		capacity += room.getCapacity();
		rooms.add(room);
	}

	public void addCap(int cap) {
		if (cap >= 0) {
			capacity += cap;
		}
	}

	public void authorize(User user) {
		users.add(user);
	}

}
