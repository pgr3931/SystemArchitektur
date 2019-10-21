package pmp.solution;

import pmp.filter.Sink;

import java.io.StreamCorruptedException;

public class MySink {

    //TODO:replace object with stream etc
    private Sink s = new Sink<Object>();

    public void doStuff(Object value){
        try {
            s.write(value);
        }catch(StreamCorruptedException e){
            e.printStackTrace();
        }
    }
}
