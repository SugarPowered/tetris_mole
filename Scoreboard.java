
// Jednoduchy scoreboard
// Ide cisto o vypis a narabanie so skore ako takym, 
// format je potrebne poriesit v HernomRozhrani
public class Scoreboard {
    private int skore;  
    
    public Scoreboard(int skore) {
        this.skore = skore;
    }
    
    public int getSkore() {
        return this.skore;
    }
    
    public void vypisSkore() {
        System.out.println("Skore: " + this.skore);
    }
    
    public void pridajSkore(int pridaneSkore) {
        this.skore = this.skore + pridaneSkore;
    }
    
    public void resetSkore() {
        this.skore = 0;
    }   
}
