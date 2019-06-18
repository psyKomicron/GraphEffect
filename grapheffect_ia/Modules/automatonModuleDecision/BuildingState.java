package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Spaceships.TypeSpaceship;

/**
 * @author julie
 *
 */
public class BuildingState extends State {
	private TypeSpaceship _typeSpaceship;

	public BuildingState(AI ai, TypeSpaceship typeSpaceship) {
		super(ai);
		_typeSpaceship = typeSpaceship;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "BUILDSHIP|"+_typeSpaceship.label;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		this.getMemoryModule().addSpaceships(_typeSpaceship.label);
		return new ManageSpaceshipsState(getAi(), getMemoryModule().getCurrentSpaceship());
	}

}
