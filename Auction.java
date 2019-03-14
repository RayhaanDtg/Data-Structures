
import java.util.*;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 *
 * @author (of AuctionSkeleton) Lynn Marshall
 * @version 2.0
 * 
 * @author <GOOLAM DUSTAGHEER Mohammad Rayhaan>
 * @student ID : 101053805
 * @version <2017/10/09>
 * 
 */
public class Auction
{
    /** The list of Lots in this auction. */
    private ArrayList<Lot> lots;

    /** 
     * The number that will be given to the next lot entered
     * into this auction.  Every lot gets a new number, even if some lots have
     * been removed.  (For example, if lot number 3 has been deleted, we don't
     * reuse it.)
     */
    private int nextLotNumber;
    /** A new variable of type boolean is being created so as to check the state of
     * an auction, whether it is closed or not
     */
    private boolean closedAuction ;
    /**
     * Create a new auction, with nextLotNumber = 1 and making the auction open 
     * by setting closedAuction to false.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
        closedAuction= false ;
    }

    /**
     *   This constructor takes
     * an Auction as a parameter. Calling the method isAuctionClosed()
     *  to the auction to see if auction parameter
     * is closed. In this case, the constructor creates a new auction containing
     * the unsold lots of the closed auction by calling method getNoBids().
     *   If the auction parameter(isAuctionClosed() returns false)
     *    is still open or null, this constructor behaves like the
     * default constructor. At the end, closedAuction is set to false 
     * to show that the auction is open.
     */

    public Auction ( Auction auction) {

        if (auction.isAuctionClosed ()) {
            lots= auction.getNoBids();
            nextLotNumber = 1 ;

        }
        else {

            lots = new ArrayList<Lot>();
            nextLotNumber = 1;

        }
        closedAuction=false ;
    }

    /**
     * Enter a new lot into the auction.  Returns false if the
     * auction is not open or if the description is null.
     * The condition "this.isAuctionClosed()" checks if the 
     * auction is closed. If the auction is open, a new lot is added
     * with the proper description and nextLotNumber is incremented

     * @param description : A description of the lot. 
     */
    public boolean enterLot(String description)
    {

        if ((this.isAuctionClosed ()) || description==null) {
            return false ;
        } 

        lots.add(new Lot(nextLotNumber, description));

        nextLotNumber++;
        return true ;

    }

    /**
     * Show the full list of lots in this auction.
     *
     * A blank line is printed first, to make our output look nicer. 
     * If there are no lots, print a message indicating this. Here the
     * method isEmpty() is being called on lots to know if the lots contain
     * something or not. If method isEmpty() returns true, this shows that
     * the lot contains nothing. The for each loop is being used to iterate 
     * through the array list of lots to consider each lot and print them out.
     * 
     */
    public void showLots()
    {
        if (lots.isEmpty()==true) {
            System.out.println ("") ;
            System.out.println ( "There are no lots in this auction") ;
        }
        else {
            for(Lot lot : lots) {
                System.out.println ("") ;

                System.out.println(lot);
            }
        }
    }

