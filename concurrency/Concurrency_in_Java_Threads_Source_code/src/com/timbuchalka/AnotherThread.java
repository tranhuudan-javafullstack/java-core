package com.timbuchalka.Concurrency_in_Java_Threads_Source_code.src.com.timbuchalka;

import static com.timbuchalka.ThreadColor.ANSI_BLUE;

/**
 * Created by timbuchalka on 25/05/2016.
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread.");
    }
}
