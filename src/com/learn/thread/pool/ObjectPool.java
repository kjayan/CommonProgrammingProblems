package com.learn.thread.pool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ObjectPool {

    private long expirationTime;
    private HashMap<Object,Long> locked, unlocked;

    abstract Object create();
    abstract boolean validate( Object o );
    abstract void expire( Object o );


    public ObjectPool(long expirationTime) {
        this.expirationTime = expirationTime;
        this.locked = new HashMap<>();
        this.unlocked = new HashMap<>();
    }

    public synchronized Object checkOut(){
        long now = System.currentTimeMillis();
        if( unlocked.size() > 0 ){
            Set keySet = unlocked.keySet();
            for(Object oKey:keySet){
                if((now - ((Long)unlocked.get(oKey)).longValue() ) > expirationTime ){
                    unlocked.remove(oKey);
                    expire(oKey);
                }
                else {
                    if(validate(oKey)){
                        unlocked.remove(oKey);
                        locked.put(oKey, new Long( now ) );
                        return oKey;
                    }
                    else {
                        unlocked.remove(oKey);
                        expire(oKey);
                    }
                }
            }
        }
        // no objects available, create a new one
        Object o = create();
        locked.put( o,now);
        return o;
    }
    public synchronized void checkIn(Object o){
        this.locked.remove(o);
        this.unlocked.put(o,System.currentTimeMillis());
    }
}
