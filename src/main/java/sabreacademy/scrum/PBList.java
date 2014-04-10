package sabreacademy.scrum;

import java.util.ArrayList;
import java.util.List;

public class PBList {

	private List<PBI> items = new ArrayList<PBI>();

	public void addElementAtTheEnd(PBI newPBI) {
		items.add(newPBI);
	}

	public void addAtCertainPosition(PBI pbi, int position) {
		items.add(position, pbi);
	}

	public PBI getLastPBI() {
		return items.get(items.size()-1);
	}

	public PBI getPBI(int position) {
		return items.get(position);
	}

	public int getPBIOrder(PBI pbi) {
		return items.indexOf(pbi);
	}

}
