public class Kalkulacka {
    /**
     * Hodnota, ktorú ukazuje kalkulačka na displeji
     */
    private double medziVysledok;
    private double operand;
    private char operacia;
    
    public Kalkulacka() {
        this.medziVysledok = 0;
        this.operand = 0;
        this.operacia = '=';
    }
    
    public void zadajCislo(double cislo) {
        this.operand = cislo;
    }
    
    public double getVysledok() {
        return this.medziVysledok;
    }
    
    public double getOperand() {
        return this.operand;
    }    
    
    public char getOperacia() {
        return this.operacia;
    }
    
    /**
     * Vlozi operaciu do kalkulacky, podporované operacie +,-,*,/,2,!
     */
    // vracat true ak sa podari inak false
    public boolean zadajOperaciu(char operacia) {
        switch (this.operacia) {
            case '=':
                this.medziVysledok = this.operand;
                break;
            case '+':
                this.medziVysledok += this.operand;
                break;
            case '-':
                this.medziVysledok -= this.operand;
                break;
            case '*':
                this.medziVysledok *= this.operand;
                break;
            case '/':
                if (this.operand == 0) {
                    System.out.println("Delenie nulou");
                    return false;
                }
                else {
                    this.medziVysledok /= this.operand;
                }
                break;
            // mocnina 
            case '^':
                if (this.operand % 1 != 0) {
                    System.out.println("Nasa kalkulacka pouziva ako exponent len cele cisla");
                    return false;
                }
                double tmpVysledok = this.medziVysledok;
                for( int i = 0; i < this.operand - 1; i++) {
                    this.medziVysledok *= tmpVysledok;
                }
                break;
        }
        
        //Unarne operacie sa vykonavajú hneď
        if (operacia == '2') {
            this.medziVysledok = this.medziVysledok * this.medziVysledok;
        }
        // faktorial
        else if (operacia == '!') {
            if (this.medziVysledok % 1 != 0 || this.medziVysledok < 1) {
                System.out.println("Faktorial sa dá len pre kladné a celé číslo");
                return false;
            }
            double vysledok = 1;
            for (int i = 2; i <= this.medziVysledok; i++) {
                vysledok *= i;
            }
            this.medziVysledok = vysledok;
        }
        // odmocnina
        else if (operacia == 'o') {
            double odhad = this.medziVysledok;
            do {
                odhad = (odhad + (this.medziVysledok / odhad)) / 2;
            } while (odhad * odhad - this.medziVysledok > 0.001);
            this.medziVysledok = odhad;
        }
        else {
            this.operacia = operacia;
        }
        return true;
    } 

}
