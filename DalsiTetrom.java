
public class DalsiTetrom {
    //vacsina metod je velmi zavislych na Kubovej classe Tetrom (boli robene nezavisle od seba)
    private Tetrom tetrom;
    private Tetrom[] poleTetromov; // zasobnik kam sa ukladaju tetromy
    
    public DalsiTetrom() {
        Tetrom tetrom = new Tetrom();
    }
    
    //Spravy su odvodene od metod tetromu 
    public void zobrazDalsiTetrom() {
        tetrom.vygenerujTvar();
        tetrom.zobrazTvar();
    }
    
    // Do pola tetromov uloz tetrom do pola
    public void pridajTetromDoPola() {
        for(int i = 0; i < poleTetromov.length; i++) {
            poleTetromov[i] = tetrom.vygenerujTvar();
        }
    }
    
    // Povodny zamer "Generatora" nebol realizovany
    // Generovat nahodne tetromy vieme priamo cez Kubovu classu Tetrom
}
