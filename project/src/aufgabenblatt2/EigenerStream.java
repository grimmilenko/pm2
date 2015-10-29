package aufgabenblatt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EigenerStream {

	Predicate<String> keinNull = text -> !text.equals(null);

	public List<String> streamWork(String array[]) {
		List<String> listErg = new ArrayList<String>();
		return Arrays.stream(array).filter(keinNull);
	}
}
