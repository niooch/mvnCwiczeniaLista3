package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    @Override
    public void open(String givenCode){
        //sprawdzanie odbywa sie w funkcji unlock w klasie ThirdPartyDoor
        try {
            this.unlock(givenCode);
            this.setState(DoorState.OPEN);
        } catch (Exception e) {
            System.out.println("IncorrectDoorCodeException");
        }
    }
    @Override
    public void close(){
        this.lock();
    }
    @Override
    public boolean isOpen() {
        return this.getState() == DoorState.OPEN;
    }
    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException {
        try {
            this.setNewLockCode(newCode);
        } catch (Exception e) {
            System.out.println("CodeMismatchException/IncorrectDoorCodeException");
        }
    }
    @Override
    public boolean testCode(String code) {
        //sprawdz czy kod jest poprawny za pomoca funkcji unlock
        try {
            this.unlock(code);
            this.lock();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
