package bsthw;

public class bst {

	btnode root;
	public int index = 0;
	public int size = 0;

	public bst() {
		this.root = null;
	}

	public bst(bst bst) {
		this.root = bst.root;
		this.size = bst.size;
	}

	public boolean isempty() {
		if (root == null)
			return true;
		else
			return false;
	}

	public void insert(customer customer) {
		this.root = insert(root, customer);
		size++;
	}

	public btnode insert(btnode root, customer customer) {
		if (root == null) {
			root = new btnode(customer);
			return root;
		} else if (root.customer.compareTo(customer) > 0)
			root.left = insert(root.left, customer);
		else
			root.right = insert(root.right, customer);
		return root;
	}

	public void delete(customer customer) {// neccessary because regular delete needs two inputs
		delete(this.root, customer);
		size--;
	}

	public btnode delete(btnode root, customer customer) {
		if (root == null)// check to see if theres a node initially
			return null;
		else if (root.customer.compareTo(customer) > 0) {
			root.left = delete(root.left, customer);
		} else if (root.customer.compareTo(customer) < 0) {
			root.right = delete(root.right, customer);
		} else if (root.customer.compareTo(customer) == 0) {// node to delete
			if (root.left != null && root.right != null) {// if node to delete has 2 children
				customer max = findmax(root.left);
				root.customer = max;
				root.left = delete(root.left, max);// change node to delete to left max and delete left max
				return root;
			} else if (root.right == null) {// node to delete has one child, left
				return root.left;
			} else if (root.left == null) {// node to delete has one child, right
				return root.right;
			} else
				return null;// node to delete has no children
		}
		return root;
	}

	public customer findmax(btnode root) {
		if (root.right != null)
			return findmax(root.right);
		else
			return root.customer;
	}

	public customer findmin(btnode root) {
		if (root.left != null)
			return findmin(root.left);
		else
			return root.customer;
	}

	public customer search(customer customer) {// neccessary to put this.root in real search
		return search(this.root, customer);
	}

	public customer search(btnode root, customer customer) {
		if (root == null) {
			System.out.println("error: customer does not exist");
			return null;
		} else if (root.customer.compareTo(customer) == 0)
			return root.customer;
		else if (root.customer.compareTo(customer) > 0) {
			return search(root.left, customer);
		}
		return search(root.right, customer);

	}

	public customer[] inordertraversal() {
		customer[] arr = new customer[size];
		return inordertraversal(this.root, arr);
	}

	public customer[] inordertraversal(btnode root, customer[] arr) {
		if (root == null)
			return null;
		inordertraversal(root.left, arr);
		arr[index++] = root.customer;
		inordertraversal(root.right, arr);

		return arr;
	}

	public customer[] preordertraversal() {
		customer[] arr = new customer[size];
		return preordertraversal(this.root, arr);
	}

	public customer[] preordertraversal(btnode root, customer[] arr) {
		if (root == null)
			return null;

		arr[index] = root.customer;
		index++;
		preordertraversal(root.left, arr);
		preordertraversal(root.right, arr);

		return arr;
	}

	public customer[] postordertraversal() {
		customer[] arr = new customer[size];
		return postordertraversal(this.root, arr);
	}

	public customer[] postordertraversal(btnode root, customer[] arr) {
		if (root == null)
			return null;
		postordertraversal(root.left, arr);

		postordertraversal(root.right, arr);
		arr[index++] = root.customer;

		return arr;
	}

}
