public class RealShieldAccess implements ShieldAccess {
    private boolean granted = false;

    @Override
    public boolean grantAccess() {
        return granted = true;
    }

    @Override
    public boolean isGranted() {
        return granted;
    }
}