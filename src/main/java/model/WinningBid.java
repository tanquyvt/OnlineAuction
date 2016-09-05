package model;

import java.util.Date;

public class WinningBid {

	private long bidder;
	private Money maximumBid;
	private Date timeOfOffer;
	private Price currentAuctionPrice;
	
	public WinningBid() {
		// TODO Auto-generated constructor stub
	}

	public WinningBid(long bidder, Money maximumBid, Money bid, Date timeOfBid) {
		this.bidder = bidder;
		this.maximumBid = maximumBid;
		this.timeOfOffer = timeOfBid;
		this.currentAuctionPrice = new Price(bid);
	}

	public WinningBid raiseMaximumBidTo(Money newAmount) {
		if (newAmount.isGreaterThan(maximumBid)) {
			return new WinningBid(bidder, newAmount, currentAuctionPrice.getAmount(), new Date());
		} else {
			throw new IllegalArgumentException("Maximum bid must be larger than current maximum bid.");
		}
	}

	public boolean wasMadeBy(long bidder) {
		return this.bidder == bidder;
	}

	public boolean canBeExceededBy(Money offer) {
		return currentAuctionPrice.canBeExceededBy(offer);
	}

	public boolean hasNotReachedMaximumBid() {
		return maximumBid.isGreaterThan(currentAuctionPrice.getAmount());
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

	public Price getCurrentAuctionPrice() {
		return currentAuctionPrice;
	}

	public void setCurrentAuctionPrice(Price currentAuctionPrice) {
		this.currentAuctionPrice = currentAuctionPrice;
	}

}
