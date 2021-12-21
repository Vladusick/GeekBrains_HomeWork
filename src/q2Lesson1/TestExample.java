package q2Lesson1;

public class TestExample {

    public static void main(String[] args) {

        Motion[] motionsArray = new Motion[4];
        motionsArray[0] = new Cat("Барсик");
        motionsArray[1] = new Human("Валера");
        motionsArray[2] = new Robot("Энергон");
        motionsArray[3] = new Human("Санёк");

        Obstacle[] obstaclesArray = new Obstacle[3];
        obstaclesArray[0] = new Wall("Cтена-1");
        obstaclesArray[1] = new Treadmill("Беговая дорожка-1");
        obstaclesArray[2] = new Treadmill("Беговая дорожка-2");

        for (int i = 0; i < motionsArray.length; i++) {
            System.out.println(" - - - ");
            for (int j = 0; j < obstaclesArray.length; j++) {
                if (obstaclesArray[j] instanceof Wall) {
                    ((Wall) obstaclesArray[j]).canJump(motionsArray[i].jump());
                } else if (obstaclesArray[j] instanceof Treadmill) {
                    ((Treadmill) obstaclesArray[j]).canRun(motionsArray[i].run());
                }
            }

        }


    }


}
