package model;

public interface AuctionDao {

	public int add(Auction auction);

	public void list();

	public void update(Auction acc);

	public void delete(Auction auction);

	public Auction findBy(int id);

}
