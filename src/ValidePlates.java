import java.util.ArrayList;
import java.util.List;

public class ValidePlates {
	private List<List> plates;

	public ValidePlates(List<List> plates) {
		this.plates = plates;
	}

	public List<Plate> getValidePlates(Plate currPlate) {
		List<Plate> validePlates = new ArrayList<Plate>();
		for (List<Plate> platesList : plates)
			for (Plate checkPlate : platesList) {
				if (currPlate.getFigure().isValide(checkPlate, currPlate,
						plates))
					validePlates.add(checkPlate);

			}
		return validePlates;
	}

	public boolean isValide(Plate plateDestination, Plate currPlate) {
		return currPlate.getFigure().isValide(plateDestination, currPlate,
				plates);
	}

}
