package model;

public class Price {

	private Money amount;
	
	public Price() {
		// TODO Auto-generated constructor stub
	}

	public Price(Money amount) {
		this.amount = amount;
	}

	public Money bidIncrement() {
		if (amount.isGreaterThanOrEqualTo(new Money("0.01")) && !amount.isGreaterThan(new Money("0.99"))) {
			return amount.add(new Money("0.05"));
		}
		if (amount.isGreaterThanOrEqualTo(new Money("1.00")) && !amount.isGreaterThan(new Money("4.99"))) {
			return amount.add(new Money("0.20"));
		}
		if (amount.isGreaterThanOrEqualTo(new Money("5.00")) && !amount.isGreaterThan(new Money("14.99"))) {
			return amount.add(new Money("0.50"));
		}

		return amount.add(new Money("1.00"));
	}

	public boolean canBeExceededBy(Money offer) {
		return offer.isGreaterThanOrEqualTo(bidIncrement());
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

}
