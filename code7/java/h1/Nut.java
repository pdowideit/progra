package cargo;

public class Nut{
	String name;
	int weight;
	public Nut(){

		this("",-1);
	}
	
	public Nut(String name, int weight){
		this.name = name;
		this.weight = weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
}