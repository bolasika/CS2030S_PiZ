class PiZ {
    private Foods[] foods; 
    private int count = 0;

    public PiZ(int num) {
        this.foods = new Foods[num];        
    }

    public String addBeefPizza() {
        Foods food = new BeefPizza();
        this.foods[this.count] = food;                
        this.count += 1;
        return String.format("%s: %s added",this.count - 1, this.foods[this.count - 1].toString());
    }

    public String addPersonalFries() {
        Foods food = new PersonalFries();
        this.foods[this.count] = food;                
        this.count += 1;
        return String.format("%s: %s added",this.count - 1, this.foods[this.count - 1].toString());
    }

    public String eat(int idx, int pax) {
        Foods food = this.foods[idx]; 
        food.eat(pax);
        return String.format("%s: %s with %sg sugar intake each", idx, food, food.sugar(pax));
    }

    @Override
    public String toString() {
        return "";
    }
}
