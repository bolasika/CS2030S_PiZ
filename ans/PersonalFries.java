class PersonalFries extends Foods{    
    @Override 
    public int sugar(int pax) {
        return 250;
    }

    @Override
    public String toString() {
        return "PersonalFries" + super.toString();
    }

    @Override
    public void eat(int pax) {
        if (pax > 1) {
            throw new PersonalException(String.format("PERSONAL FOOD! Not for %s", pax));
        }
    }
}