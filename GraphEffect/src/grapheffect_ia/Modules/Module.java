package grapheffect_ia.Modules;

import grapheffect_ia.AI;

/**
 * Abstract superclass of the different modules
 * @author Matthieu
 */
public abstract class Module {
    private AI ai;
    
    public Module(AI ai) {
        this.ai = ai;
    }
    
    public AI getAI() {
        return this.ai;
    }
    
}
