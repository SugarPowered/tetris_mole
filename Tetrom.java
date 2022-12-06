 import java.util.Random;

public class Tetrom {
    private Stvorec[][] tetrom;
    private Boolean[][] tvar;
    private int otocenie;
    public Tetrom() {
        this.tetrom = new Stvorec[][] {{new Stvorec(), new Stvorec(),new Stvorec(),new Stvorec()}, {new Stvorec(), new Stvorec(), new Stvorec(), new Stvorec(),}};
        this.tvar = new Boolean[][] {{false, false, false, false, }, {false, false, false, false,}};
        this.otocenie = 0;
        
        for (int i = 0; i < this.tetrom.length; i++) {
            for (int j = 0; j < this.tetrom[0].length; j++){
                this.tetrom[i][j].zmenStranu(20);
            
            }
        }
        
        this.tetrom[0][0].posunVodorovne(50);
        this.tetrom[0][0].posunZvisle(-50);
       
        this.tetrom[0][1].posunVodorovne(70);
        this.tetrom[0][1].posunZvisle(-50);
        
        this.tetrom[0][2].posunVodorovne(90);
        this.tetrom[0][2].posunZvisle(-50);
        
        this.tetrom[0][3].posunVodorovne(110);
        this.tetrom[0][3].posunZvisle(-50);
        
        this.tetrom[1][0].posunVodorovne(50);
        this.tetrom[1][0].posunZvisle(-30);
        
        this.tetrom[1][1].posunVodorovne(70);
        this.tetrom[1][1].posunZvisle(-30);
        
        this.tetrom[1][2].posunVodorovne(90);
        this.tetrom[1][2].posunZvisle(-30);
        
        this.tetrom[1][3].posunVodorovne(110);
        this.tetrom[1][3].posunZvisle(-30);
        
        this.vygenerujTvar();
    }

    public void vygenerujTvar() {
    for (int i = 0; i < this.tvar.length; i++) {
        for (int j = 0; j < this.tvar[0].length; j++){
            this.tvar[i][j] = false;
            
        }
        }
    //nahodne vygeneruje tetrom
    switch (new Random().nextInt(5)) {
        //vytvara tvar stvorec
        case 0 :  
        this.tvar[0][1] = true;
        this.tvar[0][2] = true;
        this.tvar[1][1] = true;
        this.tvar[1][2] = true;
        break;
        //vytvara tvar L
        case 1 :  
        this.tvar[0][2] = true;
        this.tvar[1][0] = true;
        this.tvar[1][1] = true;
        this.tvar[1][2] = true;
        break;
        //vytvara tvar I
        case 2 :  
        this.tvar[0][0] = true;
        this.tvar[0][1] = true;
        this.tvar[0][2] = true;
        this.tvar[0][3] = true;
        break;
        //vytvara tvar T
        case 3 :  
        this.tvar[0][1] = true;
        this.tvar[1][0] = true;
        this.tvar[1][1] = true;
        this.tvar[1][2] = true;
        break;
        //vytvara tvar Z
        case 4 :  
        this.tvar[0][0] = true;
        this.tvar[0][1] = true;
        this.tvar[1][1] = true;
        this.tvar[1][2] = true;
        return;
    }
    
    }
    
    public void zobrazTvar() {
    for (int i = 0; i < this.tetrom.length; i++) {
        for (int j = 0; j < this.tetrom[0].length; j++){
            if (this.tvar[i][j] == true) {
                this.tetrom[i][j].zobraz();
            }
            
        }
        }
    }
    
    public void posunVpravo() {
     for (int i = 0; i < this.tetrom.length; i++) {
        for (int j = 0; j < this.tetrom[0].length; j++){
            this.tetrom[i][j].posunVpravo();
        }           
    }
    }
   
    public void posunVlavo() {
    for (int i = 0; i < this.tetrom.length; i++) {
        for (int j = 0; j < this.tetrom[0].length; j++){
            this.tetrom[i][j].posunVlavo();
        }           
    }  
    }
    
    public void posunDole() {
    for (int i = 0; i < this.tetrom.length; i++) {
        for (int j = 0; j < this.tetrom[0].length; j++){
            this.tetrom[i][j].posunZvisle(20);
        }           
    }  
    }
    
