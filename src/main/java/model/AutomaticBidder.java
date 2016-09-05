package model;

import java.util.ArrayList;
import java.util.List;

public class AutomaticBidder {

	public List<WinningBid> generateNextSequenceOfBidsAfter(Offer offer, WinningBid currentWinningBid) {
		List<WinningBid> bids = new ArrayList<WinningBid>();

		if (currentWinningBid.getMaximumBid().isGreaterThanOrEqualTo(offer.getMaximumBid())) {
			WinningBid bidFromOffer = new WinningBid(offer.getBidder(), offer.getMaximumBid(), offer.getMaximumBid(),
					offer.getTimeOfOffer());
			bids.add(bidFromOffer);
			bids.add(calculateNextBid(bidFromOffer, new Offer(currentWinningBid.getBidder(),
					currentWinningBid.getMaximumBid(), currentWinningBid.getTimeOfOffer())));
		} else {
			if (currentWinningBid.hasNotReachedMaximumBid()) {
				WinningBid currentBiddersLastBid = new WinningBid(currentWinningBid.getBidder(),
						currentWinningBid.getMaximumBid(), currentWinningBid.getMaximumBid(),
						currentWinningBid.getTimeOfOffer());
				bids.add(currentBiddersLastBid);
				bids.add(calculateNextBid(currentBiddersLastBid, offer));
			} else {
				bids.add(new WinningBid(offer.getBidder(), currentWinningBid.getCurrentAuctionPrice().bidIncrement(),
						offer.getMaximumBid(), offer.getTimeOfOffer()));
			}
		}

		return bids;
	}

	public WinningBid calculateNextBid(WinningBid winningBid, Offer offer) {
		WinningBid bid;

		if (winningBid.canBeExceededBy(offer.getMaximumBid())) {
			bid = new WinningBid(offer.getBidder(), offer.getMaximumBid(),
					winningBid.getCurrentAuctionPrice().bidIncrement(), offer.getTimeOfOffer());
		} else {
			bid = new WinningBid(offer.getBidder(), offer.getMaximumBid(), offer.getMaximumBid(),
					offer.getTimeOfOffer());
		}

		return bid;
	}

}
