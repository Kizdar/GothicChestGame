package GeneratorLosu;

import java.util.Random;

public class LosowanieSzyfru {


    public  String losowanie(){
        Random generator = new Random();
        boolean los = generator.nextBoolean();

        if (los == false){
            return "prawo";
        }
        return "lewo";
    }
}
