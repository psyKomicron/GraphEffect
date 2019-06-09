/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 *
 */
public abstract class State {
	private AI _ai;
	
	
	public State(AI ai) {
		_ai = ai;
	}
	
	public Module_Decision getDecisionModule() {
		return _ai.getModuleDecision();
	}
	
	public Module_Memory getMemoryModule() {
		return _ai.getModuleMemory();
	}
	
	public AI getAi() {
		return _ai;
	}
	
	public abstract String messageToSend();
	
	public abstract State transition();
	
}
