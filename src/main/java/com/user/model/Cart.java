package com.user.model;

public class Cart {

	private Long cartId;

	private Double totalPrice;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, int userIdFetched) {
		super();
		this.cartId = (long) id;
		this.totalPrice = (double) userIdFetched;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalPrice=" + totalPrice + "]";
	}

	public int getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
