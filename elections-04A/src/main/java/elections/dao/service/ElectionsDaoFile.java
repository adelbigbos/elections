package elections.dao.service;

import elections.dao.service.IElectionsDao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elections.dao.entities.ElectionsException;
import elections.dao.entities.ListeElectorale;

/**
 * @author Hicham
 *
 */
public class ElectionsDaoFile implements IElectionsDao  {
	
	

		/**
		 *le nom du fichier qui continent les données nécessaires au calcul des sièges
		 */
		private String inFileName = null;

		/**
		 * Le nom du fichier qui contiendra les résultats
		 */
		String outFileName = null;
		/**
		 * Le nom du fichier de logs
		 */

		private String logFileName = null;
		
		/**
		 * le seuil électoral
		 */
		private double seuilElectoral;

		/**
		 * le nombre de sièges à pourvoir
		 */
		private int nbSiegesAPourvoir;

		/**
		 * les listes en compétition
		 */
		
		
		private List<ListeElectorale> listeElectorales = new ArrayList<ListeElectorale>();

		public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) throws ElectionsException {
			super();
			this.inFileName = inFileName;
			this.outFileName = outFileName;
			this.logFileName = logFileName;	
			
			//System.out.println("path: "+getClass().getResource(this.inFileName).getPath());
			
			//File f = new File(getInFileName());
			try{
				InputStream flux=new FileInputStream("src\\test\\resources\\"+this.inFileName); 
				InputStreamReader lecture=new InputStreamReader(flux);
				BufferedReader buff=new BufferedReader(lecture);
				String ligne;
				int cpt = 0;
				while ((ligne=buff.readLine())!=null){
					switch (cpt) {
		            case 0:  setNbSiegesAPourvoir(Integer.parseInt(ligne));
		                     break;
		            case 1:  setSeuilElectoral(Double.parseDouble(ligne));
		                     break;
		            default: ListeElectorale temp_listElectoral = new ListeElectorale();
		            		temp_listElectoral.setNom(ligne);
		            		temp_listElectoral.setId(cpt+1);//le numero de la ligne
		            		temp_listElectoral.setVoix(0);
		            		temp_listElectoral.setElimine(false);
		            		temp_listElectoral.setSieges(0);
		            		listeElectorales.add(temp_listElectoral);
		            
			        }					
					cpt++;
				}
				buff.close(); 
				}	
				catch (FileNotFoundException exc){					
					throw new ElectionsException(0, "File not found");
				}
				catch (Exception e){
					e.printStackTrace();
				}
		}

		
		
		public String getInFileName() {		
			System.out.println("start 1");
			return inFileName;			
		}



		public double getSeuilElectoral() {
			
			return seuilElectoral;
		}

		public int getNbSiegesAPourvoir() {
		
			return nbSiegesAPourvoir;
		}

		public List<ListeElectorale> getListesElectorales() {
						
			return listeElectorales;
		}

		public void setListesElectorales(List<ListeElectorale> listeElectorales) {
			
			File f = new File ("src\\test\\resources\\"+this.outFileName);
			 
			try
			{
			    FileWriter fw = new FileWriter (f);
			 
			    Iterator<ListeElectorale> it = listeElectorales.iterator();
			    try {
				    while (it.hasNext()) {
				    	ListeElectorale temp = it.next();			    	
				    	fw.write (temp.toString());
					    fw.write ("\r\n");			    	
					}	
			    } catch (Exception e) {
					e.printStackTrace();
				}finally {						
					fw.close();
				}
			    fw.close();
			    
			    this.listeElectorales=listeElectorales;
			}
			catch (IOException exception)
			{
			    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
			
			
		}



		public String getLogFileName() {
			return logFileName;
		}



		public void setLogFileName(String logFileName) {
			this.logFileName = logFileName;
		}



		public void setInFileName(String inFileName) {
			this.inFileName = inFileName;
		}



		public void setSeuilElectoral(double seuilElectoral) {
			this.seuilElectoral = seuilElectoral;
		}



		public void setNbSiegesAPourvoir(int nbSiegesAPourvoir) {
			this.nbSiegesAPourvoir = nbSiegesAPourvoir;
		}



}


