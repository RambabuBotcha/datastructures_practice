package test;

public class Order{
	public Order(String args[]) {
		this.id=Long.parseLong(args[1]);
		this.tsp=Long.parseLong(args[2]);
		this.sbl=args[3].trim();
		this.ot=OT.valueOf(args[4].trim());
		this.side=Side.valueOf(args[5].trim());
		this.price=Float.parseFloat(args[6]);
		this.qt=Long.parseLong(args[7]);
	}
	enum OT {
		M,L,I
	}
	enum Side{
		B,S;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTsp() {
		return tsp;
	}
	public void setTsp(long tsp) {
		this.tsp = tsp;
	}
	public String getSbl() {
		return sbl;
	}
	public void setSbl(String sbl) {
		this.sbl = sbl;
	}
	public OT getOt() {
		return ot;
	}
	public void setOt(OT ot) {
		this.ot = ot;
	}
	public Side getSide() {
		return side;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getQt() {
		return qt;
	}
	public void setQt(long qt) {
		this.qt = qt;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", tsp=" + tsp + ", sbl=" + sbl + ", ot=" + ot + ", side=" + side + ", price="
				+ price + ", qt=" + qt + "]";
	}
	public boolean check(Order order) {
		if(order.id==this.id) {
			return true;
		}else
			return false;
	}
    public boolean validate(Order order) {
    	if(this.sbl.equals(order.sbl) && this.ot==order.ot && this.side==order.side && this.tsp==order.tsp) {
    		return true;
    	}else {
    		return false;
    	}
    }
	private long id;
	public long tsp;
	private String sbl;
	private OT ot;
	private Side side;
	private float price;
	private long qt;
}
