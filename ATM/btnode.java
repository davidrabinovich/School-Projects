package bsthw;

public class btnode {
	btnode left, right;
	customer customer;

	public btnode() {
		left = null;
		right = null;
		customer = null;
	}

	public btnode(customer customer) {
		this.customer = customer;
	}
}
