
public class Grid {
    private Stvorec[][] plocha;
    private Boolean[][] bplocha;
    private Tetrom tetrom;
    private int velkost = 20;
    private int plochaX = 2;
    private int plochaY = 2;
    //private int tetromX = 2;
    //private int tetromY = 2;
   
    public Grid() {
        this.plocha = new Stvorec[20][12];
        for (int i = 0; i < this.plocha.length; i++) {
            for (int j = 0; j < this.plocha[0].length; j++) {
                this.plocha[i][j] = new Stvorec(this.plochaX, this.plochaY);
                this.plocha[i][j].zmenStranu(this.velkost);
                this.plocha[i][j].zmenFarbu("black");
                this.plocha[i][j].zobraz();
                this.plochaX += this.velkost + 5;
            }
            this.plochaY += this.velkost + 5;
            this.plochaX = 2;
        }
    }

    public Stvorec[][] getPlocha() {
        return this.plocha;
    }
    
    public void nastavStvorec(int indexRiadku, int indexStlpca) {
        if (((indexRiadku >= this.plocha.length) || (indexRiadku < 0)) || ((indexStlpca >= this.plocha[0].length) || (indexStlpca < 0))) {
            System.out.println("Chybný index");
            return;
        }
        this.plocha[indexRiadku][indexStlpca].zmenFarbu("red");
    }
    
    public void nastavTetrom() {
        
    }
}