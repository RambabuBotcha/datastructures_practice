package practice;


public class Room implements Comparable<Room>{
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + "]";
	}

	private final Integer id;
	private final String name; 
	Room(int id,String name){
		this.id=id;
		this.name=name;
	}
	public Integer id() {return id;}
	public String name() {return name;}
	
    public boolean equals(Object o) {
        if (!(o instanceof Room))
            return false;
        Room n = (Room) o;
        return n.name.equals(name);
    }

    public int hashCode() {
        return 31*name.hashCode() + id.hashCode();
    }
	
	public int compareTo(Room r) {
		return name.compareTo(r.name);
	}
	
	
	
}
