class BeefPizza extends Foods{    
    @Override 
    public int sugar(int pax) {
        return 5000 / pax;
    }

    @Override
    public String toString() {
        return "BeefPizza" + super.toString();
    }
}