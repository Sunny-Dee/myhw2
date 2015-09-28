package myhw2.data;
import java.util.Comparator;

public class Compar implements Comparator<Record> {

	public int compare(Record r1, Record r2) {
		// TODO Auto-generated method stub
		return r2.numRentals() - r1.numRentals();
	}

}
