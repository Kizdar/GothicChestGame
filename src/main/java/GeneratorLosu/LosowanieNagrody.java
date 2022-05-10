package GeneratorLosu;

import java.util.Random;

public class LosowanieNagrody {

    public int nagroda(){
        Random generator = new Random();

        int a = generator.nextInt(101);
        if(a<5){
            return -1;
        }
        int liczba = generator.nextInt(101) ;
        return liczba;

    }
}
