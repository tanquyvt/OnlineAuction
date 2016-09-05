package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Auction {

	private int id;
	private Date endTime;
	private Money startingPrice;
	private WinningBid winningBid;

	private List<HistoricalBid> bids = new ArrayList<HistoricalBid>();
	
	public Auction() {
		
	}

	public Auction(int id, Money startingPrice, Date endTime) {
		this.id = id;
		this.startingPrice = startingPrice;
		this.endTime = endTime;
	}

	public void reduceTheStartingPrice() {
		// TODO only if no bids and more than 12 hours left
	}

	public boolean isInProgress(Date currentTime) {
		return endTime.after(currentTime);
	}

	public void placeBidFor(Offer offer) {
		if (isFirstOffer()) {
			placeABidForTheFirst(offer);
		} else if (isBidderIncreasingMaximumBidToNew(offer)) {
			winningBid = winningBid.raiseMaximumBidTo(offer.getMaximumBid());
		} else if (winningBid.canBeExceededBy(offer.getMaximumBid())) {
			List<WinningBid> newBids = new AutomaticBidder().generateNextSequenceOfBidsAfter(offer, winningBid);

			for (WinningBid bid : newBids) {
				place(bid);
			}
		}
	}

	public boolean isBidderIncreasingMaximumBidToNew(Offer offer) {
		return winningBid.wasMadeBy(offer.getBidder())
				&& offer.getMaximumBid().isGreaterThan(winningBid.getMaximumBid());
	}

	public boolean isFirstOffer() {
//		return winningBid == null;
//		return bids == null;
		return bids.isEmpty();
	}

	public void placeABidForTheFirst(Offer offer) {
		if (offer.getMaximumBid().isGreaterThanOrEqualTo(startingPrice)) {
			place(new WinningBid(offer.getBidder(), offer.getMaximumBid(), startingPrice, offer.getTimeOfOffer()));
		}
	}

	public void place(WinningBid newBid) {
		if (!isFirstOffer() && winningBid.wasMadeBy(newBid.getBidder())) {
			// TODO outbid event
		}

		// bids.add(new HistoricalBid(newBid.getBidder(),
		// newBid.getMaximumBid(), newBid.getTimeOfOffer()));
		bids.add(new HistoricalBid(newBid.getBidder(), newBid.getCurrentAuctionPrice().getAmount(),
				newBid.getTimeOfOffer()));

		winningBid = newBid;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Money getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Money startingPrice) {
		this.startingPrice = startingPrice;
	}

	public WinningBid getWinningBid() {
		return winningBid;
	}

	public void setWinningBid(WinningBid winningBid) {
		this.winningBid = winningBid;
	}

	public List<HistoricalBid> getBids() {
		return bids;
	}

	public void setBids(List<HistoricalBid> bids) {
		this.bids = bids;
	}

}
