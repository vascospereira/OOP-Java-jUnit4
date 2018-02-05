import java.util.ArrayList;

public class Room extends Facility {

	private Building building;
	private String number;
	private int floor;
	private int capacity;

	public Room(Building building, String number, int floor) throws DuplicateRoomException {
		if (floor > building.getMaxFloor()) {
			throw new IllegalArgumentException();
		}
		if (floor < building.getMinFloor()) {
			throw new IllegalArgumentException();
		}
		capacity = 0;
		this.name = building.getName() + number;
		this.building = building;
		this.number = number;
		this.floor = floor;
		users = new ArrayList<>();
		this.building.add(this);
	}

	public Room(Building building, String number, int floor, int cap) throws DuplicateRoomException {
		this(building, number, floor);
		capacity += cap;
		this.building.addCap(cap);
	}

	public Building getBuilding() {
		return building;
	}

	public String getNumber() {
		return number;
	}

	public int getFloor() {
		return floor;
	}

	public String toString() {
		return "Room(" + building.getName() + "," + number + ")";
	}

	public boolean equals(Room r1) {
		if (r1.number.equals(this.number) && r1.floor == this.floor)
			return true;
		return false;
	}

	public int getCapacity() {
		return capacity;
	}

	public void authorize(User user) {
		users.add(user);
		building.authorize(user);
	}
}