    /**
     * This method is used to bid for a lot.
     * The lots are not necessarily  stored in numerical order.
     * 
     *   
     * A blank line is first printed to make the output neater.  
     * Then a message is printed to show whether or not the bid is successful.
     * If the bid is successful,  the lot number,
     *  high bidder's name, and the bid value are printed
     * If the bid is not successful,  the lot number 
     * and high bid (but not the high bidder's name) are printed.
     * 
     * Returns false if the auction is closed, the lot doesn't
     * exist, the bidder is null, or the bid was not positive
     * and true otherwise (even if the bid was not high enough).

     * @param number The lot number being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public boolean bidFor(int lotNumber, Person bidder, long value)
    {
        Lot chosenLot = getLot (lotNumber) ;
        System.out.println("") ;
        if ( this.isAuctionClosed () || chosenLot== null || bidder==null || value<= 0) {

            System.out.println ("The bid was not successful.") ;
            return false ;
        }
        else {

            Bid bid = new Bid ( bidder, value) ;
            if (chosenLot.bidFor(bid) == true) {
                System.out.println ( "The bid with lot number" + lotNumber + " was successful.") ;
                System.out.println ( "The high bidder is " + bidder.getName() +".") ;
                System.out.println ( "The bid value is " +  value + "." ) ;
            }

            else {
                System.out.println ( "The bid with lot number" + lotNumber + " was not successful.") ;
                System.out.println ( "The bid value is " +  value + "." ) ;
            }
            return true ;

        }
    }

    /**
     * Return the lot with the given number. 
     *  the lots are not necessarily stored in numerical order.   
     *   
     * Returns null if the lot does not exist.
     * The conditions for the if statement are used to 
     * check whether the lot number entered as parameter is 
     * a valid one.
     * 
     *
     * @param lotNumber The number of the lot to return.
     *
     * @return the Lot with the given number
     */
    public Lot getLot(int lotNumber)
    {

        if ( (lotNumber>=1) && (lotNumber < nextLotNumber)) {
            for (Lot lot :lots) {
                if ((lot.getNumber())==lotNumber) {

                    return lot;

                }

            }
        }

        return null; 
    }

    /**
     * Closes the auction and prints information on the lots.
     * A blank line is printed at first .  Then for each lot,
     * its number and description are printed.
     * If it did sell, the high bidder and bid value are also printed.  
     * If it didn't sell, that information is printed.
     *
     * Returns false if the auction is already closed, true otherwise.

     */
    public boolean close()

    {
        if (!(isAuctionClosed ())) {
            System.out.println ( "") ;

            for ( Lot lot:lots) {

                System.out.println ( "The lot number : " + lot.getNumber() + ".") ;
                System.out.println ( " The description of the lot : " + lot.getDescription () + ".") ;
                if ( lot.getHighestBid() !=null) {
                    System.out.println ( " Bid value is " + lot.getHighestBid().getValue() + ".") ;
                    System.out.println ( " The bidder is " + lot.getHighestBid().getBidder().getName() + "." );
                }
                else {
                    System.out.println ( "The lot number : " + lot.getNumber() + " has not been sold.") ;
                }
            }
            closedAuction = true ;
            return true ;
        } 
        else {
            closedAuction=true;
            return false ;
        }

    }

    /**
     * Returns an ArrayList containing all the items that have no bids so far.
     * (or have not sold if the auction has ended).
     * @return an ArrayList named listOfItems of the Lots which currently have no bids
     */
    public ArrayList<Lot> getNoBids()
    {

        ArrayList<Lot> listOfItems= new ArrayList<Lot> () ;
        for ( Lot lot : lots ) {
            if ( lot.getHighestBid () == null ) {
                listOfItems.add(lot) ;
            }
        }
        return listOfItems ;

    }

    /**
     * Remove the lot with the given lot number, as long as the lot has
     * no bids, and the auction is open.  
     *  an Iterator object with the name "it" to search the list and,
     * if applicable, remove the item.
     *  The lots are not necessarily stored in numerical order.
     *
     * Returns true if successful, false otherwise (auction closed,
     * lot does not exist, or lot has a bid).
     * (You need to update the return type, documentation, and code.)
     *
     * @param number The number of the lot to be removed.
     */
    public boolean removeLot(int number)
    {
        Iterator <Lot> it = lots. iterator () ;
        boolean successful = false ;

        if (!(this.isAuctionClosed())) {
            while (it.hasNext() ) {
                Lot lot = it.next() ;
                if ( (lot.getNumber() == number) && (lot.getHighestBid() == null)) {

                    lots.remove(lot) ;
                    successful= true ;
                }
            }
        }
        else {
            successful = false ;
        }
        return successful ;
    }

    /** 
     * Method isAuctionClosed is of boolean type and it is private,
     * since it is used just for the Auction class. This method checks
     * whether the auction is closed or open.
     * @ return It returns closedAuction which can be either true or false.
     * 
     */ 
    public boolean isAuctionClosed () {
        return closedAuction;
    }
}

   