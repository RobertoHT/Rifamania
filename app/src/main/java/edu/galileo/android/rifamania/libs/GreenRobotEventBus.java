package edu.galileo.android.rifamania.libs;


import edu.galileo.android.rifamania.libs.base.EventBus;

/**
 * Created by praxis on 13/07/16.
 */
public class GreenRobotEventBus implements EventBus{
    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus() {
        eventBus = org.greenrobot.eventbus.EventBus.getDefault();
    }

    @Override
    public void register(Object suscribe) {
        eventBus.register(suscribe);
    }

    @Override
    public void unregister(Object suscribe) {
        eventBus.unregister(suscribe);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
