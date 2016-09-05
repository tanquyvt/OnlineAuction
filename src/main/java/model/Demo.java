package model;

import java.util.Date;
import java.util.List;

public class Demo {

	static Auction auction;

	public static void main(String[] args) {

		AuctionDao dao = new AuctionDaoImpl();

		auction = dao.findBy(7);

		// auction = new Auction(1, new Money("0.99"), new Date(2016, 9, 6));

		auction.placeBidFor(new Offer(1, new Money("10.00"), new Date(2016, 9, 5, 20, 5, 22)));
		dao.update(auction);
		auction.placeBidFor(new Offer(2, new Money("1.49"), new Date(2016, 9, 5, 20, 5, 23)));
		dao.update(auction);
		auction.placeBidFor(new Offer(2, new Money("10.01"), new Date(2016, 9, 5, 20, 5, 24)));
		dao.update(auction);

		List<HistoricalBid> list = auction.getBids();

		System.out.println(
				"Current Bid: " + auction.getWinningBid().getCurrentAuctionPrice().getAmount().getValue() + "\n");
		System.out.println("Winning Bidder: " + auction.getWinningBid().getBidder() + "\n");

		for (HistoricalBid historicalBid : list) {
			System.out.println(historicalBid.getBidder() + " - " + historicalBid.getAmount().getValue() + " at "
					+ historicalBid.getTimeOfBid().toString());
		}

		dao.update(auction);
	}

}
