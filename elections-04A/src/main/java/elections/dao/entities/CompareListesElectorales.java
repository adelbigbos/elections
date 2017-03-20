package elections.dao.entities;

import java.util.Comparator;

public class CompareListesElectorales implements Comparator<ListeElectorale> {


	// comparaison de deux listes �lectorales selon le nombre de si�ges
		public int compare(ListeElectorale liste1, ListeElectorale liste2) {
			if(liste1.getVoix()<liste2.getVoix())	return +1;
			
			if(liste1.getVoix()>liste2.getVoix()) return -1;
			
			else return 0;
		}

}