    public void otoc() {
    
    if (this.otocenie == 0){
    this.tetrom[0][0].posunZvisle(-20);
    this.tetrom[0][0].posunVodorovne(40);
    this.tetrom[0][1].posunZvisle(0);
    this.tetrom[0][1].posunVodorovne(20);
    this.tetrom[0][2].posunZvisle(20);
    this.tetrom[0][2].posunVodorovne(0);
    this.tetrom[0][3].posunZvisle(40);
    this.tetrom[0][3].posunVodorovne(-20);
    this.tetrom[1][0].posunZvisle(-40);
    this.tetrom[1][0].posunVodorovne(20);
    this.tetrom[1][1].posunZvisle(-20);
    this.tetrom[1][1].posunVodorovne(0);
    this.tetrom[1][2].posunZvisle(0);
    this.tetrom[1][2].posunVodorovne(-20);
    this.tetrom[1][3].posunZvisle(20);
    this.tetrom[1][3].posunVodorovne(-40);
    this.otocenie++;
    return;
    }
    
    
    if (this.otocenie == 1 ){
    this.tetrom[0][0].posunZvisle(40);
    this.tetrom[0][0].posunVodorovne(20);
    this.tetrom[0][1].posunZvisle(20);
    this.tetrom[0][1].posunVodorovne(0);
    this.tetrom[0][2].posunZvisle(0);
    this.tetrom[0][2].posunVodorovne(-20);
    this.tetrom[0][3].posunZvisle(-20);
    this.tetrom[0][3].posunVodorovne(-40);
    this.tetrom[1][0].posunZvisle(20);
    this.tetrom[1][0].posunVodorovne(40);
    this.tetrom[1][1].posunZvisle(0);
    this.tetrom[1][1].posunVodorovne(20);
    this.tetrom[1][2].posunZvisle(-20);
    this.tetrom[1][2].posunVodorovne(0);
    this.tetrom[1][3].posunZvisle(-40);
    this.tetrom[1][3].posunVodorovne(-20);
    this.otocenie++;
    return;
    }
    
    if (this.otocenie == 2 ){
    this.tetrom[0][0].posunZvisle(20);
    this.tetrom[0][0].posunVodorovne(-40);
    this.tetrom[0][1].posunZvisle(0);
    this.tetrom[0][1].posunVodorovne(-20);
    this.tetrom[0][2].posunZvisle(-20);
    this.tetrom[0][2].posunVodorovne(0);
    this.tetrom[0][3].posunZvisle(-40);
    this.tetrom[0][3].posunVodorovne(20);
    this.tetrom[1][0].posunZvisle(40);
    this.tetrom[1][0].posunVodorovne(-20);
    this.tetrom[1][1].posunZvisle(20);
    this.tetrom[1][1].posunVodorovne(0);
    this.tetrom[1][2].posunZvisle(0);
    this.tetrom[1][2].posunVodorovne(20);
    this.tetrom[1][3].posunZvisle(-20);
    this.tetrom[1][3].posunVodorovne(40);
    this.otocenie++;
    return;
    }
    
    if (this.otocenie == 3 ){
    this.tetrom[0][0].posunZvisle(-40);
    this.tetrom[0][0].posunVodorovne(-20);
    this.tetrom[0][1].posunZvisle(-20);
    this.tetrom[0][1].posunVodorovne(0);
    this.tetrom[0][2].posunZvisle(0);
    this.tetrom[0][2].posunVodorovne(20);
    this.tetrom[0][3].posunZvisle(20);
    this.tetrom[0][3].posunVodorovne(40);
    this.tetrom[1][0].posunZvisle(-20);
    this.tetrom[1][0].posunVodorovne(-40);
    this.tetrom[1][1].posunZvisle(-20);
    this.tetrom[1][1].posunVodorovne(0);
    this.tetrom[1][2].posunZvisle(20);
    this.tetrom[1][2].posunVodorovne(0);
    this.tetrom[1][3].posunZvisle(40);
    this.tetrom[1][3].posunVodorovne(20);
    this.otocenie = 0;
    return;
    }
}
    
}        
        
       



      


      
     
  
        
    
 
    



