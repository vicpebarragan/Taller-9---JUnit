

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.jupiter.api.Test;

public class CustomerTest extends TestCase{
	static Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
	static MovieRental test1, test2, test3;
	static VideoGameRental test4, test5, test6;
	static Ps3Game MK4;
	static WiiGame MarioBros;
	static Xbox360Game HaloWars;
	static Customer instance;
	
	public CustomerTest(){	
	}
	
    @BeforeClass
    public static void setUpClass() {
    	instance = new Customer("Pepe");
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
        
        MK4 = new Ps3Game("Mortal Kombat 4");
        MarioBros = new WiiGame("Super Mario Bros 3");
        HaloWars = new Xbox360Game("Halo Wars");
        
        test1 = new MovieRental(theManWhoKnewTooMuch, 5);
        test2 = new MovieRental(mulan, 4);
        test3 = new MovieRental(slumdogMillionaire, 3);
        test4 = new VideoGameRental(MK4, 10, true);
        test5 = new VideoGameRental(MarioBros, 8, false);
        test6 = new VideoGameRental(HaloWars, 6, false);
        
        instance.addMovieRental(test1);
    	instance.addMovieRental(test2);
    	instance.addMovieRental(test3);
    	
    	instance.addVideoGameRental(test4);
    	instance.addVideoGameRental(test5);
    	instance.addVideoGameRental(test6);    	
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     *
     */
    @Test
    public void testStatement() {
    	System.out.println("Statement Test");
        setUpClass();
        String result = instance.statement();
	// FRP = 4+8+1+2
        assertEquals("Rental Record for Pepe\n" +
                "\tThe Man Who Knew Too Much\t6.5\n" +
                "\tMulan\t2.75\n" +
                "\tSlumdog Millionaire\t9.0\n" +
                "\tMortal Kombat 4\t51.489999999999995\n" +
                "\tSuper Mario Bros 3\t9.0\n" +
                "\tHalo Wars\t8.0\n" +
                "Amount owed is 86.74\n" +
                "You earned 15 frequent renter points",
           result);    	  	
    }
}
