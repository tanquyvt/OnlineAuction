package model;

import java.util.Date;

public class Offer {

	private long bidder;
	private Money maximumBid;
	private Date timeOfOffer;
	
	public Offer() {
		// TODO Auto-generated constructor stub
	}

	public Offer(long bidderId, Money maximumBid, Date timeOfOffer) {
		this.bidder = bidderId;
		this.maximumBid = maximumBid;
		this.timeOfOffer = timeOfOffer;
	}

	public long getBidder() {
		return bidder;
	}

	public void setBidder(long bidder) {
		this.bidder = bidder;
	}

	public Money getMaximumBid() {
		return maximumBid;
	}

	public void setMaximumBid(Money maximumBid) {
		this.maximumBid = maximumBid;
	}

	public Date getTimeOfOffer() {
		return timeOfOffer;
	}

	public void setTimeOfOffer(Date timeOfOffer) {
		this.timeOfOffer = timeOfOffer;
	}

}
