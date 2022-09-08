package main;

public class GameEngine extends Thread{

    public GameScene gameScene;

    GameEngine(GameScene gameScene){
        this.gameScene = gameScene;
    }


    @Override
    public void run() {
        double drawInterval = 1000000000/gameScene.FPS; // 0.16 second
        double nextDrawTime =  System.nanoTime() + drawInterval;
        while(gameScene.engine != null){

            gameScene.update();
            gameScene.repaint();

            try {
                double remainingTime = nextDrawTime- System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime < 0)
                    remainingTime = 0;
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
