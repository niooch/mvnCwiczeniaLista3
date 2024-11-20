package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;


public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    @Override
    public void open(String givenCode) throws IncorrectDoorCodeException{
        //sprawdzanie odbywa sie w funkcji unlock w klasie ThirdPartyDoor
        try {
            this.unlock(givenCode);
            this.setState(DoorState.OPEN);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        } catch (CannotChangeStateOfLockedDoor e) {
            throw new RuntimeException("CannotChangeStateOfLockedDoor");
        }
    }
    @Override
    public void close(){
        try {
            this.setState(DoorState.CLOSED);
        } catch (CannotChangeStateOfLockedDoor e) {
            throw new RuntimeException("CannotChangeStateOfLockedDoor");
        }
    }
    @Override
    public boolean isOpen() {
        return this.getState() == DoorState.OPEN;
    }
    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if (!newCode.equals(newCodeConfirmation)) {
            throw new CodeMismatchException();
        }
        try {
            this.unlock(oldCode);

            this.setNewLockCode(newCode);

            this.lock();
        } catch (CannotChangeCodeForUnlockedDoor e) {
            throw new RuntimeException("CannotChangeStateOfLockedDoor");
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }
    }
    @Override
    public boolean testCode(String code) {
        //sprawdz czy kod jest poprawny za pomoca funkcji unlock
        try {
            this.unlock(code);
            this.lock();
            return true;
        } catch (CannotUnlockDoorException e) {
            return false;
        }
    }
}
