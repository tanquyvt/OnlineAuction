package model;

import java.util.Date;

public class HistoricalBid {

	private long bidder;
	private Money amount;
	private Date timeOfBid;

	public HistoricalBid(long bidder, Money bid, Date timeOfBid) {
		this.bidder = bidder;
		this.amount = bid;
		this.timeOfBid = timeOfBid;
	}

	public long getBidder() {
		return bidder;
	}

	public void setBidder(long bidder) {
		this.bidder = bidder;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public Date getTimeOfBid() {
		return timeOfBid;
	}

	public void setTimeOfBid(Date timeOfBid) {
		this.timeOfBid = timeOfBid;
	}

}
