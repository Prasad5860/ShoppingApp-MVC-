package Modal;

public class Coupon {
	private String couponCodeString;
	private int discount;
	private int count;

	public String getCouponCodeString() {
		return couponCodeString;
	}

	public void setCouponCodeString(String couponCodeString) {
		this.couponCodeString = couponCodeString;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
