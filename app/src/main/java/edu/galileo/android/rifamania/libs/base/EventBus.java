package edu.galileo.android.rifamania.libs.base;

/**
 * Created by praxis on 13/07/16.
 */
public interface EventBus {
    void register(Object suscribe);
    void unregister(Object suscribe);
    void post(Object event);
}
