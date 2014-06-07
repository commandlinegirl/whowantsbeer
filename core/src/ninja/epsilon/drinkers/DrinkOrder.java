package ninja.epsilon.drinkers;

public interface DrinkOrder {
	TypeOfDrink getWhatsTheDrink();
	int getPosition();
	int getPointsReceived(long timeOfReceivingDrink);
	void setReceived();
}