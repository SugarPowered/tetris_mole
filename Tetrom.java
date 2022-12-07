import java.util.Random;
 

public class Tetrom {
    private Stvorec[][] tetrom;
    private Boolean[][] tvar;    
    private String druhTvaru;
    private int poziciaX;
    private int poziciaY;
    private int poziciaOtocenia;
    public Tetrom() {
        this.poziciaX = 120;
        this.poziciaY = 0;
        this.poziciaOtocenia = 1;
        
        
        // nahodne vyberie tetrom
        switch (new Random().nextInt(5)) {
        //vytvara tvar stvorec
            case 0 :  
                this.tvar = new Boolean[][] {{true, true}, {true, true}};
                this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec()}, {new Stvorec(), new Stvorec()}};
                this.druhTvaru = "S";
                break;
        //vytvara tvar L
            case 1 :  
                this.tvar = new Boolean[][] {{true, true, true}, {true, false, false}};
                this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec(), new Stvorec()}, {new Stvorec(), new Stvorec(), new Stvorec()}};
                this.druhTvaru = "L";
                break;
        //vytvara tvar I
            case 2 :  
                this.tvar = new Boolean[][] {{true, true, true, true}};
                this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec(), new Stvorec(), new Stvorec()}};
                this.druhTvaru = "I";
                break;
        //vytvara tvar T
            case 3 :  
                this.tvar = new Boolean[][] {{false, true, false}, {true, true, true}};
                this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec(), new Stvorec()}, {new Stvorec(), new Stvorec(), new Stvorec()}};
                this.druhTvaru = "T";
                break;
        //vytvara tvar Z
            default :  
                this.tvar = new Boolean[][] {{true, true, false}, {false, true, true}};
                this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec(), new Stvorec()}, {new Stvorec(), new Stvorec(), new Stvorec()}};
                this.druhTvaru = "Z";
                break;
        
        
        }
        this.vytvorTetrom(120, 0);
    }
    
    /** vytvori tetrom ktory bol nahodne vybrany v konstruktore*/   
    public void vytvorTetrom(int x, int y) {
        
        for (int i = 0; i < this.tvar.length; i++) {
            for (int j = 0; j < this.tvar[0].length; j++) {
                this.tetrom[i][j].posunVodorovne(x - 60 + 20 * j);
                this.tetrom[i][j].posunZvisle(y - 50 + 20 * i);
            }
        }       
           
           
        for (int i = 0; i < this.tvar.length; i++) {
            for (int j = 0; j < this.tvar[0].length; j++) {
                if (!this.tvar[i][j]) {
                    this.tetrom[i][j].zmenStranu(20);
                } else {
                    this.tetrom[i][j].zmenStranu(20);
                    this.tetrom[i][j].zobraz();
                }
            }
        }
    }
        
   
    /** posuva tetrom do prava max po okraj plochy*/
    public void posunVpravo() {
        if (this.poziciaX + 20 * this.tetrom[0].length < 300) {
            for (int i = 0; i < this.tetrom.length; i++) {
                for (int j = 0; j < this.tetrom[0].length; j++) {
                    this.tetrom[i][j].posunVpravo();
                }           
            }
            this.poziciaX = this.poziciaX + 20;
        }
    }
    
    /** posuva tetrom do prava max po okraj plochy*/
    public void posunVlavo() {
        if (this.poziciaX > 0) {
            for (int i = 0; i < this.tetrom.length; i++) {
                for (int j = 0; j < this.tetrom[0].length; j++) {
                    this.tetrom[i][j].posunVlavo();
                }           
            }  
            this.poziciaX = this.poziciaX - 20;
        }
    }
    
    /** posuva tetrom do dola */
    public void tik() {
        if (this.poziciaY + 20 * this.tetrom.length < 500) {
            for (int i = 0; i < this.tetrom.length; i++) {
                for (int j = 0; j < this.tetrom[0].length; j++) {
                    this.tetrom[i][j].posunZvisle(20);
                }           
            }  
        }
        this.poziciaY = this.poziciaY + 20;
    }
    
    /** otaca tetrom */
    public void otoc() {
        Boolean[][] otocenePole = new Boolean[this.tetrom[0].length][this.tetrom.length];
    //vytovri nove pole kde su riadky vymenene so stlpcami
        for (int i = 0; i < otocenePole.length; i++) {
            for (int j = 0; j < otocenePole[0].length; j++) {
                otocenePole[i][j] = this.tvar[j][i];
            }           
        }
    
        this.tvar = null;
        this.tvar = otocenePole;
    //zrusi stary tetrom
        for (int i = 0; i < this.tetrom.length; i++) {
            for (int j = 0; j < this.tetrom[0].length; j++) {
                this.tetrom[i][j].skry();
            }           
        }
        this.tetrom = null;
    
        this.tetrom = new Stvorec[otocenePole.length][otocenePole[0].length];
    //vytvori novy tetrom uz otoceny
        for (int i = 0; i < otocenePole.length; i++) {
            for (int j = 0; j < otocenePole[0].length; j++) {
                this.tetrom[i][j] = new Stvorec();
            }           
        }
        this.vytvorTetrom(this.poziciaX, this.poziciaY);
        this.poziciaOtocenia++;
    }  
    
    public Boolean[][] getTvar() {
    return this.tvar;
    }
    
    public int getX() {
    return this.poziciaX;
    }
    
    public int getY() {
    return this.poziciaY;
    }
}   
    
    
    
   
