/**
 * 
 */
package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memory;

/**
 * @author julie
 *
 */
public abstract class State {

	private Module_Decision _moduleDecision;
	
	public State(Module_Decision moduleDecision) {
		_moduleDecision = moduleDecision;
	}
	
	public Module_Decision getDecisionModule() {
		return this._moduleDecision;
	}
	
	public Module_Memory getMemoryModule() {
		return this._moduleDecision.getAI().getModuleMemory();
	}
	
	public abstract String messageToSend();
	
	public abstract State transition();
	
}
