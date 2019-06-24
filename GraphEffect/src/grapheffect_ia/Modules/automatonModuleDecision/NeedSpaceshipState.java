package grapheffect_ia.Modules.automatonModuleDecision;

import grapheffect_ia.AI;
import grapheffect_ia.Model.Spaceships.TypeSpaceship;

/**
 * @author julie
 *
 */
public class NeedSpaceshipState extends State {

	public NeedSpaceshipState(AI ai) {
		super(ai);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String messageToSend() {
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State transition() {
		State transition = null;
		TypeSpaceship type = null;
		if(getMemoryModule().getData().countOfAllSpaceships() <= 2 && getMemoryModule().isCoordinateFree(getMemoryModule().getBase())) {
			if (getMemoryModule().getSpaceshipsNumber(TypeSpaceship.EXPLORER) <	 2) {
				type = TypeSpaceship.EXPLORER;
			}
			else if (getMemoryModule().getSpaceshipsNumber(TypeSpaceship.CONSTRUCTOR) < 1 && getMemoryModule().getSpaceshipsNumber(TypeSpaceship.EXPLORER) >= 2) {
				type = TypeSpaceship.CONSTRUCTOR;
			}
			transition = new BuildingState(getAi(), type);
		} else transition = new ManageSpaceshipsState(getAi(), getMemoryModule().getCurrentSpaceship());
		return transition;
	}

}
