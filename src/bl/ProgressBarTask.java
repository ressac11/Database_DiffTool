/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Random;
import javax.swing.SwingWorker;

/**
 *
 * @author Sarah
 */
public class ProgressBarTask extends SwingWorker<Void, Void> {

    /*
     * Main task. Executed in background thread.
     */
    @Override
    public Void doInBackground() {
        Random random = new Random();
        int progress = 0;
        //Initialize progress property.
        setProgress(0);
        //Sleep for at least one second to simulate "startup".
        try {
            Thread.sleep(1000 + random.nextInt(2000));
        } catch (InterruptedException ignore) {
        }
        return null;
    }

    /*
     * Executed in event dispatch thread
     */
    public void done() {
        
    }

}
