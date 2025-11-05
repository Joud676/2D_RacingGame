public class RealShieldAccess implements ShieldAccess {
    private boolean granted = false;

    @Override
    public void grantAccess() {
        granted = true;
    }

    @Override
    public boolean isGranted() {
        return granted;
    }
}