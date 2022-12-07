
/**
 * Write a description of class hraciaPlocha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hraciaPlocha {
    private Stvorec[][] plocha;
    private Boolean[][] plochaKontrola;  
    public hraciaPlocha() {
        this.plochaKontrola = new Boolean[25][15];
         for (int i = 0; i < this.plochaKontrola.length; i++) {
            for (int j = 0; j < this.plochaKontrola[0].length; j++) {
            this.plochaKontrola[i][j] = false;
            }
        }
        this.plocha = new Stvorec[25][15];
        for (int i = 0; i < this.plocha.length; i++) {
            for (int j = 0; j < this.plocha[0].length; j++) {
            this.plocha[i][j] = new Stvorec();
            this.plocha[i][j].zmenStranu(20);
            this.plocha[i][j].posunZvisle(-50 + i * 20);
            this.plocha[i][j].posunVodorovne(-60 + j * 20);
            }
        }
        
    }
    
    public void pridajTetrom(Tetrom tetrom) {
        int rad = tetrom.getY() / 20;
        int stlpec = tetrom.getX() / 20;
        Boolean[][] tvarTetromu = tetrom.getTvar();
        for (int i = 0; i < tvarTetromu.length; i++) {
            for (int j = 0; j < tvarTetromu[0].length; j++) {
            if (tvarTetromu[i][j]) {
                this.plochaKontrola[rad + i][stlpec + j] = true;
            }
            }
        }
        this.zobrazPlochu();
    }
    
    public void zobrazPlochu() {
      for (int i = 0; i < this.plochaKontrola.length; i++) {
            for (int j = 0; j < this.plochaKontrola[0].length; j++) {
            if (this.plochaKontrola[i][j]) {
                this.plocha[i][j].zobraz();
            } else {
                
                this.plocha[i][j].skry();
            }
            }
        }  
    }
     
}
