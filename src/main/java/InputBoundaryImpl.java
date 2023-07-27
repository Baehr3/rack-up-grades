public class InputBoundaryImpl implements InputBoundary{

    private GameUseCase useCase;

    InputBoundaryImpl(UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void setName(String newName) {
        useCase.setName(newName);
    }

    @Override
    public void click(Integer i) {
        useCase.click(i);
    }


}