abstract class Foods {
    private int pax;
    private boolean ate;
    
    public Foods() {
        this.pax = 0;
        this.ate = false;        
    }

    public void eat(int pax) {
        this.pax = pax;
        this.ate = true;
    }

    public abstract int sugar(int pax);

    @Override
    public String toString() {
        // part 1:
        if (this.ate) {
            // part 1
            // return String.format(" for %s eater(s)", this.pax);
            
            // part 2 
            return String.format(" (%s eater(s))", this.pax);
        } else {
            return "";
        }        

                
    }
}
